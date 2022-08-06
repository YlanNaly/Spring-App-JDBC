package com.sprinapplicationperos.Repository;

import com.sprinapplicationperos.Model.Students;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface StudentsRepo {
    List<Students> findAll() throws SQLException;

    String add(Students s) throws SQLException;

    void deleteById(Long a) throws SQLException;

    Students updateNameById(Long id , String newName);
    @Query(value = "SELECT * FROM students WHERE students.name ILIKE %(:id)% ")
    List<Students> findWhereNameLike(String query);
}
