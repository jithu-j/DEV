package com.perproj.learnspringboot;

////http://localhost:8080/courses
//[
//        {
//            "id": 1,
//        "name": "Learn AWS",
//        "author": "Jack"
//        }
//        ]

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1, "Learn AWS" , "Jack"),
                new Course(2, "Learn DevOps", "Jill")
        );
    }
}
