package com.sprinapplicationperos.Controller;

import com.sprinapplicationperos.Model.Students;
import com.sprinapplicationperos.Repository.RepoImplementation.JPA.StudentsImplJPA;
import com.sprinapplicationperos.Repository.StudentsRepoJPA;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@Controller
@RestController
@AllArgsConstructor
public class ControllerApi {
    /**
    public String Registration(@RequestBody ){
        @PostMapping("/")

    }
     */
    private StudentsImplJPA studentsImplJPA;
    private StudentsRepoJPA repoJPA;
    @GetMapping(path="/jpa/allstudent")
    public @ResponseBody List<Students> findAll() {
        return studentsImplJPA.getRepoJPA();
    }
    @GetMapping(path = "/students?={id}")
    private String deleteById(@PathVariable (required = true) Long id) throws SQLException {
        if(id != null){
            return "Delete successfully";
        }
        return "Id not found";
    }
}
