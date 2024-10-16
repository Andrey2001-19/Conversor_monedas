package com.aluracursos.conversormodenas.main;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ObtencionConversionMoneda {
    public void resultado(String monedaEntrada, String monedaSalida,Double valor){
        try {

            ConsultaAPI consulta = new ConsultaAPI();
            String json = consulta.consultaConversion(monedaEntrada);


            JsonElement jsonElement = JsonParser.parseString(json);
            JsonObject jsonObject = jsonElement.getAsJsonObject();



            Double relacion = jsonObject.getAsJsonObject("conversion_rates").get(monedaSalida).getAsDouble();


            System.out.printf("El valor %.2f [%s] corresponde a =>>> %.2f [%s]%n", valor, monedaEntrada, valor * relacion, monedaSalida);
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Cerrando Conversor.");
        }
    }
}