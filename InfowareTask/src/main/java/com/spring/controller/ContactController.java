package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.Contact;
import com.spring.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;


	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "fullName", "asc", model);
	}

	@GetMapping("/addContact")
	public String openAddContactForm(Model model) {
		model.addAttribute("title", "Add Contact");
		model.addAttribute("contact", new Contact());
		return "addContact";
	}

	@PostMapping("/process-contact")
	public String processAddContact(@ModelAttribute("contact") Contact contact) {
		// save contact to database
		this.contactService.addContact(contact);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

		Contact contact = this.contactService.getContactById(id);
		model.addAttribute("contact", contact);
		return "update_contact";
	}

	@GetMapping("/showDetails/{id}")
	public String showDetails(@PathVariable(value = "id") int id, Model model) {

		Contact contact = this.contactService.getContactById(id);
		model.addAttribute("title", "Show All details");
		model.addAttribute("contact", contact);
		return "showDetails";
	}

	@GetMapping("/deleteContact/{id}")
	public String deleteEmployee(@PathVariable(value = "id") int id) {

		// call delete employee method
		this.contactService.deleteContact(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir, Model model) {
		int pageSize = 5;

		Page<Contact> page = this.contactService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Contact> listContacts = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listContacts", listContacts);
		return "home";
	}

}
