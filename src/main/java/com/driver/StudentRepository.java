package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {

     private HashMap<String,Student> studentHashMap;
     private HashMap<String,Teacher> teacherHashMap;
     private HashMap<String, List<String>> teacherStudentPair;

     public StudentRepository(){
         this.studentHashMap=new HashMap<>();
         this.teacherHashMap=new HashMap<>();
         this.teacherStudentPair=new HashMap<>();
     }

     public void addStudentToMap(Student student){
         studentHashMap.put(student.getName(), student);
     }

     public void addTeacherToMap(Teacher teacher){
         teacherHashMap.put(teacher.getName(), teacher);
     }

     public void pairStudentAndTeacher(String studentName,String teacherName){

         List<String> studentList = new ArrayList<>();
         if(teacherStudentPair.containsKey(teacherName)){
             studentList = teacherStudentPair.get(teacherName);
         }
         studentList.add(studentName);

         teacherStudentPair.put(teacherName,studentList);
     }

     public Student findStudentByName(String studentName){
           return studentHashMap.get(studentName);
     }

     public Teacher findTeacherByName(String teacherName){
         return teacherHashMap.get(teacherName);
     }

     public List<String> findStudentsByTeacherName(String teacherName){

         List<String> studentList = new ArrayList<>();

         if(teacherStudentPair.containsKey(teacherName)){
             studentList = teacherStudentPair.get(teacherName);
         }
         return studentList;
     }

     public List<String> findAllStudents(){

         List<String> allStudentList = new ArrayList<>(studentHashMap.keySet());
         return allStudentList;
     }

     public void deleteTeacherAndStudents(String teacherName){

            List<String> studentsOfTeacher = new ArrayList<>();

            if(teacherStudentPair.containsKey(teacherName)){
                studentsOfTeacher = teacherStudentPair.get(teacherName);
            }

            for(String student: studentsOfTeacher){
                if(studentHashMap.containsKey(student)){
                    studentHashMap.remove(student);
                }
            }

            if(teacherHashMap.containsKey(teacherName))
                teacherHashMap.remove(teacherName);

     }

     public void deleteAllTeacherStudent(){

         List<String> studentList = new ArrayList<>();

         teacherHashMap = new HashMap<>();

         for(String teacherName: teacherStudentPair.keySet()){
             for(String studentName: teacherStudentPair.get(teacherName)){
                 studentList.add(studentName);
             }
         }

         for(String studentName:studentList){
             if(studentHashMap.containsKey(studentName)){
                 studentHashMap.remove(studentName);
             }
         }

         teacherStudentPair = new HashMap<>();
     }

}
