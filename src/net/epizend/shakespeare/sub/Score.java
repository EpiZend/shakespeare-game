package net.epizend.shakespeare.sub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author epizend
 */
public class Score {
    private final int score;
    private final String player;
    
    public Score(final int score, final String player){
        this.score = score;
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

    public int getScore() {
        return score;
    }
    
    public String serializeScore(){
        final String escPlayer = player.replace(":", ">>>>>").replace(",", "<<<<<<");
        return "["+escPlayer+":"+score+"]";
    }
    
    public static Score deserialize(final String score){
        assert score.length() >= 3 : "score "+score;
        final String[] fields = score.substring(1, score.length()-1).split(":");
        return new Score(Integer.parseInt(fields[1]), fields[0].replace(">>>>>", ":").replace("<<<<<<", ","));
    }
    
    public static List<Score> deserializeList(final String score){
        if(score.length() == 0){
            return Collections.emptyList();
        }
        final String[] scores = score.split(",");
        List<Score> scoreList = new ArrayList<Score>(scores.length);
        for (int i = 0; i < scores.length; i++) {
            String string = scores[i];
            scoreList.add(deserialize(string));
        }
        return scoreList;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Score other = (Score) obj;
        if (this.score != other.score) {
            return false;
        }
        if ((this.player == null) ? (other.player != null) : !this.player.equals(other.player)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.score;
        hash = 53 * hash + (this.player != null ? this.player.hashCode() : 0);
        return hash;
    }
}
