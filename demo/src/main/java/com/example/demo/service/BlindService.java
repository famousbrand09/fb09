package com.example.demo.service;

import com.example.demo.model.BlindPerson;
import com.example.demo.repository.IBlindPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlindService implements IBlindService{
    @Autowired
    private IBlindPersonRepository blindPersonRepository;

    @Override
    public Page<BlindPerson> findAll(Pageable pageable) {
        return this.blindPersonRepository.findAll(pageable);
    }

    @Override
    public void save(BlindPerson blindPerson) {
        this.blindPersonRepository.save(blindPerson);
    }
}
