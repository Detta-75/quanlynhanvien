package view;

import controller.NewEmployeeController;
import entity.Employee;
import entity.NewEmployee;

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
                    employees=newEmployeeController.getAll();
                    for (Employee employee : employees){
                        System.out.println(employee);
                    }
                    break;
                case 2:
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
}
