package com.Reactive.WebFlux.Services.StudentServices;

import com.Reactive.WebFlux.Entity.Students;
import com.Reactive.WebFlux.Repository.StudentRepo;
import com.Reactive.WebFlux.Services.Services;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@Getter
@Setter
@NoArgsConstructor
@Lazy
public class StudentServiceImpl implements Services
{
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Mono<Students> getById(Integer rollNo)
    {
        return studentRepo.findById(rollNo).switchIfEmpty(Mono.error(new Exception("Student not found")));
    }

    @Override
    public Flux<Students> getAll()
    {
        return studentRepo.findAll();
    }

    @Override
    public void addStudent(Students students)
    {
        studentRepo.save(students).subscribe();
    }

    @Override
    public Mono<Students> updateStudent(Students students, Integer rollNo)
    {
        return studentRepo.findById(students.getRollno())
                .switchIfEmpty(Mono.error(new Exception("Student not found")))
                .map(s->{
                    s.setName(students.getName());
                    s.setClas(students.getClas());
                    s.setGuardian(students.getGuardian());
                    return s;
                }).flatMap(studentRepo::save);
    }

    @Override
    public Mono<Void> deleteStudent(Integer rollno)
    {
        studentRepo.deleteById(rollno).switchIfEmpty(Mono.error(new Exception("Student not found")));
        return null;
    }
}
