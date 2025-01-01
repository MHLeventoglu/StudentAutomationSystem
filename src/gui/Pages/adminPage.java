package gui.Pages;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class adminPage {
    // Verilerin saklanacağı listeler
    static ArrayList<String> ogrenciler = new ArrayList<>();
    static ArrayList<String> ogretimGorevlileri = new ArrayList<>();
    static ArrayList<String> dersler = new ArrayList<>();
    static ArrayList<String> sinavTarihleri = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Admin Paneli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);

        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(10, 10, 200, 540);
        leftPanel.setLayout(new GridLayout(5, 1, 20, 20));
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        leftPanel.setBackground(Color.LIGHT_GRAY);

        // Menü butonları
        JButton btnKullaniciYonetimi = new JButton("Kullanıcı Yönetimi");
        JButton btnDersYonetimi = new JButton("Ders Yönetimi");
        JButton btnSinavYonetimi = new JButton("Sınav Yönetimi");
        JButton btnRaporlar = new JButton("Sistem Raporları");

        leftPanel.add(btnKullaniciYonetimi);
        leftPanel.add(btnDersYonetimi);
        leftPanel.add(btnSinavYonetimi);
        leftPanel.add(btnRaporlar);

        // Kullanıcı Yönetimi Paneli
        JPanel kullaniciYonetimi = new JPanel();
        kullaniciYonetimi.setBounds(220, 10, 550, 540);
        kullaniciYonetimi.setLayout(null);

        JLabel lblTitle = new JLabel("Kullanıcı Yönetimi");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(150, 10, 300, 30);
        kullaniciYonetimi.add(lblTitle);

        JButton btnOgrenciEkle = new JButton("Öğrenci Ekle");
        btnOgrenciEkle.setBounds(100, 100, 150, 30);
        kullaniciYonetimi.add(btnOgrenciEkle);

        JButton btnOgretimEkle = new JButton("Öğretim Görevlisi Ekle");
        btnOgretimEkle.setBounds(300, 100, 200, 30);
        kullaniciYonetimi.add(btnOgretimEkle);

        JButton btnKullaniciSil = new JButton("Kullanıcı Sil");
        btnKullaniciSil.setBounds(100, 150, 150, 30);
        kullaniciYonetimi.add(btnKullaniciSil);

        // Ders Yönetimi Paneli
        JPanel dersYonetimi = new JPanel();
        dersYonetimi.setBounds(220, 10, 550, 540);
        dersYonetimi.setLayout(null);

        JLabel lblDersYonetimi = new JLabel("Ders Yönetimi");
        lblDersYonetimi.setFont(new Font("Arial", Font.BOLD, 24));
        lblDersYonetimi.setBounds(150, 10, 300, 30);
        dersYonetimi.add(lblDersYonetimi);

        JButton btnDersEkle = new JButton("Ders Ekle");
        btnDersEkle.setBounds(100, 100, 150, 30);
        dersYonetimi.add(btnDersEkle);

        JButton btnDersSil = new JButton("Ders Sil");
        btnDersSil.setBounds(300, 100, 150, 30);
        dersYonetimi.add(btnDersSil);

        // Sınav Yönetimi Paneli
        JPanel sinavYonetimi = new JPanel();
        sinavYonetimi.setBounds(220, 10, 550, 540);
        sinavYonetimi.setLayout(null);

        JLabel lblSinavYonetimi = new JLabel("Sınav Yönetimi");
        lblSinavYonetimi.setFont(new Font("Arial", Font.BOLD, 24));
        lblSinavYonetimi.setBounds(150, 10, 300, 30);
        sinavYonetimi.add(lblSinavYonetimi);

        JButton btnSinavTarihiEkle = new JButton("Sınav Tarihi Ekle");
        btnSinavTarihiEkle.setBounds(100, 100, 150, 30);
        sinavYonetimi.add(btnSinavTarihiEkle);

        JButton btnSinavNotlari = new JButton("Sınav Notlarını Gör");
        btnSinavNotlari.setBounds(300, 100, 150, 30);
        sinavYonetimi.add(btnSinavNotlari);

        // Sistem Raporları Paneli
        JPanel raporlarPaneli = new JPanel();
        raporlarPaneli.setBounds(220, 10, 550, 540);
        raporlarPaneli.setLayout(null);

        JLabel lblRaporlar = new JLabel("Sistem Raporları");
        lblRaporlar.setFont(new Font("Arial", Font.BOLD, 24));
        lblRaporlar.setBounds(150, 10, 300, 30);
        raporlarPaneli.add(lblRaporlar);

        JButton btnIstatistikGoruntule = new JButton("İstatistikleri Görüntüle");
        btnIstatistikGoruntule.setBounds(100, 100, 200, 30);
        raporlarPaneli.add(btnIstatistikGoruntule);

        // Paneller arası geçiş
        kullaniciYonetimi.setVisible(true);
        dersYonetimi.setVisible(false);
        sinavYonetimi.setVisible(false);
        raporlarPaneli.setVisible(false);

        btnKullaniciYonetimi.addActionListener(e -> {
            kullaniciYonetimi.setVisible(true);
            dersYonetimi.setVisible(false);
            sinavYonetimi.setVisible(false);
            raporlarPaneli.setVisible(false);
        });

        btnDersYonetimi.addActionListener(e -> {
            kullaniciYonetimi.setVisible(false);
            dersYonetimi.setVisible(true);
            sinavYonetimi.setVisible(false);
            raporlarPaneli.setVisible(false);
        });

        btnSinavYonetimi.addActionListener(e -> {
            kullaniciYonetimi.setVisible(false);
            dersYonetimi.setVisible(false);
            sinavYonetimi.setVisible(true);
            raporlarPaneli.setVisible(false);
        });

        btnRaporlar.addActionListener(e -> {
            kullaniciYonetimi.setVisible(false);
            dersYonetimi.setVisible(false);
            sinavYonetimi.setVisible(false);
            raporlarPaneli.setVisible(true);
        });

        // Buton İşlevleri
        btnOgrenciEkle.addActionListener(e -> {
            String ogrenciAdi = JOptionPane.showInputDialog("Yeni öğrenci adı girin:");
            if (ogrenciAdi != null && !ogrenciAdi.isEmpty()) {
                ogrenciler.add(ogrenciAdi);
                JOptionPane.showMessageDialog(null, "Öğrenci " + ogrenciAdi + " başarıyla eklendi.");
            }
        });

        btnOgretimEkle.addActionListener(e -> {
            String ogretimAdi = JOptionPane.showInputDialog("Yeni öğretim görevlisi adı girin:");
            if (ogretimAdi != null && !ogretimAdi.isEmpty()) {
                ogretimGorevlileri.add(ogretimAdi);
                JOptionPane.showMessageDialog(null, "Öğretim görevlisi " + ogretimAdi + " başarıyla eklendi.");
            }
        });

        btnKullaniciSil.addActionListener(e -> {
            String kullaniciAdi = JOptionPane.showInputDialog("Silinecek kullanıcı adını girin:");
            if (kullaniciAdi != null && !kullaniciAdi.isEmpty()) {
                if (ogrenciler.remove(kullaniciAdi) || ogretimGorevlileri.remove(kullaniciAdi)) {
                    JOptionPane.showMessageDialog(null, "Kullanıcı " + kullaniciAdi + " başarıyla silindi.");
                } else {
                    JOptionPane.showMessageDialog(null, "Kullanıcı bulunamadı.");
                }
            }
        });

        btnDersEkle.addActionListener(e -> {
            String dersAdi = JOptionPane.showInputDialog("Yeni ders adı girin:");
            if (dersAdi != null && !dersAdi.isEmpty()) {
                dersler.add(dersAdi);
                JOptionPane.showMessageDialog(null, "Ders " + dersAdi + " başarıyla eklendi.");
            }
        });

        btnDersSil.addActionListener(e -> {
            String dersAdi = JOptionPane.showInputDialog("Silinecek ders adı girin:");
            if (dersAdi != null && !dersAdi.isEmpty()) {
                if (dersler.remove(dersAdi)) {
                    JOptionPane.showMessageDialog(null, "Ders " + dersAdi + " başarıyla silindi.");
                } else {
                    JOptionPane.showMessageDialog(null, "Ders bulunamadı.");
                }
            }
        });

        btnSinavTarihiEkle.addActionListener(e -> {
            String sinavTarihi = JOptionPane.showInputDialog("Sınav tarihini girin:");
            if (sinavTarihi != null && !sinavTarihi.isEmpty()) {
                sinavTarihleri.add(sinavTarihi);
                JOptionPane.showMessageDialog(null, "Sınav tarihi " + sinavTarihi + " başarıyla eklendi.");
            }
        });

        btnSinavNotlari.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Sınav notları: " + sinavTarihleri);
        });

        btnIstatistikGoruntule.addActionListener(e -> {

            String istatistikler = "Öğrenci Sayısı: " + ogrenciler.size() + "\n"
                    + "Öğretim Görevlisi Sayısı: " + ogretimGorevlileri.size() + "\n"
                    + "Ders Sayısı: " + dersler.size() + "\n"
                    + "Sınav Tarihi Sayısı: " + sinavTarihleri.size();
            JOptionPane.showMessageDialog(null, istatistikler);
        });

        frame.add(leftPanel);
        frame.add(kullaniciYonetimi);
        frame.add(dersYonetimi);
        frame.add(sinavYonetimi);
        frame.add(raporlarPaneli);

        frame.setVisible(true);
    }
}
