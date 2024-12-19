package controller;

import entity.NewEmployee;
import service.INewEmployeeService;
import service.impl.NewEmployeeService;

import java.util.List;

public class NewEmployeeController {
    private INewEmployeeService newEmployeeService = new NewEmployeeService();

    public List<NewEmployee> getAll() {
        return newEmployeeService.getAll();
    }

    public void save(NewEmployee newEmployee) {
        newEmployeeService.save(newEmployee);
    }
}
