package repository;

import entity.NewEmployee;
import entity.SeniorEmployee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SeniorEmployeeRepository {

    public static final String SENIOREMPLOYEE_CSV = "src/data/senioremployee.csv";

    public List<SeniorEmployee> findAll() {
        File file = new File(SENIOREMPLOYEE_CSV);
        List<SeniorEmployee> seniorEmployees = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
            String line;
            String s[];
            SeniorEmployee employee;
            while ((line = bufferedReader.readLine()) != null) {
                s = line.split(",");
                employee = new SeniorEmployee(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Double.parseDouble(s[3]));
                seniorEmployees.add(employee);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return seniorEmployees;
    }

    public void save(SeniorEmployee seniorEmployee) {
        File file = new File(SENIOREMPLOYEE_CSV);
        List<SeniorEmployee> seniorEmployees = new ArrayList<>();
        seniorEmployees.add(seniorEmployee);
        writeFile(seniorEmployees,true);
    }

    private void writeFile(List<SeniorEmployee> seniorEmployees,boolean apped) {
        File file = new File(SENIOREMPLOYEE_CSV);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,apped))) {
            for (SeniorEmployee employee : seniorEmployees) {
                bufferedWriter.write(seniorEmployeeToString(employee));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    private String seniorEmployeeToString(SeniorEmployee seniorEmployee){
        return seniorEmployee.getName() + "," + seniorEmployee.getId() + "," + seniorEmployee.getYearsOfExperience() + "," + seniorEmployee.getSeniorityAllowance();
    }
}
