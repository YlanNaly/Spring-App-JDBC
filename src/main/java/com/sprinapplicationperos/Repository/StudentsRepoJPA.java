package com.sprinapplicationperos.Repository;

import com.sprinapplicationperos.Model.Students;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentsRepoJPA extends JpaRepository<Students, Long> {
    @Override
    Optional<Students> findById(Long aLong);

    @Query(value = "SELECT * FROM students WHERE students.id=(:id) ")
    List<Students> findStudentsByIdAndName(@Param("id") String id);
}
