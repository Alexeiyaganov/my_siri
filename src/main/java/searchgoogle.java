import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class searchgoogle {
    public static void search(String query){



        try {


            String url = "https://www.google.com/search?q="+query;

            Document document = Jsoup //
                    .connect(url) //
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36") //
                    .get();

            Element divResultStats = document.select("div#result-stats").first();
            if (divResultStats==null) {
                throw new RuntimeException("Unable to find results stats.");
            }
            System.out.print("\n");
            System.out.println("Siri:"+ divResultStats.text());



        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
