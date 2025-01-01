package gui.Pages;

import entities.Course;
import entities.Lecturer;
import gui.AbstractPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OgretimGorevlisiPage extends AbstractPanel {
    public Lecturer ogrGrv;


    public OgretimGorevlisiPage(Lecturer ogrGrv) {
        super();
        this.ogrGrv = ogrGrv;

        this.setLayout(null);

        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(10, 10, 200, 440);
        leftPanel.setLayout(new GridLayout(5, 1, 20, 20));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        leftPanel.setBackground(Color.LIGHT_GRAY);

        JButton btnSinavNotuGirisi = new JButton("Sınav Notu Girişi");
        JButton btnDersProgrami = new JButton("Ders Programı");
        JButton btnDevamsizlikTakibi = new JButton("Devamsızlık Takibi");
        JButton btnOgrenciListesi = new JButton("Öğrenci Listesi");

        leftPanel.add(btnSinavNotuGirisi);
        leftPanel.add(btnDersProgrami);
        leftPanel.add(btnDevamsizlikTakibi);
        leftPanel.add(btnOgrenciListesi);

        JPanel sinavNotuGirisi = new JPanel();
        sinavNotuGirisi.setBounds(220, 10, 550, 440);
        sinavNotuGirisi.setLayout(null);

        JLabel lblSinavNotuGirisi = new JLabel("Sınav Notu Girişi");
        lblSinavNotuGirisi.setFont(new Font("Arial", Font.BOLD, 24));
        lblSinavNotuGirisi.setBounds(200, 10, 200, 30);
        sinavNotuGirisi.add(lblSinavNotuGirisi);

        JLabel lblDersAdi = new JLabel("Ders Adı:");
        lblDersAdi.setBounds(50, 60, 100, 30);
        sinavNotuGirisi.add(lblDersAdi);

        JTextField txtDersAdi = new JTextField();
        txtDersAdi.setBounds(200, 60, 300, 30);
        sinavNotuGirisi.add(txtDersAdi);

        JLabel lblOgrenciNo = new JLabel("Öğrenci No:");
        lblOgrenciNo.setBounds(50, 110, 100, 30);
        sinavNotuGirisi.add(lblOgrenciNo);

        JTextField txtOgrenciNo = new JTextField();
        txtOgrenciNo.setBounds(200, 110, 300, 30);
        sinavNotuGirisi.add(txtOgrenciNo);

        JLabel lblSinavNotu = new JLabel("Sınav Notu:");
        lblSinavNotu.setBounds(50, 160, 100, 30);
        sinavNotuGirisi.add(lblSinavNotu);

        JTextField txtSinavNotu = new JTextField();
        txtSinavNotu.setBounds(200, 160, 300, 30);
        sinavNotuGirisi.add(txtSinavNotu);

        JButton btnSinavNotuKaydet = new JButton("Kaydet");
        btnSinavNotuKaydet.setBounds(350, 210, 150, 30);
        sinavNotuGirisi.add(btnSinavNotuKaydet);

        JPanel dersProgrami = new JPanel();
        dersProgrami.setBounds(220, 10, 550, 440);
        dersProgrami.setLayout(null);

        JLabel lblDersProgrami = new JLabel("Ders Programı");
        lblDersProgrami.setFont(new Font("Arial", Font.BOLD, 24));
        lblDersProgrami.setBounds(200, 10, 200, 30);
        dersProgrami.add(lblDersProgrami);

        JLabel lblDersTarihi = new JLabel("Ders Tarihi:");
        lblDersTarihi.setBounds(50, 60, 100, 30);
        dersProgrami.add(lblDersTarihi);

        JTextField txtDersTarihi = new JTextField();
        txtDersTarihi.setBounds(200, 60, 300, 30);
        dersProgrami.add(txtDersTarihi);

        JLabel lblDersSaati = new JLabel("Ders Saati:");
        lblDersSaati.setBounds(50, 110, 100, 30);
        dersProgrami.add(lblDersSaati);

        JTextField txtDersSaati = new JTextField();
        txtDersSaati.setBounds(200, 110, 300, 30);
        dersProgrami.add(txtDersSaati);

        JButton btnDersProgramiKaydet = new JButton("Kaydet");
        btnDersProgramiKaydet.setBounds(350, 160, 150, 30);
        dersProgrami.add(btnDersProgramiKaydet);

        JPanel devamsizlikTakibi = new JPanel();
        devamsizlikTakibi.setBounds(220, 10, 550, 440);
        devamsizlikTakibi.setLayout(null);

        JLabel lblDevamsizlikTakibi = new JLabel("Devamsızlık Takibi");
        lblDevamsizlikTakibi.setFont(new Font("Arial", Font.BOLD, 24));
        lblDevamsizlikTakibi.setBounds(200, 10, 300, 30);
        devamsizlikTakibi.add(lblDevamsizlikTakibi);

        JLabel lblOgrenciNoDevamsizlik = new JLabel("Öğrenci No:");
        lblOgrenciNoDevamsizlik.setBounds(50, 60, 100, 30);
        devamsizlikTakibi.add(lblOgrenciNoDevamsizlik);

        JTextField txtOgrenciNoDevamsizlik = new JTextField();
        txtOgrenciNoDevamsizlik.setBounds(200, 60, 300, 30);
        devamsizlikTakibi.add(txtOgrenciNoDevamsizlik);

        JButton btnDevamsizlikKaydet = new JButton("Kaydet");
        btnDevamsizlikKaydet.setBounds(350, 110, 150, 30);
        devamsizlikTakibi.add(btnDevamsizlikKaydet);
/////////////////////////////////////////// OgrenciListesi VVVVVVV
        JPanel ogrenciListesi = new JPanel();
        ogrenciListesi.setBounds(220, 10, 550, 440);
        ogrenciListesi.setLayout(null);

        JLabel lblOgrenciListesi = new JLabel("Öğrenci Listesi");
        lblOgrenciListesi.setFont(new Font("Arial", Font.BOLD, 24));
        lblOgrenciListesi.setBounds(200, 10, 200, 30);
        ogrenciListesi.add(lblOgrenciListesi);

        // Combobox //
        JComboBox<Course> courseComboBox = new JComboBox<>();
        ogrGrv.getCourses().forEach(courseComboBox::addItem);
        courseComboBox.setBounds(50,60,450,30);
        ogrenciListesi.add(courseComboBox);

            //Öğrenci listesi
        DefaultListModel<String> ogrenciListesiModel = new DefaultListModel<>();
        JList<String> ogrenciJList = new JList<>(ogrenciListesiModel);
        JScrollPane scrollOgrenciListesi = new JScrollPane(ogrenciJList);
        scrollOgrenciListesi.setBounds(50, 110, 450, 300);
        ogrenciListesi.add(scrollOgrenciListesi);
        //Combobox action listener'ı
        courseComboBox.addActionListener(e -> {
            // Get the selected Course
            Course selectedCourse = (Course) courseComboBox.getSelectedItem();
            if (selectedCourse != null) {
                // Clear the previous student list
                ogrenciListesiModel.clear();

                // Populate the JList with students from the selected course
                selectedCourse.getStudents().forEach(student -> {
                    String studentInfo = student.getId() + " - " + student.getName();
                    ogrenciListesiModel.addElement(studentInfo);
                });
            }
        });

// Ensure the panel is updated visually
        ogrenciListesi.revalidate();
        ogrenciListesi.repaint();


        sinavNotuGirisi.setVisible(true);
        dersProgrami.setVisible(false);
        devamsizlikTakibi.setVisible(false);
        ogrenciListesi.setVisible(false);

        btnSinavNotuGirisi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sinavNotuGirisi.setVisible(true);
                dersProgrami.setVisible(false);
                devamsizlikTakibi.setVisible(false);
                ogrenciListesi.setVisible(false);
            }
        });

        btnDersProgrami.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sinavNotuGirisi.setVisible(false);
                dersProgrami.setVisible(true);
                devamsizlikTakibi.setVisible(false);
                ogrenciListesi.setVisible(false);
            }
        });

        btnDevamsizlikTakibi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sinavNotuGirisi.setVisible(false);
                dersProgrami.setVisible(false);
                devamsizlikTakibi.setVisible(true);
                ogrenciListesi.setVisible(false);
            }
        });

        btnOgrenciListesi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sinavNotuGirisi.setVisible(false);
                dersProgrami.setVisible(false);
                devamsizlikTakibi.setVisible(false);
                ogrenciListesi.setVisible(true);
            }
        });

        this.add(leftPanel);
        this.add(sinavNotuGirisi);
        this.add(dersProgrami);
        this.add(devamsizlikTakibi);
        this.add(ogrenciListesi);
    }
}