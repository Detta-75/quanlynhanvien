package entity;

public class SeniorEmployee extends Employee {
    private int yearsOfExperience;
    private double seniorityAllowance;

    public SeniorEmployee() {
    }

    public SeniorEmployee(String name, int id, int yearsOfExperience, double seniorityAllowance) {
        super(name, id);
        this.yearsOfExperience = yearsOfExperience;
        this.seniorityAllowance = seniorityAllowance;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public double getSeniorityAllowance() {
        return seniorityAllowance;
    }

    public void setSeniorityAllowance(double seniorityAllowance) {
        this.seniorityAllowance = seniorityAllowance;
    }

    @Override
    public String toString() {
        return String.format("| %-20s | %-20s | %-20d | %-20.2f | %-11.2f |", getName(), getId(),yearsOfExperience,seniorityAllowance,calculateSalary());
    }

    @Override
    double calculateSalary() {
        return LUONG_CO_BAN + (yearsOfExperience * seniorityAllowance);
    }
}
