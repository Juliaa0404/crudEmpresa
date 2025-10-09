package com.example.crudSpring.projetoCRUD.CONTROLLER;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.crudSpring.projetoCRUD.ENTITY.Empresa;
import com.example.crudSpring.projetoCRUD.SERVICE.EmpresaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;








@Controller
@RequestMapping("/empresaCTR")

public class EmpresaController {
    
    private final EmpresaService empresaService;

    //processo de instaciação de classe
    public EmpresaController(EmpresaService ligacaoEmpresaService){
        this.empresaService = ligacaoEmpresaService;
    }

    @GetMapping("/listarTodasEmpresas")
    public String listarEmpresa(Model oModel) {
        oModel.addAttribute("empresas", empresaService.findAll());
        return "listarEmpresas";
    }
    
    
    @GetMapping("/viewCadEmpresa")
    public String mostrarFormCadastro(Model oModel){//model serve para chamar o frontend
        oModel.addAttribute("empresa", new Empresa());
        return "cadastroEmpresa";
    }

    // @ = notation
    @PostMapping("/salvarEmpresa")
    public String salvarEmpresa( @ModelAttribute Empresa objEmpresa) {
       //chamando o método cadastrar e passando o objeto("pacotinho") com os dados que precisam ser salvos
        empresaService.cadastrarEmpresa(objEmpresa);
        return "redirect:/empresaCTR/listarTodasEmpresas";
    }

    @GetMapping("/editar/{id}")
    public String formEditar(@PathVariable("id") Long id, Model oModel) {
        
        Empresa objEmpresa = empresaService.buscaPorId(id)
        .orElseThrow(() -> new 
        IllegalArgumentException("Empresa não encontrada"));

        oModel.addAttribute("empresaEditar", objEmpresa);
        return "editarEmpresa";
    }

    @PostMapping("/atualizarEmpresa/{id}")
    public String empresaAtualizar(@PathVariable("id") Long id, 
    @ModelAttribute Empresa objEmpresaAtualizado) {

        empresaService.editarDadoEmpresa(id, objEmpresaAtualizado);

        return "redirect:/empresaCTR/listarTodasEmpresas";
    }
    
    @GetMapping("/deletarEmpresa/{id}")
    public String apagarEmpresa(@PathVariable ("id") Long id) {

        empresaService.deletarEmpresa(id);
        
        return "redirect:/empresaCTR/listarTodasEmpresas";
    }
    
    
    
}