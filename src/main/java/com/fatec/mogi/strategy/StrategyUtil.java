package com.fatec.mogi.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrategyUtil {

	
	public Map<String, List<IStrategy>> getStrategies(){
		
		List<IStrategy> validacoesComprador = new ArrayList<>();
		
		
		
		
		
		validacoesComprador.add(new EncriptarSenha());
		
		
		
		
		
		Map<String, List<IStrategy>> mapaStrategies = new HashMap<>();
		mapaStrategies.put("comprador", validacoesComprador);
		
		return mapaStrategies;
		
	}
	
	
}
