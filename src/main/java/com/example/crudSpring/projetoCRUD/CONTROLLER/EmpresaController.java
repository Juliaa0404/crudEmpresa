package com.example.crudSpring.projetoCRUD.CONTROLLER;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.example.crudSpring.projetoCRUD.SERVICE.EmpresaService;


@Controller
public class EmpresaController {
    
    private final EmpresaService empresaService;

    //processo de instaciação de classe
    public EmpresaController(EmpresaService ligacaoEmpresaService){
        this.empresaService = ligacaoEmpresaService;
    }


}
