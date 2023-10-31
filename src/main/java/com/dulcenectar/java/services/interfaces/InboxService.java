package com.dulcenectar.java.services.interfaces;

import java.util.List;

import com.dulcenectar.java.dtos.inbox.CreateInboxRequestDto;
import com.dulcenectar.java.models.Inbox;

public interface InboxService {
	public String createInbox(CreateInboxRequestDto inbox);
	public List<Inbox> getAllInbox();
	public String deleteById(Integer id);
}
