package com.idat.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.Favorito;
import com.idat.pe.repository.FavoritoRepository;

@Service
public class FavoritoService {
		@Autowired
		private FavoritoRepository repository;
		@Autowired
		private UsuarioService usuarioService;
		@Autowired
		private ObraService obraService;
		
		public FavoritoService(FavoritoRepository repository, UsuarioService usuarioService, ObraService obraService) {
			super();
			this.repository = repository;
			this.usuarioService = usuarioService;
			this.obraService = obraService;
		}
		
		public List<Favorito> listar()
		{
			return repository.findAll();
		}
		
		public Favorito guardarFavorito(Favorito favorito )
		{
			return repository.save(favorito);
		}
		
		public void eliminarFavorito(int id_favorito)
		{
			repository.deleteById(id_favorito);
		}
	
}
