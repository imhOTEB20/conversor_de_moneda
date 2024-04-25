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
        int opcionMenu = -1;
        int opcionConversion = -1;
        double cantidadAConvertir = 0;
        Scanner scanner = new Scanner(System.in);

        String codISO4217Base;
        String codISO4217Conversion;
        Moneda monedaBase;

        System.out.println("BIENVENIDO AL CONVERSOR DE MONEDAS ALURA:");
        System.out.println("SELECCIONA UNA MONEDA BASE POR SU REGION.");
        try {
            do {
                menuPrincipal();
                opcionMenu = scanner.nextInt();
                if (opcionMenu == 1) {
                    codISO4217Base = generarCodISO4217();
                    if (!codISO4217Base.equals("atras")) {
                        monedaBase = new Moneda(codISO4217Base, "eac9ab36e5ea7ccf2935338d");
                        do {
                            menuDeConversion(codISO4217Base);
                            opcionConversion = scanner.nextInt();
                            switch (opcionConversion) {
                                case 1:
                                    System.out.println("SELECCIONA UNA MONEDA A CONVERTIR");
                                    codISO4217Conversion = generarCodISO4217();
                                    if (!codISO4217Conversion.equals("atras")) {
                                        System.out.println("INGRESA LA CANTIDAD EN %s".formatted(codISO4217Base));
                                        cantidadAConvertir = scanner.nextDouble();
                                        System.out.println("%.2f %s es en %s -> %.2f".
                                                formatted(cantidadAConvertir, codISO4217Base, codISO4217Conversion, monedaBase.convertirA(codISO4217Conversion, cantidadAConvertir)));
                                    }
                                    opcionConversion = -1;
                                    break;
                                case 2:
                                    System.out.println("SELECCIONA UNA MONEDA A CONVERTIR EN %s".formatted(codISO4217Base));
                                    codISO4217Conversion = generarCodISO4217();
                                    if (!codISO4217Conversion.equals("atras")) {
                                        System.out.println("INGRESA LA CANTIDAD EN %s".formatted(codISO4217Conversion));
                                        cantidadAConvertir = scanner.nextDouble();
                                        System.out.println("%.2f %s es en %s -> %.2f".
                                                formatted(cantidadAConvertir, codISO4217Conversion, codISO4217Base, monedaBase.convertirDesde(codISO4217Conversion, cantidadAConvertir)));
                                    }
                                    opcionConversion = -1;
                                    break;
                                case 0:
                                    opcionMenu = -1;
                                    break;
                                default:
                                    System.out.println("SELECCION NO VALIDO.");
                            }
                        }  while (opcionConversion < 0 || opcionConversion > 2);
                    } else opcionMenu = -1;
                } else if (opcionMenu != 0) {
                    System.out.println("SELECCION NO VALIDA.");
                }
            } while (opcionMenu < 0 || opcionMenu > 1);
        } catch (IllegalArgumentException e) {
            System.out.println("No se pudo crear el objeto moneda en cuestion, revise que los parametros codISO4217Base y key sean correctos");

        }
    }
    public static void menuPrincipal() {
        System.out.println("1.Selecciona una moneda base");
        System.out.println("0.Salir");
    }
    public static void menuDeConversion(String codISO4217) {
        System.out.println("MENU DE CONVERSION (%s)".formatted(codISO4217));
        System.out.println("1. Convertir %s a otra moneda.".formatted(codISO4217));
        System.out.println("2. Convertir otra moneda a %s.".formatted(codISO4217));
        System.out.println("0. Atras.");
    }
    public static void seleccionRegion() {
        System.out.println("Selecciona una Region:");
        System.out.println("1.America.");
        System.out.println("2.Europa.");
        System.out.println("3.Asia.");
        System.out.println("4.África.");
        System.out.println("5.Oceanía.");
        System.out.println("6.Medio Oriente.");
        System.out.println("7.Caribe.");
        System.out.println("0.Atras");
    }
    public static void monedaAmerica() {
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
        System.out.println("10. BOB (Bolivia)");
        System.out.println("11. PYG (Paraguay)");
        System.out.println("12. CRC (Costa Rica)");
        System.out.println("13. DOP (República Dominicana)");
        System.out.println("14. GTQ (Guatemala)");
        System.out.println("15. HNL (Honduras)");
        System.out.println("16. NIO (Nicaragua)");
        System.out.println("0. Atras");
    }

    public static void monedaEuropa() {
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
        System.out.println("0. Atras");
    }

    public static void monedaAsia() {
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
        System.out.println("0. Atras");
    }

    public static void monedaAfrica() {
        System.out.println("**** Menú de Monedas de África ****");
        System.out.println("1. ZAR (Rand sudafricano)");
        System.out.println("2. EGP (Libra egipcia)");
        System.out.println("3. NGN (Naira nigeriana)");
        System.out.println("4. KES (Chelín keniano)");
        System.out.println("5. ETB (Birr etíope)");
        System.out.println("6. GHS (Cedi ghanés)");
        System.out.println("7. XAF (Franco CFA de África Central)");
        System.out.println("8. XOF (Franco CFA de África Occidental)");
        System.out.println("9. DZD (Dinar argelino)");
        System.out.println("10. MAD (Dirham marroquí)");
        System.out.println("11. XCD (Dólar del Caribe Oriental)");
        System.out.println("12. SDG (Libra sudanesa)");
        System.out.println("13. SOS (Chelín somalí)");
        System.out.println("14. GMD (Dalasi gambiano)");
        System.out.println("0. Atras");
    }

    public static void monedaOceania() {
        System.out.println("**** Menú de Monedas de Oceanía ****");
        System.out.println("1. AUD (Dólar australiano)");
        System.out.println("2. NZD (Dólar neozelandés)");
        System.out.println("3. FJD (Dólar de Fiyi)");
        System.out.println("4. PGK (Kina de Papúa Nueva Guinea)");
        System.out.println("5. WST (Tala de Samoa)");
        System.out.println("6. TOP (Pa'anga de Tonga)");
        System.out.println("7. SBD (Dólar de las Islas Salomón)");
        System.out.println("8. VUV (Vatu de Vanuatu)");
        System.out.println("9. KWD (Dólar de Kuwait)");
        System.out.println("10. XPF (Franco CFP)");
        System.out.println("0. Atras");
    }

    public static void monedaMedioOriente() {
        System.out.println("**** Menú de Monedas de Medio Oriente ****");
        System.out.println("1. SAR (Riyal saudí)");
        System.out.println("2. AED (Dirham de los Emiratos Árabes Unidos)");
        System.out.println("3. QAR (Riyal catarí)");
        System.out.println("4. JOD (Dinar jordano)");
        System.out.println("5. ILS (Nuevo shekel israelí)");
        System.out.println("6. KWD (Dinar kuwaití)");
        System.out.println("7. TJS (Somoni tayiko)");
        System.out.println("8. UZS (Som uzbeko)");
        System.out.println("9. AFN (Afgani afgano)");
        System.out.println("10. PKR (Rupia pakistaní)");
        System.out.println("0. Atras");
    }

    public static void monedaCaribe() {
        System.out.println("**** Menú de Monedas del Caribe ****");
        System.out.println("1. BSD (Dólar bahameño)");
        System.out.println("2. BBD (Dólar barbadense)");
        System.out.println("3. JMD (Dólar jamaiquino)");
        System.out.println("4. TTD (Dólar de Trinidad y Tobago)");
        System.out.println("5. ANG (Florín antillano neerlandés)");
        System.out.println("6. KYD (Dólar de las Islas Caimán)");
        System.out.println("7. XCD (Dólar del Caribe Oriental)");
        System.out.println("8. BZD (Dólar beliceño)");
        System.out.println("9. HTG (Gourde haitiano)");
        System.out.println("10. XOF (Franco CFA de África Occidental)");
        System.out.println("0. Atras");
    }

    private static String generarCodISO4217(){
        Scanner scanner = new Scanner(System.in);
        int region;
        int moneda;
        int cod;
        String codISO4217 = "";

        do {
            seleccionRegion();
            region = scanner.nextInt();
            switch (region) {
                case 1:
                    do {
                        monedaAmerica();
                        cod = scanner.nextInt();
                        switch (cod) {
                            case 1:
                                codISO4217 = "USD";
                                break;
                            case 2:
                                codISO4217 = "ARS";
                                break;
                            case 3:
                                codISO4217 = "BRL";
                                break;
                            case 4:
                                codISO4217 = "CAD";
                                break;
                            case 5:
                                codISO4217 = "CLP";
                                break;
                            case 6:
                                codISO4217 = "COP";
                                break;
                            case 7:
                                codISO4217 = "MXN";
                                break;
                            case 8:
                                codISO4217 = "PEN";
                                break;
                            case 9:
                                codISO4217 = "UYU";
                                break;
                            case 10:
                                codISO4217 = "BOB";
                                break;
                            case 11:
                                codISO4217 = "PYG";
                                break;
                            case 12:
                                codISO4217 = "CRC";
                                break;
                            case 13:
                                codISO4217 = "DOP";
                                break;
                            case 14:
                                codISO4217 = "GTQ";
                                break;
                            case 15:
                                codISO4217 = "HNL";
                                break;
                            case 16:
                                codISO4217 = "NIO";
                                break;
                            case 0:
                                region = -1;
                                break;
                            default:
                                System.out.println("OPCION INCORRECTA. Selecciona una opcion valida.");
                        }
                    } while (cod < 0 || cod > 16);
                    break;

                case 2:
                    do {
                        monedaEuropa();
                        cod = scanner.nextInt();
                        switch (cod) {
                            case 1:
                                codISO4217 = "EUR";
                                break;
                            case 2:
                                codISO4217 = "GBP";
                                break;
                            case 3:
                                codISO4217 = "CHF";
                                break;
                            case 4:
                                codISO4217 = "SEK";
                                break;
                            case 5:
                                codISO4217 = "NOK";
                                break;
                            case 6:
                                codISO4217 = "DKK";
                                break;
                            case 7:
                                codISO4217 = "CZK";
                                break;
                            case 8:
                                codISO4217 = "RUB";
                                break;
                            case 9:
                                codISO4217 = "PLN";
                                break;
                            case 10:
                                codISO4217 = "HUF";
                                break;
                            case 11:
                                codISO4217 = "TRY";
                                break;
                            case 0:
                                region = -1;
                                break;
                            default:
                                System.out.println("OPCION INCORRECTA. Selecciona una opcion valida.");
                        }
                    } while (cod < 0 || cod > 11);
                    break;

                case 3:
                    do {
                        monedaAsia();
                        cod = scanner.nextInt();
                        switch (cod) {
                            case 1:
                                codISO4217 = "JPY";
                                break;
                            case 2:
                                codISO4217 = "CNY";
                                break;
                            case 3:
                                codISO4217 = "KRW";
                                break;
                            case 4:
                                codISO4217 = "INR";
                                break;
                            case 5:
                                codISO4217 = "IDR";
                                break;
                            case 6:
                                codISO4217 = "PHP";
                                break;
                            case 7:
                                codISO4217 = "SGD";
                                break;
                            case 8:
                                codISO4217 = "THB";
                                break;
                            case 9:
                                codISO4217 = "MYR";
                                break;
                            case 10:
                                codISO4217 = "TWD";
                                break;
                            case 11:
                                codISO4217 = "VND";
                                break;
                            case 12:
                                codISO4217 = "KZT";
                                break;
                            case 0:
                                region = -1;
                                break;
                            default:
                                System.out.println("OPCION INCORRECTA. Selecciona una opcion valida.");
                        }
                    } while (cod < 0 || cod > 12);
                    break;

                case 4:
                    do {
                        monedaAfrica();
                        cod = scanner.nextInt();
                        switch (cod) {
                            case 1:
                                codISO4217 = "ZAR";
                                break;
                            case 2:
                                codISO4217 = "EGP";
                                break;
                            case 3:
                                codISO4217 = "NGN";
                                break;
                            case 4:
                                codISO4217 = "KES";
                                break;
                            case 5:
                                codISO4217 = "ETB";
                                break;
                            case 6:
                                codISO4217 = "GHS";
                                break;
                            case 7:
                                codISO4217 = "XAF";
                                break;
                            case 8:
                                codISO4217 = "XOF";
                                break;
                            case 9:
                                codISO4217 = "DZD";
                                break;
                            case 10:
                                codISO4217 = "MAD";
                                break;
                            case 11:
                                codISO4217 = "XCD";
                                break;
                            case 12:
                                codISO4217 = "SDG";
                                break;
                            case 13:
                                codISO4217 = "SOS";
                                break;
                            case 14:
                                codISO4217 = "GMD";
                                break;
                            case 0:
                                region = -1;
                                break;
                            default:
                                System.out.println("OPCION INCORRECTA. Selecciona una opcion valida.");
                        }
                    } while (cod < 0 || cod > 14);
                    break;

                case 5:
                    do {
                        monedaOceania();
                        cod = scanner.nextInt();
                        switch (cod) {
                            case 1:
                                codISO4217 = "AUD";
                                break;
                            case 2:
                                codISO4217 = "NZD";
                                break;
                            case 3:
                                codISO4217 = "FJD";
                                break;
                            case 4:
                                codISO4217 = "PGK";
                                break;
                            case 5:
                                codISO4217 = "WST";
                                break;
                            case 6:
                                codISO4217 = "TOP";
                                break;
                            case 7:
                                codISO4217 = "SBD";
                                break;
                            case 8:
                                codISO4217 = "VUV";
                                break;
                            case 9:
                                codISO4217 = "KWD";
                                break;
                            case 10:
                                codISO4217 = "XPF";
                                break;
                            case 0:
                                region = -1;
                                break;
                            default:
                                System.out.println("OPCION INCORRECTA. Selecciona una opcion valida.");
                        }
                    } while (cod < 0 || cod > 10);
                    break;

                case 6:
                    do {
                        monedaMedioOriente();
                        cod = scanner.nextInt();
                        switch (cod) {
                            case 1:
                                codISO4217 = "SAR";
                                break;
                            case 2:
                                codISO4217 = "AED";
                                break;
                            case 3:
                                codISO4217 = "QAR";
                                break;
                            case 4:
                                codISO4217 = "JOD";
                                break;
                            case 5:
                                codISO4217 = "ILS";
                                break;
                            case 6:
                                codISO4217 = "KWD";
                                break;
                            case 7:
                                codISO4217 = "TJS";
                                break;
                            case 8:
                                codISO4217 = "UZS";
                                break;
                            case 9:
                                codISO4217 = "AFN";
                                break;
                            case 10:
                                codISO4217 = "PKR";
                                break;
                            case 0:
                                region = -1;
                                break;
                            default:
                                System.out.println("OPCION INCORRECTA. Selecciona una opcion valida.");
                        }
                    } while (cod < 0 || cod > 10);
                    break;
                case 7:
                    do {
                        monedaCaribe();
                        cod = scanner.nextInt();
                        switch (cod) {
                            case 1:
                                codISO4217 = "BSD";
                                break;
                            case 2:
                                codISO4217 = "BBD";
                                break;
                            case 3:
                                codISO4217 = "JMD";
                                break;
                            case 4:
                                codISO4217 = "TTD";
                                break;
                            case 5:
                                codISO4217 = "ANG";
                                break;
                            case 6:
                                codISO4217 = "KYD";
                                break;
                            case 7:
                                codISO4217 = "XCD";
                                break;
                            case 8:
                                codISO4217 = "BZD";
                                break;
                            case 9:
                                codISO4217 = "HTG";
                                break;
                            case 10:
                                codISO4217 = "XOF";
                                break;
                            case 0:
                                region = -1;
                                break;
                            default:
                                System.out.println("OPCION INCORRECTA. Selecciona una opcion valida.");
                        }
                    } while (cod < 0 || cod > 10);
                    break;
                case 0:
                    codISO4217 = "atras";
                    break;
                default:
                    System.out.println("OPCION NO VALIDA.");
            }
        } while (region < 0 || region > 7);

        return codISO4217;
    }
}