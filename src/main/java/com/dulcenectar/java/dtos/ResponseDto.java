package com.dulcenectar.java.dtos;

public interface ResponseDto<Entity> {
	public ResponseDto<Entity> fromEntity(Entity entity);
}
