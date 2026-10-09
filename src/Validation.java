import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final int POCET_UDAJU = 5;

    private static final Pattern CODE =Pattern.compile("^[A-Z]{3}\\d{3}$");

    private static final Pattern PLANET =Pattern.compile("^(Země|Mars|Venuše|Titan|Krypton)$");

    private static final Pattern DATE =Pattern.compile("^(19\\d{2}|20[01]\\d|202[0-6])$");

    private static final Pattern TYPE =Pattern.compile("^(Stíhač|Transportér|Explorer|Bitevník)$");

    private static final Pattern QUANTITY =Pattern.compile("^(1000|[1-9]\\d{0,2}|0)$");

    private final String radek;

    Validation(String radek) {
        this.radek = radek;
    }

    public Pilot validation(){
        System.out.println("Radek: " + radek);

        String[] data = radek.split(";", -1);

        if (data.length != POCET_UDAJU) {
            System.out.println("  NEVALIDNÍ - špatný počet údajů (nalezeno " + data.length
                    + ", očekáváno " + POCET_UDAJU + ")");
            return null;
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].trim();
        }

        List<String> chyby = new ArrayList<>();

        if (!CODE.matcher(data[0]).matches()) {
            chyby.add("neplatný kód");
        }

        if (!PLANET.matcher(data[1]).matches()) {
            chyby.add("neplatná planeta");
        }

        int date = 0;
        if (DATE.matcher(data[2]).matches()) {
            date = Integer.parseInt(data[2]);
        } else {
            chyby.add("neplatný formát datumu");
        }

        if (!TYPE.matcher(data[3]).matches()) {
            chyby.add("neplatný typ");
        }

        int quantity = 0;
        if (QUANTITY.matcher(data[4]).matches()) {
            quantity = Integer.parseInt(data[4]);
        } else {
            chyby.add("neplatný formát množství");
        }

        if (!chyby.isEmpty()) {
            System.out.println("  NEVALIDNÍ - " + String.join(", ", chyby));
            return null;
        }

        System.out.println("  VALIDNÍ");
        return new Pilot(data[0], data[1], date, data[3], quantity);
    }
}
