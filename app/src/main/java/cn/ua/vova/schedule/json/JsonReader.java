package cn.ua.vova.schedule.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by Vova on 20.04.2016.
 */
public class JsonReader {

    private JsonReader(){};
    private static final  JsonReader instance=new JsonReader();

    public static  synchronized JsonReader  getInstance(){
        return instance;
    }

    public String readJsonFromUrl(String url) {
        String retval=null;
        try {
            InputStream inputStream = new URL(url).openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            retval =stringBuilder.toString();
            inputStream.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retval;
    }
}
