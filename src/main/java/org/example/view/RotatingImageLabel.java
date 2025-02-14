package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotatingImageLabel extends JLabel {
    private ImageIcon icon;
    private int angle = 0;
    private static final int WIDTH = 20;  // Taille  de l'image
    private static final int HEIGHT = 20; // Taille de l'image

    public RotatingImageLabel(String imagePath) {
        super(new ImageIcon(imagePath));
        this.icon = (ImageIcon) getIcon();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));  // Dimension  pour l'icône
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);

        // Utilisation d'un Timer pour faire tourner l'image toutes les 100ms
        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotateImage();
            }
        });
        timer.start();
    }

    private void rotateImage() {
        angle = (angle + 10) % 360; // Rotation de 10 degrés à chaque fois
        Image rotatedImage = rotateImage(icon.getImage(), angle);
        setIcon(new ImageIcon(rotatedImage));
    }

    private Image rotateImage(Image srcImg, int angle) {
        int w = WIDTH;
        int h = HEIGHT;
        BufferedImage rotatedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotatedImg.createGraphics();
        g2d.rotate(Math.toRadians(angle), w / 2, h / 2);
        g2d.drawImage(srcImg, 0, 0, w, h, null); // Redimensionner l'image avant de la dessiner
        g2d.dispose();
        return rotatedImg;
    }
}
