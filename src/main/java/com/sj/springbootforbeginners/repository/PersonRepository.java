package com.sj.springbootforbeginners.repository;

import com.sj.springbootforbeginners.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByAgeGreaterThan(int age); // Example criteria
}
