package com.capgemini.dao.impl;

import com.capgemini.dao.FilmDAO;
import com.capgemini.domain.ActorEntity;
import com.capgemini.domain.FilmEntity;
import com.capgemini.domain.StudioEntity;
import com.capgemini.types.FilmSearchCriteria;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class FilmDAOImpl extends AbstractDao<FilmEntity, Integer> implements FilmDAO {

    @PersistenceContext
    public EntityManager entityManager;

    //podpunkt a
    @Override
    public List<FilmEntity> findFilmBy(FilmSearchCriteria filmSearchCriteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<FilmEntity> query = cb.createQuery(FilmEntity.class);
        Root<FilmEntity> filmEntity = query.from(FilmEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filmSearchCriteria.getKind() != null) {
            predicates.add(cb.equal(filmEntity.get("kind"), filmSearchCriteria.getKind()));
        }

        if (filmSearchCriteria.getType() != null) {
            predicates.add(cb.equal(filmEntity.get("type"), filmSearchCriteria.getType()));
        }

        if (filmSearchCriteria.getLengthFrom() != null) {
            predicates.add(cb.greaterThan(filmEntity.get("length"), filmSearchCriteria.getLengthFrom()));
        }

        if (filmSearchCriteria.getLengthTo() != null) {
            predicates.add(cb.lessThan(filmEntity.get("length"), filmSearchCriteria.getLengthTo()));
        }

        if (filmSearchCriteria.getPremierDateFrom() != null && filmSearchCriteria.getPremierDateTo() != null) {
            predicates.add(cb.between(filmEntity.get("premierDate"), filmSearchCriteria.getPremierDateFrom(), filmSearchCriteria.getPremierDateTo()));
        } else if (filmSearchCriteria.getPremierDateFrom() != null) {
            predicates.add(cb.greaterThan(filmEntity.<LocalDate>get("premierDate"), filmSearchCriteria.getPremierDateFrom()));
        } else if (filmSearchCriteria.getPremierDateTo() != null) {
            predicates.add(cb.lessThan(filmEntity.<LocalDate>get("premierDate"), filmSearchCriteria.getPremierDateTo()));
        }

        if (filmSearchCriteria.getIs3d() != null) {
            predicates.add(cb.equal(filmEntity.get("is3d"), filmSearchCriteria.getIs3d()));
        }

        if (filmSearchCriteria.getStudioId() != null) {
            predicates.add(cb.equal(filmEntity.get("studio"), filmSearchCriteria.getStudioId()));
        }

        query.select(filmEntity).where(predicates.toArray(new Predicate[]{}));

        return entityManager.createQuery(query).getResultList();
    }

// podpunkt b
    @Override
    public Double calculateWeekFilmAverage() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Double> criteriaQuery = cb.createQuery(Double.class);
        Root<FilmEntity> root = criteriaQuery.from(FilmEntity.class);

        CriteriaQuery<Double> query = criteriaQuery.select(cb.avg(root.get("profit1stWeek")));

        final TypedQuery<Double> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }

    public Double calculateTotalFilmAverage() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Double> criteriaQuery = cb.createQuery(Double.class);
        Root<FilmEntity> root = criteriaQuery.from(FilmEntity.class);

        CriteriaQuery<Double> query = criteriaQuery.select(cb.avg(root.get("profitTotal")));

        final TypedQuery<Double> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }

//podpunkt c
    public Double calculateMostExpensiveTotalProfit(Integer howManyFilms) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Double> criteriaQuery = cb.createQuery(Double.class);
        Root<FilmEntity> root = criteriaQuery.from(FilmEntity.class);

        CriteriaQuery<Double> query = criteriaQuery.select(cb.sum(root.get("profitTotal")))
                .orderBy(cb.desc(root.get("profitTotal")));

        final TypedQuery<Double> typedQuery = entityManager.createQuery(query);
        return typedQuery.setMaxResults(howManyFilms).getSingleResult();
    }


// podpunkt d
    public Double calculateBudget(LocalDate dateFrom, LocalDate dateTo) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Double> criteriaQuery = cb.createQuery(Double.class);
        Root<FilmEntity> root = criteriaQuery.from(FilmEntity.class);

        CriteriaQuery<Double> query = criteriaQuery.select(cb.sum(root.get("budget")))
                .where(cb.between(root.get("premierDate"), dateFrom, dateTo));

        final TypedQuery<Double> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult().doubleValue();
    }

// podpunkt e
    public List<ActorEntity> findNotPlayingActors(LocalDate dateFrom, LocalDate dateTo) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ActorEntity> criteriaQuery = cb.createQuery(ActorEntity.class);
        Root<ActorEntity> root = criteriaQuery.from(ActorEntity.class);
        Join<FilmEntity, ActorEntity> films = root.join("filmEntities");

        CriteriaQuery<ActorEntity> query = criteriaQuery.select(films)
                .where(cb.not(cb.between(root.get("premierDate"), dateFrom, dateTo)));

        final TypedQuery<ActorEntity> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

// podpunkt f
    public List<FilmEntity> findLongestFilmInStudioInTime(String studioName, LocalDate dateFrom, LocalDate dateTO) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<FilmEntity> criteriaQuery = cb.createQuery(FilmEntity.class);
        Root<FilmEntity> root = criteriaQuery.from(FilmEntity.class);
        Join<StudioEntity, FilmEntity> films = root.join("studio");

        Expression<Number> maxLength = cb.max(root.get("length"));

        CriteriaQuery<FilmEntity> query =
                criteriaQuery.select(films).where(cb.like(root.get("studioName"), studioName),
                        cb.between(root.get("premierDate"), dateFrom, dateTO), cb.equal(maxLength, root.get("length")));

        return null;
    }


// podpunkt g
    public void countStudioFilmsInYear(LocalDate year) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudioEntity> criteriaQuery = cb.createQuery(StudioEntity.class);
        Root<StudioEntity> root = criteriaQuery.from(StudioEntity.class);
        Join<FilmEntity, StudioEntity> films = root.join("films");

        CriteriaQuery<StudioEntity> query = criteriaQuery.select(films)
                .where(cb.equal(root.get("premierDate"), year)).groupBy(root.get("studioName"));

        }
}
