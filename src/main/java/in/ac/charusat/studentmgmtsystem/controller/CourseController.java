package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Course;
import in.ac.charusat.studentmgmtsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable Integer id){
        return courseRepository.findById(id).get();
    }
    @GetMapping("/listCourses")
    public List<Course> listCourses(){
        return courseRepository.findAll();
    }
    @PostMapping("/course")
    public List<Course> postCourses(@RequestBody Course course){
        courseRepository.save(course);
        return courseRepository.findAll();
    }
    @PutMapping("/course/{id}")
    public List<Course> updateCourse(@RequestBody Course course, @PathVariable Integer id){
        Course courseObj = courseRepository.findById(id).get();
        courseObj.setTitle(course.getTitle());
        courseObj.setId(course.getId());
        courseRepository.save(courseObj);
        return courseRepository.findAll();
    }
    @DeleteMapping("/course/{id}")
    public List<Course> deleteCourse(@PathVariable Integer id){
        courseRepository.delete(courseRepository.findById(id).get());
        return courseRepository.findAll();
    }
}
