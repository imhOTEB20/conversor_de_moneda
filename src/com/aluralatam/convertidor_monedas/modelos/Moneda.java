package com.aluralatam.convertidor_monedas.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Moneda {
    private String codISO4217;
    private Map<String,Double> codigos = new HashMap<>();
    private LocalDateTime ultima_actualizacion;

    public Moneda(MonedaV6Exchangerate serializable) {
        this.codISO4217 = serializable.base_code();
        this.codigos = serializable.conversion_rates();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        this.ultima_actualizacion = LocalDateTime.parse(serializable.time_last_update_utc(), formatter);
    }

    public Moneda(String codISO4217, String key) throws IOException, InterruptedException {
        if (codigoValido(codISO4217)) {
            Conexion conexion = new Conexion(key);
            Gson gson = new Gson();
            MonedaV6Exchangerate monedaV6Exchangerate = gson.fromJson(conexion.getResponse(codISO4217), MonedaV6Exchangerate.class);
            System.out.println(monedaV6Exchangerate);

            try {
                this.codISO4217 = monedaV6Exchangerate.base_code();
                this.codigos = monedaV6Exchangerate.conversion_rates();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
                this.ultima_actualizacion = LocalDateTime.parse(monedaV6Exchangerate.time_last_update_utc(), formatter);
            } catch (NullPointerException e) {
                throw new IllegalArgumentException("Se produjo un error en la conexion, y se estan devolviendo parametros nulos.");
            }
        } else {
            throw new IllegalArgumentException("El Codigo ISO 4217 %s no es valido."
                    .formatted(codISO4217));
        }
    }

    public String getCodISO4217() {
        return codISO4217;
    }

    public Map<String, Double> getCodigos() {
        return codigos;
    }

    public LocalDateTime getUltima_actualizacion() {
        return ultima_actualizacion;
    }

    public boolean codISOValido(String codISO4217) {
        return this.codigos.containsKey(codISO4217);
    }

    public double convertirA(String codISO4217, double cantidad) {
        if (this.codISOValido(codISO4217)) {
            return cantidad * this.codigos.get(codISO4217);
        } else {
            return -1;
        }
    }

    public double convertirDesde(String codISO4217, double cantidad) {
        if (this.codISOValido(codISO4217)) {
            return cantidad / this.codigos.get(codISO4217);
        } else {
            return -1;
        }
    }

    public static boolean codigoValido(String codISO4217) {
        //Ultima Actualizacion: 04/25/2024
        List<String> codigos = Arrays.asList(
                "USD","AED","AFN","ALL","AMD","ANG","AOA","ARS","AUD","AWG",
                "AZN","BAM","BBD","BDT","BGN","BHD","BIF","BMD","BND","BOB",
                "BRL","BSD","BTN","BWP","BYN","BZD","CAD","CDF","CHF","CLP",
                "CNY","COP","CRC","CUP","CVE","CZK","DJF","DKK","DOP","DZD",
                "EGP","ERN","ETB","EUR","FJD","FKP","FOK","GBP","GEL","GGP",
                "GHS","GIP","GMD","GNF","GTQ","GYD","HKD","HNL","HRK","HTG",
                "HUF","IDR","ILS","IMP","INR","IQD","IRR","ISK","JEP","JMD",
                "JOD","JPY","KES","KGS","KHR","KID","KMF","KRW","KWD","KYD",
                "KZT","LAK","LBP","LKR","LRD","LSL","LYD","MAD","MDL","MGA",
                "MKD","MMK","MNT","MOP","MRU","MUR","MVR","MWK","MXN","MYR",
                "MZN","NAD","NGN","NIO","NOK","NPR","NZD","OMR","PAB","PEN",
                "PGK","PHP","PKR","PLN","PYG","QAR","RON","RSD","RUB","RWF",
                "SAR","SBD","SCR","SDG","SEK","SGD","SHP","SLE","SLL","SOS",
                "SRD","SSP","STN","SYP","SZL","THB","TJS","TMT","TND","TOP",
                "TRY","TTD","TVD","TWD","TZS","UAH","UGX","UYU","UZS","VES",
                "VND","VUV","WST","XAF","XCD","XDR","XOF","XPF","YER","ZAR",
                "ZMW","ZWL");

        return codigos.contains(codISO4217);
    }
}
