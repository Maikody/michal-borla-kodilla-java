package com.kodilla.hibernate.manytomany.facade;

import com.example.kodilla.hibernate.manytomany.Company;
import com.example.kodilla.hibernate.manytomany.Employee;
import com.example.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.example.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Facade {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> findCompany(String name) {
       return companyDao.findByNameFragment(name);
    }

    public List<Employee> findEmployee(String name) {
        return employeeDao.findByNameFragment(name);
    }

}
