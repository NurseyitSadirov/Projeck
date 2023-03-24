package service.impl;

import db.Database;
import enums.Gender;
import model.Student;
import service.StudentService;


import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    Database database = new Database();
    @Override
    public String addStudent(Student student) {
        database.getStudents().add(student);
        return "Success "+ student;
    }

    @Override
    public Student getStudentById(int id) {
        database.getStudents().stream() .filter(s -> s.getId() == id).findFirst().stream();
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return database.getStudents();
    }

    @Override
    public String updateStudentFullName(int id, String fullName) {
        database.getStudents().stream() .filter(s -> s.getId() == id)
                .map(s -> {
                    s.setFullName(fullName);
                    return s;
                })
                .findFirst();
        return database.getStudents().stream().map(Student::getFullName).findAny().orElse(null);
    }

    @Override
    public List<Student> filterByGender(){
        database.getStudents().stream().filter(x->x.getGender().equals(Gender.MALE)).forEach(System.out::println);
        database.getStudents().stream().filter(x->x.getGender().equals(Gender.FEMALE)).forEach(System.out::println);
        return null;
    }

    @Override
    public void deleteStudentById(int id) {
    database.getStudents().stream().filter(x->x.getId() != id).collect(Collectors.toList());
    database.getStudents().clear();
    }
}
