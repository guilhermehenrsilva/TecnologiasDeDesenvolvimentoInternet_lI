package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Medicamento;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repository.FarmaciaRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repository.MedicamentoRepository;

import jakarta.validation.Valid;

@Controller
public class MedicamentoController {

    @Autowired
    private MedicamentoRepository medicamentoRepo;

    @Autowired
    private FarmaciaRepository farmaciaRepo;

    @GetMapping("/medicamentos")
    public String listMedicamentos(Model model) {
        List<Medicamento> medicamento = medicamentoRepo.findAll();

        model.addAttribute("medicamentos", medicamento);

        return "medicamentos";
    }

    @GetMapping("/medicamentos/form")
    public String medicamentoForm(@ModelAttribute("medicamento") Medicamento medicamento) {
        return "medicamentos_form";
    }

    @PostMapping("/medicamentos/register")
    public String medicamentoNew(@Valid @ModelAttribute("medicamento") Medicamento medicamento, BindingResult errors) {

        if (errors.hasErrors()) {
            return "medicamentos_form";
        }

        farmaciaRepo.save(medicamento.getFarmacia());
        medicamentoRepo.save(medicamento);

        return "redirect:/medicamentos";
    }

    @GetMapping("/medicamentos/update/{id}")
    public String medicamentoUpdate(@PathVariable("id") Integer id, Model model) {

        Optional<Medicamento> medicamentoOpt = medicamentoRepo.findById(id);
        Medicamento medicamento;

        if(!medicamentoOpt.isPresent()) {
            medicamento = new Medicamento();
        } else {
            medicamento = medicamentoOpt.get();
        }

        model.addAttribute("medicamento", medicamento);

        return "medicamentos_form";
    }
    
    @GetMapping("/medicamentos/delete/{id}")
    public String medicamentoDelete(@PathVariable("id") Integer id) {

        medicamentoRepo.delete(new Medicamento(id));

        return "redirect:/medicamentos";
    }
}
