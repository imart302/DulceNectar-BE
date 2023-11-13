package com.dulcenectar.java.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dulcenectar.java.dtos.inbox.CreateInboxRequestDto;
import com.dulcenectar.java.models.Inbox;
import com.dulcenectar.java.services.interfaces.InboxService;

@RestController
@RequestMapping(path = "/inbox")
public class InboxController {

	private final InboxService inboxService;
	
	public InboxController(InboxService inboxService) {
		this.inboxService = inboxService;
	}
	
	@PostMapping
	public ResponseEntity<String> createInbox(@RequestBody CreateInboxRequestDto inbox){
		String response = this.inboxService.createInbox(inbox);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Inbox>> getAllInbox(){
		List<Inbox> inboxList = this.inboxService.getAllInbox();
		return new ResponseEntity<List<Inbox>>(inboxList, HttpStatus.OK); 
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteInbox(@PathVariable(name = "id") Integer id){
		String res = this.inboxService.deleteById(id);
		return new ResponseEntity<String>(res, HttpStatus.OK);
	}
}
