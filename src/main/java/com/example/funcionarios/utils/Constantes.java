package com.example.funcionarios.utils;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class Constantes {

  private Constantes() {
  }

  public final static DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public final static BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");
  public final static BigDecimal INDICE_REAJUSTE = new BigDecimal("0.10");

}
