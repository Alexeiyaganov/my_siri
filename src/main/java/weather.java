import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class weather {
    private static String place;
    static private  String API_KEY = "471e11c0b72565c259940cd2422750e4";

    weather(String place){
        this.place = place;
    }

    public static void getweather()throws IOException {

        try {

            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + place + "&APPID=" + API_KEY + "");
            // https://api.openweathermap.org/data/2.5/weather?q=москва&APPID=471e11c0b72565c259940cd2422750e4

            Object o=url.getContent();
            Scanner in = new Scanner((InputStream)
                    o);

            String result = "";
            while (in.hasNext()) {
                result += in.nextLine();
            }
            if(result==""){
                System.out.println("Не удалось найти указанный населенный пункт!");
                return;
            }


            JSONObject object = new JSONObject(result);
            String name = object.getString("name");
            String main = object.getJSONArray("weather").getJSONObject(0).getString("main");
            String desc = object.getJSONArray("weather").getJSONObject(0).getString("description");
            JSONObject mainw = object.getJSONObject("main");
            Integer temp = mainw.getInt("temp");
            JSONObject wind = object.getJSONObject("wind");
            Double speed = wind.getDouble("speed");
            temp -= 273;
            System.out.print("\n");
            System.out.println("Siri: Погода: " + main);
            System.out.println("Описание: " + desc);
            System.out.println("Температура: " + temp + " 'C");
            System.out.println("Ветер: " + speed + " м/с");
        }
        catch (Exception e){
            System.out.println("Не удается найти указанного населенного пункта или Api выдачи погоды не работает");
        }

    }
}
