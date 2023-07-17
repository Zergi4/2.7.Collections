package pro.sky.collections.skypro_collections.service;


import org.springframework.stereotype.Service;
import pro.sky.collections.skypro_collections.Employee;
import pro.sky.collections.skypro_collections.exception.EmloyeeNotFoundException;
import pro.sky.collections.skypro_collections.exception.EmployeeAlreadyAddedException;
import pro.sky.collections.skypro_collections.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private final static int MAX_SIZE = 2;

    public Employee add(String firstName, String lastName) {
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee find(String firstName, String lastName) {
        Employee employeeForFound = new Employee(firstName, lastName);
        for (Employee employee : employees) {
            if (employee.equals(employeeForFound)) {
                return employeeForFound;
            }
        }
        throw new EmloyeeNotFoundException("Такого сотрудника нет");
    }

    public Employee remove(String firstName, String lastName) {
        Employee employeeForRemove = new Employee(firstName, lastName);
       boolean removeResult=  employees.remove(employeeForRemove);
        if (removeResult) {
            return employeeForRemove;
        } else {
            throw new EmloyeeNotFoundException("Сотрудрник не удален, т.к. не был найден");
        }
    }

    public List<Employee> getAll() {
        return employees;
    }

}
