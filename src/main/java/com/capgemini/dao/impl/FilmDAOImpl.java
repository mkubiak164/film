package com.capgemini.dao.impl;

import com.capgemini.dao.FilmDAO;
import com.capgemini.domain.FilmEntity;
import com.capgemini.types.ActorTO;
import com.capgemini.types.FilmSearchCriteria;
import com.capgemini.types.FilmTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
            predicates.add(cb.equal(filmEntity.get("length"), filmSearchCriteria.getLengthFrom()));
        }

        if (filmSearchCriteria.getLengthTo() != null) {
            predicates.add(cb.equal(filmEntity.get("length"), filmSearchCriteria.getLengthTo()));
        }

        if (filmSearchCriteria.getPremierDateFrom() != null) {
            predicates.add(cb.equal(filmEntity.get("premierDate"), filmSearchCriteria.getPremierDateFrom()));
        }

        if (filmSearchCriteria.getPremierDateTo() != null) {
            predicates.add(cb.equal(filmEntity.get("premierDate"), filmSearchCriteria.getPremierDateTo()));
        }

        if (filmSearchCriteria.getIs3d() != null) {
            predicates.add(cb.equal(filmEntity.get("premierDate"), filmSearchCriteria.getPremierDateTo()));
        }

        if (filmSearchCriteria.getStudioId() != null) {
            predicates.add(cb.equal(filmEntity.get("studio"), filmSearchCriteria.getStudioId()));
        }

        query.select(filmEntity).where(predicates.toArray(new Predicate[]{}));

        return entityManager.createQuery(query).getResultList();
    }

// podpunkt b
    public Double calculateWeekAndTotalFilmAverage() {



        return null;
    }

//podpunkt c
    public Long calculateMostExpensiveTotalProfit(Integer howManyFilms) {

        return null;
    }


// podpunkt d
    public Double calculateBudget(LocalDate dateFrom, LocalDate dateTo) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Double> criteriaQuery = cb.createQuery(Double.class);
        Root<FilmEntity> root = criteriaQuery.from(FilmEntity.class);

        CriteriaQuery<Double> query = criteriaQuery.select(cb.sum(root.get("budget")))
                .where(cb.between(root.get("premierDate"), dateFrom, dateTo));

        final TypedQuery<Double> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }


// podpunkt e
    public List<ActorTO> findNotPlayingActors(LocalDate dateFrom, LocalDate dateTo) {

        return null;
    }

// podpunkt f
    public List<FilmTO> findLongestFilmInStudioInTime(String studioName, LocalDate dateFrom, LocalDate dateTO) {

        return null;
    }


// podpunkt g
    public void countStudioFilmsInYear(LocalDate year) {

    }
}
