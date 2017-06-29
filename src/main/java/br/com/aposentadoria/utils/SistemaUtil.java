package br.com.aposentadoria.utils;

import java.util.Calendar;
import java.util.Date;

public class SistemaUtil {
	
	public static Date calcularPrazoAnos(Date data, Integer qtdAno) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.YEAR, qtdAno);
		return calendar.getTime();
	}
	
	public static double calculaPorcentagemSalario(Double salario, Double porcentagem) {
		return formatDouble((salario * porcentagem) / 100);
	}
	
	public static Double formatDouble(double x) { 
		return Double.valueOf(String.format("%.2f", x).replace(",", ".")); }

}
