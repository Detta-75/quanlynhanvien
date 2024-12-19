package entity;

public class NewEmployee extends Employee{
    private int probationDays;
    private double probationBonus;

    public NewEmployee() {
    }

    public NewEmployee(String name, int id, int probationDays, double probationBonus) {
        super(name, id);
        this.probationDays = probationDays;
        this.probationBonus = probationBonus;
    }

    public int getProbationDays() {
        return probationDays;
    }

    public void setProbationDays(int probationDays) {
        this.probationDays = probationDays;
    }

    public double getProbationBonus() {
        return probationBonus;
    }

    public void setProbationBonus(double probationBonus) {
        this.probationBonus = probationBonus;
    }

    @Override
    public String toString() {
        return String.format("| %-20s | %-20s | %-20d | %-20.2f | %-11.2f |", getName(), getId(),probationDays,probationBonus,calculateSalary());
    }

    @Override
    double calculateSalary() {
        return LUONG_CO_BAN + (probationBonus * probationDays);
    }

}
