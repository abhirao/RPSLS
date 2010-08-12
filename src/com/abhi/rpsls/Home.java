package com.abhi.rpsls;

import com.abhi.rpsls.model.Referee;
import com.abhi.rpsls.model.Result;
import com.abhi.rpsls.model.Result.Outcome;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/** test comment **/

public class Home extends Activity {
	private Referee ref = new Referee();
	private CharSequence selectionA =null;
	private CharSequence selectionB =null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final ListView view = (ListView) findViewById(R.id.mainList);
        final String[] values = getApplicationContext().getResources().getStringArray(R.array.choices);
		view.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values));
		view.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		view.setOnItemClickListener(new OnItemClickListener() {


			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
					TextView tv = (TextView) arg1;
					CharSequence newSelection = tv.getText();
					String display;
					if(selectionA==null){
						selectionA = newSelection;
						display = selectionA + " vs. ";
					}else{
						selectionB = selectionA;
						selectionA = newSelection;
						final Result res = ref.determineWinner(selectionA.toString(), selectionB.toString());
						if(Outcome.TIE == res.getOutcome()){
							display = selectionA + " ties with " + selectionB;
						}else if(Outcome.WIN == res.getOutcome()){
							display = selectionA + " vs. " + selectionB + ". Winner is " + res.getWinner() + ".";
						}else{
							display = "Invalid input.";
						}
					}
					TextView selectionView = (TextView) findViewById(R.id.selection);
					selectionView.setText(display);
			}
			
		});
    }
}