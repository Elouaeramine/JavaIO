
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class IHMGestionFichier extends JFrame {
    JTextArea TextArea = new JTextArea();
    JTextField textField = new JTextField(30);
    JButton BoutonQuitter = new JButton("Quitter");
    JButton BoutonSauvegarder = new JButton("Sauvegarder");
    JButton BoutonLire = new JButton("Lire");

    JPanel SouthPanel = new JPanel();
    JPanel NorthPanel = new JPanel();

    public IHMGestionFichier() {
        this.add(SouthPanel, BorderLayout.SOUTH);
        this.add(NorthPanel, BorderLayout.NORTH);
        this.add(TextArea, BorderLayout.CENTER);

        SouthPanel.setLayout(new FlowLayout());
        SouthPanel.add(BoutonQuitter);
        SouthPanel.add(BoutonSauvegarder);

        NorthPanel.setLayout(new FlowLayout());
        NorthPanel.add(textField);
        NorthPanel.add(BoutonLire);

        BoutonQuitter.addActionListener(new BoutonQuitterListener());
        BoutonLire.addActionListener(new BoutonLireListener());
        BoutonSauvegarder.addActionListener(new BoutonSauvegarderListener());

        this.setSize(600, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    private class BoutonSauvegarderListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           GestionFichier gf = new GestionFichier();
           try {
               gf.Sauvegarder(TextArea, textField);
           } catch (IOException e1) {
               e1.printStackTrace();
           }

        }
        
    }

    private class BoutonLireListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GestionFichier gf = new GestionFichier();
            try {
                gf.Lire(TextArea, textField);
            } catch (IOException e1) {
               
                e1.printStackTrace();
            }
      }
      
  }
  
  private class BoutonQuitterListener implements ActionListener {
    
      @Override
      public void actionPerformed(ActionEvent e) {
          System.exit(0);

      }

  }

public static void main(String[] args) {
    IHMGestionFichier ihm =new IHMGestionFichier();
}
}