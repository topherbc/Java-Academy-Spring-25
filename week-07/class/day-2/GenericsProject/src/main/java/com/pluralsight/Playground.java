package com.pluralsight;

public class Playground<A extends Activity>{

    public void playActivity(A active) {
        active.playGame();
    }
}
