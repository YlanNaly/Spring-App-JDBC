package com.sprinapplicationperos.Repository.RepoImplementation.jdbc;

import com.sprinapplicationperos.Model.Groups;
import com.sprinapplicationperos.Model.Students;
import com.sprinapplicationperos.Repository.StudentsRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Controller
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class StudentsImpl extends DbConnection implements StudentsRepo{

     DbConnection connection = new DbConnection();

    public List<Students> findAll() throws SQLException {
        Statement stmt = connection.getStatement();
        ResultSet rs;
        List<Students> studentsList = new ArrayList<>();
        try {
            rs = stmt.executeQuery("" +
                    "SELECT students.id,students.name , students.groups_id , creation_date , groups.name AS name_groups " +
                    " FROM students " +
                    "INNER JOIN Groups " +
                    "ON groups.id = students.groups_id " );

            while (rs.next()) {
                //Students
                   Long id = rs.getLong("id");
                   String name = rs.getString("name");

                   //Groups
                Long groups_id = rs.getLong("id");
                String groups_name = rs.getString("name_groups");
                Date creationDate = rs.getDate("creation_date");
                studentsList.add(new Students(name,id,new Groups(groups_name,groups_id, creationDate.toLocalDate())));
            }
            return studentsList;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Request failed");
        }
        return null;
    }
    @Override
    public String add(Students s ) throws SQLException {
        Statement stmt = connection.getStatement();
        Date date =new Date(2002,02,02);
        String strDateFormat = "yy-mm-dd";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        try{
            String choix =
                    "INSERT INTO Groups VALUES ("+s.getGroups().getName()+","+s.getId()+","+formattedDate+");"
                    +"INSERT INTO Students VALUES ("+s.getName()+","+s.getId()+","+s.getGroups().getId()+");";
            stmt.executeUpdate(choix);
            System.out.println("insert faites");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("insert failed");
        }
        return null;
    }

    @Override
    public void deleteById(Long a) throws SQLException {

    }

    @Override
    public Students updateNameById(Long id, String newName) {
        return null;
    }

    @Override
    public List<Students> findWhereNameLike(String query) {
        return null;
    }

}

/**
 * implementez cette interface avec une classe concrète avec JDBC
 * Devoir recherche sur google :
 *      proposez une autre implémentation avec JPQL
 *      Langage (vous pouvez voir l'annotation @Query) */