package DAO;

import DTO.Student;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAO {
    public ArrayList<Student> listStudents() {
        try {
            ArrayList<Student> res=new ArrayList<Student>();
            ResultSet rs= new DBConn().queryDB("SELECT * FROM student");
            while (rs.next()) {
                res.add(new Student(rs.getInt(1),rs.getString(2)));
            }
            return res;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Student>();
    }
    public void addStudent(Student st) {
        try {
            new DBConn().updateDB("INSERT INTO student VALUES (null,'"+st.getName()+"')");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
