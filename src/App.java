import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<Pessoa> listaDePessoas = List.of(
            // Pessoa que nasceu a 99 anos
            new Pessoa("Roberto", "08/07/20"),
            new Pessoa("João", "07/08/22"),
            new Pessoa("Maria", "07/08/97"),
            new Pessoa("Ricardo", "07/08/55"),
            new Pessoa("Igor", "17/03/93")
        ).stream().sorted().collect(Collectors.toList());
        listaDePessoas.stream().forEach(System.out::println);
    }
}
