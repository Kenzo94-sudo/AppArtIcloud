<<<<<<< HEAD
		package com.idat.pe.service;

		import com.idat.pe.DTO.FavoritoRequest;
import com.idat.pe.model.Favorito;
import com.idat.pe.model.Obras;
import com.idat.pe.model.Usuarios;
import com.idat.pe.repository.FavoritoRepository;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.stereotype.Service;
		import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

		@Service
		public class FavoritoService {

		    @Autowired
		    private FavoritoRepository repository;
		    @Autowired
		    private UsuarioService usuarioService;
		    @Autowired
		    private ObraService obraService;

		    
		    public FavoritoService(FavoritoRepository repository, 
			                    UsuarioService usuarioService, 
			                    ObraService obraService) {
			  this.repository = repository;
			  this.usuarioService = usuarioService;
			  this.obraService = obraService;
			}
		    
		 // 1. Listar favoritos por usuario
		    public List<Favorito> listarPorUsuario(int idUsuario) {
		        return repository.findByUsuario_idUsuario(idUsuario);
		    }

		    // 2. Verificar si ya es favorito (Para el corazón en Android)
		    public boolean esFavorito(int idUsuario, int idObra) {
		        return repository.existsByUsuario_idUsuarioAndObra_idObra(idUsuario, idObra);
		    }

		    // 3. Agregar a favoritos
		    @Transactional
		    public Favorito agregarAFavoritos(FavoritoRequest dto) throws Exception {
		        // Evitar duplicados
		        if (esFavorito(dto.getIdUsuario(), dto.getIdObra())) {
		            throw new Exception("Esta obra ya se encuentra en tus favoritos.");
		        }

		        Usuarios user = usuarioService.buscarPorId(dto.getIdUsuario());
		        Obras obra = obraService.buscarPorId(dto.getIdObra());

		        Favorito fav = new Favorito();
		        fav.setUsuario(user);
		        fav.setObra(obra);

		        return repository.save(fav);
		    }

		    // 4. Eliminar de favoritos
		    @Transactional
		    public void eliminar(int idUsuario, int idObra) {
		        // Buscamos el registro específico para borrarlo
		        Optional<Favorito> fav = repository.findByUsuario_idUsuarioAndObra_idObra(idUsuario, idObra);
		        fav.ifPresent(repository::delete);
		    }
		}
	
=======
package com.idat.pe.service;

public class FavoritoService {

}
>>>>>>> 1709edb (FINAL COMMIT)
