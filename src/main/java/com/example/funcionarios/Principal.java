package com.example.funcionarios;

import com.example.funcionarios.dominio.Funcionario;
import com.example.funcionarios.service.ConsultarFuncionarios;
import com.example.funcionarios.utils.Formatador;
import com.example.funcionarios.utils.ListaInicialDeFuncionarios;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Principal {

  public static void main(String[] args) {
    ConsultarFuncionarios consultas = new ConsultarFuncionarios();

    List<Funcionario> funcionarios = ListaInicialDeFuncionarios.criarFuncionarios();

    funcionarios.removeIf(funcionario -> funcionario.temNomeIgualA("João"));

    imprimir("Funcionários:");
    imprimir(funcionarios);

    funcionarios.forEach(funcionario -> funcionario.aplicarReajuste());

    Map<String, List<Funcionario>> funcionarioPorFuncao = consultas.agruparPorFuncao(funcionarios);
    imprimir("Funcionários agrupados por função:");
    imprimir(funcionarioPorFuncao);

    Set<Integer> meses = new TreeSet<>(Set.of(10, 12));
    imprimir("Funcionários aniversariantes  nos meses " + meses + ":");
    imprimir(consultas.filtrarAniversariantesMeses(funcionarios, meses));

    Funcionario funcionarioMaisVelho = consultas.encontrarMaisVelho(funcionarios);
    imprimir("Funcionários mais velho:");
    imprimir(funcionarioMaisVelho.toStringApenasNomeEIdade());

    imprimir("Funcionários por ordem alfabética:");
    imprimir(consultas.ordenarPorNome(funcionarios));

    imprimir("Total dos Salários:");
    imprimirTotalSalarios(consultas.somarSalarios(funcionarios));

    imprimir("Salários mínimo por funciário:");
    imprimirComSlariosMinimos(funcionarios);
  }

  private static void imprimir(String conteudo) {
    System.out.println(conteudo);
    System.out.println();
  }

  private static void imprimir(List<Funcionario> funcionarios) {
    funcionarios.forEach(System.out::println);
    System.out.println();
  }

  private static void imprimir(Map<String, List<Funcionario>> mapa) {
    mapa.forEach((funcao, lista) -> {
      System.out.println(funcao + ":");
      lista.forEach(f -> System.out.println("  " + f));
      System.out.println();
    });
  }

  private static void imprimirComSlariosMinimos(List<Funcionario> funcionarios) {
    funcionarios.stream()
            .map(Funcionario::toStringComSalarioMinimo)
            .forEach(System.out::println);
    System.out.println();
  }

  private static void imprimirTotalSalarios(BigDecimal total) {
    System.out.println(Formatador.totalSalarios(total));
    System.out.println();
  }
}
