package ar.edu.unq.model;


import java.util.ArrayList;

public class FixtureGenerator {


    public static ArrayList<Match> createFixture(ArrayList<Team> teams) {

        ArrayList<Match> matches = new ArrayList<Match>();

        if (teams.size() % 2 == 1) {
             //Number of teams uneven ->  add the decoy team for a free round
            teams.add(new Team("DecoyTeam", new User("DecoyUser")));//needs review
        }

        for (int i = 1; i < teams.size(); i++) {
            createOneRound(i, teams,matches);
            // Move last item to first
            teams.add(1, teams.get(teams.size() - 1));
            teams.remove(teams.size() - 1);
        }

        return matches;

    }

    private static void createOneRound(int round, ArrayList<Team> teams, ArrayList<Match> matches) {

        int middle = teams.size() / 2;
        // Split list into two

        ArrayList<Team> l1 = new ArrayList<Team>();
        // Can't use sublist (can't cast it to ArrayList - how stupid is that)??
        for (int j = 0; j < middle; j++) {
            l1.add(teams.get(j));
        }

        ArrayList<Team> l2 = new ArrayList<Team>();
        // We need to reverse the other list
        for (int j = teams.size() - 1; j >= middle; j--) {
            l2.add(teams.get(j));
        }

        for (int tId = 0; tId < l1.size(); tId++) {
            Team local;
            Team visitor;
            // Switch sides after each round
            //opcional si hay ida y vuelta, habria que volarlo
            if (round % 2 == 1) {
                local = l1.get(tId);
                visitor =l2.get(tId);
            } else {
                local = l2.get(tId);
                visitor = l1.get(tId);
            }

            matches.add(new Match(round, local, visitor));
        }
    }

}
