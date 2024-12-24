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
            choice = getChoice(scanner);
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
            System.out.println("3. Sửa thông tin. ");
            System.out.println("4. Xóa. ");
            System.out.println("5. Tìm kiếm theo mã nhân viên. ");
            System.out.println("6. Tìm kiếm tên nhân viên.. ");
            System.out.println("0. Thoát. ");
            System.out.println("Mời bạn nhập lựa chọn: ");
            List<NewEmployee> employees;
            choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    employees = newEmployeeController.getAll();
                    newEmployeesTable(employees);
                    break;
                case 2:
                    NewEmployee newEmployee = inputNewEmployee(scanner, newEmployeeController);
                    newEmployeeController.save(newEmployee);
                    System.out.println("Thêm mới thành công");
                    break;
                case 3:
                    updateNew(scanner, newEmployeeController);
                    break;
                case 4:
                    deleteIdNew(scanner, newEmployeeController);
                    break;
                case 5:
                    findByIdNew(scanner, newEmployeeController);
                    break;
                case 6:
                    findAllByNameNew(scanner, newEmployeeController);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Nhập sai mời nhập lại");
            }
        }
    }

    private static void findAllByNameNew(Scanner scanner, NewEmployeeController newEmployeeController) {
        List<NewEmployee> employees;
        System.out.println("Nhập tên cần tìm: ");
        String name;
        while (true) {
            name = scanner.nextLine().trim();
            if (!name.matches(".*\\d.*")) {
                name = capitalizeFirstLetter(name);
                break;
            } else {
                System.out.println("Tên không được chứa số. Vui lòng nhập lại: ");
            }
        }
        employees = newEmployeeController.findAllByName(name);
        newEmployeesTable(employees);
    }

    private static void updateNew(Scanner scanner, NewEmployeeController newEmployeeController) {
        NewEmployee newEmployee;
        int id;
        while (true) {
            System.out.println("Mời nhập ID cần cập nhật: ");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("ID không được để trống. Vui lòng nhập lại.");
            } else {
                try {
                    id = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("ID phải là số. Vui lòng nhập lại.");
                }
            }
        }
        newEmployee = newEmployeeController.findById(id);
        newTable(newEmployee);
        if (newEmployee != null) {
            inputUpdateNew(scanner, newEmployee);
            newEmployeeController.update(id, newEmployee);
            System.out.println("Cập nhật thành công");
        } else {
            System.out.println("Không tìm thấy để nhân viên này");
        }
    }

    private static void inputUpdateNew(Scanner scanner, NewEmployee newEmployee) {
        System.out.println("Nhập tên nhân viên: (bỏ trống để giữ nguyên)");
        String newName = scanner.nextLine();
        newName = capitalizeFirstLetter(newName);
        if (!newName.isEmpty()) {
            newEmployee.setName(newName);
        }
        System.out.println("Nhập mã nhân viên: (bỏ trống để giữ nguyên)");
        String newIdInput = scanner.nextLine();
        if (!newIdInput.isEmpty()) {
            int newId = Integer.parseInt(newIdInput);
            newEmployee.setId(newId);
        }
        System.out.println("Nhập số ngày thử việc: (bỏ trống để giữ nguyên)");
        String newProbationDaysInput = scanner.nextLine();
        if (!newProbationDaysInput.isEmpty()) {
            int newProbationDays = Integer.parseInt(newProbationDaysInput);
            newEmployee.setProbationDays(newProbationDays);
        }
        System.out.println("Nhập thưởng thử việc: (bỏ trống để giữ nguyên)");
        String newProbationBonusInput = scanner.nextLine();
        if (!newProbationBonusInput.isEmpty()) {
            double newProbationBonus = Double.parseDouble(newProbationBonusInput);
            newEmployee.setProbationBonus(newProbationBonus);
        }
    }

    private static void findByIdNew(Scanner scanner, NewEmployeeController newEmployeeController) {
        NewEmployee newEmployee;
        int id;
        while (true) {
            try {
                System.out.println("Nhập mã nhân viên cần tìm: ");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Mã nhân viên phải là số. Vui lòng nhập lại.");
            }
        }
        newEmployee = newEmployeeController.findById(id);
        newTable(newEmployee);
    }

    private static void newTable(NewEmployee newEmployee) {
        if (newEmployee == null) {
            System.out.println("Không có trong danh sách");
        } else {
            System.out.println("+----------------------+----------------------+----------------------+----------------------+-------------+");
            System.out.println("| Tên Nhân Viên        | Mã Nhân Viên         | Số Ngày Thử Việc     | Thưởng Thử Việc      | Tổng Lương  |");
            System.out.println("+----------------------+----------------------+----------------------+----------------------+-------------+");
            System.out.println(newEmployee);
            System.out.println("+----------------------+----------------------+----------------------+----------------------+-------------+");
        }
    }

    private static void deleteIdNew(Scanner scanner, NewEmployeeController newEmployeeController) {
        NewEmployee newEmployee;
        int id;
        while (true) {
            try {
                System.out.println("Nhập mã nhân viên cần xóa: ");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Mã nhân viên phải là số. Vui lòng nhập lại.");
            }
        }
        newEmployee = newEmployeeController.findById(id);
        if (newEmployee == null) {
            System.out.println("Không tìm thấy để xóa");
        } else {
            System.out.println("Thông tin của đối tượng: \n" + newEmployee);
            System.out.println("Bạn có chắc muốn xóa không (Y/N):");
            char confirm = scanner.nextLine().charAt(0);
            if (confirm == 'y') {
                newEmployeeController.remove(id);
                System.out.println("Xóa thành công");
            }
        }
    }


    private static NewEmployee inputNewEmployee(Scanner scanner, NewEmployeeController newEmployeeController) {
        NewEmployee newEmployees;
        System.out.println("Nhập tên nhân viên: ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) {
            name = capitalizeFirstLetter(name);
        }
        int id;
        while (true) {
            try {
                System.out.println("Nhập mã nhân viên: ");
                id = Integer.parseInt(scanner.nextLine());
                newEmployees = newEmployeeController.findById(id);
                if (newEmployees != null) {
                    System.out.println("Mã đã tồn tại, mời nhập lại");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Mã nhân viên phải là số. Vui lòng nhập lại.");
            }
        }
        int probationDays;
        while (true) {
            try {
                System.out.println("Nhập số ngày thử việc: ");
                probationDays = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Số ngày thử việc phải là số. Vui lòng nhập lại.");
            }
        }
        double probationBonus;
        while (true) {
            try {
                System.out.println("Nhập thưởng thử việc: ");
                probationBonus = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Thưởng thử việc phải là số. Vui lòng nhập lại.");
            }
        }
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

    //
    private static void menuSeniorEmployee() {
        SeniorEmployeeController seniorEmployeeController = new SeniorEmployeeController();
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("-------QUẢN LÝ NHÂN VIÊN LÂU NĂM-------");
            System.out.println("1. Hiển thị danh sách. ");
            System.out.println("2. Thêm mới. ");
            System.out.println("3. Sửa thông tin. ");
            System.out.println("4. Xóa. ");
            System.out.println("5. Tìm kiếm theo mã nhân viên. ");
            System.out.println("6. Tìm kiếm tên nhân viên. ");
            System.out.println("0. Thoát. ");
            System.out.println("Mời bạn nhập lựa chọn: ");
            List<SeniorEmployee> employees;
            choice = getChoice(scanner);
            switch (choice) {
                case 1:
                    employees = seniorEmployeeController.getAll();
                    seniorEmployeeTable(employees);
                    break;
                case 2:
                    SeniorEmployee seniorEmployee = inputSeniorEmployee(scanner, seniorEmployeeController);
                    seniorEmployeeController.save(seniorEmployee);
                    System.out.println("Thêm mới thành công");
                    break;
                case 3:
                    updateSenior(scanner, seniorEmployeeController);
                    break;
                case 4:
                    deleteIdSenior(scanner, seniorEmployeeController);
                    break;
                case 5:
                    findByIdSenior(scanner, seniorEmployeeController);
                    break;
                case 6:
                    findAllByNameSenior(scanner, seniorEmployeeController);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Nhập sai mời nhập lại");
            }
        }
    }

    private static void findAllByNameSenior(Scanner scanner, SeniorEmployeeController seniorEmployeeController) {
        List<SeniorEmployee> employees;
        System.out.println("Nhập tên cần tìm: ");
        String name;
        while (true) {
            name = scanner.nextLine().trim();
            if (!name.matches(".*\\d.*")) {
                name = capitalizeFirstLetter(name);
                break;
            } else {
                System.out.println("Tên không được chứa số. Vui lòng nhập lại: ");
            }
        }
        employees = seniorEmployeeController.findAllByName(name);
        seniorEmployeeTable(employees);
    }

    private static void updateSenior(Scanner scanner, SeniorEmployeeController seniorEmployeeController) {
        SeniorEmployee seniorEmployee;
        int id;
        while (true) {
            System.out.println("Mời nhập ID cần cập nhật: ");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("ID không được để trống. Vui lòng nhập lại.");
            } else {
                try {
                    id = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("ID phải là số. Vui lòng nhập lại.");
                }
            }
        }
        seniorEmployee = seniorEmployeeController.findById(id);
        seniorTable(seniorEmployee);
        if (seniorEmployee != null) {
            inputUpdateSenior(scanner, seniorEmployee);
            seniorEmployeeController.update(id, seniorEmployee);
            System.out.println("Cập nhật thành công");
        } else {
            System.out.println("Không tìm thấy để nhân viên này");
        }
    }

    private static void inputUpdateSenior(Scanner scanner, SeniorEmployee seniorEmployee) {
        System.out.println("Nhập tên nhân viên (bỏ trống để giữ nguyên): ");
        String newName = scanner.nextLine();
        newName = capitalizeFirstLetter(newName);
        if (!newName.isEmpty()) {
            seniorEmployee.setName(newName);
        }
        System.out.println("Nhập mã nhân viên (bỏ trống để giữ nguyên): ");
        String newIdInput = scanner.nextLine();
        if (!newIdInput.isEmpty()) {
            int newId = Integer.parseInt(newIdInput);
            seniorEmployee.setId(newId);
        }
        System.out.println("Nhập số năm công tác (bỏ trống để giữ nguyên): ");
        String newYearsOfExperienceInput = scanner.nextLine();
        if (!newYearsOfExperienceInput.isEmpty()) {
            int newYearsOfExperience = Integer.parseInt(newYearsOfExperienceInput);
            seniorEmployee.setYearsOfExperience(newYearsOfExperience);
        }
        System.out.println("Nhập phụ cấp nhân viên (bỏ trống để giữ nguyên): ");
        String newSeniorityAllowanceInput = scanner.nextLine();
        if (!newSeniorityAllowanceInput.isEmpty()) {
            double newSeniorityAllowance = Double.parseDouble(newSeniorityAllowanceInput);
            seniorEmployee.setSeniorityAllowance(newSeniorityAllowance);
        }
    }

    private static void deleteIdSenior(Scanner scanner, SeniorEmployeeController seniorEmployeeController) {
        SeniorEmployee seniorEmployee;
        int id;
        while (true) {
            try {
                System.out.println("Nhập mã nhân viên cần xóa: ");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Mã nhân viên phải là số. Vui lòng nhập lại.");
            }
        }
        seniorEmployee = seniorEmployeeController.findById(id);
        if (seniorEmployee == null) {
            System.out.println("Không tìm thấy để xóa");
        } else {
            System.out.println("Thông tin của đối tượng: \n" + seniorEmployee);
            System.out.println("Bạn có chắc muốn xóa không (Y/N):");
            char confirm = scanner.nextLine().charAt(0);
            if (confirm == 'y') {
                seniorEmployeeController.remove(id);
                System.out.println("Xóa thành công");
            }
        }
    }

    private static void findByIdSenior(Scanner scanner, SeniorEmployeeController seniorEmployeeController) {
        SeniorEmployee seniorEmployee;
        int id;
        while (true) {
            try {
                System.out.println("Nhập mã nhân viên cần tìm: ");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Mã nhân viên phải là số. Vui lòng nhập lại.");
            }
        }
        seniorEmployee = seniorEmployeeController.findById(id);
        seniorTable(seniorEmployee);
    }

    private static void seniorTable(SeniorEmployee seniorEmployee) {
        if (seniorEmployee == null) {
            System.out.println("Không có trong danh sách");
        } else {
            System.out.println("+----------------------+----------------------+----------------------+----------------------+-------------+");
            System.out.println("| Tên Nhân Viên        | Mã Nhân Viên         | Số Năm Kinh Nghiệm   | Phụ cấp              | Tổng Lương  |");
            System.out.println("+----------------------+----------------------+----------------------+----------------------+-------------+");
            System.out.println(seniorEmployee);
            System.out.println("+----------------------+----------------------+----------------------+----------------------+-------------+");
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

    private static SeniorEmployee inputSeniorEmployee(Scanner scanner, SeniorEmployeeController seniorEmployeeController) {
        SeniorEmployee seniorEmployees;
        System.out.println("Nhập tên nhân viên: ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) {
            name = capitalizeFirstLetter(name);
        }

        int id;
        while (true) {
            try {
                System.out.println("Nhập mã nhân viên: ");
                id = Integer.parseInt(scanner.nextLine());
                seniorEmployees = seniorEmployeeController.findById(id);
                if (seniorEmployees != null) {
                    System.out.println("Mã đã tồn tại, mời nhập lại.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Mã nhân viên phải là số. Vui lòng nhập lại.");
            }
        }
        int yearsOfExperience;
        while (true) {
            try {
                System.out.println("Nhập số năm công tác: ");
                yearsOfExperience = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Số năm công tác phải là số. Vui lòng nhập lại.");
            }
        }
        double seniorityAllowance;
        while (true) {
            try {
                System.out.println("Nhập phụ cấp nhân viên: ");
                seniorityAllowance = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Phụ cấp nhân viên phải là số. Vui lòng nhập lại.");
            }
        }
        SeniorEmployee seniorEmployee = new SeniorEmployee(name, id, yearsOfExperience, seniorityAllowance);
        return seniorEmployee;
    }

    private static int getChoice(Scanner scanner) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai, vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định");
            }
        }
        return choice;
    }

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        String[] words = input.split(" ");
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                capitalized.append(capitalizedWord).append(" ");
            }
        }

        return capitalized.toString().trim();
    }
}
