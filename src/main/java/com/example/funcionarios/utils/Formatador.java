package com.example.funcionarios.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Formatador {

  private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  public final static DecimalFormatSymbols SIMBOLOS_BR = new DecimalFormatSymbols(new Locale("pt", "BR"));
  public final static DecimalFormat FORMATO_NUMERO = new DecimalFormat("#,##0.00", SIMBOLOS_BR);

  public static String data(LocalDate data) {
    return data.format(FORMATO_DATA);
  }

  public static String numero(BigDecimal valor) {
    return FORMATO_NUMERO.format(valor);
  }

  public static String salariosMinimos(BigDecimal salario) {
    BigDecimal qtd = salario.divide(Constantes.SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
    return numero(qtd);
  }

  public static String totalSalarios(BigDecimal total) {
    return numero(total);
  }
}
