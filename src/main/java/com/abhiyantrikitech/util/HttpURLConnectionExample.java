package com.abhiyantrikitech.util;


import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionExample {

    public static void main(String[] args) throws Exception {

        HttpURLConnectionExample obj = new HttpURLConnectionExample();

        //System.out.println("Testing 1 - Send Http GET request");
        //obj.sendGet();

        System.out.println("Testing 2 - Send Http POST request");
        obj.sendPost();

    }

    private void sendGet() throws Exception {

        String url = "https://www.google.com/search?q=mkyong";

        HttpURLConnection httpClient =
                (HttpURLConnection) new URL(url).openConnection();

        // optional default is GET
        httpClient.setRequestMethod("GET");

        //add request header
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = httpClient.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            //print result
            System.out.println(response.toString());

        }

    }

    private void sendPost() throws Exception {

		// url is missing?
        //String url = "https://selfsolve.apple.com/wcResults.do";
        String url = "http://media.smsgupshup.com/GatewayAPI/rest";

        HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();

        //add reuqest header
        httpClient.setRequestMethod("POST");
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpClient.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        
        httpClient.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        StringBuffer sb=new StringBuffer();
        sb.append("Dear Deepak");
        sb.append("\n");
        sb.append("Your registration for Azadi Ka Amrit Mahotsav Program has been done. Kindly login and proceed. Here are your login credentials.");
        sb.append("\n");
        sb.append("Email: - deepakp");
        sb.append("\n");
        sb.append("Password - test");
        sb.append("\n");
        sb.append("Click Here to login - https://quiz.nism.ac.in/loginAzadiQuiz");
        sb.append("\n");
        sb.append("In case of  any difficulty feel free to contact on 8095210200 or write back on Sebiquiz@nism.ac.in ");
        sb.append("\n");
        sb.append("Regards,");
        sb.append("\n");
        sb.append("NISM");
        sb.append("\n");
        sb.append("Note: This is an auto generated message. Please do not respond.");
        System.out.println("String Buffer text \n"+sb.toString());
        String urlParameters = "send_to=918080886250&msg_type=Text&userid=2000203679&auth_scheme=plain&password=ufWcTPEh&method=SendMessage&v=1.1&format=json&msg="+sb.toString();

        // Send post request
        httpClient.setDoOutput(true);
        try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
            wr.writeBytes(urlParameters);
            wr.flush();
        }

        int responseCode = httpClient.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(httpClient.getInputStream()))) {

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            //print result
            System.out.println(response.toString());

        }

    }

}
