package com.fatec.mogi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.mogi.model.Componente;
@RestController
@RequestMapping("/componente")
public class ComponenteController extends AbstractController<Componente> {

}
