package BUS;

import DAO.StudentDAO;
import DTO.Student;

import java.util.ArrayList;

public class StudentBus {
    public ArrayList<Student> listStudents() {
        return new StudentDAO().listStudents();
    }
}
