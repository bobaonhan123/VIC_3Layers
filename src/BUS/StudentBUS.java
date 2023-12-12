package BUS;

import DAO.StudentDAO;
import DTO.Student;

import java.util.ArrayList;

public class StudentBUS {
    public ArrayList<Student> listStudents() {
        return new StudentDAO().listStudents();
    }
    public void addStudent(Student st) {
        new StudentDAO().addStudent(st);
    }
}
