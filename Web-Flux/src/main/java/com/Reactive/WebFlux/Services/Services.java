package com.Reactive.WebFlux.Services;

import com.Reactive.WebFlux.Entity.Students;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface Services
{
    public Mono<Students> getById(Integer rollNo);
    public Flux<Students> getAll();
    public void addStudent(Students students);
    public Mono<Students> updateStudent(Students students,Integer rollNo);
    public Mono<Void> deleteStudent(Integer rollno);
}
