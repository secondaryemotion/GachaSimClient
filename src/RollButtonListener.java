import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


class RollButtonListener implements ActionListener {
    GachaSimulator gachaSimulator;
    JTextField output;

    public RollButtonListener(GachaSimulator gachaSimulator, JTextField output) {
        this.gachaSimulator = gachaSimulator;
        this.output = output;
    }


    public void actionPerformed(ActionEvent event) {
        try {
            Loot loot = gachaSimulator.pull();
            String name = loot.getLootName();
            output.setText(name);
            RollStatsSerializer.serialize(gachaSimulator.stats,Main.getRollStatsFilePath());
        } catch (IOException e) {
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
