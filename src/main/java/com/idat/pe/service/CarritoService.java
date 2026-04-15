package com.idat.pe.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.Carrito;
import com.idat.pe.model.Usuarios;
=======
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.pe.model.Carrito;
import com.idat.pe.model.CarritoDetalle;
import com.idat.pe.model.Obras;
import com.idat.pe.model.Usuarios;
import com.idat.pe.repository.CarritoDetalleRepository;
>>>>>>> 1709edb (FINAL COMMIT)
import com.idat.pe.repository.CarritoRepository;

@Service
public class CarritoService {
<<<<<<< HEAD
	
	@Autowired
	private CarritoRepository repository;
	@Autowired
	private UsuarioService usuarioService;
	
	public CarritoService() {}
	
	public CarritoService(CarritoRepository repository, UsuarioService usuarioService) {
		super();
		this.repository = repository;
		this.usuarioService = usuarioService;
	}

	public List<Carrito> listar(){
		return repository.findAll();
	}
	
	public Carrito buscarPorId(Integer idCarrito) {
		return repository.findById(idCarrito)
				.orElseThrow(() -> new RuntimeException
						("Carrito no encontrado:" + idCarrito));}
	
	public Carrito buscarPorUsuario(Integer idUsuario) {
		return repository.findByUsuario_idUsuario(idUsuario).orElseThrow(() -> new RuntimeException
				("Usuario no encontrado:" + idUsuario));}
	
	public Carrito obtenerOCrear(int idUsuario) {
		return repository.findByUsuario_idUsuario(idUsuario).orElseGet(() -> {
			Usuarios usuario = null;
			try {
				usuario = usuarioService.buscarPorId(idUsuario);
			} catch (AttributeNotFoundException e) {
				e.printStackTrace();
			}
			Carrito nuevo = new Carrito();
			nuevo.setUsuario(usuario);
			return repository.save(nuevo);
		});
	}
		
	 public Carrito guardarCompra(Carrito carrito) {
		 return repository.save(carrito);
	 }
	
	 public void eliminar(int idCarrito) {
		 buscarPorId(idCarrito);
		 repository.deleteById(idCarrito);
	 }
}
=======

    private final CarritoRepository carritoRepo;
    private final CarritoDetalleRepository detalleRepo;
    private final UsuarioService usuarioService;
    private final ObraService obraService;

    public CarritoService(CarritoRepository carritoRepo,
                          CarritoDetalleRepository detalleRepo,
                          UsuarioService usuarioService,
                          ObraService obraService) {
        this.carritoRepo  = carritoRepo;
        this.detalleRepo  = detalleRepo;
        this.usuarioService = usuarioService;
        this.obraService    = obraService;
    }

    // Obtener o crear carrito del usuario
    public Carrito obtenerOCrearCarrito(int idUsuario) throws AttributeNotFoundException {
        return carritoRepo.findByUsuarioIdUsuario(idUsuario)
            .orElseGet(() -> {
                try {
                    Usuarios usuario = usuarioService.buscarPorId(idUsuario);
                    Carrito nuevo = new Carrito();
                    nuevo.setUsuario(usuario);
                    nuevo.setFechaCompra(new java.util.Date());
                    return carritoRepo.save(nuevo);
                } catch (AttributeNotFoundException e) {
                    throw new RuntimeException("Usuario no encontrado: " + idUsuario);
                }
            });
    }

    // Obtener items del carrito
    public List<CarritoDetalle> obtenerItems(int idUsuario) throws AttributeNotFoundException {
        Carrito carrito = obtenerOCrearCarrito(idUsuario);
        return detalleRepo.findByCarritoIdCarrito(carrito.getId_carrito());
    }

    // Agregar obra al carrito
    public CarritoDetalle agregarItem(int idUsuario, int idObra, int cantidad)
            throws AttributeNotFoundException {
        Carrito carrito = obtenerOCrearCarrito(idUsuario);
        Obras obra = obraService.buscarPorId(idObra);

        // Verificar si ya existe ese item
        List<CarritoDetalle> items = detalleRepo.findByCarritoIdCarrito(carrito.getId_carrito());
        CarritoDetalle existente = items.stream()
            .filter(i -> i.getObras().getId_obra() == idObra)
            .findFirst().orElse(null);

        if (existente != null) {
            existente.setCantidad(existente.getCantidad() + cantidad);
            return detalleRepo.save(existente);
        } else {
            CarritoDetalle detalle = new CarritoDetalle();
            detalle.setCarrito(carrito);
            detalle.setObras(obra);
            detalle.setCantidad(cantidad);
            detalle.setPrecio(obra.getPrecio());
            return detalleRepo.save(detalle);
        }
    }

    // Actualizar cantidad
    public CarritoDetalle actualizarCantidad(int idDetalle, int cantidad)
            throws AttributeNotFoundException {
        CarritoDetalle detalle = detalleRepo.findById(idDetalle)
            .orElseThrow(() -> new AttributeNotFoundException("Item no encontrado: " + idDetalle));
        if (cantidad <= 0) {
            detalleRepo.delete(detalle);
            return null;
        }
        detalle.setCantidad(cantidad);
        return detalleRepo.save(detalle);
    }

    // Eliminar item
    @Transactional
    public void eliminarItem(int idDetalle) throws AttributeNotFoundException {
        if (!detalleRepo.existsById(idDetalle))
            throw new AttributeNotFoundException("Item no encontrado: " + idDetalle);
        detalleRepo.deleteById(idDetalle);
    }

    // Vaciar carrito
    @Transactional
    public void vaciarCarrito(int idUsuario) throws AttributeNotFoundException {
        Carrito carrito = obtenerOCrearCarrito(idUsuario);
        detalleRepo.deleteByCarritoIdCarrito(carrito.getId_carrito());
    }
}
>>>>>>> 1709edb (FINAL COMMIT)
