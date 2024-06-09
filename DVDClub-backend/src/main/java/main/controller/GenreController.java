package main.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.model.Genre;
import main.service.GenreService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "genre")
public class GenreController {

	@Autowired
	private GenreService genreService;
	
	@GetMapping("/getAll")
    public @ResponseBody ArrayList<Genre> getAll(){
		return genreService.findAll();
	}
}
