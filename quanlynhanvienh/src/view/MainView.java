package view;

import controller.NewEmployeeController;
import controller.SeniorEmployeeController;
import entity.NewEmployee;
import entity.SeniorEmployee;

import java.util.List;
import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        int choice;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("-----CHƯƠNG QUẢN LÝ NHÂN VIÊN----");
            System.out.println("1. Quản lý nhân viên mới. ");
            System.out.println("2. Quản lý nhân viên cũ. ");
            System.out.println("0. Thoát");
            System.out.println("Mời bạn nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    menuNewEmployee();
                    break;
                case 2:
                    menuSeniorEmployee();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Nhập sai mời nhập lại");
            }
        }
    }

    private static void menuNewEmployee() {
        NewEmployeeController newEmployeeController = new NewEmployeeController();
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("-------QUẢN LÝ NHÂN VIÊN MỚI-------");
            System.out.println("1. Hiển thị danh sách. ");
            System.out.println("2. Thêm mới. ");
            System.out.println("3. Sửa thông tin");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm nhân viên");
            System.out.println("0. Thoát");
            System.out.println("Mời bạn nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            List<NewEmployee> employees;
            switch (choice) {
                case 1:
                    employees = newEmployeeController.getAll();
                    newEmployeesTable(employees);
                    break;
                case 2:
                    NewEmployee newEmployee = inputNewEmployee(scanner);
                    newEmployeeController.save(newEmployee);
                    System.out.println("Thêm mới thành công");
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Nhập sai mời nhập lại");
            }
        }
    }
    private static NewEmployee inputNewEmployee(Scanner scanner) {
        System.out.println("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập mã nhân viên: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số ngày thử việc: ");
        int probationDays = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập thưởng thử việc: ");
        double probationBonus = Double.parseDouble(scanner.nextLine());
        NewEmployee newEmployee = new NewEmployee(name, id, probationDays, probationBonus);
        return newEmployee;
    }

    private static void newEmployeesTable(List<NewEmployee> employees) {
        System.out.println("+----------------------+----------------------+----------------------+----------------------+-------------+");
        System.out.println("| Tên Nhân Viên        | Mã Nhân Viên         | Số Ngày Thử Việc     | Thưởng Thử Việc      | Tổng Lương  |");
        System.out.println("+----------------------+----------------------+----------------------+----------------------+-------------+");
        for (NewEmployee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("+----------------------+----------------------+----------------------+----------------------+-------------+");
    }

    private static void menuSeniorEmployee() {
        SeniorEmployeeController seniorEmployeeController = new SeniorEmployeeController();
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("-------QUẢN LÝ NHÂN VIÊN LÂU NĂM-------");
            System.out.println("1. Hiển thị danh sách. ");
            System.out.println("2. Thêm mới. ");
            System.out.println("3. Sửa thông tin");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm nhân viên");
            System.out.println("0. Thoát");
            System.out.println("Mời bạn nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            List<SeniorEmployee> employees;
            switch (choice) {
                case 1:
                    employees = seniorEmployeeController.getAll();
                    seniorEmployeeTable(employees);
                    break;
                case 2:
                    SeniorEmployee seniorEmployee = inputSeniorEmployee(scanner);
                    seniorEmployeeController.save(seniorEmployee);
                    System.out.println("Thêm mới thành công");
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Nhập sai mời nhập lại");
            }
        }
    }

    private static void seniorEmployeeTable(List<SeniorEmployee> employees) {
        System.out.println("+----------------------+----------------------+----------------------+----------------------+-------------+");
        System.out.println("| Tên Nhân Viên        | Mã Nhân Viên         | Số Năm Kinh Nghiệm   | Phụ cấp              | Tổng Lương  |");
        System.out.println("+----------------------+----------------------+----------------------+----------------------+-------------+");
        for (SeniorEmployee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("+----------------------+----------------------+----------------------+----------------------+-------------+");
    }

    private static SeniorEmployee inputSeniorEmployee(Scanner scanner) {
        System.out.println("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập mã nhân viên: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số năm công tác: ");
        int yearsOfExperience = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập phụ cấp nhân viên: ");
        double setSeniorityAllowance = Double.parseDouble(scanner.nextLine());
        SeniorEmployee seniorEmployee = new SeniorEmployee(name,id,yearsOfExperience,setSeniorityAllowance);
        return seniorEmployee;
    }


}
