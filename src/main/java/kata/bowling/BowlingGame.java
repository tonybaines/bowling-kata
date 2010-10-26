package kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Integer> bowls = new ArrayList<Integer>();

    public void bowl(int bowl) {
      this.bowls.add(bowl);
    }

    public int score() {
      int score = 0;
      int bowlNumber = 0;
      for (int frame=1; frame <= 10; frame++) {
        if (isAStrike(bowlNumber)) { // Strike, just one ball this frame
          score += scoreAStrike(bowlNumber++);
        }
        else { // Two balls bowled for this frame
          int bowl1 = safeGetBowl(bowlNumber++);
          int bowl2 = safeGetBowl(bowlNumber);
          if (isASpare(bowl1, bowl2)) {
            score += safeGetBowl(bowlNumber+1);
          }
          score += bowl1 + bowl2;
          bowlNumber++;
        }
      }
      return score;
    }

    private boolean isASpare(int bowl1, int bowl2) {
      return bowl1 + bowl2 == 10;
    }

    private boolean isAStrike(int bowlNumber) {
      return safeGetBowl(bowlNumber) == 10;
    }

    private int scoreAStrike(int bowlNumber) {
      return safeGetBowl(bowlNumber) + safeGetBowl(bowlNumber+1) + safeGetBowl(bowlNumber+2);
    }
    
    private int safeGetBowl(int bowlNumber) {
      if (bowlNumber <= this.bowls.size()-1) {
        return this.bowls.get(bowlNumber);
      }
      else {
        return 0;
      }
    }
}
