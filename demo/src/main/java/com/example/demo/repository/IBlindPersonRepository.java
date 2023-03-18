package com.example.demo.repository;

import com.example.demo.model.BlindPerson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlindPersonRepository extends JpaRepository<BlindPerson, Integer> {
    Page<BlindPerson> findAll (Pageable pageable);
}
