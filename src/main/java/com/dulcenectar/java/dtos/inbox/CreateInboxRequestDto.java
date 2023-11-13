package com.dulcenectar.java.dtos.inbox;

import com.dulcenectar.java.dtos.RequestDto;
import com.dulcenectar.java.models.Inbox;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CreateInboxRequestDto implements RequestDto<Inbox> {
	
	@NotBlank(message = "name is required")
	private String name;
	@NotBlank(message = "message is required")
	@Size(max = 1000, message = "message size should be up to 1000 characters")
	private String message;
	@NotBlank(message = "senderEmail is required")
	@Email(message = "senderEmail should be a valid email")
	private String senderEmail;
	@NotNull(message = "phoneNumber is required")
	@Positive(message = "phoneNumber should be positive")
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
