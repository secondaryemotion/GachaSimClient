import java.net.URI;
import java.net.URISyntaxException;
public class Main {
    public static void main(String[] args) throws URISyntaxException {



        URI uri = new URI("http://localhost:8080/random");
        NameGeneratorAPIRequester requester = new NameGeneratorAPIRequester(uri);
        RollGenerator roller = new RollGenerator(new BasicLootRepository(requester), new EpicLootRepository(requester), new LegendaryLootRepository(requester));
        RollStatsTracker tracker = new RollStatsTracker();
        GachaSimulator gacha = new GachaSimulator(roller, tracker);
        GachaSimGUI gachaSimGUI = new GachaSimGUI();
        gachaSimGUI.go(gacha);



    }


}