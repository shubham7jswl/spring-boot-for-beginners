package com.sj.springbootforbeginners.repository;

import com.sj.springbootforbeginners.model.Roommate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoommateRepository extends JpaRepository<Roommate, Long> {
    List<Roommate> findAll();
}
