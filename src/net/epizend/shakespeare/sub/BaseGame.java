package net.epizend.shakespeare.sub;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.prefs.Preferences;

/**
 *
 * @author epizend
 */
public abstract class BaseGame {
    
    private static final Preferences highscores = Preferences.userNodeForPackage(Score.class);
    
    private final String ID = this.getClass().getName();
    private final String HS_ID = ID+"-HS";
    
    private final List<Listener> listeners = new LinkedList<Listener>();
    
    public abstract void start();
    
    public void addListener(Listener listener){
        listeners.add(listener);
    }
    
    protected void notifySuccess(){
        for (int i = 0; i < listeners.size(); i++) {
            Listener listener = listeners.get(i);
            listener.success();
        }
    }
    
    protected void notifyFail(){
        for (int i = 0; i < listeners.size(); i++) {
            Listener listener = listeners.get(i);
            listener.fail();
        }
    }
    
    public void saveScore(Score sc){
        String str = highscores.get(HS_ID, null);
        if(str == null || str.trim().isEmpty()){
            str = sc.serializeScore();
        } else {
            str = str+","+sc.serializeScore();
        }
        highscores.put(HS_ID, str);
    }
    
    public List<Score> getScores(){
        final String scores = highscores.get(HS_ID, null);
        if(scores == null || scores.length() == 0){
            return Collections.EMPTY_LIST;
        }
        return Score.deserializeList(scores);
    }
    
    public void resetScore(){
        highscores.put(HS_ID, "");
    }
    
}
