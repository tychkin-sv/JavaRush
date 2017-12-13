package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {

        return students;
    }



    public Student getStudentWithAverageGrade(double averageGrade) {
        Student studentWithAverageGrade = null;

        if (students.size()>0){
            for (Student student:students) {
                if (Double.compare(student.getAverageGrade(), averageGrade) == 0){
                    studentWithAverageGrade = student;
                    return studentWithAverageGrade;
                }
            }
        }
        return studentWithAverageGrade;
    }


    //возвращает студента с максимальным средним баллом
    public Student getStudentWithMaxAverageGrade() {
        Student studentWithMaxAverageGrade = null;
        Double maxAverageGrade=Double.MIN_VALUE;
        if (students.size()>0){
           for (Student student:students) {
               if (student.getAverageGrade()>maxAverageGrade){
                   studentWithMaxAverageGrade = student;
                   maxAverageGrade = student.getAverageGrade();
               }
           }
        }
        return studentWithMaxAverageGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        Student studentWithMinAverageGrade = null;
        Double minAverageGrade=Double.MAX_VALUE;
        if (students.size()>0){
            for (Student student:students) {
                if (student.getAverageGrade()<minAverageGrade){
                    studentWithMinAverageGrade = student;
                    minAverageGrade = student.getAverageGrade();
                }
            }
        }
        return studentWithMinAverageGrade;
    }
    public void expel(Student student){
        students.remove(student);
    }
}