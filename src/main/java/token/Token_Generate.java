package token;


import java.util.*;
import java.io.FileReader;
import java.io.IOException;

public class Token_Generate extends Token {

    public String read_file() throws IOException {
        //File file = new File("src/main/java/token/charlist.txt");

        List charlist = new ArrayList();
        FileReader inputStream = null;


        try {
            inputStream = new FileReader("src/main/java/token/charlist.txt");

            int con;
            while ((con = inputStream.read()) != -1) {
                //System.out.print((char)con); test
                charlist.add((char)con);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return charlist.toString();
    }


    public Token token_date(){

        return token_date();
    }
    public Token token_key(){

        return token_key();
    }

    public Token token_generate(){



        return token_generate();
    }



}
