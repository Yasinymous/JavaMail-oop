//TOKEN YAZILIMI YAZ
// MAİL YAZ İSTEK GÖNDER DÖNÜŞ TOKENİ BEKLE
// DÖNÜŞ TOKENİNİ YAZ GÖNDER
// VE ONAYLA

package token;

import java.util.*;

public class Token {

    private String token;
    private String key;
    private Date date;

    public Token() {
    }
    public Token(String token, String key, Date date) {
        this.token = token;
        this.key = key;
        this.date = date;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

