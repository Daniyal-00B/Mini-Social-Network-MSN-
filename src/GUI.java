import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {

    // ==============================
    // 1. تابع نمایش فرم لاگین
    // ==============================
    public static void showLoginForm() {
        // ایجاد پنجره اصلی
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2, 10, 10));

        // فیلدها
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        // دکمه‌ها
        JButton loginButton = new JButton("Login");
        JButton signInButton = new JButton("Sign In");

        // افزودن به پنجره
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(signInButton);

        // رویداد دکمه لاگین
        loginButton.addActionListener(e -> {
            String name = nameField.getText();
            String pass = new String(passwordField.getPassword());

            // فقط جهت تست
            JOptionPane.showMessageDialog(frame,
                    "Login pressed\nName: " + name + "\nPass: " + pass);
        });

        // رویداد دکمه Sign In
        signInButton.addActionListener(e -> showSignInForm());

        frame.setVisible(true);
    }


    // ==============================
    // 2. تابع نمایش فرم Sign-In
    // ==============================
    public static void showSignInForm() {
        JFrame frame = new JFrame("Sign In");
        frame.setSize(300, 220);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        // فیلدها
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JLabel confirmLabel = new JLabel("Confirm Password:");
        JPasswordField confirmField = new JPasswordField();

        JButton okButton = new JButton("Create Account");

        // افزودن کامپوننت‌ها
        frame.add(nameLabel);
        frame.add(nameField);

        frame.add(passLabel);
        frame.add(passField);

        frame.add(confirmLabel);
        frame.add(confirmField);

        frame.add(new JLabel(""));
        frame.add(okButton);

        // رویداد دکمه
        okButton.addActionListener(e -> {
            String pass = new String(passField.getPassword());
            String confirm = new String(confirmField.getPassword());

            if (!pass.equals(confirm)) {
                JOptionPane.showMessageDialog(frame,
                        "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Account created successfully!");
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }


    // ==============================
    // 3. تابع ساخت یک فیلد عددی با لیبل
    //    مقدار معتبر را برمی‌گرداند
    // ==============================
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
