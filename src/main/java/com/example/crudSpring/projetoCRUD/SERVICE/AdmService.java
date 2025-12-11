package com.example.crudSpring.projetoCRUD.SERVICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudSpring.projetoCRUD.REPOSITORY.AdmRepository;

@Service
public class AdmService {
    

    @Autowired
    private AdmRepository admRepository;

   
}