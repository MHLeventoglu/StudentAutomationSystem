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
        baslikLabel.setBounds(230, 100, 150, 25);
        this.add(baslikLabel);


        JLabel rolLabel = new JLabel("Rol Seçiniz:");
        rolLabel.setBounds(100, 150, 150, 25);
        this.add(rolLabel);

        String[] roller = {"Rol seçiniz...","Öğrenci", "Öğretmen", "Kullanıcı"};
        JComboBox<String> rolDropdown = new JComboBox<>(roller);
        rolDropdown.setBounds(300, 150, 150, 25);
        rolDropdown.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getSource() == rolDropdown) {

                    currentRole = rolDropdown.getSelectedItem().toString();
                }
            }
        });
        this.add(rolDropdown);


        JLabel mailLabel = new JLabel("Mailinizi Giriniz:");
        mailLabel.setBounds(100, 180, 150, 25);
        this.add(mailLabel);

        JTextField mailText = new JTextField("Mailinizi Giriniz:");
        mailText.setBounds(300, 180, 150, 25);
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
        passwordLabel.setBounds(100, 210, 150, 25);
        this.add(passwordLabel);

        JTextField passwordText = new JTextField("Şifrenizi Giriniz:");
        passwordText.setBounds(300, 210, 150, 25);
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
        button.setBounds(200, 260, 150, 35);
        this.add(button);

        button.addActionListener(e -> {
            // Get user from the userController
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
                OgrenciPage ogrenciPage = new OgrenciPage(ogrenci);
                frame.add(ogrenciPage,"OgrenciPage");
                CardLayout layout = (CardLayout) frame.getContentPane().getLayout();
                layout.show(frame.getContentPane(), "OgrenciPage");

                JOptionPane.showMessageDialog(this, "Öğrenci Rolünde oturum açıldı :"+user.getName(), "Başarı", JOptionPane.INFORMATION_MESSAGE);
            }
            if(user.getRole()=="Öğretim Görevlisi"){
                Lecturer ogrGrv = (Lecturer) user;
                OgretimGorevlisiPage ogrGrvPage = new OgretimGorevlisiPage(ogrGrv);
                frame.add(ogrGrvPage,"OgrGrvPage");
                CardLayout layout = (CardLayout) frame.getContentPane().getLayout();
                layout.show(frame.getContentPane(), "OgrGrvPage");

                JOptionPane.showMessageDialog(this, "Öğretim Görevlisi Rolünde oturum açıldı :"+user.getName(), "Başarı", JOptionPane.INFORMATION_MESSAGE);
            }

        });


    }
}

