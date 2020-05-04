import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GestionFichier {

    public void Lire(JTextArea textArea ,JTextField textField) throws IOException {
        String filename = textField.getText();
        try {
            FileInputStream fStream =new FileInputStream(new File(filename));
            StringBuilder content = new StringBuilder();
            int myByte;
            while((myByte=fStream.read())!=-1){
                content.append(Character.toString((char)myByte));
            }
            textArea.setText(content.toString());
            fStream.close();
            
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Fichier Introuvable", "File Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Sauvegarder(JTextArea textArea, JTextField textField) throws IOException {
        String text = textArea.getText();
        String filename = textField.getText();
        File f = new File(filename);
        try {
            FileOutputStream fos = new FileOutputStream(f);
            byte [] b = text.getBytes();
            fos.write(b);
            fos.close();
            textArea.setText("");
            JOptionPane.showMessageDialog(null, "Fichier Sauvegardé", "Success", JOptionPane.YES_OPTION);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Fichier Introuvable", "File Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }
}