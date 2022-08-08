package com.sprinapplicationperos.Controller;

import com.sprinapplicationperos.Model.Groups;
import com.sprinapplicationperos.Model.Students;
import com.sprinapplicationperos.Service.jdbc.StudentsImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Controller
@RestController
@AllArgsConstructor
public class ControllerApiJDBC {
    private StudentsImpl students;

    @GetMapping(path="/jdbc/students")
    public List<Students> getStudents() throws SQLException {
        return students.findAll();
    }
    @PostMapping(path="/jdbc/name={name}&id={id}")
    public @ResponseBody String add(@PathVariable(required = false)String name,@PathVariable(required = false) Long id) throws SQLException {
        LocalDate date = null;
        /*
        * TODO : localDate => "G1",  date.of(2022,9,9)
        */
        Groups groups = new Groups();
        return students.add(new Students(name,id,groups));
    }

    @DeleteMapping (path="/jdbc/delete={id} ")
    public Students delete(@PathVariable Long id) throws SQLException {
        return students.deleteById(id);
    }

    @PutMapping(path="/jdbc/{name} ")
    public List<Students> findWhereNameLike(@PathVariable (required = false) String name){
        return students.findWhereNameLike(name);
    }
}
