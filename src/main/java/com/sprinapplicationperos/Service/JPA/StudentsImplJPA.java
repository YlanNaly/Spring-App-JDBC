package com.sprinapplicationperos.Service.JPA;

import com.sprinapplicationperos.Model.Students;
import com.sprinapplicationperos.Repository.StudentsRepoJPA;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
@AllArgsConstructor
@Getter
public class StudentsImplJPA{
    private StudentsRepoJPA repoJPA;
    public List<Students> getRepoJPA() {
        return repoJPA.findAll();
    }

    public Students add(Students s) throws SQLException {
        return repoJPA.save(s);
    }

    public String deleteById(Long a) throws SQLException {
        repoJPA.deleteById(a);
        return null;
    }

    public Students updateNameById(Long id, String newName) {
       Students str = new Students();
      if (repoJPA.findById(id).isPresent()){
          repoJPA.save(new Students(newName));
      };
       return str;
    }

}
