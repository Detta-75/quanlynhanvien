package controller;

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
}
