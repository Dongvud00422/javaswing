/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing.vaildate;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javaswing.entity.Student;

/**
 *
 * @author dongvu
 */
public class VaildateInputData {

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_REGEX = "^0(1\\d{9}|9\\d{8})$";

    public boolean vaildateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean vaildatePhone(String phone) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public HashMap<String, String> errors(Student student) {
        HashMap<String, String> errors = new HashMap<>();
        if (student.getName().isEmpty()) {
            errors.put("txtName", "* Name can not empty !!");
        }
        if (student.getBirthday().isEmpty()){
            errors.put("txtBirthday", "* Birthday can not empty !!");
        }
        if (student.getEmail().isEmpty()) {
            errors.put("txtEmail", "* Email can not empty !!");
        } else if (!vaildateEmail(student.getEmail())) {
            errors.put("txtEmail", "* Email format Error !!");
        }
        if(student.getPhone().isEmpty()){
            errors.put("txtPhone", "* Phone can not empty !!");
        } else if (!vaildatePhone(student.getPhone())){
            errors.put("txtPhone", "* Phone format Error !!");
        }
        if (student.getRollNumber().isEmpty()){
            errors.put("txtRollNumber", "* RollNumber can not empty !!");
        }
        if (student.getClassName().isEmpty()){
            errors.put("txtClassName", "* ClassName can not empty !!");
        }
        return errors;
    }
}
