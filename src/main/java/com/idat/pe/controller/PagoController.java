package com.idat.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.service.PagoService;

@RestController
@RequestMapping("/api/pago")
public class PagoController {
	
	@Autowired
	private PagoService service;
}
