package com.Reactive.WebFlux.Controller;

import com.Reactive.WebFlux.Entity.Students;
import com.Reactive.WebFlux.Services.StudentServices.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping(value = "/all",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Flux<Students> getAllStudents()
    {
        return studentService.getAll();
    }
    @GetMapping("/one/{rollNo}")
    @ResponseStatus(HttpStatus.FOUND)
    public Mono<Students> getById(@PathVariable Integer rollNo)
    {
        return studentService.getById(rollNo);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void newStudent(@RequestBody Students students)
    {
        studentService.addStudent(students);
    }

    @PutMapping("/update/{rollNo}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Students> updateCustomer(@RequestBody Students students, @PathVariable Integer rollNo) throws WebClientResponseException.NotFound
    {
        return studentService.updateStudent(students,rollNo);
    }
    @DeleteMapping("/delete/{rollNo}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deleteStudent(@PathVariable Integer rollNo)
    {
        studentService.deleteStudent(rollNo);
        return null;
    }
}
