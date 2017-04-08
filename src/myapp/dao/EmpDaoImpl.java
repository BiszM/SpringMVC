package myapp.dao;

import myapp.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bisz on 4/8/17.
 */
@Repository
public class EmpDaoImpl implements EmpDao{
    @Autowired
    private SessionFactory session;

    @Override
    public void add(Employee employee) {
        session.getCurrentSession().save(employee);
    }

    @Override
    public void update(Employee employee) {
        session.getCurrentSession().update(employee);
    }

    @Override
    public void delete(int empID) {
        session.getCurrentSession().delete(getEmployee(empID));
    }

    @Override
    public Employee getEmployee(int empID) {
        return (Employee) session.getCurrentSession().get(Employee.class, empID);
    }

    @Override
    public List getAllEmployee() {
        return session.getCurrentSession().createQuery("from Employee").list();
    }
}
