package space.commandf1.FasterLib.run;

import space.commandf1.FasterLib.run.gui.Window;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("This program can only run on a Bukkit/Spigot server");
        main.loadErrorUI();
    }

    public void loadErrorUI() {
        JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel();
        JButton jButton = new JButton();
        JButton fuckMyComputer = new JButton();
        fuckMyComputer.setText("Fuck my computer please");
        fuckMyComputer.addActionListener(e -> {
            fuckMyComputer.setEnabled(false);
            for (int i = 0; i < 114514; i++) {
                Robot robot = null;
                try {
                    robot = new Robot();
                } catch (AWTException ex) {
                    ex.printStackTrace();
                }
                assert robot != null;
                robot.delay(100);
                new Window(new Random().nextInt(1500), new Random().nextInt(1500));
            }
        });
        jLabel.setText("This program can only run on a Bukkit/Spigot server, please put the plugin to your \"plugins\" dir.");
        jLabel.setForeground(Color.RED);
        jButton.setText("Close");
        jButton.addActionListener(event -> System.exit(0));
        jPanel.add(jLabel);
        jPanel.add(jButton);
        jPanel.add(fuckMyComputer);
        jFrame.add(jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(600, 100);
        jFrame.setTitle("Runtime Error");
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
