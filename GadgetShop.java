import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GadgetShop implements ActionListener {
    private ArrayList<Gadget> gadgets;

    private JFrame frame;
    private JTextField modelField, priceField, weightField, sizeField, creditField, memoryField, phoneNumberField, durationField, downloadField, displayNumberField;
    private JButton addMobileButton, addMP3Button, clearButton, displayAllButton, makeCallButton, downloadMusicButton;

    /**
     * Constructor for GadgetShop. Initializes the gadget list, sets up the GUI components, and applies the Nimbus look and feel.
     */
    public GadgetShop() {
        gadgets = new ArrayList<>();
        initializeFields();
        setupFrame();
        setLookAndFeel();
    }

    /**
     * Sets the Nimbus look and feel for the GUI.
     */
    private void setLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, default to another look and feel.
            e.printStackTrace();
        }
    }

    /**
     * Initializes the text fields and buttons for the GUI.
     */
    private void initializeFields() {
        modelField = new JTextField(10);
        priceField = new JTextField(10);
        weightField = new JTextField(10);
        sizeField = new JTextField(10);
        creditField = new JTextField(10);
        memoryField = new JTextField(10);
        phoneNumberField = new JTextField(10);
        durationField = new JTextField(10);
        downloadField = new JTextField(10);
        displayNumberField = new JTextField(10);

        addMobileButton = new JButton("Add Mobile");
        addMP3Button = new JButton("Add MP3");
        clearButton = new JButton("Clear Fields");
        displayAllButton = new JButton("Display All Gadgets");
        makeCallButton = new JButton("Make Call");
        downloadMusicButton = new JButton("Download Music");

        addMobileButton.addActionListener(this);
        addMP3Button.addActionListener(this);
        clearButton.addActionListener(this);
        displayAllButton.addActionListener(this);
        makeCallButton.addActionListener(this);
        downloadMusicButton.addActionListener(this);
    }

    /**
     * Sets up the main frame for the GUI and adds the components to it.
     */
    private void setupFrame() {
        frame = new JFrame("Gadget Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Adding labels and fields
        addLabeledField(frame, constraints, "Model:", modelField, 0);
        addLabeledField(frame, constraints, "Price:", priceField, 1);
        addLabeledField(frame, constraints, "Weight:", weightField, 2);
        addLabeledField(frame, constraints, "Size:", sizeField, 3);
        addLabeledField(frame, constraints, "Credit (Mobile):", creditField, 4);
        addLabeledField(frame, constraints, "Memory (MP3):", memoryField, 5);
        addLabeledField(frame, constraints, "Phone Number:", phoneNumberField, 6);
        addLabeledField(frame, constraints, "Call Duration:", durationField, 7);
        addLabeledField(frame, constraints, "Download Size:", downloadField, 8);
        addLabeledField(frame, constraints, "Display Number:", displayNumberField, 9);

        // Adding buttons
        constraints.gridy = 10;
        constraints.gridwidth = 2;
        frame.add(addMobileButton, constraints);
        constraints.gridy++;
        frame.add(addMP3Button, constraints);
        constraints.gridy++;
        frame.add(clearButton, constraints);
        constraints.gridy++;
        frame.add(displayAllButton, constraints);
        constraints.gridy++;
        frame.add(makeCallButton, constraints);
        constraints.gridy++;
        frame.add(downloadMusicButton, constraints);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Adds a labeled text field to the specified container.
     *
     * @param parent      The container to which the label and field are added.
     * @param constraints The layout constraints for the component.
     * @param label       The text for the label.
     * @param field       The text field to add.
     * @param row         The row position for the component.
     */
    private void addLabeledField(Container parent, GridBagConstraints constraints, String label, JTextField field, int row) {
        constraints.gridx = 0;
        constraints.gridy = row;
        parent.add(new JLabel(label), constraints);

        constraints.gridx = 1;
        parent.add(field, constraints);
    }

    /**
     * Handles button click events.
     *
     * @param event The ActionEvent triggered by button clicks.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        try {
            if (source == addMobileButton) {
                String model = modelField.getText();
                double price = readDouble(priceField, "price");
                int weight = readInt(weightField, "weight");
                String size = sizeField.getText();
                int credit = readInt(creditField, "credit");

                Mobile newMobile = new Mobile(model, price, weight, size, credit);
                gadgets.add(newMobile);
                JOptionPane.showMessageDialog(frame, "Mobile added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            } else if (source == addMP3Button) {
                String model = modelField.getText();
                double price = readDouble(priceField, "price");
                int weight = readInt(weightField, "weight");
                String size = sizeField.getText();
                double memory = readDouble(memoryField, "memory");

                MP3 newMP3 = new MP3(model, price, weight, size, memory);
                gadgets.add(newMP3);
                JOptionPane.showMessageDialog(frame, "MP3 added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            } else if (source == clearButton) {
                clearFields();

            } else if (source == displayAllButton) {
                displayAllGadgets();

            } else if (source == makeCallButton) {
                int index = readDisplayNumber();
                if (index != -1 && index < gadgets.size() && gadgets.get(index) instanceof Mobile) {
                    Mobile mobile = (Mobile) gadgets.get(index);
                    String phoneNumber = phoneNumberField.getText().trim();
                    int duration = readInt(durationField, "duration");
                    mobile.makePhoneCall(phoneNumber, duration);
                    JOptionPane.showMessageDialog(frame, "Call made successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "The selected gadget is not a mobile or the index is invalid.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else if (source == downloadMusicButton) {
                int index = readDisplayNumber();
                if (index != -1 && index < gadgets.size() && gadgets.get(index) instanceof MP3) {
                    MP3 mp3 = (MP3) gadgets.get(index);
                    double downloadSize = readDouble(downloadField, "download size");
                    mp3.downloadMusic(downloadSize);
                    JOptionPane.showMessageDialog(frame, "Music downloaded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "The selected gadget is not an MP3 player or the index is invalid.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Displays all gadgets in the list in a message dialog.
     */
    private void displayAllGadgets() {
        if (gadgets.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No gadgets available.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder allGadgets = new StringBuilder("<html>");
        for (Gadget gadget : gadgets) {
            allGadgets.append(gadget.display().replace("\n", "<br>")).append("<br><br>");
        }
        allGadgets.append("</html>");
        JOptionPane.showMessageDialog(frame, allGadgets.toString(), "All Gadgets", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Clears all input fields in the GUI.
     */
    private void clearFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadField.setText("");
        displayNumberField.setText("");
    }

    /**
     * Reads a double value from a text field.
     *
     * @param field     The text field to read from.
     * @param fieldName The name of the field (for error messages).
     * @return The double value from the field.
     * @throws IllegalArgumentException If the input is not a valid double.
     */
    private double readDouble(JTextField field, String fieldName) {
        try {
            return Double.parseDouble(field.getText().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please enter a valid number for " + fieldName + ".");
        }
    }

    /**
     * Reads an integer value from a text field.
     *
     * @param field     The text field to read from.
     * @param fieldName The name of the field (for error messages).
     * @return The integer value from the field.
     * @throws IllegalArgumentException If the input is not a valid integer.
     */
    private int readInt(JTextField field, String fieldName) {
        try {
            return Integer.parseInt(field.getText().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please enter a valid number for " + fieldName + ".");
        }
    }

    /**
     * Reads the display number from the text field, ensuring it is a valid index.
     *
     * @return The display number, or -1 if invalid.
     */
    private int readDisplayNumber() {
        int index = -1;
        try {
            index = Integer.parseInt(displayNumberField.getText().trim()) - 1; // Convert to zero-based index
            if (index < 0 || index >= gadgets.size()) {
                JOptionPane.showMessageDialog(frame, "Invalid display number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                index = -1;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid integer for the display number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
        return index;
    }

    /**
     * The main method to launch the GadgetShop application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GadgetShop::new);
    }
}

