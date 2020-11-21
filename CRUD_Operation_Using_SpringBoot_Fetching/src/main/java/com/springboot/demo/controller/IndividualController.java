package com.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.demo.dao.IndividualRepo;
import com.springboot.demo.model.Individual;

@Controller
public class IndividualController
{
	@Autowired
	IndividualRepo repo;

	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	@RequestMapping("/addIndividual")
	public String addIndividual(Individual individual)
	{
		repo.save(individual);
		return "home.jsp";
	}
	@RequestMapping("/getIndividual")
	public ModelAndView getIndividual(@RequestParam int aid)
	{
		ModelAndView mv=new ModelAndView("showIndividual.jsp");
		Individual individual=repo.findById(aid).orElse(new Individual());
		mv.addObject(individual);
		return mv;
	}
}
