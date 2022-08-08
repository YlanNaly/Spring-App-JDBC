package com.sprinapplicationperos.Controller;

import com.sprinapplicationperos.Model.Students;
import com.sprinapplicationperos.Service.JPA.StudentsImplJPA;
import com.sprinapplicationperos.Repository.StudentsRepoJPA;
import lombok.AllArgsConstructor;
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
    @GetMapping(path="/jpa/students")
    public @ResponseBody List<Students> findAll() {
        return studentsImplJPA.getRepoJPA();
    }
    @PostMapping(path = "/students?={id}")
    private String deleteById(@PathVariable (required = false) Long id) throws SQLException {
        if(id != null){
            return studentsImplJPA.deleteById(id);
        }
        return "Id not found";
    }
}
