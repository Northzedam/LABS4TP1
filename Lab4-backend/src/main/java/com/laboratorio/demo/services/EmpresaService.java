package com.laboratorio.demo.services;

import org.springframework.stereotype.Service;
import java.util.*;
import javax.transaction.Transactional;
import com.laboratorio.demo.dtos.EmpresaDto;
import com.laboratorio.demo.entities.Empresa;
import com.laboratorio.demo.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	private final EmpresaRepository repository;

	public EmpresaService(EmpresaRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public List<EmpresaDto> findAll() throws Exception {
		try {
			List<Empresa> entities = repository.findAll();
			List<EmpresaDto> dtos = new ArrayList();
			for (Empresa i : entities) {
				EmpresaDto unDto = new EmpresaDto();
				unDto.setId(i.getId());
				unDto.setDenominacion(i.getDenominacion());
				unDto.setTelefono(i.getTelefono());
				unDto.setHorario_de_atencion(i.getHorario_de_atencion());
				unDto.setQuienes_somos(i.getQuienes_somos());
				unDto.setLatitud(i.getLatitud());
				unDto.setLongitud(i.getLongitud());
				unDto.setDomicilio(i.getDomicilio());
				unDto.setEmail(i.getEmail());
				dtos.add(unDto);
			}
			return dtos;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Transactional
	public EmpresaDto findById(int id) throws Exception {
		Optional<Empresa> entityOptional = repository.findById(id);
		try {
			Empresa entity = entityOptional.get();
			EmpresaDto unDto = new EmpresaDto();
			unDto.setId(entity.getId());
			unDto.setDenominacion(entity.getDenominacion());
			unDto.setTelefono(entity.getTelefono());
			unDto.setHorario_de_atencion(entity.getHorario_de_atencion());
			unDto.setQuienes_somos(entity.getQuienes_somos());
			unDto.setLatitud(entity.getLatitud());
			unDto.setLongitud(entity.getLongitud());
			unDto.setDomicilio(entity.getDomicilio());
			unDto.setEmail(entity.getEmail());
			return unDto;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Transactional
	public EmpresaDto save(EmpresaDto dto) throws Exception {
		try {
			Empresa entidad = new Empresa();
			entidad.setDenominacion(dto.getDenominacion());
			entidad.setTelefono(dto.getTelefono());
			entidad.setHorario_de_atencion(dto.getHorario_de_atencion());
			entidad.setQuienes_somos(dto.getQuienes_somos());
			entidad.setLatitud(dto.getLatitud());
			entidad.setLongitud(dto.getLongitud());
			entidad.setDomicilio(dto.getDomicilio());
			entidad.setEmail(dto.getEmail());
			entidad = repository.save(entidad);
			dto.setId(entidad.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Transactional
	public EmpresaDto update(int id, EmpresaDto dto) throws Exception {
		Optional<Empresa> entityOptional = repository.findById(id);
		try {
			Empresa entidad = entityOptional.get();
			entidad.setId(dto.getId());
			entidad.setDenominacion(dto.getDenominacion());
			entidad.setTelefono(dto.getTelefono());
			entidad.setHorario_de_atencion(dto.getHorario_de_atencion());
			entidad.setQuienes_somos(dto.getQuienes_somos());
			entidad.setLatitud(dto.getLatitud());
			entidad.setLongitud(dto.getLongitud());
			entidad.setDomicilio(dto.getDomicilio());
			entidad.setEmail(dto.getEmail());
			entidad = repository.save(entidad);
			dto.setId(entidad.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Transactional
	public boolean delete(int id) throws Exception {

		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		} else {
			throw new Exception();
		}
	}
}
