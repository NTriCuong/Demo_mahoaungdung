package phuongthucdichuyen;

public class Move {

    public String document;
    public String key;
    public String cipher;
    //contructor
    public Move(String document, String key, String cipher){
        this.document = document;
        this.key = key;
        this.cipher = cipher;
    }
}
