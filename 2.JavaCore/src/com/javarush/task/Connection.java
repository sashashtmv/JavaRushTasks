package com.javarush.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Connection {
    public static void main(String[] args) {

        HttpURLConnection uC;
        BufferedReader br;
        String resultJoin;

        InputStream inpStr;
        StringBuffer sb;

        URL url;
        try{
        url = new URL("https://gist.githubusercontent.com/sashashtmv/ac70c69e6e7a7fef1b67b4579dd34da4/raw/697b35d7976d659ac38f21715bbf9e7160ff1d2b/fastCredit.json");

        uC = (HttpURLConnection) url.openConnection();
        uC.setRequestMethod("GET");
        uC.connect();

        inpStr = uC.getInputStream();
        sb = new StringBuffer();

        br = new BufferedReader(new InputStreamReader(inpStr));

        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        resultJoin = sb.toString();

            System.out.println(resultJoin);
    } catch (
    MalformedURLException e) {
        e.printStackTrace();
    } catch (
    IOException e) {
        e.printStackTrace();
    }

}
}
