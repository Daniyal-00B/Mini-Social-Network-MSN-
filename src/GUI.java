import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {

    private static JFrame frame; // پنجره اصلی

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> showLoginForm());
    }

    // ==============================
    // نمایش فرم Login
    // ==============================
    public static void showLoginForm() {
        frame = new JFrame("Login / Sign In");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLocationRelativeTo(null);

        // پنل اصلی با فاصله از کناره‌ها
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // ستونی

        // -------------------------
        // فیلد Name
        JPanel namePanel = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        namePanel.add(nameLabel, BorderLayout.NORTH);
        namePanel.add(nameField, BorderLayout.CENTER);
        namePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

        // -------------------------
        // فیلد Password
        JPanel passPanel = new JPanel(new BorderLayout());
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        passPanel.add(passLabel, BorderLayout.NORTH);
        passPanel.add(passField, BorderLayout.CENTER);
        passPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

        // -------------------------
        // دکمه‌ها
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton loginButton = new JButton("Login");
        JButton signInButton = new JButton("Sign In");
        buttonPanel.add(loginButton);
        buttonPanel.add(signInButton);
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        // -------------------------
        // افزودن همه چیز به mainPanel
        mainPanel.add(namePanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(passPanel);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(buttonPanel);

        frame.add(mainPanel);
        frame.setVisible(true);

        // ================== رویدادها ==================
        loginButton.addActionListener(e -> {
            String name = nameField.getText();
            String pass = new String(passField.getPassword());
            JOptionPane.showMessageDialog(frame, "Login pressed\nName: " + name + "\nPass: " + pass);
        });

        signInButton.addActionListener(e -> showSignUpForm(mainPanel));
    }

    // ==============================
    // نمایش فرم Sign Up داخل همان فریم
    // ==============================
    private static void showSignUpForm(JPanel mainPanel) {
        mainPanel.removeAll(); // حذف همه کامپوننت های قبلی
        mainPanel.revalidate();
        mainPanel.repaint();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // -------------------------
        // فیلد Name
        JPanel namePanel = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        namePanel.add(nameLabel, BorderLayout.NORTH);
        namePanel.add(nameField, BorderLayout.CENTER);
        namePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

        // -------------------------
        // فیلد Password
        JPanel passPanel = new JPanel(new BorderLayout());
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        passPanel.add(passLabel, BorderLayout.NORTH);
        passPanel.add(passField, BorderLayout.CENTER);
        passPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

        // -------------------------
        // فیلد Confirm Password
        JPanel confirmPanel = new JPanel(new BorderLayout());
        JLabel confirmLabel = new JLabel("Confirm Password:");
        JPasswordField confirmField = new JPasswordField();
        confirmPanel.add(confirmLabel, BorderLayout.NORTH);
        confirmPanel.add(confirmField, BorderLayout.CENTER);
        confirmPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));

        // -------------------------
        // دکمه‌ها
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton createButton = new JButton("Create Account");
        JButton backButton = new JButton("Back");
        buttonPanel.add(createButton);
        buttonPanel.add(backButton);
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        // -------------------------
        // افزودن همه چیز به mainPanel
        mainPanel.add(namePanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(passPanel);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(confirmPanel);
        mainPanel.add(Box.createVerticalStrut(15));
        mainPanel.add(buttonPanel);

        mainPanel.revalidate();
        mainPanel.repaint();

        // ================== رویدادها ==================
        createButton.addActionListener(e -> {
            String name = nameField.getText();
            String pass = new String(passField.getPassword());
            String confirm = new String(confirmField.getPassword());

            if (!pass.equals(confirm)) {
                JOptionPane.showMessageDialog(frame, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Account created successfully!\nName: " + name);
            }
        });

        backButton.addActionListener(e -> {
            mainPanel.removeAll();
            mainPanel.revalidate();
            mainPanel.repaint();
            showLoginForm(); // برگشت به فرم لاگین
            frame.dispose(); // فرم قدیمی را ببند
        });
    }
    public static int getNum(String labelText) {
        // ایجاد پنجره ورودی
        JPanel panel = new JPanel(new GridLayout(2, 1));
        JLabel label = new JLabel(labelText);
        JTextField field = new JTextField();

        panel.add(label);
        panel.add(field);

        // نمایش دیالوگ ورودی
        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Enter Number",
                JOptionPane.OK_CANCEL_OPTION
        );

        // اگر کاربر Cancel زد
        if (result != JOptionPane.OK_OPTION) {
            return -1; // مقدار پیش‌فرض
        }

        // تلاش برای تبدیل مقدار
        try {
            return Integer.parseInt(field.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please enter a valid integer!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return getNum(labelText); // دوباره تلاش کن
        }
    }
}

