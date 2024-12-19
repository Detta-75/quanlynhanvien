package repository;

import entity.NewEmployee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NewEmployeeRepository {

    public static final String NEWEMPLOYEE_CSV = "src/data/newemployee.csv";

    public List<NewEmployee> findAll() {
        File file = new File(NEWEMPLOYEE_CSV);
        List<NewEmployee> newEmployees = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
            String line;
            String s[];
            NewEmployee employee;
            while ((line = bufferedReader.readLine()) != null) {
                s = line.split(",");
                employee = new NewEmployee(s[0],Integer.parseInt(s[1]),Integer.parseInt(s[2]),Double.parseDouble(s[3]));
                newEmployees.add(employee);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return newEmployees;
    }

    public void save(NewEmployee newEmployee) {
        File file = new File(NEWEMPLOYEE_CSV);
        List<NewEmployee> newEmployees = new ArrayList<>();
        newEmployees.add(newEmployee);
        writeFile(newEmployees,true);
    }

    private void writeFile(List<NewEmployee> newEmployees, boolean append) {
        File file = new File(NEWEMPLOYEE_CSV);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,append))) {
            for (NewEmployee employee : newEmployees) {
                bufferedWriter.write(newEmployeeToString(employee));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    private String newEmployeeToString(NewEmployee newEmployee){
        return newEmployee.getName() + "," + newEmployee.getId() + "," + newEmployee.getProbationDays() + "," + newEmployee.getProbationBonus();
    }
}
