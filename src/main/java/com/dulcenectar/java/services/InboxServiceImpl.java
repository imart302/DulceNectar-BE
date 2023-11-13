package com.dulcenectar.java.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dulcenectar.java.dtos.inbox.CreateInboxRequestDto;
import com.dulcenectar.java.exceptions.InboxNotFoundException;
import com.dulcenectar.java.models.Inbox;
import com.dulcenectar.java.repositories.InboxRepository;
import com.dulcenectar.java.services.interfaces.InboxService;

@Service
public class InboxServiceImpl implements InboxService {

	private final InboxRepository inboxRepository;
	
	public InboxServiceImpl(InboxRepository inboxRepository) {
		this.inboxRepository = inboxRepository;
	}

	@Override
	public String createInbox(CreateInboxRequestDto inbox) {
		Inbox inboxEnt = inbox.toEntity();
		inboxEnt = inboxRepository.save(inboxEnt);
		return "OK";
	}

	@Override
	public List<Inbox> getAllInbox() {
		List<Inbox> inboxList = (List<Inbox>) this.inboxRepository.findAll();
		return inboxList;
	}

	@Override
	public String deleteById(Integer id) {
		Optional<Inbox> inbox = this.inboxRepository.findById(id);
		if(inbox.isEmpty()) {
			throw new InboxNotFoundException();
		}
		this.inboxRepository.delete(inbox.get());
		
		return "OK";
	}
	
}
