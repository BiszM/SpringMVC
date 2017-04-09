package myapp.service;

import myapp.model.Employee;

import java.util.List;

/**
 * Created by bisz on 4/8/17.
 */
public interface EmpService {
    public void add(Employee employee);
    public void update(Employee employee);
    public void delete(int empID);
    public Employee getEmployee(int empID);
    public List getAllEmployee();
}
