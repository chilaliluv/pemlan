import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm {
    private JFrame frame;
    private JTextField nameField, birthDateField, regNumberField, phoneField, addressField, emailField;

    public RegistrationForm() {
        frame = new JFrame("Form Registrasi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Registrasi", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
        JLabel nameLabel = new JLabel("Nama Lengkap:");
        nameField = new JTextField(20);
        JLabel birthDateLabel = new JLabel("Tanggal Lahir:");
        birthDateField = new JTextField(20);
        JLabel regNumberLabel = new JLabel("Nomor Pendaftaran:");
        regNumberField = new JTextField(20);
        JLabel phoneLabel = new JLabel("No. Telp:");
        phoneField = new JTextField(20);
        JLabel addressLabel = new JLabel("Alamat:");
        addressField = new JTextField(20);
        JLabel emailLabel = new JLabel("E-mail:");
        emailField = new JTextField(20);
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(nameLabel, gbc);
        gbc.gridx = 1;
        frame.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(birthDateLabel, gbc);
        gbc.gridx = 1;
        frame.add(birthDateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(regNumberLabel, gbc);
        gbc.gridx = 1;
        frame.add(regNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(phoneLabel, gbc);
        gbc.gridx = 1;
        frame.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(addressLabel, gbc);
        gbc.gridx = 1;
        frame.add(addressField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        frame.add(emailLabel, gbc);
        gbc.gridx = 1;
        frame.add(emailField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        frame.add(submitButton, gbc);

        frame.setVisible(true);
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (nameField.getText().isEmpty() || birthDateField.getText().isEmpty() || regNumberField.getText().isEmpty() ||
                phoneField.getText().isEmpty() || addressField.getText().isEmpty() || emailField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Semua kolom harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int response = JOptionPane.showConfirmDialog(frame, "Apakah anda yakin data yang Anda isi sudah benar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    showDataWindow();
                }
            }
        }
    }

    private void showDataWindow() {
        JFrame dataFrame = new JFrame("Data Mahasiswa");
        dataFrame.setSize(400, 300);

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("Nama: " + nameField.getText() + "\n" +
                         "Tanggal Lahir: " + birthDateField.getText() + "\n" +
                         "No. Pendaftaran: " + regNumberField.getText() + "\n" +
                         "No. Telp: " + phoneField.getText() + "\n" +
                         "Alamat: " + addressField.getText() + "\n" +
                         "E-mail: " + emailField.getText());

        dataPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        tabbedPane.addTab("Data Mahasiswa", dataPanel);

        dataFrame.add(tabbedPane);
        dataFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
