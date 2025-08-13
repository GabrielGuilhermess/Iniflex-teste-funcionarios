package com.example.funcionarios.dominio;

import com.example.funcionarios.utils.Constantes;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class Pessoa {

  private final String nome;
  private final LocalDate dataNascimento;

  public Pessoa(String nome, LocalDate dataNascimento) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
  }

  public String getNome() {
    return nome;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public int getIdade() {
    return Period.between(dataNascimento, LocalDate.now()).getYears();
  }

  public int getIdadeEm(LocalDate dataReferencia) {
    return Period.between(dataNascimento, dataReferencia).getYears();
  }

  public boolean fazAniversarioNoMes(int mes) {
    return dataNascimento.getMonthValue() == mes;
  }

  public String formatarDataNascimento() {
    return dataNascimento.format(Constantes.FORMATO_DATA);
  }

  public boolean temNomeIgualA(String nome) {
    if (nome == null) {
      return false;
    }
    String n = this.nome == null ? "" : this.nome.trim();
    return nome.equalsIgnoreCase(n);
  }

  public static Comparator<Pessoa> comparadorPorNome() {
    return Comparator.comparing(Pessoa::getNome, String.CASE_INSENSITIVE_ORDER);
  }

  public static Comparator<Pessoa> comparadorPorDataNascimento() {
    return Comparator.comparing(Pessoa::getDataNascimento);
  }
}
