package com.noobsmoke.springsecure.repository;

import com.noobsmoke.springsecure.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeRepo {

    private List<Student> studentList;


    {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Alice", 85));
        studentList.add(new Student(2, "Bob", 92));
        studentList.add(new Student(3, "Charlie", 78));
        studentList.add(new Student(4, "Diana", 88));
        studentList.add(new Student(5, "Ethan", 95));
        studentList.add(new Student(6, "Fiona", 81));
        studentList.add(new Student(7, "George", 73));
        studentList.add(new Student(8, "Hannah", 90));
        studentList.add(new Student(9, "Isaac", 84));
        studentList.add(new Student(10, "Julia", 97));
        studentList.add(new Student(11, "Kevin", 76));
        studentList.add(new Student(12, "Liam", 89));
        studentList.add(new Student(13, "Mia", 91));
        studentList.add(new Student(14, "Noah", 82));
        studentList.add(new Student(15, "Olivia", 94));
        studentList.add(new Student(16, "Paul", 68));
        studentList.add(new Student(17, "Quinn", 87));
        studentList.add(new Student(18, "Rachel", 79));
        studentList.add(new Student(19, "Sam", 83));
        studentList.add(new Student(20, "Tina", 96));

    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public void addNewStudent(Student newStudent) {
        studentList.add(newStudent);
    }


}
