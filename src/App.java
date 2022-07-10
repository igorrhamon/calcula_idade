import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        // Roberto - 08/07/2021 - Quinta Feira - 1 ano
        // Ricardo - 08/07/2020 - Quarta Feira - 2 anos
        // Entrada: name; yy-mm-dd
        List<Pessoa> listaDePessoas = List.of(
            new Pessoa("Roberto", "21/07/08"),
            new Pessoa("João", "21/07/08"),
            new Pessoa("Maria", "18/07/08"),
            new Pessoa("Ricardo", "20/07/08"),
            new Pessoa("Igor", "00/03/17")
        ).stream().sorted().collect(Collectors.toList());
        listaDePessoas.stream().forEach(System.out::println);
    }
}
