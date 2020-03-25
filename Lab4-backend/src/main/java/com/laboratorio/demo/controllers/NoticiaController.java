package com.laboratorio.demo.controllers;

import java.io.IOException;
import javax.transaction.Transactional;

//import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.laboratorio.demo.dtos.NoticiaDto;
import com.laboratorio.demo.services.NoticiaService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST,
		RequestMethod.PUT })
@RequestMapping(path = "api/v1/noticia")
public class NoticiaController {

	private final NoticiaService servicio;

	public NoticiaController(NoticiaService servicio) {
		this.servicio = servicio;
	}
	
	@GetMapping("/maxid")
	@Transactional
	public ResponseEntity getMaxID() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.getMaxID());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"message\":\"Ha ocurrido un error al obtener el id maximo de noticia\"}");
		}
	}

	@GetMapping("/recoverUpload")
	@Transactional
	public ResponseEntity getPathImages() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.getPathImages());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"message\":\"Ha ocurrido un error al obtener la direccion de la imagen\"}");
		}
	}

	@PostMapping("/upload")
	@Transactional
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return new ResponseEntity<Object>("Seleccionar un Archivo", HttpStatus.OK);
		}
		try {
			servicio.saveFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("Archivo subido correctamente", HttpStatus.OK);

	}

	@GetMapping("/searchEmpresa/{id}")
	@Transactional
	public ResponseEntity getLast(@PathVariable("id") int id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.getLast(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"message\":\"Ha ocurrido un error en el metodo getLast\"}");
		}
	}

	@GetMapping("/search/{nombre}")
	@Transactional
	public ResponseEntity buscarPorNombre(@PathVariable("nombre") String nombre) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.buscarPorNombre(nombre));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"message\":\"Ha ocurrido un error en el metodo getAll\"}");
		}
	}

	@GetMapping("/")
	@Transactional
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"message\":\"Ha ocurrido un error en el metodo getAll\"}");
		}
	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity getOne(@PathVariable int id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"message\":\"Ha ocurrido un error en el metodo getOne\"}");
		}
	}

	@PostMapping("/")
	@Transactional
	public ResponseEntity post(@RequestBody NoticiaDto dto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.save(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"message\":\"Ha ocurrido un error en el metodo post\"}");
		}
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity put(@PathVariable int id, @RequestBody NoticiaDto dto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"message\":\"Ha ocurrido un error en el metodo put\"}");
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable int id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"message\":\"Ha ocurrido un error en el metodo delete\"}");
		}
	}
}
