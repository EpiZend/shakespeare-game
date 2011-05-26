package net.epizend.shakespeare.sub;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.VolatileImage;
import javax.swing.JPanel;

public class ReactionInstruction extends JPanel {

    public ReactionInstruction() {

    }
    private VolatileImage buffer;

    private static final String title = "Shoot the deer - Instructions";
    
    private static final String instructions = 
            "Between 1585 to 1592, no records of Shakespeare\n"+
            "can be found. One theory of this is that he was\n"+
            "prosecuted for poaching deers and therefore had\n"+
            "to move to London.\n\n"+
            "Three deers will appear on the screen, going from\n"+
            "the left to the right. As quickly as you see a deer,\n"+
            "you need to fire on it. Your score will be the average\n"+
            "of the time it took for you to shoot at the deers.\n";
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Dynamically calculate size information
        Dimension size = getSize();
        // diameter
        int w = (int) size.getWidth();
        int h = (int) size.getHeight();
        int x = (size.width - w) / 2;
        int y = (size.height - h) / 2;
        int arc = 70;

        // draw circle (color already set to foreground)
        g2d.setColor(Color.decode("#BF8D30"));
        g2d.fillRoundRect(x, y, w, h, arc, arc);
        g2d.setStroke(new BasicStroke(5f));
        g2d.setColor(Color.WHITE);
        g2d.drawRoundRect(x, y, w, h, arc, arc);
        Font font = new Font("Helvetica", Font.BOLD, 25);
        g2d.setFont(font);
        int headlineSize = g2d.getFontMetrics().stringWidth(title);
        g2d.setColor(Color.BLACK);
        g2d.drawString(title, w/2 - headlineSize/2, 50);
        font = new Font("Helvetica", Font.PLAIN, 16);
        g2d.setFont(font);
        g2d.setColor(Color.DARK_GRAY);
        String[] rows = instructions.split("\n");
        for (int i = 0; i < rows.length; i++) {
            String string = rows[i];
            g2d.drawString(string, 15, 70+(i*19));
        }
    }
}