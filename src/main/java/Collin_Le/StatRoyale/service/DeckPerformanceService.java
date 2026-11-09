package Collin_Le.StatRoyale.service;

import Collin_Le.StatRoyale.model.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class DeckPerformanceService {
    BattleLog battlelog;
    HashMap<List<Integer>, DeckPerformance> map = new HashMap<>();

    public List<DeckPerformance> getDeckPerforamnce(String tag) {
        for(int i = 0; i < battlelog.getBattleLog().size(); i++) {

            Battle battle = battlelog.getBattleLog().get(i);
            Team team = battle.getTeam().getFirst();
            Opponent opponent = battle.getOpponent().getFirst();
            List<Card> cards = team.getCards();

            List<Integer> deckKey = cards.stream().map(Card::getId).collect(Collectors.toList());
            Collections.sort(deckKey.subList(3, 8));

            if(!map.containsKey(deckKey)) {
                //public DeckPerformance(List<Card> deck, int numOfBattle, int wins, int draws, int loses, int teamCrowns, int opponentCrowns)
                map.put(deckKey, new DeckPerformance(cards, 1, win(team.getCrowns(), opponent.getCrowns()), draw(team.getCrowns(), opponent.getCrowns()), lose(team.getCrowns(), opponent.getCrowns())));
            } else {
                DeckPerformance performance = map.get(deckKey);
                performance.updatePerformance(win(team.getCrowns(), opponent.getCrowns()), draw(team.getCrowns(), opponent.getCrowns()), lose(team.getCrowns(), opponent.getCrowns()));
            }
        }

        return new ArrayList<>(map.values());
    }

    public int win(int teamCrowns, int opponentCrowns) {
        if(teamCrowns > opponentCrowns) {
            return 1;
        }
        return 0;
    }
    public int lose(int teamCrowns, int opponentCrowns) {
        if(teamCrowns < opponentCrowns) {
            return 1;
        }
        return 0;
    }

    public int draw(int teamCrowns, int opponentCrowns) {
        if(teamCrowns == opponentCrowns) {
            return 1;
        }
        return 0;
    }

}
