package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudentToMap(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacherToMap(teacher);
    }

    public void createStudentTeacherPair(String studentName,String teacherName){
        studentRepository.pairStudentAndTeacher(studentName,teacherName);
    }

    public Student findStudent(String studentName){
        return studentRepository.findStudentByName(studentName);
    }

    public Teacher findTeacher(String teacherName){
        return studentRepository.findTeacherByName(teacherName);
    }

    public List<String> findStudentByTeacher(String teacherName){
        return studentRepository.findStudentsByTeacherName(teacherName);
    }

    public List<String> findAllStudents(){
        return studentRepository.findAllStudents();
    }

    public void deleteTeacherAndStudent(String teacherName){
        studentRepository.deleteTeacherAndStudents(teacherName);
    }

    public void deleteAllTeacherStudent(){
        studentRepository.deleteAllTeacherStudent();
    }
}
