package com.laboratorio.demo.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.laboratorio.demo.dtos.NoticiaDto;
import com.laboratorio.demo.entities.Empresa;
import com.laboratorio.demo.entities.Noticia;
import com.laboratorio.demo.repositories.EmpresaRepository;
import com.laboratorio.demo.repositories.NoticiaRepository;
import com.laboratorio.demo.BackendLaboratorioApplication;

@Service
public class NoticiaService {


	private final NoticiaRepository repository;
	private final EmpresaRepository repositorio2;
	private String upload_folder = String.valueOf(BackendLaboratorioApplication.getHome() +"\\files\\").replace("\\","/");
	
	
	public NoticiaService(NoticiaRepository repository, EmpresaRepository repositorio2) {
		this.repository = repository;
		this.repositorio2 = repositorio2;

	}
	
	@Transactional
	public String getMaxID() throws Exception{
		try {
			 return repository.maximoIDnoticia();
		}catch(Exception e) {
			throw new Exception();
		}
	}
	
	@Transactional
	public String getPathImages() {
		return this.upload_folder;
	}

	@Transactional
	public void saveFile(MultipartFile file) throws IOException {
		System.out.println(BackendLaboratorioApplication.getHome());
		 File directorio = new File(BackendLaboratorioApplication.getHome()+"//files");
	        if (!directorio.exists()) {
	            if (directorio.mkdirs()) {
	                System.out.println("Directorio creado");
	            } else {
	                System.out.println("Error al crear directorio");
	            }
	        }
		if (!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(upload_folder + file.getOriginalFilename());
			Files.write(path, bytes);
		}
	}

	@Transactional
	public List<NoticiaDto> getLast(int id) throws Exception {

		Pageable firstPageWithFiveElements = PageRequest.of(0, 5);

		try {
			List<Noticia> entities = repository.buscarPorEmpresa(id, firstPageWithFiveElements);

			List<NoticiaDto> dtos = new ArrayList();
			for (Noticia i : entities) {
				NoticiaDto unDto = new NoticiaDto();
				unDto.setId(i.getId());
				unDto.setTitulo_de_la_noticia(i.getTitulo_de_la_noticia());
				unDto.setResumen_de_la_noticia(i.getResumen_de_la_noticia());
				unDto.setImagen_noticia(i.getImagen_noticia());
				unDto.setContenido_html(i.getContenido_html());
				unDto.setPublicada(i.getPublicada());
				unDto.setFecha_publicacion(i.getFecha_publicacion());
				unDto.setIdEmpresa(i.getIdEmpresa().getId());
				dtos.add(unDto);
			}
			return dtos;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Transactional
	public List<NoticiaDto> buscarPorNombre(String consulta) throws Exception {
		Pageable secondPageWithFiveElements = PageRequest.of(0, 20);
		try {
			List<Noticia> entities = repository.buscarPorNombre(consulta, secondPageWithFiveElements);
			List<NoticiaDto> dtos = new ArrayList();
			for (Noticia i : entities) {
				NoticiaDto unDto = new NoticiaDto();
				unDto.setId(i.getId());
				unDto.setTitulo_de_la_noticia(i.getTitulo_de_la_noticia());
				unDto.setResumen_de_la_noticia(i.getResumen_de_la_noticia());
				unDto.setImagen_noticia(i.getImagen_noticia());
				unDto.setContenido_html(i.getContenido_html());
				unDto.setPublicada(i.getPublicada());
				unDto.setFecha_publicacion(i.getFecha_publicacion());
				unDto.setIdEmpresa(i.getIdEmpresa().getId());
				dtos.add(unDto);
			}
			return dtos;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Transactional
	public List<NoticiaDto> findAll() throws Exception {
		try {
			List<Noticia> entities = repository.findAll();
			List<NoticiaDto> dtos = new ArrayList();
			for (Noticia i : entities) {
				NoticiaDto unDto = new NoticiaDto();
				unDto.setId(i.getId());
				unDto.setTitulo_de_la_noticia(i.getTitulo_de_la_noticia());
				unDto.setResumen_de_la_noticia(i.getResumen_de_la_noticia());
				unDto.setImagen_noticia(i.getImagen_noticia());
				unDto.setContenido_html(i.getContenido_html());
				unDto.setPublicada(i.getPublicada());
				unDto.setFecha_publicacion(i.getFecha_publicacion());
				unDto.setIdEmpresa(i.getIdEmpresa().getId());
				dtos.add(unDto);
			}
			return dtos;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Transactional
	public NoticiaDto save(NoticiaDto dto) throws Exception {
		try {
			Noticia entidad = new Noticia();
			entidad.setTitulo_de_la_noticia(dto.getTitulo_de_la_noticia());
			entidad.setResumen_de_la_noticia(dto.getResumen_de_la_noticia());
			entidad.setImagen_noticia(dto.getImagen_noticia());
			entidad.setContenido_html(dto.getContenido_html());
			entidad.setPublicada(dto.getPublicada());
			entidad.setFecha_publicacion(dto.getFecha_publicacion());

			Optional<Empresa> optionalEntity = repositorio2.findById(dto.getIdEmpresa());
			Empresa empresa = optionalEntity.get();
			entidad.setIdEmpresa(empresa);

			entidad = repository.save(entidad);
			dto.setId(entidad.getId());
			return dto;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Transactional
	public NoticiaDto update(int id, NoticiaDto dto) throws Exception {
		Optional<Noticia> entityOptional = repository.findById(id);
		try {
			Noticia entidad = entityOptional.get();
			entidad.setId(dto.getId());
			entidad.setTitulo_de_la_noticia(dto.getTitulo_de_la_noticia());
			entidad.setResumen_de_la_noticia(dto.getResumen_de_la_noticia());
			entidad.setImagen_noticia(dto.getImagen_noticia());
			entidad.setContenido_html(dto.getContenido_html());
			entidad.setPublicada(dto.getPublicada());
			entidad.setFecha_publicacion(dto.getFecha_publicacion());
			Optional<Empresa> optionalEntity = repositorio2.findById(dto.getIdEmpresa());
			Empresa empresa = optionalEntity.get();
			entidad.setIdEmpresa(empresa);

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

	@Transactional
	public NoticiaDto findById(int id) throws Exception {
		Optional<Noticia> entityOptional = repository.findById(id);
		try {
			Noticia entity = entityOptional.get();
			NoticiaDto unDto = new NoticiaDto();
			unDto.setId(entity.getId());
			unDto.setTitulo_de_la_noticia(entity.getTitulo_de_la_noticia());
			unDto.setResumen_de_la_noticia(entity.getResumen_de_la_noticia());
			unDto.setImagen_noticia(entity.getImagen_noticia());
			unDto.setContenido_html(entity.getContenido_html());
			unDto.setPublicada(entity.getPublicada());
			unDto.setFecha_publicacion(entity.getFecha_publicacion());
			unDto.setIdEmpresa(entity.getIdEmpresa().getId());
			return unDto;
		} catch (Exception e) {
			throw new Exception();
		}
	}

}
