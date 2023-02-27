package skypro.dao;

import org.springframework.stereotype.Repository;
import skypro.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private SessionFactory sessionFactory;

    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Employee> getEmployee() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From Employee").list();
    }

    public Employee getEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    public void addEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }
    public void updateEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.update(employee);
    }

    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
