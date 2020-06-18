import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class siri_app {
    public static void main(String[] args) throws IOException, InterruptedException {
        boolean siri_work=true;
        System.out.print("Привет, готова ответить на вопросы \n");
        while(siri_work){
            System.out.print("Вы:  ");
            Scanner in = new Scanner(System.in);
            String answer = in.next();
            if(answer.contains("прив"))
                System.out.println("Siri: Привет!");

            else if(answer.contains("как")) {
                System.out.println("Siri: Нормально!");
            }

            else if(answer.contains("место")) {
                System.out.println("Siri: Есть место!");
            }

            else if(answer.contains("погода")) {
                Thread1 tr = new Thread1();
                tr.start();
                String place = in.next();
                weather wee=new weather(place);
                wee.getweather();
                tr.interrupt();
            }

            else if(answer.contains("корон")) {
                Thread1 tr = new Thread1();
                tr.start();
                //System.out.println("Siri:");
                Document doc = Jsoup.connect("https://xn--80aesfpebagmfblc0a.xn--p1ai/").get();
                Element div = doc.select("div.cv-countdown").first();
                Elements divs = div.select("div.cv-countdown__item");

                Iterator<Element> iterator = divs.iterator();

                tr.interrupt();
                System.out.println("");
                while (iterator.hasNext()) {
                    Element a = iterator.next();
                    System.out.println("Siri:"+a.text());
                }

            }

            else if(answer.contains("калькул")) {

                System.out.println("Siri:");
                calculator calc=new calculator();
                calc.calculate();
            }

            else if(answer.contains("гугл")) {
                Thread1 tr = new Thread1();
                tr.start();
                String query = in.nextLine();
                searchgoogle obj = new searchgoogle();
                searchgoogle.search(query);
                tr.interrupt();
            }

            else if(answer.contains("пока")) {
                System.out.println("Siri: Пока!");
                in.close();
                siri_work = false;
            }
            else
                System.out.println("Siri: Я Вас не понимаю!");

        }

    }
}
