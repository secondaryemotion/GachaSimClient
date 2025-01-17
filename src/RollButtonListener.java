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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
