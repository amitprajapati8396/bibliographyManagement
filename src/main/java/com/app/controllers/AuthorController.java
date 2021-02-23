package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.entities.Author;
import com.app.service.AuthorService;

@Controller
public class AuthorController {
	@Autowired
    private AuthorService authService;
	
	@GetMapping("/")
	public String showHome(Model model){
		Author author=new Author();
		model.addAttribute("author",author);
		model.addAttribute("authors",authService.getAllAuthors());
		return "home";
	}
	@GetMapping("/add")
	public String addAuthor(Model model){
		Author author=new Author();
		model.addAttribute("author",author);
		return "addAuthor";
	}
	@PostMapping("/saveAuthor")
	public String saveAuthor(@ModelAttribute("author") Author author){
		if((author.getName()==null ) || (author.getCountry()==null))
		 return "addAuthor";
		authService.addAuthor(author);
		return "redirect:/";
	}
	@PostMapping(path="searchAuthor/{name}")
	public String searchAuthor(@PathVariable String name,Model model){
		model.addAttribute("name",authService.getAuthorByName(name));
		
		return "redirect:/";
	}
}
