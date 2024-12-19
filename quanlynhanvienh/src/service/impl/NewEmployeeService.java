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
        return Collections.emptyList();
    }

    @Override
    public void save(NewEmployee newEmployee) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void update(int id, NewEmployee newEmployee) {

    }

    @Override
    public NewEmployee findById(int id) {
        return null;
    }
}
