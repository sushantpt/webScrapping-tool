package toolPk;

import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author sushantpt
 */
public class mainSrc {
    public static void dataSrc(String country) throws IOException {
        String url = "https://www.worldometers.info/coronavirus/country/" + country;
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("#maincounter-wrap");
        elements.forEach((e) ->{
            String value = e.select("h1").text();
            String count = e.select(".maincounter-number>span").text();
            System.out.println(value + " " + count);
        });
        
    }
    public static void main (String [] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter country name:");
        String countryInput = sc.nextLine();
        dataSrc(countryInput);
        
    }
    
}
