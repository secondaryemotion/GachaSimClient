import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    static String rollStatsFilePath = "src/resources/roll_stats.txt";

    public static void main(String[] args) throws URISyntaxException, IOException, ClassNotFoundException {



        URI uri = new URI("http://localhost:8080/random");
        NameGeneratorAPIRequester requester = new NameGeneratorAPIRequester(uri);
        RollGenerator roller = new RollGenerator(new BasicLootRepository(requester), new EpicLootRepository(requester), new LegendaryLootRepository(requester));
        RollStatsTracker tracker = RollStatsSerializer.deserialize(rollStatsFilePath);


        GachaSimulator gacha = new GachaSimulator(roller, tracker);
        GachaSimGUIBuilder gachaSimGUI = new GachaSimGUIBuilder();
        gachaSimGUI.createMainFrame(gacha);

    }
    public static String getRollStatsFilePath(){
        return rollStatsFilePath;
    }


}