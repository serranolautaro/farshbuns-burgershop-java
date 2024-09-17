package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.JPanel;

import java.awt.Graphics2D;

public class GradientPanel extends JPanel {
    private Color color1;
    private Color color2;

    public GradientPanel(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
    }

    public GradientPanel(Color orange, float[] rgBtoHSB) {
		// TODO Auto-generated constructor stub
	}

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Crear el degradado
        GradientPaint gradient = new GradientPaint(
            0, 0, color1,
            getWidth(), getHeight(), color2
        );
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}