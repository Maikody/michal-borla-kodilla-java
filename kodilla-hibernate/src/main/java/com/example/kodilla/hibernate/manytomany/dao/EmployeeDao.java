package com.example.kodilla.hibernate.manytomany.dao;

import com.example.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Query
    List<Employee> retrieveEmployeeByLastname(@Param("LASTNAME") String lastname);

    @Query("SELECT e FROM Employee e " +
            " WHERE LOWER(e.firstname) LIKE LOWER(CONCAT('%',:ARG,'%'))" +
            " OR LOWER(e.lastname) LIKE LOWER(CONCAT('%',:ARG,'%'))")
    List<Employee> findByNameFragment(@Param ("ARG") String arg);
}
