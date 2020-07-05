package com.fatec.mogi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.mogi.model.Comprador;

@RestController
@RequestMapping("/comprador")
public class CompradorController extends AbstractController<Comprador> {

}
