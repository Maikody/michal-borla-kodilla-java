package com.kodilla.hibernate.manytomany.facade;

import com.example.kodilla.hibernate.manytomany.Company;
import com.example.kodilla.hibernate.manytomany.Employee;
import com.example.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FacadeTestSuite {
    @Autowired
    public Facade facade;
    @Autowired
    private CompanyDao companyDao;

    @BeforeAll
    void init() {
        Employee johnSmith = new Employee("John", "Wachowsky");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarkson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.addEmployee(johnSmith);
        dataMaesters.addEmployee(stephanieClarckson);
        dataMaesters.addEmployee(lindaKovalsky);
        greyMatter.addEmployee(johnSmith);
        greyMatter.addEmployee(lindaKovalsky);

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
    }

    @Test
    public void testCompanySearchByName() {
        assertEquals(1, facade.findCompany("maest").size());
    }

    @Test
    public void testEmployeeSearchByName() {
        assertEquals(2, facade.findEmployee("sky").size());
    }

    @AfterAll
    void cleanDb() {
        companyDao.deleteAll();
    }
}