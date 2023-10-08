//Form1.java
//Author: Deniz Keser 21995812
//email : keserdeniiz@gmail.com

//‘Reservation.java’ isimli sınıfta kullanıcı bilgilerini
// parametre olarak alan bir kurucu bulunmaktadır. Bu kurunun
// içinde gelen bilgiler sınıf içerisinde bulunan ‘writeFile()’
// metoduna gönderilerek dosyaya yazma işlemi yapılmaktadır.

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Reservation {
    private String id;
    private String name;
    private String surname;
    private String car;
    private String pick;
    private String returnW;
    private String date;
    private String returnDate;
    private double balance;
    private String plaka;
    private String gear;
    private String fuelType;
    private String vehicleGroup;
    public Reservation(String id, String name, String surname, String car,String plaka, String gear, String fuelType, String vehicleGroup, String pick, String returnW, String date, String returnDate, double balance)
    {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.car = car;
            this.pick = pick;
            this.returnW= returnW;
            this.date = date;
            this.returnDate = returnDate;
            this.balance = balance;
            this.plaka = plaka;
            this.gear = gear;
            this.fuelType = fuelType;
            this.vehicleGroup = vehicleGroup;

            System.out.println("girdim");
            writeFile(id,name,surname,car,plaka, gear, fuelType,vehicleGroup,pick,returnW,date,returnDate, Double.parseDouble(String.valueOf(balance)));
    }

    //dosya acma ve yazma
    public void createFile() throws IOException {
        //try block
        try{
            File file = new File("reservation.txt");
            if(file.createNewFile()){
                System.out.println("File is create.");//dosya olusturur true ya da false doner.
            }else{
                System.out.println("File is available.");
            }
        }catch(IOException e){
            e.printStackTrace(); //hata mesajı yazdırma
        }
    }

    //reservation.txt dosyasına yazdırma islemleri.
    public void writeFile(String id, String name, String surname, String car,String plaka, String gear, String fuelType, String vehicleGroup, String pick, String returnW, String date, String returnDate, double balance){
       //try block
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("reservation.txt",true));
            //true yazınca sonuna ekleme modunda acti.
            String s1 = id + " " + name +" " + surname + " " + car + " "+ plaka + " " + gear +" "+ fuelType+ " " + vehicleGroup+ " "+ pick +" "+ returnW + " "+ date + " " + returnDate+ " "+ balance;
            writer.newLine(); //yeni satır ondan sonra yaz.
            writer.write(String.valueOf(s1));
            System.out.println("Dosyaya yazıldı.");
            writer.close(); //dosya kapatma
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public String getId() {
        return id;
    }

    public String getCar() {
        return car;
    }


    public String getPick() {
        return pick;
    }


    public String getReturnW() {
        return returnW;
    }

    public String getDate() {
        return date;
    }


    public String getReturnDate() {
        return returnDate;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}
