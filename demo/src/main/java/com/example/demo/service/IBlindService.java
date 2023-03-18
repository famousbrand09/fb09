package com.example.demo.service;

import com.example.demo.model.BlindPerson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBlindService {
    Page<BlindPerson> findAll(Pageable pageable);

    void save(BlindPerson blindPerson);
}
