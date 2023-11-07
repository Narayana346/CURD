package com.MarketingApp.Service;

import java.util.List;

import com.MarketingApp.dto.LeadDto;
import com.MarketingApp.entity.Lead;

public interface LeadService {
	
	public void saveLead(Lead lead) ;

	public List<Lead> findAllLeads();

	public void deleteLeadById(long id);

	public Lead findLeadById(long id);

	public void changdet(LeadDto leaddto);

	public List<Lead> findAll123();

		
		
	

}
