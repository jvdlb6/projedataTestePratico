import java.math.BigDecimal;
import java.time.LocalDate;

public class Constants {
   // Data de Nascimento do funcionário
    public static final LocalDate[] DATAS_NASCIMENTO = {
        LocalDate.parse("2000-10-18"),
        LocalDate.parse("1990-05-12"),
        LocalDate.parse("1961-05-02"),
        LocalDate.parse("1988-10-14"),
        LocalDate.parse("1995-01-05"),
        LocalDate.parse("1999-11-19"),
        LocalDate.parse("1993-03-31"),
        LocalDate.parse("1994-07-08"),
        LocalDate.parse("2003-05-24"),
        LocalDate.parse("1996-09-02")
    };

    // Nome do funcionário
    public static final String[] NOMES_FUNC = {"Maria", "João", "Caio", "Miguel", "Alice", "Heito", "Arthur", "Laura", "Heloísa", "Helena"};

   // Salário do funcionário
    public static final BigDecimal[] SALARIO_FUNC = {
        new BigDecimal("2009.44"),
        new BigDecimal("2284.38"),
        new BigDecimal("9836.14"),
        new BigDecimal("19119.88"),
        new BigDecimal("2234.68"),
        new BigDecimal("1582.72"),
        new BigDecimal("4081.84"),
        new BigDecimal("3017.45"),
        new BigDecimal("1606.85"),
        new BigDecimal("2799.93")
    };

   // Cargo do funcionário
    public static final String[] FUNCAO_FUNC = {"Operador", "Operador", "Coordenador", "Diretor", "Recepcionista", "Operador", "Contador", "Gerente", "Eletricista", "Gerente"};
}