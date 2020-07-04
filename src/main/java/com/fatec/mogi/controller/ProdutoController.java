package com.fatec.mogi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.mogi.model.Produto;

@RestController
@RequestMapping("/produto")
public class ProdutoController extends AbstractController<Produto> {

}
