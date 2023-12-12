package GUI;

import BUS.StudentBUS;
import DTO.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentGUI extends JFrame {
    private JTable table;

    public StudentGUI() {
        setSize(500, 600);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        DefaultTableModel tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Name"});
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,0,500,400);
        contentPane.add(scrollPane);
        addSampleData();
        JTextField tf=new JTextField();
        tf.setBounds(0,400,400,30);
        JButton bt=new JButton("Cập nhật");
        bt.setBounds(0,500,300,30);
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentBUS().addStudent(new Student(tf.getText()));
                addSampleData();
            }
        });
        contentPane.add(tf);
        contentPane.add(bt);
        contentPane.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addSampleData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        ArrayList<Student> data=new StudentBUS().listStudents();
        model.getDataVector().removeAllElements();
        for(int i=0;i<data.size();i++) {
            model.addRow(data.get(i).toObject());
        }
    }
}
