package com.aluralatam.convertidor_monedas.modelos;

import java.util.Map;

public record MonedaV6Exchangerate(String base_code, String time_last_update_utc, Map<String,Double> conversion_rates) {

}
