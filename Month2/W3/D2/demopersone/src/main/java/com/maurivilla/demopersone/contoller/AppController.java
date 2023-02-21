package com.maurivilla.demopersone.contoller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maurivilla.demopersone.entities.Person;

@RestController
@RequestMapping("/app")
public class AppController {
@GetMapping("/data1")
public String data1() {
	return "response";
}
@GetMapping("/data2")

public ResponseEntity<List<Person>>data2(){
	List<Person> people = new ArrayList<>(Arrays.asList(
	new Person(1,"Ulio Drink", 21),
	 new Person(2,"Marco Bardi", 30),
	new Person(3,"Maurizio wolf", 24),
	 new Person(4,"Rino Marra", 50)
	 ));
	return new ResponseEntity<>(people, HttpStatus.OK);
}
}