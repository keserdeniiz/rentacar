//Form1.java
//Author: Deniz Keser 21995812
//email : keserdeniiz@gmail.com

//Burada kullanıcının bilgi girişi,
// araba seçimi işlemlerinin yapılması ile
// butona basılması ile bilgilerin ilgili sınıflardan nesne oluşturulması ve dosyaya yazma-okuma işlemleri yapılır.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Form1 extends JFrame {

    private JLabel pickLbl, returnLbl, dateLbl, returnDateLbl, carLbl, nameLbl, surnameLbl, idLbl ;
    private JTextField dateTxt;
    private JTextField returnDateTxt;
    private JTextField nameTxt;
    private JTextField surnameTxt;
    private JTextField idTxt;
    private JComboBox pickCmb;
    private JComboBox returnCmb;
    private JComboBox carCmb;
    private JButton reserveBtn;
    private JCheckBox roofRackCbx;
    private JCheckBox trailerCbx;
    private JCheckBox snowChainCbx;
    private JCheckBox navigationCbx;
    private JCheckBox childCbx;
    private JCheckBox twoDoor;
    private JCheckBox fourDoor;
    private JCheckBox smoker;
    private JCheckBox nonsmoker;
    private JTextArea bill;
    private String[] s1 = {"Ankara", "İstanbul", "İzmir", "Bursa", "Eskişehir"};
    private String[] s2 = { "Volvo" , "BMW", "Ford", "Audi", "Mercedes"};

    private double balance = 0;

    public Form1()
    {

        //label yaratıldı.
        pickLbl = new JLabel("Pick: ");
        returnLbl = new JLabel("Return: ");
        dateLbl = new JLabel("Date: ");
        returnDateLbl = new JLabel("Return Date: ");
        carLbl = new JLabel("Choose Car: ");
        nameLbl = new JLabel("Name: ");
        surnameLbl = new JLabel("Surname: ");
        idLbl = new JLabel("Id: ");

        //text yaratıldı.
        dateTxt = new JTextField(10);
        returnDateTxt = new JTextField(10);
        nameTxt = new JTextField(10);
        surnameTxt = new JTextField(10);
        idTxt = new JTextField(10);

        //combobox yaratıldı.
        pickCmb = new JComboBox(s1);
        returnCmb = new JComboBox(s1);
        carCmb = new JComboBox(s2);

        //checkbox yaratıldı.
        roofRackCbx = new JCheckBox("roof Rack (+250) ");
        trailerCbx = new JCheckBox("Trailer (+100) ");
        snowChainCbx = new JCheckBox("Snow Chain (+400) ");
        navigationCbx = new JCheckBox("Navigation (+200)");
        childCbx = new JCheckBox("Child Seats(+250) ");
        twoDoor = new JCheckBox("Two Door (+0) ");
        fourDoor = new JCheckBox("Four Door (+0) ");
        smoker = new JCheckBox("smoker (+0)");
        nonsmoker = new JCheckBox("nonsmoker(+0) ");

        //TextArea yaratıldı.
        bill = new JTextArea(25,25);

        //buton yaratıldı.
        reserveBtn = new JButton("Reserve ");

        //container olusumu ve guiye componnetlerin eklenmesi.
        Container c = getContentPane();
        c.setLayout(new FlowLayout()); //set layout manager
        c.add(pickLbl);
        c.add(pickCmb);
        c.add(returnLbl);
        c.add(returnCmb);
        c.add(dateLbl);
        c.add(dateTxt);
        c.add(returnDateLbl);
        c.add(returnDateTxt);
        c.add(carLbl);
        c.add(carCmb);
        c.add(roofRackCbx);
        c.add(trailerCbx);
        c.add(snowChainCbx);
        c.add(navigationCbx);
        c.add(childCbx);
        c.add(twoDoor);
        c.add(fourDoor);
        c.add(smoker);
        c.add(nonsmoker);
        c.add(nameLbl);
        c.add(nameTxt);
        c.add(surnameLbl);
        c.add(surnameTxt);
        c.add(idLbl);
        c.add(idTxt);
        c.add(reserveBtn);
        c.add(bill);

        MyEventHandler meh = new MyEventHandler();
        reserveBtn.addActionListener(meh);
    }


    public class MyEventHandler implements ActionListener { //inner class kullanımı
        public void actionPerformed(ActionEvent e) {
            CarManagement volvo, bmw, ford, audi, mercedes; //CarManagement turunde objeler olusturuldu.

            volvo = new CarManagement("06-DK-1999", "benzin", "manuel", "1.grup");
            bmw = new CarManagement("34-AS-1804", "dizel", "otomatik", "2.grup");
            audi = new CarManagement("26-BIL-343", "benzin", "manuel", "3.grup");
            ford = new CarManagement("35-MS-97", "dizel", "otomatik", "denizgrup");
            mercedes = new CarManagement("06-MYK-100", "benzin", "manuel", "1.grup");

            ArrayList<CarManagement> carsArr = new ArrayList<>();

            //secilen arabaya göre yapılacak islemler:
            if (getCarCmb().getSelectedItem() == "BMW") { //araba bmw secilirse
                setBalance(getBalance() + (800 * (calculate())));
                Reservation reservation = new Reservation(idTxt.getText(), nameTxt.getText(),
                        surnameTxt.getText(), getCarCmb().getSelectedItem().toString(), bmw.getPlaka(), bmw.getGear(), bmw.getFuelType(),
                        bmw.getVehicleGroup(), getPickCmb().getSelectedItem().toString(), getReturnCmb().getSelectedItem().toString(),
                        dateTxt.getText(), returnDateTxt.getText(), balance); //Reservation kurucuna göndererek doyaya yazma islemi yapılır.

                CarManagement carManagement = new CarManagement(bmw.getPlaka(), bmw.getGear(), bmw.getFuelType(),
                        bmw.getVehicleGroup(), dateTxt.getText(), returnDateTxt.getText()); //CarManagement kurucusuna gönderilir.
                carsArr.add(bmw);
                bill.append("                  CAR              ");
                bill.append("\n" + bmw.getPlaka() + "\n " + bmw.getGear() + "\n" + bmw.getFuelType() + "\n" + bmw.getVehicleGroup()); //faturaya yazdırma.
            }
            if (getCarCmb().getSelectedItem() == "Volvo") {
                setBalance(getBalance() + (800 * (calculate())));
                Reservation reservation = new Reservation(idTxt.getText(), nameTxt.getText(),
                        surnameTxt.getText(), getCarCmb().getSelectedItem().toString(), volvo.getPlaka(), volvo.getGear(),
                        volvo.getFuelType(), volvo.getVehicleGroup(), getPickCmb().getSelectedItem().toString(), getReturnCmb().getSelectedItem().toString(),
                        dateTxt.getText(), returnDateTxt.getText(), balance);
                CarManagement carManagement = new CarManagement(volvo.getPlaka(), volvo.getGear(), volvo.getFuelType(),
                        volvo.getVehicleGroup(), dateTxt.getText(), returnDateTxt.getText());
                carsArr.add(volvo);
                bill.append("                CAR             ");
                bill.append("\n" + volvo.getPlaka() + "\n " + volvo.getGear() + "\n" + volvo.getFuelType() + "\n" + volvo.getVehicleGroup());
            }
            if (getCarCmb().getSelectedItem() == "Ford") {
                setBalance(getBalance() + (750 * (calculate())));
                Reservation reservation = new Reservation(idTxt.getText(), nameTxt.getText(),
                        surnameTxt.getText(), getCarCmb().getSelectedItem().toString(), ford.getPlaka(), ford.getGear(), ford.getFuelType(),
                        ford.getVehicleGroup(), getPickCmb().getSelectedItem().toString(), getReturnCmb().getSelectedItem().toString(),
                        dateTxt.getText(), returnDateTxt.getText(), balance);
                CarManagement carManagement = new CarManagement(ford.getPlaka(), ford.getGear(), ford.getFuelType(),
                        ford.getVehicleGroup(), dateTxt.getText(), returnDateTxt.getText());
                carsArr.add(ford);
                bill.append("                  CAR              ");
                bill.append("\n" + ford.getPlaka() + "\n " + ford.getGear() + "\n" + ford.getFuelType() + "\n" + ford.getVehicleGroup());

            }
            if (getCarCmb().getSelectedItem() == "Audi") {
                setBalance(getBalance() + (700 * (calculate())));
                Reservation reservation = new Reservation(idTxt.getText(), nameTxt.getText(),
                        surnameTxt.getText(), getCarCmb().getSelectedItem().toString(), audi.getPlaka(), audi.getGear(), audi.getFuelType(),
                        audi.getVehicleGroup(), getPickCmb().getSelectedItem().toString(), getReturnCmb().getSelectedItem().toString(),
                        dateTxt.getText(), returnDateTxt.getText(), balance);
                CarManagement carManagement = new CarManagement(audi.getPlaka(), audi.getGear(), audi.getFuelType(),
                        audi.getVehicleGroup(), dateTxt.getText(), returnDateTxt.getText());
                carsArr.add(audi);
                bill.append("                  CAR              ");
                bill.append("\n" + audi.getPlaka() + "\n " + audi.getGear() + "\n" + audi.getFuelType() + "\n" + audi.getVehicleGroup());
            }
            if (getCarCmb().getSelectedItem() == "Mercedes") {
                setBalance(getBalance() + (1000 * (calculate())));
                Reservation reservation = new Reservation(idTxt.getText(), nameTxt.getText(),
                        surnameTxt.getText(), getCarCmb().getSelectedItem().toString(), mercedes.getPlaka(), mercedes.getGear(), mercedes.getFuelType(),
                        mercedes.getVehicleGroup(), getPickCmb().getSelectedItem().toString(), getReturnCmb().getSelectedItem().toString(),
                        dateTxt.getText(), returnDateTxt.getText(), balance);
                CarManagement carManagement = new CarManagement(mercedes.getPlaka(), mercedes.getGear(), mercedes.getFuelType(),
                        mercedes.getVehicleGroup(), dateTxt.getText(), returnDateTxt.getText());
                carsArr.add(mercedes);
                bill.append("                 CAR              ");
                bill.append("\n " + mercedes.getPlaka() + "\n " + mercedes.getGear() + "\n" + mercedes.getFuelType() + "\n" + mercedes.getVehicleGroup());
            }

            //chekbox ile secimlerin faturaya yazdırması ve fiyatı degistimesi islemleri
            if (e.getSource() == getReserveBtn()) {
                if (roofRackCbx.isSelected()) {
                    setBalance(getBalance() + 250);
                    bill.append(roofRackCbx.getText() + "\n");
                }
                if (trailerCbx.isSelected()) {
                    setBalance(getBalance() + 100);
                    bill.append(trailerCbx.getText() + "\n");
                }
                if (snowChainCbx.isSelected()) {
                    setBalance(getBalance() + 400);
                    bill.append(snowChainCbx.getText() + "\n");
                }
                if (navigationCbx.isSelected()) {
                    setBalance(getBalance() + 200);
                    bill.append(navigationCbx.getText() + "\n");
                }
                if (childCbx.isSelected()) {
                    setBalance(getBalance() + 250);
                    bill.append(childCbx.getText() + "\n");
                }
                if(twoDoor.isSelected()){
                    bill.append(twoDoor.getText() + "\n");
                }
                if(fourDoor.isSelected()){
                    bill.append(fourDoor.getText() + "\n");
                }
                if(smoker.isSelected()){
                    bill.append(smoker.getText() + "\n");
                }
                if(nonsmoker.isSelected()){
                    bill.append(nonsmoker.getText() + "\n");
                }
                String s1 = "\n" + idTxt.getText() + "\n " + nameTxt.getText() + "\n " + surnameTxt.getText() + "\n" +
                        getCarCmb().getSelectedItem().toString() + "\n"+getPickCmb().getSelectedItem().toString() + " \n" +
                        getReturnCmb().getSelectedItem().toString() + "\n " + dateTxt.getText() + "\n " + returnDateTxt.getText() + "\n" + String.valueOf(balance);
                bill.append("                  KULLANICI              ");
                bill.append(s1);
                //Customer turunde nesne üretilmesi ve sınıfın metoduyla dosyaya yazdırılması islemleri
                Customer customer = new Customer(Integer.parseInt(getIdTxt().getText()), getNameTxt().getText(), getSurnameTxt().getText(), getBalance());
                customer.writeFile();
            }
            }
        }

        //gün hesabının yapıldıgı method.
        public int calculate() throws RuntimeException {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            // Try Block
            try {

                Date d1 = simpleDateFormat.parse(getDateTxt().getText());
                Date d2 = simpleDateFormat.parse(getReturnDateTxt().getText());

                // milisaniye cinsinden farkı hesaplama
                long zaman_farki = d2.getTime() - d1.getTime();

                int day = (int) ((zaman_farki / (1000 * 60 * 60 * 24)) % 365);
                return day;

            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        }

        public JTextField getDateTxt() {
            return dateTxt;
        }

        public JTextField getReturnDateTxt() {
            return returnDateTxt;
        }

        public JComboBox getPickCmb() {
            return pickCmb;
        }

        public JComboBox getReturnCmb() {
            return returnCmb;
        }

        public JButton getReserveBtn() {
            return reserveBtn;
        }


        public JCheckBox getRoofRackCbx() {
            return roofRackCbx;
        }

        public JCheckBox getTrailerCbx() {
            return trailerCbx;
        }

        public JCheckBox getSnowChainCbx() {
            return snowChainCbx;
        }

        public JCheckBox getNavigationCbx() {
            return navigationCbx;
        }

        public JCheckBox getChildCbx() {
            return childCbx;
        }

        public String[] getS1() {
            return s1;
        }

        public String[] getS2() {
            return s2;
        }

        public JTextField getNameTxt() {
            return nameTxt;
        }

        public JTextField getSurnameTxt() {
            return surnameTxt;
        }

        public JTextField getIdTxt() {
            return idTxt;
        }

        public JComboBox getCarCmb() {
            return carCmb;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
    public JCheckBox getTwoDoor() {
        return twoDoor;
    }

    public void setTwoDoor(JCheckBox twoDoor) {
        this.twoDoor = twoDoor;
    }

    public JCheckBox getFourDoor() {
        return fourDoor;
    }

    public void setFourDoor(JCheckBox fourDoor) {
        this.fourDoor = fourDoor;
    }

    public JCheckBox getSmoker() {
        return smoker;
    }

    public void setSmoker(JCheckBox smoker) {
        this.smoker = smoker;
    }

    public JCheckBox getNonsmoker() {
        return nonsmoker;
    }

    public void setNonsmoker(JCheckBox nonsmoker) {
        this.nonsmoker = nonsmoker;
    }
    }
