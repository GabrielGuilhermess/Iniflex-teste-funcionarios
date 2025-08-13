package com.example.funcionarios.service;

import com.example.funcionarios.dominio.Funcionario;
import com.example.funcionarios.dominio.Pessoa;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class ConsultarFuncionarios {

  public Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
    return funcionarios
            .stream()
            .collect(Collectors.groupingBy(Funcionario::getFuncao, LinkedHashMap::new, Collectors.toList()));
  }

  public List<Funcionario> filtrarAniversariantesMeses(List<Funcionario> funcionarios, Set<Integer> meses) {
    return funcionarios.stream()
            .filter(funcionario -> meses.stream().anyMatch(funcionario::fazAniversarioNoMes))
            .collect(Collectors.toList());
  }

  public Funcionario encontrarMaisVelho(List<Funcionario> funcionarios) {
    return funcionarios.stream()
            .min(Pessoa.comparadorPorDataNascimento())
            .orElseThrow(() -> new NoSuchElementException("Nenhum funcionário encontrado"));
  }

  public List<Funcionario> ordenarPorNome(List<Funcionario> funcionarios) {
    return funcionarios.stream()
            .sorted(Pessoa.comparadorPorNome())
            .collect(Collectors.toList());
  }

  public BigDecimal somarSalarios(List<Funcionario> funcionarios) {
    return funcionarios.stream()
            .map(Funcionario::getSalario)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
