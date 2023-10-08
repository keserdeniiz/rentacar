//Form1.java
//Author: Deniz Keser 21995812
//email : keserdeniiz@gmail.com
//Form1 türünde nesne oluşturularak gerekli işlemlerin yapılması sağlanır.
import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        //Form1 classından nesne üretilmesi ve ilgili islemlerin yapılması.
        Form1 gui = new Form1();
        gui.setTitle("Rent a Car App");
        gui.setSize(900,700);
        gui.setVisible(true);
        gui.setResizable(false);

        gui.setDefaultCloseOperation(gui.EXIT_ON_CLOSE);

    }
}