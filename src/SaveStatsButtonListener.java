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
            RollStatsSerializer.serialize(gachaSimulator.tracker,Main.getRollStatsFilePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
