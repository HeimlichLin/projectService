package com.heimlich.domain.project.dto.fospm1.impl;

import java.util.List;

public class Fospm101ExcelDTO extends Fospm101DTO {
	private Fospm101QueryDTO fospm101QueryDTO;
	private List<Fospm101ResultDTO> fospm101ResultDTOs;

	public Fospm101QueryDTO getFospm101QueryDTO() {
		return fospm101QueryDTO;
	}

	public void setFospm101QueryDTO(Fospm101QueryDTO fospm101QueryDTO) {
		this.fospm101QueryDTO = fospm101QueryDTO;
	}

	public List<Fospm101ResultDTO> getFospm101ResultDTOs() {
		return fospm101ResultDTOs;
	}

	public void setFospm101ResultDTOs(List<Fospm101ResultDTO> fospm101ResultDTOs) {
		this.fospm101ResultDTOs = fospm101ResultDTOs;
	}

}
