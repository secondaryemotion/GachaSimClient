import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


class SaveStatsButtonListener implements ActionListener {
    GachaSimulator gachaSimulator;

    public SaveStatsButtonListener(GachaSimulator gachaSimulator) {
        this.gachaSimulator = gachaSimulator;
    }


    public void actionPerformed(ActionEvent event) {
        try {
            gachaSimulator.tracker.serialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
