package gui.Pages;

import entities.Course;
import entities.Exam;
import entities.Lecturer;
import gui.AbstractPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class OgretimGorevlisiPage extends AbstractPanel {
    public Lecturer ogrGrv;

    protected class KeyValue{
        public long key;
        public String value;
        public KeyValue(long key, String value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return value;
        }
    }

    public OgretimGorevlisiPage(Lecturer ogrGrv,JFrame frame) {
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
        JButton btnSifreDegis = new JButton("Şifre Değiştirme");
        JButton btnOgrenciListesi = new JButton("Öğrenci Listesi/Not girme");


        leftPanel.add(btnSifreDegis);
        leftPanel.add(btnOgrenciListesi);

/// //////////////////////////// Şifre Değiştirme:
        //Şifre değiştirme paneli
        JPanel sifreDegistir = new JPanel();
        sifreDegistir.setBounds(220, 10, 550, 440);
        sifreDegistir.setLayout(null);

        // TextBox ekleme
        JTextField sifreField = new JTextField(ogrGrv.getPassword());
        sifreField.setBounds(50, 200, 200, 30); // Konum ve boyut (x, y, genişlik, yükseklik)
        sifreDegistir.add(sifreField);
        // Button ekleme
        JButton sifredegisbtn = new JButton("Değiştir");
        sifredegisbtn.setBounds(250, 200, 100, 30); // Konum ve boyut
        sifreDegistir.add(sifredegisbtn);
        sifredegisbtn.addActionListener(e -> {
            ogrGrv.setPassword(sifreField.getText());
        });



/////////////////////////////////////////// OgrenciListesi VVVVVVV
        JPanel ogrenciListesi = new JPanel();
        ogrenciListesi.setBounds(220, 10, 550, 440);
        ogrenciListesi.setLayout(null);

        JLabel lblOgrenciListesi = new JLabel("Öğrenci Listesi/Sınav Nout");
        lblOgrenciListesi.setFont(new Font("Arial", Font.BOLD, 24));
        lblOgrenciListesi.setBounds(200, 10, 200, 30);
        ogrenciListesi.add(lblOgrenciListesi);

        // Combobox //
        JComboBox<Course> courseComboBox = new JComboBox<>();
        courseComboBox.addItem(new Course("Ders Seçiniz..."));
        ogrGrv.getCourses().forEach(courseComboBox::addItem);
        courseComboBox.setBounds(50,60,450,30);
        ogrenciListesi.add(courseComboBox);

        //Öğrenci listesi
        DefaultListModel<KeyValue> ogrenciListesiModel = new DefaultListModel<>();
        JList<KeyValue> ogrenciJList = new JList<>(ogrenciListesiModel);
        JScrollPane scrollOgrenciListesi = new JScrollPane(ogrenciJList);
        scrollOgrenciListesi.setBounds(50, 110, 450, 280);
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
                    long studentId = student.getId();
                    String studentInfo = "ID: "+student.getId() + "  İsim: " + student.getName();
                    ogrenciListesiModel.addElement(new KeyValue(studentId,studentInfo));
                });
            }
        });

        // examTypeCombobox (ComboBox)
        String[] examTypes = {"sınav tipi","Final", "Vize"}; // Kombinasyondaki seçenekler
        JComboBox<String> examTypeComboBox = new JComboBox<>(examTypes);
        examTypeComboBox.setBounds(50, 410, 170, 30);
        ogrenciListesi.add(examTypeComboBox);

        // pointsSpinner (JSpinner)
        SpinnerNumberModel pointsModel = new SpinnerNumberModel(0.0f, 0.0f, 100.0f, 1.0f); // Min, max, başlangıç değeri, artış miktarı
        JSpinner pointsSpinner = new JSpinner(pointsModel);
        pointsSpinner.setBounds(225, 410, 170, 30);
        ogrenciListesi.add(pointsSpinner);

        // adjustExamButton (Button)
        JButton adjustExamButton = new JButton("Notu Gir");
        adjustExamButton.setBounds(400, 410, 100, 30);
        adjustExamButton.addActionListener(e->{
            long studentId = 0;
            if( !ogrenciJList.isSelectionEmpty()){studentId = ogrenciJList.getSelectedValue().key;}
            Course selectedCourse = (Course) courseComboBox.getSelectedItem();
            String examType = (String) examTypeComboBox.getSelectedItem();
            float examPoint = ((Number)pointsSpinner.getValue()).floatValue();
            if (examType == "sınav tipi"){
                JOptionPane.showMessageDialog(this, "Sınav tipi seçiniz", "Hata", JOptionPane.ERROR_MESSAGE);
            } else if (studentId == 0) {
                JOptionPane.showMessageDialog(this, "Lütfen öğrenci seçiniz", "Hata", JOptionPane.ERROR_MESSAGE);
            }
            else{
                examManager.add(new Exam(studentId,selectedCourse,examType,examPoint,50));
                JOptionPane.showMessageDialog(this, ((Number)studentId).toString()+" : numaralı öğrencinin "+examType+" sonucu başarıyla girilmiştir", "Başarı", JOptionPane.INFORMATION_MESSAGE);
            }


        });
        ogrenciListesi.add(adjustExamButton);


        ogrenciListesi.revalidate();
        ogrenciListesi.repaint();




        sifreDegistir.setVisible(true);
        ogrenciListesi.setVisible(false);

        JButton logoutButton = createLogoutButton(frame);
        this.add(logoutButton);

        btnSinavNotuGirisi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sifreDegistir.setVisible(false);
                ogrenciListesi.setVisible(false);
            }
        });

        btnDersProgrami.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sifreDegistir.setVisible(false);
                ogrenciListesi.setVisible(false);
            }
        });

        btnSifreDegis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sifreDegistir.setVisible(true);
                ogrenciListesi.setVisible(false);
            }
        });

        btnOgrenciListesi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sifreDegistir.setVisible(false);
                ogrenciListesi.setVisible(true);
            }
        });

        this.add(leftPanel);
        this.add(sifreDegistir);
        this.add(ogrenciListesi);
    }
}