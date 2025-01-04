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

        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(10, 10, 200, 540);
        leftPanel.setLayout(new GridLayout(6, 1, 20, 20));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        leftPanel.setBackground(Color.LIGHT_GRAY);

        // Menü butonları
        JButton btnOgretimGorevlisiEkle = new JButton("Öğretim Görevlisi Ekle");
        JButton btnOgrenciEkle = new JButton("Öğrenci Ekle");
        JButton btnDersEkle = new JButton("Ders Ekle");
        JButton btnOgrenciListesi = new JButton("Öğrenci Listesi");
        JButton btnOgretimGorevlileriListesi = new JButton("Öğretim Üyeleri Listesi");
        JButton btnDerslerListesi = new JButton("Dersler Listesi");

        leftPanel.add(btnOgretimGorevlisiEkle);
        leftPanel.add(btnOgrenciEkle);
        leftPanel.add(btnDersEkle);
        leftPanel.add(btnOgrenciListesi);
        leftPanel.add(btnOgretimGorevlileriListesi);
        leftPanel.add(btnDerslerListesi);

        // Öğretim Görevlisi Ekle Paneli
        JPanel pnlOgretimGorevlisiEkle = new JPanel();
        pnlOgretimGorevlisiEkle.setBounds(220, 10, 550, 540);
        pnlOgretimGorevlisiEkle.setLayout(null);

        JLabel lblOgretimGorevlisiEkle = new JLabel("Öğretim Görevlisi Ekle");
        lblOgretimGorevlisiEkle.setFont(new Font("Arial", Font.BOLD, 24));
        lblOgretimGorevlisiEkle.setBounds(170, 10, 300, 30);
        pnlOgretimGorevlisiEkle.add(lblOgretimGorevlisiEkle);

        JLabel lblLecturerName = new JLabel("Ad Soyad:");
        lblLecturerName.setBounds(50, 60, 100, 30);
        pnlOgretimGorevlisiEkle.add(lblLecturerName);

        JTextField txtLecturerName = new JTextField();
        txtLecturerName.setBounds(200, 60, 300, 30);
        pnlOgretimGorevlisiEkle.add(txtLecturerName);

        JLabel lblLecturerPassword = new JLabel("Password:");
        lblLecturerPassword.setBounds(50, 110, 100, 30);
        pnlOgretimGorevlisiEkle.add(lblLecturerPassword);

        JTextField txtLecturerPassword = new JTextField();
        txtLecturerPassword.setBounds(200, 110, 300, 30);
        pnlOgretimGorevlisiEkle.add(txtLecturerPassword);

        JLabel lblLecturerFaculty = new JLabel("Fakülte / Bölüm:");
        lblLecturerFaculty.setBounds(50, 160, 100, 30);
        pnlOgretimGorevlisiEkle.add(lblLecturerFaculty);

        JTextField txtLecturerFaculty = new JTextField();
        txtLecturerFaculty.setBounds(200, 160, 300, 30);
        pnlOgretimGorevlisiEkle.add(txtLecturerFaculty);

        JLabel lblLecturerMail = new JLabel("Mail:");
        lblLecturerMail.setBounds(50, 210, 100, 30);
        pnlOgretimGorevlisiEkle.add(lblLecturerMail);

        JTextField txtLecturerMail = new JTextField();
        txtLecturerMail.setBounds(200, 210, 300, 30);
        pnlOgretimGorevlisiEkle.add(txtLecturerMail);

        JButton btnKaydetLecturer = new JButton("Kaydet");
        btnKaydetLecturer.setBounds(350, 310, 150, 30);
        pnlOgretimGorevlisiEkle.add(btnKaydetLecturer);
        btnKaydetLecturer.addActionListener(e -> {
            if (txtLecturerMail.isValid() && txtLecturerFaculty.isValid() && txtLecturerName.isValid() && txtLecturerPassword.isValid()){
                lecturerManager.add(new Lecturer(txtLecturerName.getText(),txtLecturerPassword.getText(),txtLecturerFaculty.getText(),txtLecturerMail.getText()));
            }
            else
                JOptionPane.showMessageDialog(this, "Lütfen tüm kutucukları doldurunuz!", "Error", JOptionPane.ERROR_MESSAGE);

        });





        // Öğrenci Ekle Paneli
        JPanel pnlOgrenciEkle = new JPanel();
        pnlOgrenciEkle.setBounds(220, 10, 550, 540);
        pnlOgrenciEkle.setLayout(null);

        JLabel lblOgrenciEkle = new JLabel("Öğrenci Ekle");
        lblOgrenciEkle.setFont(new Font("Arial", Font.BOLD, 24));
        lblOgrenciEkle.setBounds(170, 10, 300, 30);
        pnlOgrenciEkle.add(lblOgrenciEkle);

        JLabel lblOgrenciName = new JLabel("Ad Soyad:");
        lblOgrenciName.setBounds(50, 60, 100, 30);
        pnlOgrenciEkle.add(lblOgrenciName);

        JTextField txtOgrenciName = new JTextField();
        txtOgrenciName.setBounds(200, 60, 300, 30);
        pnlOgrenciEkle.add(txtOgrenciName);

        JLabel lblOgrenciPassword = new JLabel("Password:");
        lblOgrenciPassword.setBounds(50, 110, 100, 30);
        pnlOgrenciEkle.add(lblOgrenciPassword);

        JTextField txtOgrenciPassword = new JTextField();
        txtOgrenciPassword.setBounds(200, 110, 300, 30);
        pnlOgrenciEkle.add(txtOgrenciPassword);

        JLabel lblOgrenciFaculty = new JLabel("Fakülte / Bölüm:");
        lblOgrenciFaculty.setBounds(50, 160, 100, 30);
        pnlOgrenciEkle.add(lblOgrenciFaculty);

        JTextField txtOgrenciFaculty = new JTextField();
        txtOgrenciFaculty.setBounds(200, 160, 300, 30);
        pnlOgrenciEkle.add(txtOgrenciFaculty);

        JLabel lblOgrenciMail = new JLabel("Mail:");
        lblOgrenciMail.setBounds(50, 210, 100, 30);
        pnlOgrenciEkle.add(lblOgrenciMail);

        JTextField txtOgrenciMail = new JTextField();
        txtOgrenciMail.setBounds(200, 210, 300, 30);
        pnlOgrenciEkle.add(txtOgrenciMail);

        JButton btnKaydetOE = new JButton("Kaydet");
        btnKaydetOE.setBounds(350, 310, 150, 30);
        pnlOgrenciEkle.add(btnKaydetOE);
        btnKaydetOE.addActionListener(e -> {
            if (txtOgrenciMail.isValid() && txtOgrenciFaculty.isValid() && txtOgrenciName.isValid() && txtOgrenciPassword.isValid() ){
                studentManager.add(new Student(txtOgrenciName.getText(),txtOgrenciPassword.getText(),txtOgrenciFaculty.getText(),txtOgrenciMail.getText()));
            }
            else
                JOptionPane.showMessageDialog(this, "Lütfen tüm kutucukları doldurunuz!", "Error", JOptionPane.ERROR_MESSAGE);

        });



        // Ders Ekle Paneli
        JPanel pnlDersEkle = new JPanel();
        pnlDersEkle.setBounds(220, 10, 550, 540);
        pnlDersEkle.setLayout(null);

        JLabel lblDersEkle = new JLabel("Ders Ekle");
        lblDersEkle.setFont(new Font("Arial", Font.BOLD, 24));
        lblDersEkle.setBounds(170, 10, 300, 30);
        pnlDersEkle.add(lblDersEkle);

        JLabel lblDersKodu = new JLabel("Ders Kodu:");
        lblDersKodu.setBounds(50, 60, 100, 30);
        pnlDersEkle.add(lblDersKodu);

        JTextField txtDersKodu = new JTextField();
        txtDersKodu.setBounds(200, 60, 300, 30);
        pnlDersEkle.add(txtDersKodu);

        JLabel lblDersName = new JLabel("Ders Adı:");
        lblDersName.setBounds(50, 110, 100, 30);
        pnlDersEkle.add(lblDersName);

        JTextField txtDersName = new JTextField();
        txtDersName.setBounds(200, 110, 300, 30);
        pnlDersEkle.add(txtDersName);

        JLabel lblDersCredit = new JLabel("Ders Kredisi:");
        lblDersCredit.setBounds(50, 160, 100, 30);
        pnlDersEkle.add(lblDersCredit);

        JTextField txtDersCredit = new JTextField();
        txtDersCredit.setBounds(200, 160, 300, 30);
        pnlDersEkle.add(txtDersCredit);

        JButton btnKaydetDers = new JButton("Kaydet");
        btnKaydetDers.setBounds(350, 310, 150, 30);
        pnlDersEkle.add(btnKaydetDers);
        btnKaydetDers.addActionListener(e -> {
            if (txtDersCredit.isValid() && txtDersName.isValid() && txtDersKodu.isValid()){
                courseManager.add(new Course(txtDersKodu.getText(),txtDersName.getText(),Integer.parseInt(txtDersCredit.getText())));
            }
            else
                JOptionPane.showMessageDialog(this, "Lütfen tüm kutucukları doldurunuz!", "Error", JOptionPane.ERROR_MESSAGE);

        });
        // Derse öğretim üyesi atama
        JComboBox<Course> comboBoxCourses = new JComboBox<>();
        comboBoxCourses.setBounds(50,400,200,30);
        pnlDersEkle.add(comboBoxCourses);
        JComboBox<Lecturer> comboBoxLecturers = new JComboBox<>();
        comboBoxLecturers.setBounds(250,400,200,30);
        pnlDersEkle.add(comboBoxLecturers);
        JButton btnSetLecturer = new JButton("Öğretim üyesi ata");
        btnSetLecturer.setBounds(50,430,200,30);
        pnlDersEkle.add(btnSetLecturer);
        btnSetLecturer.addActionListener(e -> {
            Course selectedCourse = (Course) comboBoxCourses.getSelectedItem();
            Lecturer selectedLecturer = (Lecturer) comboBoxLecturers.getSelectedItem();
            selectedCourse.setInstructor(selectedLecturer);
        });


        // Öğrenci Listesi Paneli
        JPanel pnlOgrenciListesi = new JPanel();
        pnlOgrenciListesi.setBounds(220, 10, 550, 540);
        pnlOgrenciListesi.setLayout(new BorderLayout());

        JLabel lblOgrenciListesi = new JLabel("Öğrenci Listesi", SwingConstants.CENTER);
        lblOgrenciListesi.setFont(new Font("Arial", Font.BOLD, 24));
        pnlOgrenciListesi.add(lblOgrenciListesi, BorderLayout.NORTH);

        // Öğrencilerin listeleneceği bir JTable oluşturuyoruz
        final String[][] columnNames = {{"ID","Ad Soyad", "Fakülte / Bölüm", "Mail"}};
        final Object[][][] rowData = {{
                {"Ali Veli", "Bilgisayar Mühendisliği", "ali@uni.com"},
                {"Ayşe Yılmaz", "Elektrik Mühendisliği", "ayse@uni.com"}
        }};

        final JTable[] studentTable = {new JTable(rowData[0], columnNames[0])};
        final JScrollPane[] scrollPane = {new JScrollPane(studentTable[0])};
        pnlOgrenciListesi.add(scrollPane[0], BorderLayout.CENTER);

        // Öğretim Üyeleri Listesi Paneli
        JPanel pnlOgretimGorevlileriListesi = new JPanel();
        pnlOgretimGorevlileriListesi.setBounds(220, 10, 550, 540);
        pnlOgretimGorevlileriListesi.setLayout(new BorderLayout());

        JLabel lblOgretimGorevlileriListesi = new JLabel("Öğretim Üyeleri Listesi", SwingConstants.CENTER);
        lblOgretimGorevlileriListesi.setFont(new Font("Arial", Font.BOLD, 24));
        pnlOgretimGorevlileriListesi.add(lblOgretimGorevlileriListesi, BorderLayout.NORTH);

        String[] lecturerColumnNames = {"ID","Ad Soyad", "Fakülte / Bölüm", "Mail"};
        final Object[][][] lecturerRowData = {{
                {"Dr. Mehmet Kaya", "Bilgisayar Mühendisliği", "mehmet@uni.com"},
                {"Prof. Ahmet Demir", "Elektrik Mühendisliği", "ahmet@uni.com"}
        }};

        final JTable[] lecturerTable = {new JTable(lecturerRowData[0], lecturerColumnNames)};
        final JScrollPane[] lecturerScrollPane = {new JScrollPane(lecturerTable[0])};
        pnlOgretimGorevlileriListesi.add(lecturerScrollPane[0], BorderLayout.CENTER);

        JButton btnOgrGrvSil = new JButton("Sil");
        btnOgrGrvSil.setPreferredSize(new Dimension(550, 30));
        pnlOgretimGorevlileriListesi.add(btnOgrGrvSil,BorderLayout.SOUTH);
        btnOgrGrvSil.addActionListener(e -> {
            lecturerManager.delete(Long.parseLong(lecturerTable[0].getValueAt(lecturerTable[0].getSelectedRow(),1).toString()));
            JOptionPane.showMessageDialog(this, "Öğretim görevlisi silindi", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
        });

        // Dersler Listesi Paneli
        JPanel pnlDerslerListesi = new JPanel();
        pnlDerslerListesi.setBounds(220, 10, 550, 540);
        pnlDerslerListesi.setLayout(new BorderLayout());

        JLabel lblDerslerListesi = new JLabel("Dersler Listesi", SwingConstants.CENTER);
        lblDerslerListesi.setFont(new Font("Arial", Font.BOLD, 24));
        pnlDerslerListesi.add(lblDerslerListesi, BorderLayout.NORTH);

        String[] courseColumnNames = {"Ders Kodu", "Ders Adı", "Kredi" , "ÖG Id"};
        final Object[][][] courseRowData = {{
                {"CS101", "Bilgisayar Programlama", "5",""},
                {"EE201", "Elektrik Devreleri", "4",""}
        }};

        final JTable[] courseTable = {new JTable(courseRowData[0], courseColumnNames)};
        final JScrollPane[] courseScrollPane = {new JScrollPane(courseTable[0])};
        pnlDerslerListesi.add(courseScrollPane[0], BorderLayout.CENTER);

        JButton btnDersSil = new JButton("Sil");
        btnDersSil.setBounds(220, 510, 550, 30); // Panelin en altına yerleştiriyoruz
        pnlDerslerListesi.add(btnDersSil);
        btnDersSil.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Alt Buton Tıklandı!", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
        });


        JButton logoutButton = createLogoutButton(frame);
        this.add(logoutButton);

        pnlOgretimGorevlisiEkle.setVisible(true);
        pnlOgrenciEkle.setVisible(false);
        pnlDersEkle.setVisible(false);
        pnlOgrenciListesi.setVisible(false);
        pnlOgretimGorevlileriListesi.setVisible(false);
        pnlDerslerListesi.setVisible(false);

        btnOgretimGorevlisiEkle.addActionListener(e -> {
            pnlOgretimGorevlisiEkle.setVisible(true);
            pnlOgrenciEkle.setVisible(false);
            pnlDersEkle.setVisible(false);
            pnlOgrenciListesi.setVisible(false);
            pnlOgretimGorevlileriListesi.setVisible(false);
            pnlDerslerListesi.setVisible(false);
        });

        btnOgrenciEkle.addActionListener(e -> {
            pnlOgretimGorevlisiEkle.setVisible(false);
            pnlOgrenciEkle.setVisible(true);
            pnlDersEkle.setVisible(false);
            pnlOgrenciListesi.setVisible(false);
            pnlOgretimGorevlileriListesi.setVisible(false);
            pnlDerslerListesi.setVisible(false);
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


            pnlOgretimGorevlisiEkle.setVisible(false);
            pnlOgrenciEkle.setVisible(false);
            pnlDersEkle.setVisible(true);
            pnlOgrenciListesi.setVisible(false);
            pnlOgretimGorevlileriListesi.setVisible(false);
            pnlDerslerListesi.setVisible(false);
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

            pnlOgrenciListesi.removeAll();  // Mevcut bileşenleri temizle
            pnlOgrenciListesi.add(scrollPane[0], BorderLayout.CENTER);  // Yeni tabloyu ekle
            pnlOgrenciListesi.revalidate();  // Yeniden düzenle
            pnlOgrenciListesi.repaint();     // Yeniden çiz
            pnlOgretimGorevlisiEkle.setVisible(false);
            pnlOgrenciEkle.setVisible(false);
            pnlDersEkle.setVisible(false);
            pnlOgrenciListesi.setVisible(true);
            pnlOgretimGorevlileriListesi.setVisible(false);
            pnlDerslerListesi.setVisible(false);
        });

        btnOgretimGorevlileriListesi.addActionListener(e -> {
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
            pnlOgretimGorevlileriListesi.removeAll();
            pnlOgretimGorevlileriListesi.add(lecturerScrollPane[0], BorderLayout.CENTER);
            pnlOgretimGorevlileriListesi.revalidate();
            pnlOgretimGorevlileriListesi.repaint();

            pnlOgretimGorevlisiEkle.setVisible(false);
            pnlOgrenciEkle.setVisible(false);
            pnlDersEkle.setVisible(false);
            pnlOgrenciListesi.setVisible(false);
            pnlOgretimGorevlileriListesi.setVisible(true);
            pnlDerslerListesi.setVisible(false);
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
            pnlDerslerListesi.removeAll();
            pnlDerslerListesi.add(courseScrollPane[0], BorderLayout.CENTER);
            pnlDerslerListesi.revalidate();
            pnlDerslerListesi.repaint();

            pnlOgretimGorevlisiEkle.setVisible(false);
            pnlOgrenciEkle.setVisible(false);
            pnlDersEkle.setVisible(false);
            pnlOgrenciListesi.setVisible(false);
            pnlOgretimGorevlileriListesi.setVisible(false);
            pnlDerslerListesi.setVisible(true);
        });



        this.add(leftPanel);
        this.add(pnlOgretimGorevlisiEkle);
        this.add(pnlOgrenciEkle);
        this.add(pnlDersEkle);
        this.add(pnlOgrenciListesi);
        this.add(pnlOgretimGorevlileriListesi);
        this.add(pnlDerslerListesi);

        this.setVisible(true);

    }
}
