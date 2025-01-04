package gui;

import gui.Pages.OgrenciPage;
import gui.Pages.LoginPage;
import gui.Pages.OgretimGorevlisiPage;

import javax.swing.*;
import java.awt.*;

public class GuiMain {
    public static void main(String[] args) {JFrame frame = new JFrame("Main Frame");
        frame.setSize(800, 600);
        frame.setLocation(1920/4,1080/5);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new CardLayout());

        // Instantiate pages
        LoginPage loginPanel = new LoginPage(frame);


        // Add pages to the frame
        frame.add(loginPanel, "LoginPage");

        frame.setVisible(true);
    }
}
