package com.trading.transaction.functions;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Function {
   static public String apiParser(String textUrl, String valueOf) throws IOException {
        URL url = new URL(textUrl);
        URLConnection request = url.openConnection();
        request.connect();
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        JsonObject obj2 =  rootobj.getAsJsonObject("Realtime Currency Exchange Rate");
        String currencyCode = obj2.get(valueOf).toString();
        System.out.println(currencyCode);
        return currencyCode;
    }
    static public double doubleApiParser(String textUrl, String valueOf) throws IOException {
        return Double.parseDouble(apiParser(textUrl,valueOf).replace("\"", ""));
    }
}
