package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.entities.Publication;
import com.app.service.PublicationService;

@Controller
public class PublicationController {
   @Autowired
   private PublicationService pubService;
   
   @GetMapping("/showPublication")	
   public String showPublications(Model model){
	   model.addAttribute("publications",pubService.getAll());
	   return "publication";
   }
   @GetMapping("/addPublication")
   public String addPublication(Model model){
	  Publication publication=new Publication();
	  model.addAttribute("publication",publication);
	  return "addPublication"; 
   }
   @PostMapping("/savePublication")
   public String savePublication(@ModelAttribute("publication") Publication publication) {
	   pubService.addPublication(publication);
	   return "redirect:/showPublication";
   }
}
