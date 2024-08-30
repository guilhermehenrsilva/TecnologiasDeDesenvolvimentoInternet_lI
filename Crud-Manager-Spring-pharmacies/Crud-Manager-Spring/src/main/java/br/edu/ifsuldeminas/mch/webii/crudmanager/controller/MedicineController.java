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

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Medicine;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Pharmacy;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.PharmacyRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.MedicineRepository;
import jakarta.validation.Valid;

@Controller
public class MedicineController {
    
    @Autowired
    private MedicineRepository medicineRepo;
    
    @Autowired
    private PharmacyRepository pharmacyRepo;
    
    @GetMapping("/medicines")
    public String listMedicines(Model model) {
        List<Medicine> medicines = medicineRepo.findAll();
        model.addAttribute("medicines", medicines);
        return "medicine";
    }
    
    @GetMapping("/medicines/form")
    public String medicineForm(Model model) {
        model.addAttribute("medicine", new Medicine());
        model.addAttribute("pharmacy", pharmacyRepo.findAll());
        return "medicines_form";
    }
    
    @PostMapping("/medicines/register")
    public String medicineNew(@Valid @ModelAttribute("medicine") Medicine medicine, BindingResult erros) {
        if (erros.hasErrors()) {
            return "medicines_form";
        }
        
        // Não precisa salvar a farmácia aqui se já estiver associada ao medicamento
        medicineRepo.save(medicine);
        return "redirect:/medicines";
    }
    
    @GetMapping("/medicines/update/{id}")
    public String medicineUpdate(@PathVariable("id") Integer id, Model model) {
        Optional<Medicine> medicineOpt = medicineRepo.findById(id);
        Medicine medicine = medicineOpt.orElse(new Medicine());
        model.addAttribute("medicine", medicine);
        model.addAttribute("pharmacy", pharmacyRepo.findAll());
        return "medicines_form";
    }
    
    @GetMapping("/medicines/delete/{id}")
    public String medicineDelete(@PathVariable("id") Integer id) {
        medicineRepo.deleteById(id);
        return "redirect:/medicines";
    }
}
