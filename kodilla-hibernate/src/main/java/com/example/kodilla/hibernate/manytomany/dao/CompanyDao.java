package com.example.kodilla.hibernate.manytomany.dao;

import com.example.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query(nativeQuery = true)
    List<Company> retrieveCompanyByFirstThreeLetters(@Param("TICKER") String ticker);

    @Query("SELECT c FROM Company c " +
            " WHERE LOWER(c.name) LIKE LOWER(CONCAT('%',:ARG,'%'))")
    List<Company> findByNameFragment(@Param ("ARG") String arg);
}
