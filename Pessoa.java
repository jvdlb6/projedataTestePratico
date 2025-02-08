
import java.time.LocalDate;

public class Pessoa {
  public String nome;
  public LocalDate dataNascimento;

  public String getNome () {
    return nome;
  }

  public LocalDate getDataNascimento () {
    return dataNascimento;
  }
}