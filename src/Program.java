import it.accenture.padel.model.Match;
import it.accenture.padel.model.Player;
import it.accenture.padel.model.Team;

public class Program {
    public static void main(String[] args) {
        Team teamA = new Team("Ferrari");
        Team teamB = new Team("Red Bull");
        Match match = new Match(teamA, teamB);
        match.play();
    }
}
