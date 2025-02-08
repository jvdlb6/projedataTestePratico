import java.math.BigDecimal;

public class Funcionario extends Pessoa {
  public BigDecimal salario;
  public String funcao;

  public BigDecimal getSalario() {
    return salario;
  }
  public String getFuncao() {
    return funcao;
  }
}