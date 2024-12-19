package service;

import entity.Employee;

import java.util.List;

public interface IService<T extends Employee> {
    List<T> getAll();

    void save(T t);

    void remove(int id);

    void update(int id, T t);

    T findById(int id);
}