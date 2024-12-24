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

    public NewEmployee findById(int id) {
        return newEmployeeService.findById(id);
    }

    public void remove(int id) {
        newEmployeeService.remove(id);
    }

    public void update(int id, NewEmployee newEmployee) {
        newEmployeeService.update(id, newEmployee);
    }


    public List<NewEmployee> findAllByName(String name) {
        return newEmployeeService.findAllByName(name);
    }
}
