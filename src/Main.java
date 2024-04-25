import com.aluralatam.convertidor_monedas.modelos.Conexion;
import com.aluralatam.convertidor_monedas.modelos.Moneda;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            System.out.println("BIENVENIDO AL CONVERSOR DE MONEDAS ALURA:");
            System.out.println("SELECCIONA UNA MONEDA BASE POR SU REGION.");
            System.out.println(menuPrincipal());

        } catch (IllegalArgumentException e) {
            System.out.println("No se pudo crear el objeto moneda en cuestion, revise que los parametros codISO4217 y key sean correctos");

        }
    }
    public static int menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int seleccion;
        System.out.println("1.Selecciona una moneda base");
        System.out.println("0.Salir");
        seleccion = scanner.nextInt();
        return seleccion;
    }
    public static int seleccionRegion() {
        Scanner scanner = new Scanner(System.in);
        int region;
        System.out.println("Selecciona una Region:");
        System.out.println("1.America.");
        System.out.println("2.Europa.");
        System.out.println("3.Asia.");
        System.out.println("4.África.");
        System.out.println("5.Oceanía.");
        System.out.println("6.Medio Oriente.");
        System.out.println("7.Caribe.");
        region = scanner.nextInt();
        return region;
    }
    public static int monedaAmerica() {
        Scanner scanner = new Scanner(System.in);
        int moneda;
        System.out.println("**** Menú de Monedas de América ****");
        System.out.println("1. USD (Estados Unidos)");
        System.out.println("2. ARS (Argentina)");
        System.out.println("3. BRL (Brasil)");
        System.out.println("4. CAD (Canadá)");
        System.out.println("5. CLP (Chile)");
        System.out.println("6. COP (Colombia)");
        System.out.println("7. MXN (México)");
        System.out.println("8. PEN (Perú)");
        System.out.println("9. UYU (Uruguay)");
        moneda = scanner.nextInt();
        return moneda;
    }
    public static int monedaEuropa() {
        Scanner scanner = new Scanner(System.in);
        int moneda;
        System.out.println("**** Menú de Monedas de Europa ****");
        System.out.println("1. EUR (Euro)");
        System.out.println("2. GBP (Libra esterlina)");
        System.out.println("3. CHF (Franco suizo)");
        System.out.println("4. SEK (Corona sueca)");
        System.out.println("5. NOK (Corona noruega)");
        System.out.println("6. DKK (Corona danesa)");
        System.out.println("7. CZK (Corona checa)");
        System.out.println("8. RUB (Rublo ruso)");
        System.out.println("9. PLN (Zloty polaco)");
        System.out.println("10. HUF (Forinto húngaro)");
        System.out.println("11. TRY (Lira turca)");
        moneda = scanner.nextInt();
        return moneda;
    }

    public static int monedaAsia() {
        Scanner scanner = new Scanner(System.in);
        int moneda;
        System.out.println("**** Menú de Monedas de Asia ****");
        System.out.println("1. JPY (Yen japonés)");
        System.out.println("2. CNY (Yuan chino)");
        System.out.println("3. KRW (Won surcoreano)");
        System.out.println("4. INR (Rupia india)");
        System.out.println("5. IDR (Rupia indonesia)");
        System.out.println("6. PHP (Peso filipino)");
        System.out.println("7. SGD (Dólar singapurense)");
        System.out.println("8. THB (Baht tailandés)");
        System.out.println("9. MYR (Ringgit malasio)");
        System.out.println("10. TWD (Nuevo dólar taiwanés)");
        System.out.println("11. VND (Dong vietnamita)");
        System.out.println("12. KZT (Tenge kazajo)");
        moneda = scanner.nextInt();
        return moneda;
    }

    public static int monedaAfrica() {
        Scanner scanner = new Scanner(System.in);
        int moneda;
        System.out.println("**** Menú de Monedas de África ****");
        System.out.println("1. ZAR (Rand sudafricano)");
        System.out.println("2. EGP (Libra egipcia)");
        System.out.println("3. NGN (Naira nigeriana)");
        System.out.println("4. KES (Chelín keniano)");
        moneda = scanner.nextInt();
        return moneda;
    }

    public static int monedaOceania() {
        Scanner scanner = new Scanner(System.in);
        int moneda;
        System.out.println("**** Menú de Monedas de Oceanía ****");
        System.out.println("1. AUD (Dólar australiano)");
        System.out.println("2. NZD (Dólar neozelandés)");
        moneda = scanner.nextInt();
        return moneda;
    }

    public static int monedaMedioOriente() {
        Scanner scanner = new Scanner(System.in);
        int moneda;
        System.out.println("**** Menú de Monedas de Medio Oriente ****");
        System.out.println("1. SAR (Riyal saudí)");
        System.out.println("2. AED (Dirham de los Emiratos Árabes Unidos)");
        System.out.println("3. QAR (Riyal catarí)");
        System.out.println("4. JOD (Dinar jordano)");
        System.out.println("5. ILS (Nuevo shekel israelí)");
        System.out.println("6. KWD (Dinar kuwaití)");
        moneda = scanner.nextInt();
        return moneda;
    }

    public static int monedaCaribe() {
        Scanner scanner = new Scanner(System.in);
        int moneda;
        System.out.println("**** Menú de Monedas del Caribe ****");
        System.out.println("1. BSD (Dólar bahameño)");
        System.out.println("2. BBD (Dólar barbadense)");
        System.out.println("3. JMD (Dólar jamaiquino)");
        System.out.println("4. TTD (Dólar de Trinidad y Tobago)");
        moneda = scanner.nextInt();
        return moneda;
    }
}