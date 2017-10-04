/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing.Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javaswing.entity.Student;
import javaswing.model.StudentModel;
import javaswing.vaildate.VaildateInputData;
import javax.swing.*;

/**
 *
 * @author dongvu
 */
public class PopupOption {

    private JFrame frame;
    private JPanel background;
    private JLabel lblId;
    private JLabel lblName;
    private JLabel lblBirthday;
    private JLabel lblEmail;
    private JLabel lblPhone;
    private JLabel lblRollNumber;
    private JLabel lblClassName;

    private JLabel lblTotalMessage;
    private JLabel lblNameMessage;
    private JLabel lblBirthdayMessage;
    private JLabel lblEmailMessage;
    private JLabel lblPhonemessage;
    private JLabel lblRollNumberMessage;
    private JLabel lblClassNameMessage;

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtBirthday;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField txtRollNumber;
    private JTextField txtClassName;
    private JButton btnSubmit;
    private JButton btnReset;
    private static int operator = 0;

    StudentModel studentModel = new StudentModel();

    public void showPopupOption(Student stu) {
        frame = new JFrame("Option");
        frame.setLayout(null);
        this.background = new JPanel();
        this.background.setBounds(10, 0, 450, 580);
        this.background.setLayout(null);

        this.lblTotalMessage = new JLabel();
        this.lblTotalMessage.setBounds(10, 100, 420, 20);

        this.lblId = new JLabel("Student ID: ");
        this.lblId.setBounds(10, 135, 90, 30);

        this.lblId.setFont(new Font("Arial", 3, 12));

        this.txtId = new JTextField();
        this.txtId.setBounds(100, 135, 330, 30);
        this.txtId.setEditable(false);
        this.txtId.setText(String.valueOf(stu.getId()));

        this.lblName = new JLabel("Name: ");
        this.lblName.setBounds(10, 185, 90, 30);
        this.lblName.setFont(new Font("Arial", 3, 12));

        this.txtName = new JTextField(stu.getName());
        this.txtName.setBounds(100, 185, 330, 30);

        this.lblNameMessage = new JLabel();
        this.lblNameMessage.setBounds(100, 215, 330, 20);

        this.lblBirthday = new JLabel("Birthday: ");
        this.lblBirthday.setBounds(10, 235, 90, 30);
        this.lblBirthday.setFont(new Font("Arial", 3, 12));

        this.txtBirthday = new JTextField(stu.getBirthday());
        this.txtBirthday.setBounds(100, 235, 330, 30);

        this.lblBirthdayMessage = new JLabel();
        this.lblBirthdayMessage.setBounds(100, 265, 330, 20);

        this.lblEmail = new JLabel("Email: ");
        this.lblEmail.setBounds(10, 290, 90, 30);
        this.lblEmail.setFont(new Font("Arial", 3, 12));

        this.txtEmail = new JTextField(stu.getEmail());
        this.txtEmail.setBounds(100, 290, 330, 30);

        this.lblEmailMessage = new JLabel();
        this.lblEmailMessage.setBounds(100, 325, 330, 20);

        this.lblPhone = new JLabel("Phone: ");
        this.lblPhone.setBounds(10, 350, 90, 30);
        this.lblPhone.setFont(new Font("Arial", 3, 12));

        this.txtPhone = new JTextField(stu.getPhone());
        this.txtPhone.setBounds(100, 350, 330, 30);

        this.lblPhonemessage = new JLabel();
        this.lblPhonemessage.setBounds(100, 385, 330, 20);

        this.lblRollNumber = new JLabel("Roll-number: ");
        this.lblRollNumber.setBounds(10, 410, 90, 30);
        this.lblRollNumber.setFont(new Font("Arial", 3, 12));

        this.txtRollNumber = new JTextField(stu.getPhone());
        this.txtRollNumber.setBounds(100, 410, 330, 30);

        this.lblRollNumberMessage = new JLabel();
        this.lblRollNumberMessage.setBounds(100, 445, 330, 20);

        this.lblClassName = new JLabel("Class-name: ");
        this.lblClassName.setBounds(10, 470, 90, 30);
        this.lblClassName.setFont(new Font("Arial", 3, 12));

        this.txtClassName = new JTextField(stu.getClassName());
        this.txtClassName.setBounds(100, 470, 330, 30);

        this.lblClassNameMessage = new JLabel();
        this.lblClassNameMessage.setBounds(100, 505, 330, 20);

        this.btnSubmit = new JButton("Update");
        this.btnSubmit.setBounds(100, 530, 80, 30);
        this.btnSubmit.addActionListener(new updateHandle());

        this.btnReset = new JButton("Delete");
        this.btnReset.setBounds(185, 530, 70, 30);
        this.btnReset.addActionListener(new deleteHandle(stu.getId()));

        this.background.add(lblId);
        this.background.add(txtId);
        this.background.add(lblName);
        this.background.add(txtName);
        this.background.add(lblBirthday);
        this.background.add(txtBirthday);
        this.background.add(lblEmail);
        this.background.add(txtEmail);
        this.background.add(lblPhone);
        this.background.add(txtPhone);
        this.background.add(lblRollNumber);
        this.background.add(txtRollNumber);
        this.background.add(lblClassName);
        this.background.add(txtClassName);
        this.background.add(btnSubmit);
        this.background.add(btnReset);
        this.background.add(lblTotalMessage);
        this.background.add(lblNameMessage);
        this.background.add(lblEmailMessage);
        this.background.add(lblPhonemessage);
        this.background.add(lblRollNumberMessage);
        this.background.add(lblClassNameMessage);
        this.background.add(lblBirthdayMessage);

        frame.add(background);
        frame.setSize(550, 660);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

    private class updateHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Student student = new Student(Long.parseLong(txtId.getText()), txtName.getText(), txtBirthday.getText(), txtPhone.getText(), txtEmail.getText(), txtClassName.getText(), txtRollNumber.getText());
            HashMap<String, String> errors = new VaildateInputData().errors(student);
            resetlblErrors();
            if (errors.isEmpty()) {
                StringBuilder alert = new StringBuilder();
                alert.append("Are you want update to this infomation ?\n");
                alert.append("Student Id: ");
                alert.append(txtId.getText());
                alert.append("\nName: ");
                alert.append(txtName.getText());
                alert.append("\nBirthday: ");
                alert.append(txtBirthday.getText());
                alert.append("\nEmail: ");
                alert.append(txtEmail.getText());
                alert.append("\nPhone: ");
                alert.append(txtPhone.getText());
                alert.append("\nRoll-number: ");
                alert.append(txtRollNumber.getText());
                alert.append("\nClass-name: ");
                alert.append(txtClassName.getText());

                int result = JOptionPane.showConfirmDialog(null, alert.toString());
                if (result == 0) {
                    // Thực hiện insert student khi chọn yes.
                    studentModel.updateStudent(student);
                    PopupOption.operator = 2;
                    frame.dispose();
                }

            } else {
                showErrors(errors);

            }
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
            PopupOption.operator = 1;
            frame.dispose();
        }
    }

    public int returnOperation() {
        return this.operator;
    }

//    public Student returnUpdated() {
//        //return reStudent;
//    }
    private void resetlblErrors() {
        lblTotalMessage.setText("");
        lblNameMessage.setText("");
        lblBirthdayMessage.setText("");
        lblEmailMessage.setText("");
        lblPhonemessage.setText("");
        lblRollNumberMessage.setText("");
        lblClassNameMessage.setText("");
    }

    private void showErrors(HashMap<String, String> errors) {

        lblTotalMessage.setForeground(Color.red);
        lblTotalMessage.setText("* Invalid student information, please change the errors !!");

        if (errors.containsKey("txtName")) {
            lblNameMessage.setText(errors.get("txtName"));
            lblNameMessage.setForeground(Color.red);
        }
        if (errors.containsKey("txtBirthday")) {
            lblBirthdayMessage.setText(errors.get("txtBirthday"));
            lblBirthdayMessage.setForeground(Color.red);
        }
        if (errors.containsKey("txtEmail")) {
            lblEmailMessage.setText(errors.get("txtEmail"));
            lblEmailMessage.setForeground(Color.red);
        }
        if (errors.containsKey("txtPhone")) {
            lblPhonemessage.setText(errors.get("txtPhone"));
            lblPhonemessage.setForeground(Color.red);
        }
        if (errors.containsKey("txtRollNumber")) {
            lblRollNumberMessage.setText(errors.get("txtRollNumber"));
            lblRollNumberMessage.setForeground(Color.red);
        }
        if (errors.containsKey("txtClassName")) {
            lblClassNameMessage.setText(errors.get("txtClassName"));
            lblClassNameMessage.setForeground(Color.red);
        }
    }

}
