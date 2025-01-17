import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GetStatsButtonListener implements ActionListener {
    GachaSimulator gachaSimulator;
    JTextArea output;

    public GetStatsButtonListener(GachaSimulator gachaSimulator, JTextArea output) {
        this.gachaSimulator = gachaSimulator;
        this.output = output;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        output.setText(gachaSimulator.tracker.toString());
    }
}
