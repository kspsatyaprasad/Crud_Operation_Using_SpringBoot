package com.springboot.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.demo.model.Individual;

public interface AlienRepo extends CrudRepository<Individual,Integer>
{

}
