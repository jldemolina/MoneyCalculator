package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HTTParser {
    private URL url;
    
    public HTTParser(URL url) {
       this.url = url; 
    } 

    public String getHTTPAnswer() throws IOException {
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String answer = readAnswer(in);
        return answer;
    }
    
    private static String readAnswer(BufferedReader in) throws IOException {
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine);
        
        return response.toString();        
    }

}
