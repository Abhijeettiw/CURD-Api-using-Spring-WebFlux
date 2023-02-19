package com.Reactive.WebFlux.Repository;

import com.Reactive.WebFlux.Entity.Students;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends ReactiveCrudRepository<Students,Integer>
{

}
