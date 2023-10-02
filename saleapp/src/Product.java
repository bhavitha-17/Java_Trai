import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Product {
    long id;
    double price;
    public Product() {
    }
    public Product(long id, double price) {
        this.id = id;
        this.price = price;
    }

    void  increasepriceby(double amount){
        this.price=price+amount;

    }
}


