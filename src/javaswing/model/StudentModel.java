/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing.model;

import javaswing.entity.Student;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dongvu
 */
public class StudentModel {

    public ArrayList<Student> getListStudent() {
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            Statement stt = DAO.getConnection().createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM Student;");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setBirthday(rs.getString("birthday"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setClassName(rs.getString("class_name"));
                student.setRollNumber(rs.getString("roll_number"));

                listStudent.add(student);
            }
        } catch (SQLException ex) {
            System.err.println("Get list erorr !!!\n" + ex.getMessage());
        }
        return listStudent;
    }

    public Student getById(int id) {
        Student student = new Student();
        try {
            Statement stt = DAO.getConnection().createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM Student WHERE id=" + id);
            if (rs.next()) {
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setBirthday(rs.getString("birthday"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setClassName(rs.getString("class_name"));
                student.setRollNumber(rs.getString("roll_number"));

                return student;
            }
        } catch (SQLException ex) {
            System.err.println("Get list by Id erorr !!!\n" + ex.getMessage());
        }

        return null;
    }

    public void insert(Student student) {
        try {
            PreparedStatement preStt = DAO.getConnection().prepareStatement("INSERT INTO Student VALUE (?,?,?,?,?,?,?);");
            preStt.setLong(1, student.getId());
            preStt.setString(2, student.getName());
            preStt.setString(3, student.getBirthday());
            preStt.setString(4, student.getEmail());
            preStt.setString(5, student.getPhone());
            preStt.setString(6, student.getClassName());
            preStt.setString(7, student.getRollNumber());

            preStt.execute();

            System.out.println("-- Add student success --");
            JOptionPane.showMessageDialog(null, "Insert student infomation success !! ");
        } catch (SQLException ex) {
            System.err.println("Add student erorr !!!\n" + ex.getMessage());
        }
    }

    public void updateStudent(Student updateStudent) {
        try {
            PreparedStatement preStt = DAO.getConnection().prepareStatement("UPDATE Student SET name=?, birthday=?, email=?, phone=?, class_name=?, roll_number=? WHERE id=?");
            preStt.setString(1, updateStudent.getName());
            preStt.setString(2, updateStudent.getBirthday());
            preStt.setString(3, updateStudent.getEmail());
            preStt.setString(4, updateStudent.getPhone());
            preStt.setString(5, updateStudent.getClassName());
            preStt.setString(6, updateStudent.getRollNumber());
            preStt.setLong(7, updateStudent.getId());

            preStt.execute();
            System.out.println("-- Edit student success --");
            JOptionPane.showMessageDialog(null, "Update student infomation success !! ");
        } catch (SQLException ex) {
            System.err.println("Update student erorr !!!\n" + ex.getMessage());
        }
    }

    public void deleteStudent(long id) {
        try {
            PreparedStatement preStt = DAO.getConnection().prepareStatement("DELETE FROM Student WHERE id = ?");
            preStt.setLong(1, id);
            preStt.execute();
            System.out.println("-- Delete student success --");
            JOptionPane.showMessageDialog(null, "Delete student infomation success !! ");
        } catch (SQLException ex) {
            System.err.println("Delete student erorr !!!\n" + ex.getMessage());
        }
    }
}
