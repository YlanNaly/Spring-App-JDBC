package com.sprinapplicationperos.Repository;

import com.sprinapplicationperos.Model.Groups;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface GroupsRepo extends JpaRepository<Groups , Long> {
}
