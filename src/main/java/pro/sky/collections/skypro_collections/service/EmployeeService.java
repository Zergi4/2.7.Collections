package pro.sky.collections.skypro_collections.service;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.collections.skypro_collections.Employee;
import pro.sky.collections.skypro_collections.exception.EmloyeeNotFoundException;
import pro.sky.collections.skypro_collections.exception.EmployeeAlreadyAddedException;
import pro.sky.collections.skypro_collections.exception.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();
    private final static int MAX_SIZE = 5;

    public Employee add(String firstName, String lastName) {
        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }
        Employee newEmployee = new Employee(firstName, lastName);
     if (employees.containsKey(newEmployee.getFullName())) {

            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }

        employees.put(newEmployee.getFullName(), newEmployee);
        return newEmployee;
    }

    public Employee find(String firstName, String lastName) {
        Employee employeeForFound = new Employee(firstName, lastName);

            if (employees.containsKey(employeeForFound.getFullName())) {
                return employees.get(employeeForFound.getFullName());
            }

        throw new EmloyeeNotFoundException("Такого сотрудника нет");
    }

    public Employee remove(String firstName, String lastName) {
        Employee employeeForRemove = new Employee(firstName, lastName);
        if (employees.containsKey(employeeForRemove.getFullName())) {
            return employees.remove(employeeForRemove.getFullName());
        } else {
            throw new EmloyeeNotFoundException("Сотрудрник не удален, т.к. не был найден");
        }
    }

    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());
        //return Collections.EMPTY_SET;
    }

}
