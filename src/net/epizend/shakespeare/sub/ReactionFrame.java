package net.epizend.shakespeare.sub;

import javax.swing.JPanel;

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

    public final void help(){
        help = new ReactionInstruction();
        help.setSize(440,250);
        help.setLocation(getWidth()/2 - (help.getWidth()/2), getHeight()/2 - (help.getHeight()/2));
        help.setVisible(true);
        bgPanel.add(help,0);
    }
    
    public void unhelp(){
        
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
        bgPanel.revalidate();
        
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
