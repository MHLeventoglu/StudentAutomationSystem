package gui.Pages;

import entities.*;
import gui.AbstractPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class AdminPage extends AbstractPanel {


    public AdminPage(JFrame frame) {
        super();

        this.setLayout(null);
        this.setBounds(0, 0, 800, 600);

        JPanel menuPanel = new JPanel();
        menuPanel.setBounds(10, 10, 200, 540);
        menuPanel.setLayout(new GridLayout(6, 1, 20, 20));
        menuPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        menuPanel.setBackground(Color.LIGHT_GRAY);

        // Menü butonları
        JButton btnOgrGrvEkle = new JButton("Öğretim Görevlisi Ekle");
        JButton btnOgrenciEkle = new JButton("Öğrenci Ekle");
        JButton btnDersEkle = new JButton("Ders Ekle");
        JButton btnOgrenciListesi = new JButton("Öğrenci Listesi");
        JButton btnOgrGrvListesi = new JButton("Öğretim Üyeleri Listesi");
        JButton btnDerslerListesi = new JButton("Dersler Listesi");

        menuPanel.add(btnOgrGrvEkle);
        menuPanel.add(btnOgrenciEkle);
        menuPanel.add(btnDersEkle);
        menuPanel.add(btnOgrenciListesi);
        menuPanel.add(btnOgrGrvListesi);
        menuPanel.add(btnDerslerListesi);

        // Öğretim Görevlisi Ekle Paneli
        JPanel panelOgretimGorevlisiEkle = new JPanel();
        panelOgretimGorevlisiEkle.setBounds(220, 10, 550, 540);
        panelOgretimGorevlisiEkle.setLayout(null);

        JLabel lblOgretimGorevlisiEkle = new JLabel("Öğretim Görevlisi Ekle");
        lblOgretimGorevlisiEkle.setFont(new Font("Arial", Font.BOLD, 24));
        lblOgretimGorevlisiEkle.setBounds(170, 10, 300, 30);
        panelOgretimGorevlisiEkle.add(lblOgretimGorevlisiEkle);

        JLabel lblOgrGrvName = new JLabel("Ad Soyad:");
        lblOgrGrvName.setBounds(50, 60, 100, 30);
        panelOgretimGorevlisiEkle.add(lblOgrGrvName);

        JTextField txtOgrGrvName = new JTextField();
        txtOgrGrvName.setBounds(200, 60, 300, 30);
        panelOgretimGorevlisiEkle.add(txtOgrGrvName);

        JLabel lblOgrGrvSifre = new JLabel("Password:");
        lblOgrGrvSifre.setBounds(50, 110, 100, 30);
        panelOgretimGorevlisiEkle.add(lblOgrGrvSifre);

        JTextField txtOgrGrvSifre = new JTextField();
        txtOgrGrvSifre.setBounds(200, 110, 300, 30);
        panelOgretimGorevlisiEkle.add(txtOgrGrvSifre);

        JLabel lblOgrGrvFakulte = new JLabel("Fakülte / Bölüm:");
        lblOgrGrvFakulte.setBounds(50, 160, 100, 30);
        panelOgretimGorevlisiEkle.add(lblOgrGrvFakulte);

        JTextField txtOgrGrvFakulte = new JTextField();
        txtOgrGrvFakulte.setBounds(200, 160, 300, 30);
        panelOgretimGorevlisiEkle.add(txtOgrGrvFakulte);

        JLabel lblOgrGrvMail = new JLabel("Mail:");
        lblOgrGrvMail.setBounds(50, 210, 100, 30);
        panelOgretimGorevlisiEkle.add(lblOgrGrvMail);

        JTextField txtOgrGrvMail = new JTextField();
        txtOgrGrvMail.setBounds(200, 210, 300, 30);
        panelOgretimGorevlisiEkle.add(txtOgrGrvMail);

        JButton btnOgrGrvKaydet = new JButton("Kaydet");
        btnOgrGrvKaydet.setBounds(350, 310, 150, 30);
        panelOgretimGorevlisiEkle.add(btnOgrGrvKaydet);
        btnOgrGrvKaydet.addActionListener(e -> {
            if (txtOgrGrvMail.isValid() && txtOgrGrvFakulte.isValid() && txtOgrGrvName.isValid() && txtOgrGrvSifre.isValid()){
                lecturerManager.add(new Lecturer(txtOgrGrvName.getText(),txtOgrGrvSifre.getText(),txtOgrGrvFakulte.getText(),txtOgrGrvMail.getText()));
            }
            else
                JOptionPane.showMessageDialog(this, "Lütfen tüm kutucukları doldurunuz!", "Error", JOptionPane.ERROR_MESSAGE);

        });




        // Öğrenci Ekle Paneli
        JPanel panelOgrenciEkle = new JPanel();
        panelOgrenciEkle.setBounds(220, 10, 550, 540);
        panelOgrenciEkle.setLayout(null);

        JLabel lblOgrenciEkle = new JLabel("Öğrenci Ekle");
        lblOgrenciEkle.setFont(new Font("Arial", Font.BOLD, 24));
        lblOgrenciEkle.setBounds(170, 10, 300, 30);
        panelOgrenciEkle.add(lblOgrenciEkle);

        JLabel lblOgrenciName = new JLabel("Ad Soyad:");
        lblOgrenciName.setBounds(50, 60, 100, 30);
        panelOgrenciEkle.add(lblOgrenciName);

        JTextField txtOgrenciName = new JTextField();
        txtOgrenciName.setBounds(200, 60, 300, 30);
        panelOgrenciEkle.add(txtOgrenciName);

        JLabel lblOgrenciSifre = new JLabel("Password:");
        lblOgrenciSifre.setBounds(50, 110, 100, 30);
        panelOgrenciEkle.add(lblOgrenciSifre);

        JTextField txtOgrenciSifre = new JTextField();
        txtOgrenciSifre.setBounds(200, 110, 300, 30);
        panelOgrenciEkle.add(txtOgrenciSifre);

        JLabel lblOgrenciFakulte = new JLabel("Fakülte / Bölüm:");
        lblOgrenciFakulte.setBounds(50, 160, 100, 30);
        panelOgrenciEkle.add(lblOgrenciFakulte);

        JTextField txtOgrenciFakulte = new JTextField();
        txtOgrenciFakulte.setBounds(200, 160, 300, 30);
        panelOgrenciEkle.add(txtOgrenciFakulte);

        JLabel lblOgrenciMail = new JLabel("Mail:");
        lblOgrenciMail.setBounds(50, 210, 100, 30);
        panelOgrenciEkle.add(lblOgrenciMail);

        JTextField txtOgrenciMail = new JTextField();
        txtOgrenciMail.setBounds(200, 210, 300, 30);
        panelOgrenciEkle.add(txtOgrenciMail);

        JButton btnOgrenciKaydet = new JButton("Kaydet");
        btnOgrenciKaydet.setBounds(350, 310, 150, 30);
        panelOgrenciEkle.add(btnOgrenciKaydet);
        btnOgrenciKaydet.addActionListener(e -> {
            if (txtOgrenciMail.isValid() && txtOgrenciFakulte.isValid() && txtOgrenciName.isValid() && txtOgrenciSifre.isValid() ){
                studentManager.add(new Student(txtOgrenciName.getText(),txtOgrenciSifre.getText(),txtOgrenciFakulte.getText(),txtOgrenciMail.getText()));
            }
            else
                JOptionPane.showMessageDialog(this, "Lütfen tüm kutucukları doldurunuz!", "Error", JOptionPane.ERROR_MESSAGE);

        });



        // Ders Ekle Paneli
        JPanel panelDersEkle = new JPanel();
        panelDersEkle.setBounds(220, 10, 550, 540);
        panelDersEkle.setLayout(null);

        JLabel lblDersEkle = new JLabel("Ders Ekle");
        lblDersEkle.setFont(new Font("Arial", Font.BOLD, 24));
        lblDersEkle.setBounds(170, 10, 300, 30);
        panelDersEkle.add(lblDersEkle);

        JLabel lblDersKodu = new JLabel("Ders Kodu:");
        lblDersKodu.setBounds(50, 60, 100, 30);
        panelDersEkle.add(lblDersKodu);

        JTextField txtDersKodu = new JTextField();
        txtDersKodu.setBounds(200, 60, 300, 30);
        panelDersEkle.add(txtDersKodu);

        JLabel lblDersName = new JLabel("Ders Adı:");
        lblDersName.setBounds(50, 110, 100, 30);
        panelDersEkle.add(lblDersName);

        JTextField txtDersName = new JTextField();
        txtDersName.setBounds(200, 110, 300, 30);
        panelDersEkle.add(txtDersName);

        JLabel lblDersKredisi = new JLabel("Ders Kredisi:");
        lblDersKredisi.setBounds(50, 160, 100, 30);
        panelDersEkle.add(lblDersKredisi);

        JTextField txtDersKredisi = new JTextField();
        txtDersKredisi.setBounds(200, 160, 300, 30);
        panelDersEkle.add(txtDersKredisi);

        JButton btnDersKaydet = new JButton("Kaydet");
        btnDersKaydet.setBounds(350, 310, 150, 30);
        panelDersEkle.add(btnDersKaydet);
        btnDersKaydet.addActionListener(e -> {
            if (txtDersKredisi.isValid() && txtDersName.isValid() && txtDersKodu.isValid()){
                courseManager.add(new Course(txtDersKodu.getText(),txtDersName.getText(),Integer.parseInt(txtDersKredisi.getText())));
            }
            else
                JOptionPane.showMessageDialog(this, "Lütfen tüm kutucukları doldurunuz!", "Error", JOptionPane.ERROR_MESSAGE);

        });
        // Derse öğretim üyesi atama
        JComboBox<Course> comboBoxCourses = new JComboBox<>();
        comboBoxCourses.setBounds(50,400,200,30);
        panelDersEkle.add(comboBoxCourses);
        JComboBox<Lecturer> comboBoxLecturers = new JComboBox<>();
        comboBoxLecturers.setBounds(250,400,200,30);
        panelDersEkle.add(comboBoxLecturers);
        JButton btnSetLecturer = new JButton("Öğretim üyesi ata");
        btnSetLecturer.setBounds(50,430,200,30);
        panelDersEkle.add(btnSetLecturer);
        btnSetLecturer.addActionListener(e -> {
            Course selectedCourse = (Course) comboBoxCourses.getSelectedItem();
            Lecturer selectedLecturer = (Lecturer) comboBoxLecturers.getSelectedItem();
            selectedCourse.setInstructor(selectedLecturer);
        });


        // Öğrenci Listesi Panelini oluşturma
        JPanel panelOgrenciListesi = new JPanel();
        panelOgrenciListesi.setBounds(220, 40, 550, 510);
        panelOgrenciListesi.setLayout(new BorderLayout());

        JLabel lblOgrenciListesi = new JLabel("Öğrenci Listesi", SwingConstants.CENTER);
        lblOgrenciListesi.setFont(new Font("Arial", Font.BOLD, 24));
        panelOgrenciListesi.add(lblOgrenciListesi, BorderLayout.NORTH);

        // Öğrenci tablosu
        final String[][] columnNames = {{"ID","Ad Soyad", "Fakülte / Bölüm", "Mail"}};
        final Object[][][] rowData = {{
                {"Ali Veli", "Bilgisayar Mühendisliği", "ali@uni.com"},
                {"Ayşe Yılmaz", "Elektrik Mühendisliği", "ayse@uni.com"}
        }};

        final JTable[] studentTable = {new JTable(rowData[0], columnNames[0])};
        final JScrollPane[] scrollPane = {new JScrollPane(studentTable[0])};
        panelOgrenciListesi.add(scrollPane[0], BorderLayout.CENTER);

        // Öğretim Üyeleri Listeleme Panelini oluşturma
        JPanel panelOgretimGorevlileriListesi = new JPanel();
        panelOgretimGorevlileriListesi.setBounds(220, 40, 550, 510);
        panelOgretimGorevlileriListesi.setLayout(null);

        JPanel subPnlOgretimGorevlileriListesi = new JPanel();
        subPnlOgretimGorevlileriListesi.setBounds(220, 40, 550, 480);
        panelOgretimGorevlileriListesi.setLayout(new BorderLayout());
        panelOgretimGorevlileriListesi.add(subPnlOgretimGorevlileriListesi);

        JLabel lblOgretimGorevlileriListesi = new JLabel("Öğretim Üyeleri Listesi", SwingConstants.CENTER);
        lblOgretimGorevlileriListesi.setFont(new Font("Arial", Font.BOLD, 24));
        subPnlOgretimGorevlileriListesi.add(lblOgretimGorevlileriListesi, BorderLayout.NORTH);

        String[] lecturerColumnNames = {"ID","Ad Soyad", "Fakülte / Bölüm", "Mail"};
        final Object[][][] lecturerRowData = {{{}}};

        final JTable[] lecturerTable = {new JTable(lecturerRowData[0], lecturerColumnNames)};
        final JScrollPane[] lecturerScrollPane = {new JScrollPane(lecturerTable[0])};
        panelOgretimGorevlileriListesi.add(lecturerScrollPane[0], BorderLayout.CENTER);



        // Dersler Listesi Paneli
        JPanel panelDerslerListesi = new JPanel();
        panelDerslerListesi.setBounds(220, 40, 550, 510);
        panelDerslerListesi.setLayout(new BorderLayout());

        JLabel lblDerslerListesi = new JLabel("Dersler Listesi", SwingConstants.CENTER);
        lblDerslerListesi.setFont(new Font("Arial", Font.BOLD, 24));
        panelDerslerListesi.add(lblDerslerListesi, BorderLayout.NORTH);

        String[] courseColumnNames = {"Ders Kodu", "Ders Adı", "Kredi" , "ÖG Id"};
        final Object[][][] courseRowData = {{
                {"CS101", "Bilgisayar Programlama", "5",""},
                {"EE201", "Elektrik Devreleri", "4",""}
        }};

        final JTable[] courseTable = {new JTable(courseRowData[0], courseColumnNames)};
        final JScrollPane[] courseScrollPane = {new JScrollPane(courseTable[0])};
        panelDerslerListesi.add(courseScrollPane[0], BorderLayout.CENTER);

        /////////////////////////////////////////

        JButton logoutButton = createLogoutButton(frame);
        this.add(logoutButton);

        panelOgretimGorevlisiEkle.setVisible(true);
        panelOgrenciEkle.setVisible(false);
        panelDersEkle.setVisible(false);
        panelOgrenciListesi.setVisible(false);
        panelOgretimGorevlileriListesi.setVisible(false);
        panelDerslerListesi.setVisible(false);

        final int[] whichPage = {0};

        JButton btnSil = new JButton("Sil");
        btnSil.setBounds(230, 520, 100, 30);
        this.add(btnSil);
        btnSil.addActionListener(e -> {
            if (whichPage[0] == 1){
                studentManager.delete(Long.parseLong(studentTable[0].getValueAt(studentTable[0].getSelectedRow(),0).toString()));
                JOptionPane.showMessageDialog(this, "Öğrenci silindi", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
            } else if (whichPage[0] == 2) {
                lecturerManager.delete(Long.parseLong(lecturerTable[0].getValueAt(lecturerTable[0].getSelectedRow(),0).toString()));
                JOptionPane.showMessageDialog(this, "Öğretim görevlisi silindi", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
            } else if (whichPage[0] == 3) {
                Course currentCourse = courseManager.getByCourseCode(courseTable[0].getValueAt(courseTable[0].getSelectedRow(),0).toString());
                courseManager.delete(currentCourse.getId());
                JOptionPane.showMessageDialog(this, "Ders silindi", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnOgrGrvEkle.addActionListener(e -> {
            btnSil.setVisible(false);
            panelOgretimGorevlisiEkle.setVisible(true);
            panelOgrenciEkle.setVisible(false);
            panelDersEkle.setVisible(false);
            panelOgrenciListesi.setVisible(false);
            panelOgretimGorevlileriListesi.setVisible(false);
            panelDerslerListesi.setVisible(false);
        });

        btnOgrenciEkle.addActionListener(e -> {
            btnSil.setVisible(false);
            panelOgretimGorevlisiEkle.setVisible(false);
            panelOgrenciEkle.setVisible(true);
            panelDersEkle.setVisible(false);
            panelOgrenciListesi.setVisible(false);
            panelOgretimGorevlileriListesi.setVisible(false);
            panelDerslerListesi.setVisible(false);
        });

        btnDersEkle.addActionListener(e -> {

            comboBoxCourses.removeAllItems();
            for (Course course:courseManager.getAll()){
                comboBoxCourses.addItem(course);
            }

            comboBoxLecturers.removeAllItems();
            for (Lecturer lecturer: lecturerManager.getAll()){
                comboBoxLecturers.addItem(lecturer);
            }


            btnSil.setVisible(false);
            panelOgretimGorevlisiEkle.setVisible(false);
            panelOgrenciEkle.setVisible(false);
            panelDersEkle.setVisible(true);
            panelOgrenciListesi.setVisible(false);
            panelOgretimGorevlileriListesi.setVisible(false);
            panelDerslerListesi.setVisible(false);
        });

        btnOgrenciListesi.addActionListener(e -> {
            // Öğrenci verilerini al ve tabloyu güncelle
            List<Student> students = studentManager.getAll();

            // Tabloyu yeniden oluştur
            columnNames[0] = new String[]{"ID" ,"Ad Soyad", "Fakülte / Bölüm", "Mail"};
            rowData[0] = new Object[students.size()][4];

            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                rowData[0][i][0] = ((Number)student.getId()).toString();
                rowData[0][i][1] = student.getName();
                rowData[0][i][2] = student.getDepartment();
                rowData[0][i][3] = student.getMail();

            }
            studentTable[0] = new JTable(rowData[0], columnNames[0]);
            scrollPane[0] = new JScrollPane(studentTable[0]);

            panelOgrenciListesi.removeAll();  // Mevcut bileşenleri temizle
            panelOgrenciListesi.add(scrollPane[0], BorderLayout.CENTER);  // Yeni tabloyu ekle
            panelOgrenciListesi.revalidate();  // Yeniden düzenle
            panelOgrenciListesi.repaint();     // Yeniden çiz

            whichPage[0] = 1;
            btnSil.setVisible(true);
            panelOgretimGorevlisiEkle.setVisible(false);
            panelOgrenciEkle.setVisible(false);
            panelDersEkle.setVisible(false);
            panelOgrenciListesi.setVisible(true);
            panelOgretimGorevlileriListesi.setVisible(false);
            panelDerslerListesi.setVisible(false);
        });

        btnOgrGrvListesi.addActionListener(e -> {
            List<Lecturer> lecturers = lecturerManager.getAll();

            lecturerRowData[0] = new Object[lecturers.size()][4];
            for (int i = 0; i < lecturers.size(); i++) {
                Lecturer lecturer = lecturers.get(i);
                lecturerRowData[0][i][0] = ((Number)lecturer.getId()).toString();
                lecturerRowData[0][i][1] = lecturer.getName();
                lecturerRowData[0][i][2] = lecturer.getFaculty();
                lecturerRowData[0][i][3] = lecturer.getMail();
            }

            lecturerTable[0] = new JTable(lecturerRowData[0], lecturerColumnNames);
            lecturerScrollPane[0] = new JScrollPane(lecturerTable[0]);
            panelOgretimGorevlileriListesi.removeAll();
            panelOgretimGorevlileriListesi.add(lecturerScrollPane[0], BorderLayout.CENTER);
            panelOgretimGorevlileriListesi.revalidate();
            panelOgretimGorevlileriListesi.repaint();

            whichPage[0] = 2;
            btnSil.setVisible(true);
            panelOgretimGorevlisiEkle.setVisible(false);
            panelOgrenciEkle.setVisible(false);
            panelDersEkle.setVisible(false);
            panelOgrenciListesi.setVisible(false);
            panelOgretimGorevlileriListesi.setVisible(true);
            panelDerslerListesi.setVisible(false);
        });

        btnDerslerListesi.addActionListener(e -> {
            List<Course> courses = courseManager.getAll();

            courseRowData[0] = new Object[courses.size()][4];
            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                courseRowData[0][i][0] = course.getCourseCode();
                courseRowData[0][i][1] = course.getCourseName();
                courseRowData[0][i][2] = ((Number)course.getCredit()).toString();
                String instructorId = "ATANMAMIŞ";
                if(course.hasInstructor){
                    instructorId = ((Number)course.getInstructor().getId()).toString();
                }
                courseRowData[0][i][3] = instructorId;
            }

            courseTable[0] = new JTable(courseRowData[0], courseColumnNames);
            courseScrollPane[0] = new JScrollPane(courseTable[0]);
            panelDerslerListesi.removeAll();
            panelDerslerListesi.add(courseScrollPane[0], BorderLayout.CENTER);
            panelDerslerListesi.revalidate();
            panelDerslerListesi.repaint();

            whichPage[0] = 3;
            btnSil.setVisible(true);
            panelOgretimGorevlisiEkle.setVisible(false);
            panelOgrenciEkle.setVisible(false);
            panelDersEkle.setVisible(false);
            panelOgrenciListesi.setVisible(false);
            panelOgretimGorevlileriListesi.setVisible(false);
            panelDerslerListesi.setVisible(true);
        });



        this.add(menuPanel);
        this.add(panelOgretimGorevlisiEkle);
        this.add(panelOgrenciEkle);
        this.add(panelDersEkle);
        this.add(panelOgrenciListesi);
        this.add(panelOgretimGorevlileriListesi);
        this.add(panelDerslerListesi);

        this.setVisible(true);

    }
}
