package service.impl;

import entity.SeniorEmployee;
import repository.SeniorEmployeeRepository;
import service.ISeniorEmployeeService;

import java.util.Collections;
import java.util.List;

public class SeniorEmployeeService implements ISeniorEmployeeService {
    private static SeniorEmployeeRepository seniorEmployeeRepository = new SeniorEmployeeRepository();

    @Override
    public List<SeniorEmployee> getAll() {
        return seniorEmployeeRepository.findAll();
    }

    @Override
    public void save(SeniorEmployee seniorEmployee) {
        seniorEmployeeRepository.save(seniorEmployee);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void update(int id, SeniorEmployee seniorEmployee) {

    }

    @Override
    public SeniorEmployee findById(int id) {
        return null;
    }
}
