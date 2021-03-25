package token;

import java.util.concurrent.TimeUnit;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Token_Generate extends Token {

    public List read_file() throws IOException {
        //File file = new File("src/main/java/token/charlist.txt");

        List charlist = new ArrayList();
        FileReader inputStream = null;

        try {
            inputStream = new FileReader("src/main/java/token/charlist.txt");

            int con;
            while ((con = inputStream.read()) != -1) {
                //System.out.print((char)con);test
                charlist.add((char)con);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return charlist;
    }

    public String  random(List character){
        for (int i = 1; i <= 6; i++) {
            character.add(i);
        }
        Collections.shuffle(character);

        String token = "";
        if (character.isEmpty()){
            System.out.println("empty list");
        }
        for (int i = 0; i < character.size(); i++) {
            token+= character.get(i);
        }
        return token;
    }


    public Date token_date(){
        Date token_generate_date = new Date();
        //DateFormat df = new SimpleDateFormat("yyyy/MM/dd H:m:s:S");
        //System.out.println(df.format(token_generate_date));
        return token_generate_date;
    }
    public String  token_key() throws IOException {

        return random(read_file());
    }

    public String token_generate() throws IOException {
        setToken(random(read_file()));
        setKey(token_key());
        setDate(token_date());
        System.out.println(getToken());
        //System.out.println(getKey());
        //System.out.println(getDate());
        return getToken();
    }

    public long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }

    public boolean date_control(Date date, int time){
        Date date_control = new Date();
        DateFormat ms = new SimpleDateFormat("ms");
        int fark = (int) getDateDiff(date,date_control,TimeUnit.MINUTES);
        if (fark<=time){ return true;}
        return false;
    }

    public boolean token_control(String token){
        if (getToken().equals(token) && date_control(getDate(),2) == true){ return true; }
        return false;
    }




}
