package GUI;

import BUS.StudentBUS;
import DTO.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class StudentGUI extends JFrame {
    private JTable table;

    public StudentGUI() {
        setSize(500, 500);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Name"});
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane);

        addSampleData();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addSampleData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        ArrayList<Student> data=new StudentBUS().listStudents();
        for(int i=0;i<data.size();i++) {
            model.addRow(data.get(i).toObject());
        }
    }
}
