package gui.Pages;

import entities.Lecturer;
import entities.Student;
import entities.User;
import gui.AbstractPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LoginPage extends AbstractPanel {
    static String currentRole;

    public LoginPage(JFrame frame) {
        super();

        this.setSize(800, 600);
        this.setLayout(null);


        JLabel baslikLabel = new JLabel("GİRİŞ YAPINIZ!!!");
        baslikLabel.setBounds(340, 100, 150, 45);
        this.add(baslikLabel);



        JLabel mailLabel = new JLabel("Mailinizi Giriniz:");
        mailLabel.setBounds(250, 180, 130, 30);
        this.add(mailLabel);

        JTextField mailText = new JTextField("Mailinizi Giriniz:");
        mailText.setBounds(380, 180, 150, 30);
        this.add(mailText);

        mailText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (mailText.getText().equals("Mailinizi Giriniz:")) {
                    mailText.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (mailText.getText().isEmpty()) {
                    mailText.setText("Mailinizi Giriniz:");
                }
            }
        });


        JLabel passwordLabel = new JLabel("Şifrenizi Giriniz:");
        passwordLabel.setBounds(250, 220, 180, 30);
        this.add(passwordLabel);

        JTextField passwordText = new JTextField("Şifrenizi Giriniz:");
        passwordText.setBounds(380, 220, 150, 30);
        this.add(passwordText);

        passwordText.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordText.getText().equals("Şifrenizi Giriniz:")) {
                    passwordText.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordText.getText().isEmpty()) {
                    passwordText.setText("Şifrenizi Giriniz:");
                }
            }
        });


        JButton button = new JButton("Giriş");
        button.setBounds(325, 300, 150, 35);
        this.add(button);

        button.addActionListener(e -> {
            // Get user from the userController
            CardLayout layout = (CardLayout) frame.getContentPane().getLayout();
            if (mailText.getText().equals("admin")&&passwordText.getText().equals("admin")){
                AdminPage adminPage = new AdminPage(frame);
                frame.add(adminPage,"AdminPage");
                layout.show(frame.getContentPane(),"AdminPage");
                JOptionPane.showMessageDialog(this, "Admin Rolünde oturum açıldı : admin", "Başarı", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                System.out.println(mailText.getText().trim()+" "+ passwordText.getText().trim()); // Hata ayıklama için
                String mail = new String(mailText.getText().trim());
                String password = new String(passwordText.getText().trim());
                User user = userController.checkPassword(mail,password);

                if (user == null) {
                    JOptionPane.showMessageDialog(this, "Girdiğiniz mail yada şifre yanlış", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(user.getRole()=="Ogrenci"){
                    Student ogrenci = (Student) user;
                    OgrenciPage ogrenciPage = new OgrenciPage(ogrenci,frame);
                    frame.add(ogrenciPage,"OgrenciPage");
                    layout.show(frame.getContentPane(), "OgrenciPage");

                    JOptionPane.showMessageDialog(this, "Öğrenci Rolünde oturum açıldı :"+user.getName(), "Başarı", JOptionPane.INFORMATION_MESSAGE);
                }
                if(user.getRole()=="Öğretim Görevlisi"){
                    Lecturer ogrGrv = (Lecturer) user;
                    OgretimGorevlisiPage ogrGrvPage = new OgretimGorevlisiPage(ogrGrv,frame);
                    frame.add(ogrGrvPage,"OgrGrvPage");
                    layout.show(frame.getContentPane(), "OgrGrvPage");

                    JOptionPane.showMessageDialog(this, "Öğretim Görevlisi Rolünde oturum açıldı :"+user.getName(), "Başarı", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });


    }
}

