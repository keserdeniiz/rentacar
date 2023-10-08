//Form1.java
//Author: Deniz Keser 21995812
//email : keserdeniiz@gmail.com


//‘CarManagement.java’ isimli sınıfta arabaya ait özellikleri
// ve bu özellikleri parametre olarak alan kurucu bulunmaktadır.
// Bu sınıfta ‘reservation.txt’ dosyasından okunan değerler bir
// diziye atılır ve seçilen arabanın plakası ile karşılaştırma
// yapılarak kaç defa kiralandığı bilgisi ve özellikleri ‘car.txt’
// isimli dosyaya yazdırılmaktadır.
import java.io.*;
import java.util.Scanner;

public class CarManagement {
    private String plaka;
    private String gear;
    private String fuelType;
    private String vehicleGroup;
    private String pickUpLocation;
    private String returnLocation;
    private String date;
    private String returnDate;

    public CarManagement(String plaka, String gear, String fuelType, String vehicleGroup, String pickUpLocation, String returnLocation, String date, String returnDate)
    {
        this.plaka = plaka;
        this.gear = gear;
        this.fuelType = fuelType;
        this.vehicleGroup = vehicleGroup;
        this.pickUpLocation = pickUpLocation;
        this.returnLocation = returnLocation;
        this.setDate(date);
        this.returnDate = returnDate;
    }
    public CarManagement(String plaka, String gear, String fuelType, String vehicleGroup, String date, String returnDate)
    {
        this.plaka = plaka;
        this.gear = gear;
        this.fuelType = fuelType;
        this.vehicleGroup = vehicleGroup;
        this.setDate(date);
        this.returnDate = returnDate;
        writeFile();
    }
    public CarManagement(String plaka, String gear, String fuelType, String vehicleGroup)
    {
        this.plaka = plaka;
        this.gear = gear;
        this.fuelType = fuelType;
        this.vehicleGroup = vehicleGroup;
        this.setDate(date);
        this.returnDate = returnDate;

    }

    //dosyadan okunan degerlerle girilen plakanın karsılastırılması ile
    //count hesaplanması.
    public String findId()  //satır kontrol ve sayacın tutulduğu fonksiyon.
    {
        File file = new File("reservation.txt");
        String[] words = null;
        String line2 = this.plaka;  //id ye bakarak kontrol yapmak için tanımlandı.
        int count = 0;
        // plaka ile yapılan kontrol
        String s1 = null;

        //try block
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {//okunacak satır oldugu sürece
                String line = myReader.nextLine();
                words = line.split(" ");
                for (String word : words) {
                    if (word.equals(line2)) { //girilen degerle aynı ise;
                        s1 = words[0] + " " + words[3] + " "+ words[4] + " "+ words[5] +" "+ words[6]+" "+
                                words[7] + " " + words[10] + " "+ words[11];
                        count++;
                    }
                }
            }
            myReader.close(); //dosyayı kapatmayı unutma
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return String.valueOf(s1 + " " + count);
    }

    //car.txt dosyasına kullanıcının idsi, secilen arabanın özelliklerinin yazdırılması
    //ve counter degerinin yazdırılması.
    File file = new File("car.txt");
    public void writeFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("car.txt",true));
            //true yazınca sonuna ekleme modunda acti.
            writer.newLine(); //yeni satır ondan sonra yaz.
            writer.write(String.valueOf(findId()));
            System.out.println("Dosyaya yazıldı.");
            writer.close(); //dosya kapatma
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public String getPlaka() {
        return plaka;
    }

    public String getGear() {
        return gear;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getVehicleGroup() {
        return vehicleGroup;
    }

    public String getReturnLocation() {
        return returnLocation;
    }

    public String getDate() {
        return date;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setVehicleGroup(String vehicleGroup) {
        this.vehicleGroup = vehicleGroup;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
