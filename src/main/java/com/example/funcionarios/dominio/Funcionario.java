package com.example.funcionarios.dominio;

import com.example.funcionarios.utils.Constantes;
import com.example.funcionarios.utils.Formatador;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Funcionario extends Pessoa {

  private BigDecimal salario;
  private final String funcao;

  public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
    super(nome, dataNascimento);
    this.salario = salario;
    this.funcao = funcao;
  }

  public BigDecimal getSalario() {
    return salario;
  }

  public String getFuncao() {
    return funcao;
  }

  public void aplicarReajuste() {
    salario = salario.multiply(BigDecimal.ONE.add(Constantes.INDICE_REAJUSTE))
            .setScale(2, RoundingMode.HALF_UP);
  }

  public BigDecimal qtdSalariosMinimosValor() {
    return salario.divide(Constantes.SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
  }

  @Override
  public String toString() {
    return getNome() + " | "
            + Formatador.data(getDataNascimento()) + " | "
            + Formatador.numero(salario) + " | "
            + funcao;
  }

  public String toStringApenasNomeEIdade() {
    return getNome() + " | " + getIdade();
  }

  public String toStringComSalarioMinimo() {
    return getNome() + " | "
            + Formatador.data(getDataNascimento()) + " | "
            + Formatador.numero(salario) + " | "
            + funcao + " | "
            + Formatador.salariosMinimos(salario);
  }
}
