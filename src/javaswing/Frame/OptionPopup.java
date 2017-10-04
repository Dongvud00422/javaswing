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

    public OptionPopup(Student student) {

        this.setTitle("Edit");
        this.setLayout(null);
        table = new JTable();
        btnDelete = new JButton("Delete");
        btnUpdate = new JButton("Update Information");
        btnUpdate.addActionListener(new updateHandle());
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

        @Override
        public void actionPerformed(ActionEvent e) {
            Vector vector = (Vector) data.get(table.getSelectedRow());
            int id = vector.get(0).hashCode();
            JOptionPane.showConfirmDialog(null, id);

        }
    }
}
