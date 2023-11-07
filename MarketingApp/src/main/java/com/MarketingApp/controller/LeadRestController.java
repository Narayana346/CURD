package com.MarketingApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MarketingApp.dto.LeadDto;
import com.MarketingApp.entity.Lead;
import com.MarketingApp.repository.LeadRepository;

@RequestMapping("/api/leads")
@RestController
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepo;
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> leads =leadRepo.findAll();
		return leads;
	}
	
	@PostMapping
	public ResponseEntity<Lead> saveLead(@RequestBody Lead leads) {
		Lead savedLead =leadRepo.save(leads);
		return new ResponseEntity<>(savedLead, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Lead> updateLead(@PathVariable long id, @RequestBody LeadDto dto){
		Optional<Lead> findById = leadRepo.findById(id);
		Lead leads = findById.get();
		leads.setFirstName(dto.getFirstName());
		leads.setLastName(dto.getLastName());
		leads.setEmail(dto.getEmail());
		leads.setMobile(dto.getMobile());
		
		leadRepo.save(leads);
		return new ResponseEntity<>(leads, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteLead(@PathVariable long id ){
		leadRepo.deleteById(id);
		return new ResponseEntity<String>("Lead is deleted" , HttpStatus.OK);
	}
}
