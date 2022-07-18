import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Locale;
// Import lombok.Data;
public class Pessoa implements Comparable<Pessoa> {
    private String name;
    private LocalDate birthDate;
    private final DateTimeFormatter dateFormatterParser = DateTimeFormatter.ofPattern("dd/MM/yy", new Locale("pt", "BR"));

    public Pessoa(String name, String birthDate) {
        this.name = name;
        this.birthDate = extrairAno(birthDate);
    }
    
    private LocalDate extrairAno(String birthDate) {
        final DateTimeFormatter ano = DateTimeFormatter.ofPattern("yy", new Locale("pt", "BR"));
        
        LocalDate data;
        String[] split = birthDate.split("/");
        int anoInt = Integer.parseInt(split[2]);
        
        if(anoInt>= 0 && anoInt < Integer.valueOf(LocalDate.now().format(ano))) {
            
            data = LocalDate.parse(birthDate, dateFormatterParser);
            return data;
        }
        
        split[2] = "19"+split[2];
        data = LocalDate.of(Integer.parseInt(split[2]), Integer.parseInt(split[1]), Integer.parseInt(split[0]));
        if(data.isAfter(LocalDate.now())) {
            // Pessoa não pode ter mais de 99 anos
            throw new IllegalArgumentException("Data de nascimento inválida");
        }
        return data;
    }

    public String getName() {
        return name;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    @Override
    public int compareTo(Pessoa pessoa) {
        if(pessoa.getBirthDate().isAfter(this.getBirthDate())) {
            return 1;
        } else if(pessoa.getBirthDate().isBefore(this.getBirthDate())) {
            return -1;
        } else {
            return 0;
        }
        
    }
    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        // Roberto - 08/07/2021 - Quinta Feira - 1 ano
        
        String s = formatter.format("%s - %s - %s - %d anos", 
            this.name, 
            this.birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), 
            // Data de nascimento em português e camelCase
            birthDayFormat(),
            this.birthDate.until(LocalDate.now()).getYears())
            .toString();
        formatter.close();
        return s;

    }

    private String birthDayFormat(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE", new Locale("pt", "BR"));
        String day = dtf.format(this.birthDate);
        day = day.substring(0, 1).toUpperCase() + day.substring(1);
        if(day.contains("-feira")) {
            day = day.replace("-feira", " Feira");
        }
        return day;
    }
    
    
}