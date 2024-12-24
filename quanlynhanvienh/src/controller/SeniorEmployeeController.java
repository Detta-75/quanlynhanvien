package controller;

import entity.NewEmployee;
import entity.SeniorEmployee;
import service.ISeniorEmployeeService;
import service.impl.SeniorEmployeeService;

import java.util.List;

public class SeniorEmployeeController {
    private ISeniorEmployeeService seniorEmployeeService = new SeniorEmployeeService();

    public List<SeniorEmployee> getAll() {
        return seniorEmployeeService.getAll();
    }

    public void save(SeniorEmployee seniorEmployee) {
        seniorEmployeeService.save(seniorEmployee);
    }

    public SeniorEmployee findById(int id) {
        return seniorEmployeeService.findById(id);
    }

    public void remove(int id) {
        seniorEmployeeService.remove(id);
    }

    public void update(int id, SeniorEmployee seniorEmployee) {
        seniorEmployeeService.update(id, seniorEmployee);
    }

    public List<SeniorEmployee> findAllByName(String name) {
        return seniorEmployeeService.findAllByName(name);
    }
}
