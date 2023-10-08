//Form1.java
//Author: Deniz Keser 21995812
//email : keserdeniiz@gmail.com

//‘Customer.java’ isimli sınıfta kullanıcıya ait bilgiler
// ve bu özellikleri parametre olarak alan kurucu fonksiyon
// bulunmaktadır. Bu sınıfta ‘reservation.txt’ dosyasından
// okunan değerler bir diziye atılır ve kullanıcıdan alınan
// bilgilerden kullanıcı id’si nin kaç defa kiralama yaptığı bilgisi,
// kullanıcı bilgileri ve kullanıcının ödeme yapacağı tutar ‘client.txt’
// isimli dosyaya yazdırılmaktadır.
import java.io.*;
import java.util.Scanner;

public class Customer {
    private int id;
    private String name;
    private String surname;
    private double balance;

    public Customer(int id, String name, String surname, double balance)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
    }

    //dosya acma ve yazma
    public void createFile() throws IOException {
        //try block
        try{
            File file = new File("client.txt");
            if(file.createNewFile()){
                System.out.println("File is create.");//dosya olusturur true ya da false doner.
            }else{
                System.out.println("File is available.");
            }
        }catch(IOException e){
            e.printStackTrace(); //hata mesajı yazdırma
        }
    }

    public String findId()  //id kontrol ve sayacın tutulduğu fonksiyon.
    {
        File file = new File("reservation.txt");
        String[] words = null;
        String line2 = String.valueOf(this.id);  //id ye bakarak kontrol yapmak için tanımlandı.
        int count = 0;
        // id ile yapılan kontrol
        String s1 = null;
        //try block
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {//okunacak satır oldugu sürece
                String line = myReader.nextLine();
                words = line.split(" ");
                for (String word : words) {
                    if (word.equals(line2)) {
                        s1 = words[0] + " " + words[8] + " "+ words[9]  +" "+ words[12];
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

    //kullanıcının id degeri, arabayı teslim alıp-bırakacagı konumlar, toplam ödemesi
    //ve ac kere kiraladığı ile ilgili bilgilerin dosyaya basılması.
    public void writeFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("client_id.txt",true));
            //true yazınca sonuna ekleme modunda acti.
            writer.newLine(); //yeni satır ondan sonra yaz.
            //String s1 = id + " " + pick + " " + returnW +" " + String.valueOf(balance);
            writer.write(String.valueOf(findId()));
            System.out.println("Dosyaya yazıldı.");
            writer.close(); //dosya kapatma
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getBalance() {
        return balance;
    }
}
