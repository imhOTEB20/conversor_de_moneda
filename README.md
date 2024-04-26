# Conversor de monedas Alura-Latam

Este proyecto de diseño como parte del aprendisaje de la propuesta: ***Java Orientado a Objetos G6 - ONE*** de alura latam en conjunto con Oracle.

El proyecto *conversor de monedas* desarrolla un programa que, a traves de un menú por consola, permite realizar conversiones de monedas de un codigo ISO 4217 a otro, como por ejemplo 1 USD -> 864,7 ARS. En dicho proyecto consumimos la API que nos otorga la pagina *https://v6.exchangerate-api.com/*
para poder saber el valor de que representa una *moneda base* con respecto a las otras monedas.

Este es un ejemplo de una respuesta *GET* tomando como moneda base USD.

![Ejemplo de la pagina](https://github.com/imhOTEB20/conversor_de_moneda/blob/master/.imagenes_readme/v6_ejemplo.png)

De este JSON que tenemos como respuesta utilizaremos 3 elemento que serár atributos de nuestra clase **Moneda**

```java
public class Moneda {
    private String codISO4217; //representa -> "base_code"
    private Map<String, Double> codigos = new HashMap<>(); //representa -> "conversion_rates"
    private LocalDateTime ultima_actualizacion; //representa -> "time_last_update_utc"
}
```

para manipular los JSON utilizaremos la dependencia externa *Gson* de MVN Repository en la version 2.10.1

![https://mvnrepository.com/artifact/com.google.code.gson/gson](https://github.com/imhOTEB20/conversor_de_moneda/blob/master/.imagenes_readme/gson.png)

## Visualizacion del programa en ejecucion:
El menú principal consta de 2 opciones:

![menu principal](https://github.com/imhOTEB20/conversor_de_moneda/blob/master/.imagenes_readme/menu_principal.png)

Cada vez que se seleccione una moneda, ya sea la moneda base o la moneda a la cual se hará la conversion se mostrara un menú de regiones.

![menu_regiones](https://github.com/imhOTEB20/conversor_de_moneda/blob/master/.imagenes_readme/menu_seleccion_region.png)

Una vez seleccionada la region se podra visualizar los distintos codigo ISO 4217 con una breve descripción sobre el pais procedente de la moneda.

*Ejemplo seleccion región America*

![menu_monedas](https://github.com/imhOTEB20/conversor_de_moneda/blob/master/.imagenes_readme/menu_seleccion_moneda.png)

Una vez seleccionada la moneda base se mostrara un menu de conversion y se podra seleccionar entre convertir una cantidad de la moneda base a otra. Para cualquiera de estas opciones se pedira posteriormente que se seleccione la otra moneda y se mostrara el menu de Regiones

![menu_conversiones](https://github.com/imhOTEB20/conversor_de_moneda/blob/master/.imagenes_readme/menu_seleccion_conversion.png)

Una vez seleccionada la moneda a convertir, se solicitara al usuario un monto de acuerto a la seleccion moneda_base -> moneda_destino o moneda_destino -> moneda_base.

*ejemplo conversion moneda USD -> ARS*

![seleccion de monto](https://github.com/imhOTEB20/conversor_de_moneda/blob/master/.imagenes_readme/seleccion_monto.png)

Y se obtendra un resultado:

![resultado USD -> ARS](https://github.com/imhOTEB20/conversor_de_moneda/blob/master/.imagenes_readme/resultado.png)
