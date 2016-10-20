package com.markoarsenovic.connect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // yellow -> 0, red -> 1
    int activePlayer = 0;

    boolean gameIsActive = true;

    //2 represents unplayed position
    int[] gameState = {2,2,2,2,2,2,2,2,2};

    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7},{2,5,8}, {0,4,8}, {2,4,6}};

    public void dropIn(View view){

        //move the empty counter oout of the display up
        ImageView counter = (ImageView) view;
        System.out.println("TAG :" +counter.getTag().toString());
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedCounter] == 2 && gameIsActive){

            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1000f);

            if(activePlayer == 0)
            {
                //set the image source to the counter
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;

            } else{

                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            //bring back the selected counter on the display
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

            //checking the winning positions
            for(int[] winningPosition : winningPositions){

                if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2){

                    gameIsActive = false;

                    String winner = "RED";
                    if(gameState[winningPosition[0]] == 0)
                    {
                        winner = "YELLOW";
                    }
                    System.out.println(gameState[winningPosition[0]]);

                    //Someone has WON!!! :)
                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                    winnerMessage.setText(winner + " has won!");
                    LinearLayout layout  = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
                }
                else{

                    boolean gameIsOver = true;
                    //checking if there are any positions left
                    for( int counterState : gameState){

                        if(counterState == 2) gameIsOver = false;
                    }

                    if(gameIsOver){

                        //It's a DRAW! 
                        TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                        winnerMessage.setText("It's a DRAW!");
                        LinearLayout layout  = (LinearLayout) findViewById(R.id.playAgainLayout);
                        layout.setVisibility(View.VISIBLE);
                    }
                }
            }
        }


    }

    public void playAgain(View view){

        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);

        //INITIAL VALUES
        activePlayer = 0;
        gameIsActive = true;

        for ( int i = 0; i < gameState.length; i++){
            gameState[i] = 2;
        }

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for(int i = 0; i< gridLayout.getChildCount(); i++) { //getChildCount -> number of views inside the layout

            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0); //let us reset the images of counters
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
