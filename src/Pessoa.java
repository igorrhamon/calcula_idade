import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Locale;

public class Pessoa implements Comparable<Pessoa> {
    private String name;
    private LocalDate birthDate;
    public Pessoa(String name, String birthDate) {
        DateTimeFormatter dateFormatterParser = DateTimeFormatter.ofPattern("yy/MM/dd");       
        this.name = name;
        LocalDate parseBirthDate = LocalDate.parse(birthDate, dateFormatterParser);
        this.birthDate = parseBirthDate;
        
        
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

    /**
     * 
     * @return the birthDayFormat formatado em português e camelCase
     */
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