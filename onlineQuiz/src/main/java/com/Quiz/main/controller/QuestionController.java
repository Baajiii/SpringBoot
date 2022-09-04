package com.Quiz.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Quiz.main.model.Question;
import com.Quiz.main.repository.QuestionRepo;
import com.Quiz.main.service.QuizService;

@RestController
@RequestMapping("/Quiz")
public class QuestionController {

	@Autowired
	private QuestionRepo qRepo;
	@Autowired
	QuizService qService;
	
	@GetMapping("/allquestions")
	public Iterable<Question> AllQuestion(Model map)
	{
		Iterable<Question> qlist = qService.getAllQuestions();
		map.addAttribute("qlist", qlist);
		
		return qlist;
	}
	
	@GetMapping("/questions/{id}")  
	public Question getquestion(@PathVariable("id") int ques_id)   
	{  
	return qService.getquestionsById(ques_id);  
	}  
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Integer ques_id) {
		Question q = new Question(ques_id);
	    qRepo.delete(q);
	} 
	
	@DeleteMapping("/all")
	public void deleteAll() {
	    qRepo.deleteAll();
	} 
	
	@PostMapping  
	public void saveQuestion(@RequestBody Question ques)   
	{  
	qRepo.save(ques);
	}  
	
	@PutMapping
	private void update(@RequestBody Question ques)   
	{  
	qRepo.save(ques);  
	}  
	
}
