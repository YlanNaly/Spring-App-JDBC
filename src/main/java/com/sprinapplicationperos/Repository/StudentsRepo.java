package com.sprinapplicationperos.Repository;

import com.sprinapplicationperos.Model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface StudentsRepo extends JpaRepository<Students , Long> {
}
