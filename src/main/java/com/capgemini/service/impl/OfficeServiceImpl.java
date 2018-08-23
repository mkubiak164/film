package com.capgemini.service.impl;

import com.capgemini.dao.EmployeeDAO;
import com.capgemini.dao.OfficeDAO;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.OfficeEntity;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.mappers.OfficeMapper;
import com.capgemini.service.OfficeService;
import com.capgemini.types.EmployeeTO;
import com.capgemini.types.OfficeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeDAO officeRepository;

    @Autowired
    private EmployeeDAO employeeRepository;


    @Override
    public OfficeTO addOffice(OfficeTO officeTO) {
        OfficeEntity officeEntity = officeRepository.save(OfficeMapper.toOfficeEntity(officeTO));
        return OfficeMapper.toOfficeTO(officeEntity);
    }

    @Override
    public void removeOffice(Integer id) {
        officeRepository.delete(id);
    }

    @Override
    public OfficeTO editOffice(OfficeTO officeTO) {
        OfficeEntity officeEntity = officeRepository.save(OfficeMapper.toOfficeEntity(officeTO));
        officeRepository.update(officeEntity);
        return OfficeMapper.toOfficeTO(officeEntity);
    }

    @Override
    public void addEmployeeToOffice(Integer employeeId, Integer officeId) {
        EmployeeEntity employeeEntity = employeeRepository.findOne(employeeId);
        OfficeEntity officeEntity = officeRepository.findOne(officeId);
        employeeEntity.setOffice(officeEntity);
        employeeRepository.update(employeeEntity);
    }

    @Override
    public void removeEmployeeFromOffice(Integer employeeId, Integer officeId) {
        EmployeeEntity employeeEntity = employeeRepository.findOne(employeeId);
        employeeEntity.setOffice(null);
        employeeRepository.update(employeeEntity);
    }

    @Override
    public List<EmployeeTO> findAllOfficeEmployees(Integer officeId) {
        List<EmployeeEntity> employeesFromOffice = employeeRepository.findAllOfficeEmployees(officeId);
        return EmployeeMapper.map2TOs(employeesFromOffice);
    }

    @Override
    public List<EmployeeTO> findAllOfficeEmployeesByKeepCarId(Integer officeId, Integer carId) {
        List<EmployeeEntity> keeperFromOffice = employeeRepository.findAllOfficeEmployeesByKeepCarId(officeId, carId);
        return EmployeeMapper.map2TOs(keeperFromOffice);
    }

    /**
     * metoda potrzebna do testów
     * @return zwraca listę wszystkich placówek
     */
    @Override
    public List<OfficeTO> findAllOffices() {
        return OfficeMapper.map2TOs(officeRepository.findAll());
    }

    @Override
    public OfficeTO findbyId(Integer id) {
        return OfficeMapper.toOfficeTO(officeRepository.findOne(id));
    }
}
