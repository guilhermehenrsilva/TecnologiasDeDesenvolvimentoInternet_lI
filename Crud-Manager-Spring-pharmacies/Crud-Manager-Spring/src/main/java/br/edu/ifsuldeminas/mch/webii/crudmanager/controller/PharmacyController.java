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

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Pharmacy;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.PharmacyRepository;
import jakarta.validation.Valid;

@Controller
public class PharmacyController {
	
	@Autowired
	private PharmacyRepository pharmacyRepo;
	
	@GetMapping("/pharmacies")
	public String listPharmacies(Model model) {
		List<Pharmacy> pharmacies = pharmacyRepo.findAll();
		model.addAttribute("pharmacies", pharmacies);
		return "pharmacy";
	}
	
	@GetMapping("/pharmacies/form")
	public String pharmacyForm(Model model) { 
		model.addAttribute("pharmacy", new Pharmacy());
		return "pharmacies_form";
	}
	
	@PostMapping("/pharmacies/register")
	public String pharmacyNew(@Valid @ModelAttribute("pharmacy") Pharmacy pharmacy, BindingResult erros) {
		if (erros.hasErrors()) {
			return "pharmacies_form";
		}
		pharmacyRepo.save(pharmacy);
		return "redirect:/pharmacies";
	}
	
	@GetMapping("/pharmacies/update/{id}")
	public String pharmacyUpdate(@PathVariable("id") Integer id, Model model) {
		Optional<Pharmacy> pharmacyOpt = pharmacyRepo.findById(id);
		if (pharmacyOpt.isPresent()) {
			model.addAttribute("pharmacy", pharmacyOpt.get());
		} else {
			model.addAttribute("pharmacy", new Pharmacy());
		}
		return "pharmacies_form";
	}
	
	@GetMapping("/pharmacies/delete/{id}")
	public String pharmacyDelete(@PathVariable("id") Integer id) {
		pharmacyRepo.deleteById(id);
		return "redirect:/pharmacies";  
	}
}
