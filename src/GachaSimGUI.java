import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GachaSimGUI  {
    public void go(GachaSimulator gachaSimulator) {
        JFrame mainFrame = new JFrame("Gacha Simulator");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(300,300);
        mainFrame.setResizable(false);

        JPanel rollPanel = new JPanel();
        rollPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));

        JTextField shortOutput = new JTextField(20);
        JTextArea longOutput = new JTextArea();

        JButton rollButton = createButton("Roll");
        rollButton.addActionListener(new RollButtonListener(gachaSimulator, shortOutput));

        JButton getStatsButton = createButton("Show roll statistics");
        getStatsButton.addActionListener(new GetStatsButtonListener(gachaSimulator, longOutput));

        rollPanel.add(rollButton);
        rollPanel.add(shortOutput);
        rollPanel.add(getStatsButton);
        rollPanel.add(longOutput);

        mainFrame.getContentPane().add(rollPanel);
        mainFrame.setLocationRelativeTo(null);

        mainFrame.setVisible(true);
    }

    public JButton createButton(String name){
        JButton button = new JButton(name);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    static class RollButtonListener implements ActionListener  {
        GachaSimulator gachaSimulator;
        JTextField output;

        public RollButtonListener(GachaSimulator gachaSimulator,JTextField output){
            this.gachaSimulator = gachaSimulator;
            this.output = output;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                output.setText(gachaSimulator.pull().getLootName());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    static class GetStatsButtonListener implements ActionListener  {
        GachaSimulator gachaSimulator;
        JTextArea output;

        public GetStatsButtonListener(GachaSimulator gachaSimulator,JTextArea output){
            this.gachaSimulator = gachaSimulator;
            this.output = output;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            output.setText(gachaSimulator.tracker.toString());
        }
    }




}
