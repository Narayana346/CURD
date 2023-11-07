package com.MarketingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MarketingApp.Service.LeadService;
import com.MarketingApp.dto.LeadDto;
import com.MarketingApp.entity.Lead;


@Controller
public class LeadController {
	
	// to call service layer we need to create one object of service
	
	@Autowired
	private LeadService leadService;
	//http:localhost:8080/viewLeadForm
	@RequestMapping("/viewLeadForm") //calling the method
	public String viewLeadForm() {
		System.out.println("starting point ");

		return "create_lead";//loading page
	}
	
//	@RequestMapping("/saveLead")
//	public String saveLeadInfo(Lead lead) {
//		//controller has to call service
//		leadService.saveLead(lead);
//		return "create_lead";	
//	}	
	
	
//	@RequestMapping("/saveLead")
//	public String saveLeadInfo(
//			@RequestParam("first") String firstName,
//			@RequestParam("lastName") String lastName,
//			@RequestParam("email") String email,
//			@RequestParam("mobile") long mobile)
//	{
//		create lead object
//		Lead l=new Lead();
//		l.setFirstName(firstName);
//		l.setLastName(lastName);
//		l.setEmail(email);
//		l.setMobile(mobile);
//		leadService.saveLead(l);
//		return "create_lead";
//	}
	
//	@RequestMapping("/saveLead")
//	public String saveLeadInfo(LeadDto dto) {
//		Lead lead = new Lead();
//		leadService.saveLead(lead);
//		lead.setFirstName(dto.getFirstName());
//		lead.setLastName(dto.getLastName());
//		lead.setEmail(dto.getEmail());
//		lead.setMobile(dto.getMobile());
//		leadService.saveLead(lead);
//		return "create_lead";
//	}
	
	//http:localhost:8080/listall
	@RequestMapping("/listall")
	public String getAllLeads(Model model) {
		List<Lead> leaddata =leadService.findAllLeads();
		System.out.println(leaddata);
		model.addAttribute("msg", leaddata);
		return "List_Lead";
	}
	
	@RequestMapping("saveLead")
	public String saveLeadInfo(@ModelAttribute Lead lead, ModelMap model) {
		//modelattribute acts like set attribute  
		leadService.saveLead(lead);
		model.addAttribute("msg", "Record is saved");
		return "create_lead";
	}
	
	@RequestMapping("/delete")
	//to read the data from query parameter we use @RequestParam
	public String deleteLeadById(@RequestParam("id") long id, Model model) {
		leadService.deleteLeadById(id);
		List<Lead> leaddata =leadService.findAllLeads();
		model.addAttribute("msg", leaddata);
		return "List_Lead";
	}
	
	@RequestMapping("/update")
	public String updateLeadById(@RequestParam("id") long id, Model model) {
		//fetch the record
		Lead lead= leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return "updateLead";
	}
	
	@RequestMapping("/updatedetails")
	public String updateidDetails(LeadDto leaddto, Model model) {
		leadService.changdet(leaddto);
		
		List<Lead> leaddata =leadService.findAllLeads();
		model.addAttribute("msg", leaddata);
		return "List_Lead";
	}
	
	
}
