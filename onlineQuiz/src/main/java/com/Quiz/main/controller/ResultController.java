package com.Quiz.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Quiz.main.model.Question;
import com.Quiz.main.model.Result;
import com.Quiz.main.repository.QuestionRepo;
import com.Quiz.main.repository.ResultRepo;
import com.Quiz.main.service.QuizService;

@RestController
@RequestMapping("/Result")
public class ResultController {

	@Autowired
	private ResultRepo rRepo;
	@Autowired
	QuizService qService;
	
	@GetMapping("/allResult")
	public Iterable<Result> allResult(Model map)
	{
		Iterable<Result> rlist = qService.getAllResult();
		map.addAttribute("rlist", rlist);
		
		return rlist;
	}
	
	@GetMapping("/{id}")  
	public Result getquestion(@PathVariable("id") int id  )
	{  
	return qService.getResultById(id);  
	}  
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") Integer id) {
		Result q = new Result(id);
	    rRepo.delete(q);
	} 
	
	@DeleteMapping("/all")
	public void deleteAll() {
	    rRepo.deleteAll();
	} 
	
	@PostMapping  
	public void saveQuestion(@RequestBody Result res)   
	{  
	rRepo.save(res);
	}  
	
	@PutMapping
	private void update(@RequestBody Result res)   
	{  
	rRepo.save(res);  
	}  
}
