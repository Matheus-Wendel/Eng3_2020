package com.fatec.mogi.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrategyUtil {

	
	public Map<String, List<IStrategy>> getStrategies(){
		
		List<IStrategy> validacoesComprador = new ArrayList<>();
		List<IStrategy> validacoesProduto = new ArrayList<>();
		
		
		
		
		
		validacoesComprador.add(new ValidaSenha());
		validacoesProduto.add(new ValidaProduto());
		
		
		
		
		
		Map<String, List<IStrategy>> mapaStrategies = new HashMap<>();
		mapaStrategies.put("comprador", validacoesComprador);
		mapaStrategies.put("produto", validacoesProduto);
		
		return mapaStrategies;
		
	}
	
	
}
