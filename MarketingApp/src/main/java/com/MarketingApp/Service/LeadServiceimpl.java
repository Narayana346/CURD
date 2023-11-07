package com.MarketingApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MarketingApp.dto.LeadDto;
import com.MarketingApp.entity.Lead;
import com.MarketingApp.repository.LeadRepository;


// this page is service layer
@Service
public class LeadServiceimpl implements LeadService {

	//to interact with the database require repository layer
	@Autowired
	private LeadRepository leadRepo;
	
	@Override
	public void saveLead(Lead lead) {	
		leadRepo.save(lead);
	}
	@Override
	public List<Lead> findAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);
	}
	@Override
	public Lead findLeadById(long id) {
		Lead l1 =leadRepo.findById(id).get();
		return l1 ;
	}
	@Override
	public void changdet(LeadDto leaddto) {
		Lead l1 = new Lead();
		l1.setId(leaddto.getId());
		System.out.println(l1.getId());
		l1.setFirstName(leaddto.getFirstName());
		l1.setLastName(leaddto.getLastName());
		l1.setEmail(leaddto.getEmail());
		l1.setMobile(leaddto.getMobile());
		leadRepo.save(l1);
	}
	@Override
	public List<Lead> findAll123() {
		return leadRepo.findAll();
	}

	
}
