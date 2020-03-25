package com.laboratorio.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.laboratorio.demo.dtos.EmpresaDto;
import com.laboratorio.demo.dtos.NoticiaDto;
import com.laboratorio.demo.entities.Empresa;
import com.laboratorio.demo.entities.Noticia;
import com.laboratorio.demo.repositories.EmpresaRepository;
import com.laboratorio.demo.repositories.NoticiaRepository;

@Service
public class NoticiaService extends ServicioGenerico<Noticia, NoticiaRepository>{
	
}
