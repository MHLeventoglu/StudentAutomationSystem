package gui.Pages;

import entities.Course;
import entities.Exam;
import entities.Student;
import gui.AbstractPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OgrenciPage extends AbstractPanel {
    Student ogrenci;


    public OgrenciPage(Student ogrenci,JFrame frame) {
        super();
        this.ogrenci = ogrenci;

        this.setLayout(null);
        this.setBounds(0, 0, 800, 600);

        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(10, 10, 200, 440);
        leftPanel.setLayout(new GridLayout(5, 1, 20, 20));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        leftPanel.setBackground(Color.LIGHT_GRAY);

        // Menü butonları
        JButton btnDersSecimi = new JButton("Ders Seçimi");
        JButton btnSinavNotlari = new JButton("Sınav Notları");
        JButton btnOzluksBilgileri = new JButton("Özlük Bilgileri");

        leftPanel.add(btnDersSecimi);
        leftPanel.add(btnSinavNotlari);
        leftPanel.add(btnOzluksBilgileri);
        ////////////////////////////////////////////////////////////////////////////
        // Özlük Bilgileri Paneli
        JPanel ozlukBilgileri = new JPanel();
        ozlukBilgileri.setBounds(220, 10, 550, 440);
        ozlukBilgileri.setLayout(null);

        JLabel lblTitle = new JLabel("Özlük Bilgileri");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(200, 10, 200, 30);
        ozlukBilgileri.add(lblTitle);

        JLabel lblName = new JLabel("Ad Soyad:");
        lblName.setBounds(50, 60, 100, 30);
        ozlukBilgileri.add(lblName);

        JTextField txtName = new JTextField();
        txtName.setBounds(200, 60, 300, 30);
        ozlukBilgileri.add(txtName);

        JLabel lblEmail = new JLabel("Mail:");
        lblEmail.setBounds(50, 110, 100, 30);
        ozlukBilgileri.add(lblEmail);

        JTextField txtEmail = new JTextField("Mail");
        txtEmail.setBounds(200, 110, 300, 30);
        ozlukBilgileri.add(txtEmail);

        JLabel lblYear = new JLabel("Giriş Yılı:");
        lblYear.setBounds(50, 160, 100, 30);
        ozlukBilgileri.add(lblYear);

        JTextField txtYear = new JTextField();
        txtYear.setBounds(200, 160, 300, 30);
        ozlukBilgileri.add(txtYear);

        JLabel lblTerm = new JLabel("Dönem:");
        lblTerm.setBounds(50, 210, 100, 30);
        ozlukBilgileri.add(lblTerm);

        JTextField txtTerm = new JTextField();
        txtTerm.setBounds(200, 210, 300, 30);
        ozlukBilgileri.add(txtTerm);

        JLabel lblFaculty = new JLabel("Fakülte / Bölüm:");
        lblFaculty.setBounds(50, 260, 150, 30);
        ozlukBilgileri.add(lblFaculty);

        JTextField txtFaculty = new JTextField();
        txtFaculty.setBounds(200, 260, 300, 30);
        ozlukBilgileri.add(txtFaculty);

        JButton kaydetOzluk = new JButton("Kaydet");
        kaydetOzluk.setBounds(350, 310, 150, 30);
        ozlukBilgileri.add(kaydetOzluk);
        ///////////////////////////////////////////////////////////////////
        // Ders Seçimi Paneli
        JPanel dersSecimi = new JPanel();
        dersSecimi.setBounds(220, 10, 550, 440);
        dersSecimi.setLayout(new BoxLayout(dersSecimi, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Ders Seçimi", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dersSecimi.add(titleLabel);
        //alınan dersler
        DefaultListModel<Course> alinanDerslerModel = new DefaultListModel<>();
        for (Course course : ogrenci.getEnrolledCourses()) {
            alinanDerslerModel.addElement(course);
        }
        JList<Course> alinanDerslerList = new JList<>(alinanDerslerModel);
        JScrollPane alinanDerslerScroll = new JScrollPane(alinanDerslerList);
        dersSecimi.add(alinanDerslerScroll);
        //alınabilir dersler
        DefaultListModel<Course> alinabilirDerslerModel = new DefaultListModel<>();
        List<Course> result = new ArrayList<>(courseManager.getAll());
        result.removeAll(ogrenci.getEnrolledCourses());
        for (Course course : result) {
            alinabilirDerslerModel.addElement(course);
        }
        JList<Course> alinabilirDerslerList = new JList<>(alinabilirDerslerModel);
        JScrollPane alinabilirDerslerScroll = new JScrollPane(alinabilirDerslerList);
        dersSecimi.add(alinabilirDerslerScroll);

        JButton ekleButton = new JButton("Ekle");
        JButton birakButton = new JButton("Bırak");
        dersSecimi.add(ekleButton);
        dersSecimi.add(birakButton);

        ekleButton.addActionListener(e -> {
            Course selectedValue = alinabilirDerslerList.getSelectedValue();
            if (selectedValue != null) {
                ogrenci.addEnrolledCourse(selectedValue);
                alinabilirDerslerModel.removeElement(selectedValue);
                alinanDerslerModel.addElement(selectedValue);
            }
        });

        birakButton.addActionListener(e -> {
            Course selectedValue = alinanDerslerList.getSelectedValue();
            if (selectedValue != null) {
                ogrenci.removeEnrolledCourse(selectedValue.getCourseCode());
                alinanDerslerModel.removeElement(selectedValue);
                alinabilirDerslerModel.addElement(selectedValue);
            }
        });

        // Sınav Notları Paneli
        JPanel sinavNotlari = new JPanel();
        sinavNotlari.setBounds(220, 10, 550, 440);
        sinavNotlari.setLayout(null);

        JLabel lblSinavTitle = new JLabel("Sınav Notları");
        lblSinavTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblSinavTitle.setBounds(200, 10, 200, 30);
        sinavNotlari.add(lblSinavTitle);

        DefaultListModel<String> examListModel = new DefaultListModel<>();
        JList<String> examJList = new JList<>(examListModel);
        JScrollPane examScrollPane = new JScrollPane(examJList);
        examManager.getByStudenId(ogrenci.getId()).forEach(exam -> {
            String examInfoText = exam.getCreatedDate().toLocalDate().toString()+" | "+exam.getCourse().getCourseName() +"   -   "+ exam.getExamType() +"   -   "+ ((Number)exam.getPoint()).toString();
            examListModel.addElement(examInfoText);
        });
        examScrollPane.setBounds(50,50,450,440);
        sinavNotlari.add(examScrollPane);

        JButton logoutButton = createLogoutButton(frame);
        this.add(logoutButton);

        btnOzluksBilgileri.addActionListener(e -> {
            ozlukBilgileri.setVisible(true);
            dersSecimi.setVisible(false);
            sinavNotlari.setVisible(false);

            txtName.setText(ogrenci.getName());
            txtEmail.setText(ogrenci.getMail());
            txtFaculty.setText(ogrenci.getDepartment());
        });

        btnDersSecimi.addActionListener(e -> {
            ozlukBilgileri.setVisible(false);
            dersSecimi.setVisible(true);
            sinavNotlari.setVisible(false);
        });

        btnSinavNotlari.addActionListener(e -> {
            ozlukBilgileri.setVisible(false);
            dersSecimi.setVisible(false);
            sinavNotlari.setVisible(true);
        });

        this.add(leftPanel);
        this.add(ozlukBilgileri);
        this.add(dersSecimi);
        this.add(sinavNotlari);

        ozlukBilgileri.setVisible(false);
        dersSecimi.setVisible(false);
        sinavNotlari.setVisible(false);
    }
}
