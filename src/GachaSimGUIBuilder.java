import javax.swing.*;
import java.awt.*;

public class GachaSimGUIBuilder {
    public void createMainFrame(GachaSimulator gachaSimulator)  {
        JFrame mainFrame = new JFrame("Gacha Simulator");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300,300);
        mainFrame.setResizable(false);

        JPanel rollPanel = new JPanel();
        rollPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));

        JTextField shortOutput = new JTextField(20);
        JTextArea longOutput = new JTextArea();

        JButton rollButton = createCenterAlignedButtonLabeled("Roll");
        rollButton.addActionListener(new RollButtonListener(gachaSimulator, shortOutput));

        JButton getStatsButton = createCenterAlignedButtonLabeled("Show roll statistics");
        getStatsButton.addActionListener(new GetStatsButtonListener(gachaSimulator, longOutput));



        rollPanel.add(rollButton);
        rollPanel.add(shortOutput);
        rollPanel.add(getStatsButton);
        rollPanel.add(longOutput);

        mainFrame.getContentPane().add(rollPanel);
        mainFrame.setLocationRelativeTo(null);

        mainFrame.setVisible(true);
    }

    public JButton createCenterAlignedButtonLabeled(String name){
        JButton button = new JButton(name);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }




}
