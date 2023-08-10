package alpha;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class Mywindow extends JFrame {

    private JLabel heading;

    private JLabel clockLabel;

    private Font font = new Font("Times new roman", Font.BOLD, 35);

    Mywindow(){
        super.setTitle("My Clock");
        super.setSize(400,400);
        super.setLocation(300,50);
        this.createGui();
        this.startCLock();
        super.setVisible(true);

    }
    public void createGui(){
        heading =new JLabel("My Clock");

        clockLabel = new JLabel("CLOCK");

        heading.setFont(font);
        clockLabel.setFont(font);



        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clockLabel);

    }
    public void startCLock(){
//        Timer timer = new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                String dateTime = new java.util.Date().toString();
////                String dateTime = new java.util.Date().toLocaleString();
//                Date d = new java.util.Date();
//
//                SimpleDateFormat sfd = new SimpleDateFormat("hh:mm:ss a");
//                String dateTime = sfd.format(d);
//
//                clockLabel.setText(dateTime);
//            }
//        });
//        timer.start();


        //Using multiThreading
        Thread t = new Thread(){
            public void run(){
                try{
                    while(true){
                        Date d = new java.util.Date();

                        SimpleDateFormat sfd = new SimpleDateFormat("hh:mm:ss a");
                        String dateTime = sfd.format(d);

                        clockLabel.setText(dateTime);

//                        Thread.sleep(1000);
                        Thread.currentThread().sleep(1000);
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

}
