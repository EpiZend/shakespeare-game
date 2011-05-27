package net.epizend.shakespeare.sub;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author epizend
 */
public class ReactionFrame extends javax.swing.JFrame {

    public ReactionFrame() {
        initComponents();
        help();


    }
    JPanel help;

    public final void help() {
        help = new ReactionInstruction();
        help.setSize(440, 250);
        help.setLocation(getWidth() / 2 - (help.getWidth() / 2), getHeight() / 2 - (help.getHeight() / 2));
        help.setVisible(true);
        bgPanel.add(help, 0);
    }

    public void unhelp() {
        bgPanel.remove(help);
    }
    private Timer timer = new Timer();
    javax.swing.Timer animation = new javax.swing.Timer(10, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (deer.getX() <= -130) {
                fail();
                animation.stop();
                return;
            }
            if (!hit) {
                deer.setLocation(deer.getX() - 4, deer.getY());
                bgPanel.invalidate();
                bgPanel.repaint();
                animation.restart();
            }
        }
    });
    JLabel deer;
    int[] scores = new int[3];
    int at = 0;

    public void fail() {
        scores[at++] = 400;
        bgPanel.remove(deer);
        bgPanel.invalidate();
        bgPanel.repaint();
        if (at == 3) {
            done();
        } else {
            start();
        }
    }
    long add;
    boolean hit = false;

    public void deer() {
        System.out.println("add");
        deer = new JLabel();
        deer.setSize(481, 421);
        deer.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!animation.isRunning()) {
                    return;
                }
                hit = true;
                animation.stop();
                scores[at++] = (int) ((System.currentTimeMillis() - add) / 10);
                bgPanel.remove(deer);
                bgPanel.repaint();
                bgPanel.invalidate();
                if (at == 3) {
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            hit = false;
                            done();
                        }
                    }).start();
                } else {
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            hit = false;
                            start();
                        }
                    }).start();
                }
            }
        });

        deer.setIcon(new ImageIcon(ReactionFrame.class.getResource("/net/epizend/shakespeare/res/running.gif")));
        deer.setLocation(getWidth(), (int) (Math.random() * (getHeight() - 300)));

        bgPanel.add(deer, 0);
        bgPanel.invalidate();

        bgPanel.repaint();
        add = System.currentTimeMillis();

        animation.start();
    }

    private void done() {
        int avg = 0;
        for (int i = 0; i < scores.length; i++) {
            int j = scores[i];
            avg += j;
        }
        avg /= 3;
        int answer = JOptionPane.showOptionDialog(this, "Your score is " + (avg + 0.0) / 100 + " seconds", "Congratulations!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Retry!", "End game"}, "End Game");
        if (answer == JOptionPane.YES_OPTION) {
            at = 0;
            start();
        } else if (answer == JOptionPane.NO_OPTION) {
            System.exit(0);
        } else {
            System.exit(0);
        }
    }

    public void start() {
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                deer();
            }
        }, (int) (3000 + Math.random() * 6000));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPanel = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        bgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Shoot the deer (Reaction Time)");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(964, 660));
        setResizable(false);
        getContentPane().setLayout(null);

        bgPanel.setBackground(new java.awt.Color(255, 255, 255));
        bgPanel.setMaximumSize(new java.awt.Dimension(964, 660));
        bgPanel.setMinimumSize(new java.awt.Dimension(964, 660));
        bgPanel.setPreferredSize(new java.awt.Dimension(964, 660));
        bgPanel.setLayout(null);

        startButton.setText("Illegally hunt deer!");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        bgPanel.add(startButton);
        startButton.setBounds(400, 520, 180, 50);

        bgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/epizend/shakespeare/res/trees.jpg"))); // NOI18N
        bgLabel.setMaximumSize(new java.awt.Dimension(964, 650));
        bgLabel.setMinimumSize(new java.awt.Dimension(964, 650));
        bgLabel.setPreferredSize(new java.awt.Dimension(964, 650));
        bgPanel.add(bgLabel);
        bgLabel.setBounds(0, 0, 964, 630);

        getContentPane().add(bgPanel);
        bgPanel.setBounds(0, 0, 964, 630);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        bgPanel.remove(startButton);
        unhelp();
        bgPanel.revalidate();
        bgPanel.repaint();
        start();
    }//GEN-LAST:event_startButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ReactionFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgLabel;
    private javax.swing.JPanel bgPanel;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
