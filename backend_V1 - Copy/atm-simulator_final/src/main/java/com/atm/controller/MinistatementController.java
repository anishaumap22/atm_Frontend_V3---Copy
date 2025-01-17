package com.atm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atm.entities.MiniStatement;
import com.atm.services.MinistatementService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class MinistatementController {
	@Autowired
	MinistatementService ministatmentref;
	
	@GetMapping("/ministatement/{id}")
    public List<MiniStatement> ministatementRequest(@PathVariable int id) {
		 return ministatmentref.sendMinistatementList(id);
	}
}

