package service.impl;

import entity.Employee;
import entity.NewEmployee;
import repository.NewEmployeeRepository;
import service.INewEmployeeService;

import java.util.Collections;
import java.util.List;

public class NewEmployeeService implements INewEmployeeService {
    private static NewEmployeeRepository newEmployeeRepository = new NewEmployeeRepository();

    @Override
    public List<NewEmployee> getAll() {
        return newEmployeeRepository.findAll();
    }

    @Override
    public void save(NewEmployee newEmployee) {
        newEmployeeRepository.save(newEmployee);
    }

    @Override
    public void remove(int id) {
        newEmployeeRepository.remove(id);
    }

    @Override
    public void update(int id, NewEmployee newEmployee) {
        newEmployeeRepository.update(id, newEmployee);
    }

    @Override
    public NewEmployee findById(int id) {
        return newEmployeeRepository.findById(id);
    }

    @Override
    public List<NewEmployee> findAllByName(String name) {
        return newEmployeeRepository.findAllByName(name);
    }
}
