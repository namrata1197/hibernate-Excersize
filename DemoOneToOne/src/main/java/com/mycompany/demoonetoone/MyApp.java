package com.mycompany.demoonetoone;

import com.mycompany.demoonetoone.dao.StudentDao;
import com.mycompany.demoonetoone.entity.Address;
import com.mycompany.demoonetoone.entity.Education;
import com.mycompany.demoonetoone.entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 *
 * @author namrata
 */
public class MyApp {
    
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager = MyEntityManager.getEntityManager();
    
    public static void main(String[] args) {
        Student s=new Student("namrata","balvantbhai","dodiya","Ms","B.tech","gsduya","9876543210",null,null);
        Education e=new Education("B.tech","computer","2019","xyz",null);
        Address a=new Address("street1", "street2", "city","state", "county", "country");
        s.setAddress(a);
        s.setEducation(e);
        e.setStudent(s);
        StudentDao sd=new StudentDao();
        sd.addStudent(s);
    }
}
