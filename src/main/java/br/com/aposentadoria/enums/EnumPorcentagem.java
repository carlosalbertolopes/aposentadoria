package br.com.aposentadoria.enums;

import java.util.Arrays;
import java.util.List;

public enum EnumPorcentagem {
	ZERO("0%",0), UM("1%", 0.01),DOIS("2%", 0.02), TRES("3%", 0.03), QUATRO("4%", 0.04),
	CINCO("5%",0.05), SEIS("6%", 0.06), SETE("7%", 0.07), OITO("8%", 0.08);
	private String key;
	private double value;
	
	EnumPorcentagem(String key, double value) {
		this.key = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public double getValue() {
		return value;
	}
	public static List<EnumPorcentagem> getListPorcentagemY(){
		return Arrays.asList(EnumPorcentagem.values());
	}
	public static List<EnumPorcentagem> getListPorcentagemX(){
		return Arrays.asList(EnumPorcentagem.UM, EnumPorcentagem.DOIS, EnumPorcentagem.TRES, EnumPorcentagem.QUATRO);
	}
}