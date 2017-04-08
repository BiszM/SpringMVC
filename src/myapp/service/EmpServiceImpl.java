package myapp.service;

import myapp.dao.EmpDao;
import myapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bisz on 4/8/17.
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Transactional
    public void add(Employee employee) {
        empDao.add(employee);
    }

    @Transactional
    public void update(Employee employee) {
        empDao.update(employee);
    }

    @Transactional
    public void delete(int empID) {
        empDao.delete(empID);
    }

    @Transactional
    public Employee getEmployee(int empID) {
        return empDao.getEmployee(empID);
    }

    @Transactional
    public List<Employee> getAllEmployee() {
        return empDao.getAllEmployee();
    }
}
