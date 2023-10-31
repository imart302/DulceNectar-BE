package com.dulcenectar.java.dtos.inbox;

import com.dulcenectar.java.dtos.RequestDto;
import com.dulcenectar.java.models.Inbox;

public class CreateInboxRequestDto implements RequestDto<Inbox> {
	
	private String name;
	private String message;
	private String senderEmail;
	private Long phoneNumber;

	public CreateInboxRequestDto(String name, String message, String senderEmail, Long phoneNumber) {
		super();
		this.name = name;
		this.message = message;
		this.senderEmail = senderEmail;
		this.phoneNumber = phoneNumber;
	}

	public CreateInboxRequestDto() {
		super();
	}

	@Override
	public Inbox toEntity() {
		Inbox inbox = new Inbox();
		inbox.setMessage(this.message);
		inbox.setSenderEmail(this.senderEmail);
		inbox.setName(this.name);
		inbox.setPhoneNumber(this.phoneNumber.toString());
		
		return inbox;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
