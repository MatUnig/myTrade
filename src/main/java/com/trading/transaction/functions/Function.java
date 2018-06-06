package com.trading.transaction.functions;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.trading.registration.model.User;
import com.trading.transaction.model.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
// ZMIENIC NAZWE NA UTILS



public class Function {
    @PersistenceContext
    private static EntityManager entityManager;

    static public String apiParser(String textUrl, String valueOf) throws IOException {
        URL url = new URL(textUrl);
        URLConnection request = url.openConnection();
        request.connect();
        JsonParser jp = new JsonParser(); //from gson
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        JsonObject obj2 =  rootobj.getAsJsonObject("Realtime Currency Exchange Rate");
        String currencyCode = obj2.get(valueOf).toString().replace("\"", "");
        System.out.println(currencyCode);
        return currencyCode;
    }
    static public double parsePrice(String param1, String param2) throws IOException {
       return Double.parseDouble(apiParser("https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=" + param1 + "&to_currency=" + param2 + "&apikey=OXP7JS2TSKX8B130","5. Exchange Rate"));
    }
    static public String parseNames(String param1, String param2) throws IOException {
        String fromCurrencyName = apiParser("https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=" + param1 + "&to_currency=" + param2 + "&apikey=OXP7JS2TSKX8B130", "2. From_Currency Name");
        String toCurrencyName = apiParser("https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=" + param1 + "&to_currency=" + param2 + "&apikey=OXP7JS2TSKX8B130", "4. To_Currency Name");
        return fromCurrencyName + " / " + toCurrencyName;
    }
    static public void setCurrentPrice(Transaction transaction) throws IOException {
        String fromCurrency = transaction.getFromCurrency();
        String toCurrency = transaction.getToCurrency();
        transaction.setCurrentPrice(parsePrice(fromCurrency,toCurrency));
    }
    static public void setProfit(Transaction transaction){
        if (transaction.getStatus().equals("Working")) {
            transaction.setProfit((transaction.getCurrentPrice() - transaction.getPrice()) * transaction.getQuantity());
        }
        else{
            transaction.setProfit(transaction.getProfit());
        }
    }
    static public void applyChanges(User user) {
        entityManager.merge(user);
    }

    static public void showCurrentTrans(User user) {
        entityManager.merge(user);
    }
}
