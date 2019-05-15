package com.example.springbootstudent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;
    @RequestMapping("/")
    public String index(Model model) {
        //Create course
        Course course = new Course();
        course.setName("Java");
        course.setConstructor("HeoNguyen");
        course.setCredit(3);
        //Create a student
        Student student= new Student();
        student.setStuName("zoi");
        student.setAge(18);
        //Add the student to an empty list
        Set<Student> students = new HashSet<Student>();
        students.add(student);
        //Add the list of students to the course
        course.setStudents(students);
        //Save the course to the database
        courseRepository.save(course);
        //Grad all courses from the database and send them to the template
        model.addAttribute("courses", courseRepository.findAll());
        return "index";
    }

}
