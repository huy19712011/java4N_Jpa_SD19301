package com.example.java4n_jpa_sd19301.service;

import com.example.java4n_jpa_sd19301.entity.Student;
import com.example.java4n_jpa_sd19301.repository.StudentDao;

import java.util.ArrayList;

public class StudentService {

    private StudentDao studentDao = new StudentDao();

    public ArrayList<Student> getStudents() {

        return studentDao.getStudents();
    }

    public void deleteStudent(long id) {

        studentDao.deleteStudent(id);
    }

    public void addStudent(Student student) {

        studentDao.addStudent(student);
    }

    public Student getStudentById(long id) {

        return studentDao.getStudentById(id);
    }

    public void updateStudent(Student student) {

        studentDao.updateStudent(student);
    }
}
