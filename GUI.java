import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI extends JFrame {
  private JPanel mainPanel;
  private JButton encodeButton;
  private JButton decodeButton;
  private JTextField inputField;
  private JTextField outputField;

  public GUI() {
    setContentPane(mainPanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setVisible(true);

    encodeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String inputFile = inputField.getText();
        String outputVideo = outputField.getText();
        try {
          Encode.main(new String[]{inputFile, outputVideo});
          JOptionPane.showMessageDialog(mainPanel, "Encoding complete");
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(mainPanel, "Error: " + ex.getMessage());
        }
      }
    });

    decodeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String inputVideo = inputField.getText();
        String outputFile = outputField.getText();
        try {
          Decode.main(new String[]{inputVideo, outputFile});
          JOptionPane.showMessageDialog(mainPanel, "Decoding complete");
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(mainPanel, "Error: " + ex.getMessage());
        }
      }
    });
  }

  public static void main(String[] args) {
    new GUI();
  }
}
