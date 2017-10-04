/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javaswing.entity.Student;
import javaswing.model.StudentModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dongvu
 */
public class GetListStudent extends JPanel {

    private JTable table;
    private JScrollPane scroll;
    private ArrayList<Student> listStudent;
    private DefaultTableModel tableModel;

    public GetListStudent() {
        // Tao khung cho bang.
        tableModel = new DefaultTableModel();
        table = new JTable() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        listStudent = new StudentModel().getListStudent();

        int count = 0;
        Long[] id = new Long[listStudent.size()];
        String[] name = new String[listStudent.size()];
        String[] birthday = new String[listStudent.size()];
        String[] phone = new String[listStudent.size()];
        String[] email = new String[listStudent.size()];
        String[] className = new String[listStudent.size()];
        String[] rollNumber = new String[listStudent.size()];
        for (Student student : listStudent) {
            id[count] = student.getId();
            name[count] = student.getName();
            birthday[count] = student.getBirthday();
            phone[count] = student.getPhone();
            email[count] = student.getEmail();
            className[count] = student.getClassName();
            rollNumber[count] = student.getRollNumber();
            count++;
        }
        tableModel.addColumn("Id", id);
        tableModel.addColumn("Name", name);
        tableModel.addColumn("Birthday", birthday);
        tableModel.addColumn("Phone", phone);
        tableModel.addColumn("Email", email);
        tableModel.addColumn("ClassName", className);
        tableModel.addColumn("RollNumber", rollNumber);

        table.addMouseListener(new mouseListener());

        table.setModel(tableModel);
        scroll = new JScrollPane(table);

        scroll.setBounds(15, 15, 920, 550);
        this.setLayout(null);
        this.add(scroll);

    }

    private class mouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int row = table.getSelectedRow();
            Student stu = listStudent.get(row);
            PopupOption popup = new PopupOption();
            popup.showPopupOption(stu);
            System.out.println(popup.returnOperation());
            if (popup.returnOperation() == 1) {
                tableModel.removeRow(row);
            } else if (popup.returnOperation() == 2) {
               // Student updatedStu = popup.returnUpdated();
                //Object[] newData = new Object[]{updatedStu.getId(), updatedStu.getName(), updatedStu.getBirthday(), updatedStu.getPhone(), updatedStu.getEmail(), updatedStu.getClassName(), updatedStu.getRollNumber()};
                //tableModel.insertRow(row, newData);
                
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
