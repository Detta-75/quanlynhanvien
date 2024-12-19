package entity;

import java.text.DecimalFormat;

public abstract class Employee {
    private String name;
    private int id;
    public static final double LUONG_CO_BAN = 1800000;
    abstract double calculateSalary();

    public Employee() {
    }

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    static String formatConversion(double d) {
        DecimalFormat df = new DecimalFormat("#,###.0");
        return  df.format(d);
    }

    @Override
    public String toString() {
        return "Tên: " + name + ", mã nhân viên: " + id;
    }
}
