package com.fatec.mogi.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrategyUtil {

	@Autowired
	ValidaAcessorio validaAcessorio;
	@Autowired
	ValidaComponente validaComponente;
	@Autowired
	ValidaComprador validaComprador;
	@Autowired
	ValidaFichaTecnicaLinha validaFichaTecnicaLinha;
	@Autowired
	ValidaFichaTecnicaProduto validaFichaTecnicaProduto;
	@Autowired
	ValidaLinha validaLinha;
	@Autowired
	ValidaProduto validaProduto;

	public Map<String, List<IStrategy>> getStrategies() {

		List<IStrategy> validacoesAcessorio = new ArrayList<>();
		List<IStrategy> validacoesComponente = new ArrayList<>();
		List<IStrategy> validacoesComprador = new ArrayList<>();
		List<IStrategy> validacoesFichaTecnicaLinha = new ArrayList<>();
		List<IStrategy> validacoesFichaTecnicaProduto = new ArrayList<>();
		List<IStrategy> validacoesLinha = new ArrayList<>();
		List<IStrategy> validacoesProduto = new ArrayList<>();

		validacoesAcessorio.add(validaAcessorio);
		validacoesComponente.add(validaComponente);
		validacoesComprador.add(validaComprador);
		validacoesFichaTecnicaLinha.add(validaFichaTecnicaLinha);
		validacoesFichaTecnicaProduto.add(validaFichaTecnicaProduto);
		validacoesLinha.add(validaLinha);
		validacoesProduto.add(validaProduto);

		Map<String, List<IStrategy>> mapaStrategies = new HashMap<>();
		mapaStrategies.put("acessorio", validacoesAcessorio);
		mapaStrategies.put("componente", validacoesComponente);
		mapaStrategies.put("comprador", validacoesComprador);
		mapaStrategies.put("fichaTecnicaLinha", validacoesFichaTecnicaLinha);
		mapaStrategies.put("fichaTecnicaProduto", validacoesFichaTecnicaProduto);
		mapaStrategies.put("linha", validacoesLinha);
		mapaStrategies.put("produto", validacoesProduto);

		return mapaStrategies;

	}

}
