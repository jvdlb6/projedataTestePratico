import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class listFunc{
  public static void main(String[] args) {
    String[] nomes = Constants.NOMES_FUNC;
    LocalDate[] datasNasc = (LocalDate[]) Constants.DATAS_NASCIMENTO;
    BigDecimal[] salarioFunc = (BigDecimal[]) Constants.SALARIO_FUNC;
    String[] cargoFunc = Constants.FUNCAO_FUNC;
    ArrayList<Funcionario> funcionarios = new ArrayList<>();

    // Iteração paa povoa o array de funcionários
    for (int i = 0; i < nomes.length; i++) {
        Funcionario funcionario = new Funcionario();
        funcionario.nome = nomes[i];
        funcionario.dataNascimento = datasNasc[i];
        funcionario.salario = salarioFunc[i];
        funcionario.funcao = cargoFunc[i];
        funcionarios.add(funcionario);
    }

    // Remoção do funcionário com nome João
    for (Funcionario funcionario : funcionarios) {
      if (funcionario.getNome().equals("João")) {
          funcionarios.remove(funcionario);
          break;
      }
    }

    // Print da lista de funcionários com as suas informações na tela
    System.out.println();
    System.out.println("-----------------Lista de Funcionários-----------------------");
    System.out.println();
    System.out.println("Nome" + " - " + "Nascimento" + " - " + "Salário" + " - " + "Função");
    for (Funcionario funcionario : funcionarios) {
      System.out.printf("%s | %s | %,.2f | %s%n", funcionario.getNome(), funcionario.getDataNascimento(), funcionario.getSalario(), funcionario.getFuncao());
    }

    // Aumento de 10%
    for (Funcionario funcionario : funcionarios) {
      BigDecimal salarioAtual = funcionario.getSalario();
      BigDecimal aumento = salarioAtual.multiply(new BigDecimal("0.10"));
      BigDecimal salarioNew = salarioAtual.add(aumento);
      funcionario.salario = salarioNew;
    }

    System.out.println();
    // Map por função
    System.out.println("-----------------Funcionários por função-----------------------");
    System.out.println();
    System.out.println("Nome" + " | " + "Nascimento" + " | " + "Salário" + " | " + "Função");
    Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();

    for (Funcionario funcionario : funcionarios) {
        String funcao = funcionario.getFuncao();
        if (!funcionariosPorFuncao.containsKey(funcao)) {
            funcionariosPorFuncao.put(funcao, new ArrayList<>());
        }
        funcionariosPorFuncao.get(funcao).add(funcionario);
    }
    for (Map.Entry<String, List<Funcionario>> entry : funcionariosPorFuncao.entrySet()) {
        for (Funcionario funcionario : entry.getValue()) {
            System.out.printf("%s | %s | %,.2f | %s%n", funcionario.getNome(), funcionario.getDataNascimento(), funcionario.getSalario(), funcionario.getFuncao());
        }
    }

    System.out.println();
    // Aniversariantes do mês 10 ou 12
    int maiorIdade = 0;
    Funcionario funcionarioMaisVelho = null;

    for(int i = 0; i < Constants.DATAS_NASCIMENTO.length; i++) {
      int mes = Constants.DATAS_NASCIMENTO[i].getMonthValue();

      if (mes == 10 || mes == 12) {
        System.out.println("Funcionário aniversariante dos meses 10 ou 12: " + Constants.NOMES_FUNC[i]);
      }
    }
    System.out.println();

    // Funcionario mais velho
    for (Funcionario funcionario : funcionarios) {
      int idade = LocalDate.now().getYear() - funcionario.getDataNascimento().getYear();
      if (idade > maiorIdade) {
          maiorIdade = idade;
          funcionarioMaisVelho = funcionario;
      }
    }
    // imprime o funcionário mais velho
    if (funcionarioMaisVelho != null) {
        System.out.println("Funcionário com a maior idade é " + funcionarioMaisVelho.getNome() + " e possui a idade de " + maiorIdade + " anos");
    } else {
        System.out.println("Erro ao encontrar o funcionário mais velho.");
    }

    // imprime os func em ordem alfabética
    Collections.sort(funcionarios, (f1, f2) -> f1.getNome().compareTo(f2.getNome()));
    System.out.println();
    System.out.println("Funcionários em ordem alfabética: ");
    System.out.println();
    for (Funcionario funcionario : funcionarios) {
      System.out.printf("%s | %s | %,.2f | %s%n", funcionario.getNome(), funcionario.getDataNascimento(), funcionario.getSalario(), funcionario.getFuncao());
    }
    System.out.println();

    // imprime a soma dos salários dos funcionários
    BigDecimal somaSalarios = BigDecimal.ZERO;
      for (Funcionario funcionario : funcionarios) {
          somaSalarios = somaSalarios.add(funcionario.getSalario());
      }
    System.out.println("Somatório dos salários: R$ " + String.format("%,.2f", somaSalarios));
    System.out.println();

    // Calcula a quantidade de salarios minimos que cada usuário ganha
    BigDecimal salarioMinimo = new BigDecimal("1212.00");

    for (Funcionario funcionario : funcionarios) {
        BigDecimal salario = funcionario.getSalario();
        int quantidadeSalarioMinimo = salario.divide(salarioMinimo, 0, BigDecimal.ROUND_DOWN).intValue();
        System.out.println(funcionario.getNome() + ": " + quantidadeSalarioMinimo);
    }

    System.out.println();
  }
}