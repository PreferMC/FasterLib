package space.commandf1.FasterLib.run;

import javax.swing.*;
import java.awt.*;

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
        jLabel.setText("不是这样运行此程序!这个程序仅能够运行在Bukkit/Spigot服务器中!请将此程序放在plugins文件夹");
        jLabel.setForeground(Color.RED);
        jButton.setText("好的");
        jButton.addActionListener(event -> System.exit(0));
        jPanel.add(jLabel);
        jPanel.add(jButton);
        jFrame.add(jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(600, 100);
        jFrame.setTitle("运行错误");
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
