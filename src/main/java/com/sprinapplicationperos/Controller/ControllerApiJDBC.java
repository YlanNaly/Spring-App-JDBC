package com.sprinapplicationperos.Controller;

import com.sprinapplicationperos.Model.Groups;
import com.sprinapplicationperos.Model.Students;
import com.sprinapplicationperos.Repository.RepoImplementation.jdbc.StudentsImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
@RestController
@AllArgsConstructor
public class ControllerApiJDBC {
    private StudentsImpl students;

    @GetMapping(path="/jdbc/name={name}&id={id}")
    public @ResponseBody String add(@PathVariable(required = true)String name,@PathVariable(required = true) Long id) throws SQLException {
        LocalDate date = null;
        /*
        * TODO : localDate => "G1",  date.of(2022,9,9)
        */
        Groups groups = new Groups();
        return students.add(new Students(name,id,groups));
    }

    @GetMapping(path="/jdbc/allstudents")
    public List<Students> getStudents() throws SQLException {
        return students.findAll();
    }
}
