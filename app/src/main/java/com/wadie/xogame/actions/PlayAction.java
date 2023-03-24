package com.wadie.xogame.actions;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.wadie.xogame.R;
import com.wadie.xogame.Services.Services;
import com.wadie.xogame.one_v_bot_activity;
import com.wadie.xogame.one_v_one_activity;

public class PlayAction implements View.OnClickListener {
    private one_v_one_activity oneVOneActivity;
    private one_v_bot_activity oneVBotActivity;
    private boolean IsBot=false;
    private Context context;

    public PlayAction(one_v_one_activity oneVOneActivity) {
        this.oneVOneActivity = oneVOneActivity;
         context = oneVOneActivity.getApplicationContext();
    }

    public PlayAction(one_v_bot_activity oneVBotActivity) {
        this.oneVBotActivity = oneVBotActivity;
         context = oneVBotActivity.getApplicationContext();
        IsBot=true;
        


    }

    private void putChar(char charac, View v,int index) {
        v.setClickable(false);
        if(charac=='X')
            v.setBackgroundResource(R.drawable.x_foreground);
        else
            v.setBackgroundResource(R.drawable.o_foreground);

        if(IsBot){
            oneVBotActivity.removeActiveBtn(index);
        clickbtn(oneVBotActivity.getActiveBtns());
        }            
    }


   @Override
   public void onClick(View v) {
      switch (v.getId()) {
          case R.id.button_00:
              char charac = Services.getInstance().makeMove(0, 0);
              putChar(charac, v, 0);
              break;
          case R.id.button_01:
              charac = Services.getInstance().makeMove(0, 1);
              putChar(charac, v, 1);
              break;
          case R.id.button_02:
              charac = Services.getInstance().makeMove(0, 2);
              putChar(charac, v, 2);
              break;
          case R.id.button_10:
              charac = Services.getInstance().makeMove(1, 0);
              putChar(charac, v, 3);
              break;
          case R.id.button_11:
              charac = Services.getInstance().makeMove(1, 1);
              putChar(charac, v, 4);
              break;
          case R.id.button_12:
              charac = Services.getInstance().makeMove(1, 2);
              putChar(charac, v, 5);
              break;
          case R.id.button_20:
              charac = Services.getInstance().makeMove(2, 0);
              putChar(charac, v, 6);
              break;
          case R.id.button_21:
              charac = Services.getInstance().makeMove(2, 1);
              putChar(charac, v, 7);
              break;
          case R.id.button_22:
              charac = Services.getInstance().makeMove(2, 2);
              putChar(charac, v, 8);
              break;
      }

   char winner = Services.getInstance().checkForWinner();
   if (winner == 'O' || winner == 'X') {
       Toast.makeText(this.context, winner + " wins!", Toast.LENGTH_SHORT).show();
       reset();
   } else if(winner=='T'){
       Toast.makeText(context, "It's a tie!", Toast.LENGTH_SHORT).show();
       reset();
   }}

  private void reset(){
            Services.getInstance().reset();
            if(oneVOneActivity!=null)
                oneVOneActivity.resetBoard();
            else
                oneVBotActivity.resetBoard();
        }

public void clickbtn(Button[] btns) {
    System.out.println(oneVBotActivity.getTurn());

    if (oneVBotActivity.getTurn() % 2 == 1) {
        for (int i = 0; i < btns.length; i++) {
        if(btns[i]!=null){
            if(btns[i].isClickable())
                btns[i].performClick();
                break;
        }
        }
    }
}

}

