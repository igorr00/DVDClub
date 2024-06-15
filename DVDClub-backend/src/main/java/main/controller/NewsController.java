package main.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import main.dto.NewsDTO;
import main.model.News;
import main.service.NewsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "news")
public class NewsController {

	@Autowired
	private NewsService newsService;
	
	@PostMapping("/add")
	public ResponseEntity<News> add(@RequestBody NewsDTO dto) throws MessagingException, UnsupportedEncodingException {
		
		if(newsService.add(dto)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAll")
    public @ResponseBody ArrayList<News> getAll(){
		return newsService.findAll();
	}
	
	@PostMapping("/edit")
    public @ResponseBody Boolean edit(@RequestBody News news){
		return newsService.edit(news);	
	}
	
	@GetMapping("/getById")
    public @ResponseBody News getById(@Param("id") Long id){
		return newsService.findById(id);
	}
	
	@DeleteMapping("/delete")
	public @ResponseBody void delete(@Param("id") Long id){
		newsService.delete(id);
	}
}
