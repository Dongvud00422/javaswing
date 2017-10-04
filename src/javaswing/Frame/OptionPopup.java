/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javaswing.entity.Student;
import javaswing.model.StudentModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dongvu
 */
public class OptionPopup extends JFrame {

    private JTable table;
    private Vector colName;
    private Vector data;
    private Vector stu;
    private JButton btnDelete;
    private JButton btnUpdate;
    protected StudentModel studentModel = new StudentModel();
    private Student reStudent;
    private int operator;

    public OptionPopup(Student student) {

        this.setTitle("Edit");
        this.setLayout(null);
        table = new JTable();
        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new deleteHandle(student.getId()));
        btnUpdate = new JButton("Update Information");
        btnUpdate.addActionListener(new updateHandle(student.getId()));
        colName = new Vector();
        data = new Vector();
        this.stu = new Vector();

        btnDelete.setBounds(10, 180, 70, 30);
        btnUpdate.setBounds(90, 180, 150, 30);

        colName.add("ID");
        colName.add("Name");
        colName.add("Birthday");
        colName.add("Phone");
        colName.add("Email");
        colName.add("ClassName");
        colName.add("RollNumber");

        stu.add(student.getId());
        stu.add(student.getName());
        stu.add(student.getBirthday());
        stu.add(student.getPhone());
        stu.add(student.getEmail());
        stu.add(student.getClassName());
        stu.add(student.getRollNumber());
        data.add(stu);

        table.setModel(new DefaultTableModel(data, colName));
        table.setSize(950, 170);
        this.add(btnUpdate);
        this.add(btnDelete);
        this.add(table);
        this.setSize(950, 240);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    private class updateHandle implements ActionListener {

        private long id;

        public updateHandle(long id) {
            this.id = id;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Vector vector = (Vector) data.get(table.getSelectedRow());
            Student student = new Student();
            if (!(vector.get(0).hashCode() == id)) {
                JOptionPane.showMessageDialog(null, "* Can not change id");
                vector.set(0, "abc");
            } else {
                student.setId(vector.get(0).hashCode());
            }

            student.setName(vector.get(0).toString());
            student.setBirthday(vector.get(0).toString());
            student.setPhone(vector.get(0).toString());
            student.setEmail(vector.get(0).toString());
            student.setClassName(vector.get(0).toString());
            student.setRollNumber(vector.get(0).toString());

            studentModel.updateStudent(student);
            reStudent = student;
            operator = 1;
        }
    }

    private class deleteHandle implements ActionListener {

        private long id;

        public deleteHandle(long id) {
            this.id = id;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            studentModel.deleteStudent(id);
            operator = 0;
        }
    }

    public int returnOperation() {
        return operator;
    }

    public Student returnUpdated() {
        return reStudent;
    }
}
