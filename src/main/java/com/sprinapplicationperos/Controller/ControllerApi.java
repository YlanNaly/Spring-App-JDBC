package com.sprinapplicationperos.Controller;

import com.sprinapplicationperos.Model.Students;
import com.sprinapplicationperos.Repository.StudentsRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@NoArgsConstructor
@RestController
public class ControllerApi {
    /**
    public String Registration(@RequestBody ){
        @PostMapping("/")

    }
     */
    @Autowired
    private StudentsRepo repo;
    @GetMapping("/students")
    private List<Students> findAll(){
        return repo.findAll();
    }
}
