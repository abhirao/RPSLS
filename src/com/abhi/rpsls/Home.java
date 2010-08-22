package com.abhi.rpsls;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.abhi.rpsls.model.Referee;
import com.abhi.rpsls.model.Result;
import com.abhi.rpsls.model.Robot;
import com.abhi.rpsls.model.Result.Outcome;

public class Home extends ListActivity {
	private Referee ref = new Referee();
	private CharSequence selectionA = null;
	private CharSequence selectionB = null;
	private Robot robot = null;
	String[] items = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		items = getApplicationContext().getResources().getStringArray(
				R.array.choices);
		setContentView(R.layout.main);
		setListAdapter(new IconicDisplay());
		robot = new Robot();

	}

	public void onListItemClick(ListView parent, View v, int position, long id) {

		CharSequence newSelection = this.getListAdapter().getItem(position)
				.toString();

		TextView selectionView = (TextView) findViewById(R.id.selection);
		String display;

		selectionView.setText("");

		selectionA = newSelection;
		display = selectionA + " vs. ";

		selectionView.setText(display);

		selectionB = robot.Choice();

		selectionView.append(selectionB.toString());

		final Result res = ref.determineWinner(selectionA.toString(),
				selectionB.toString());
		if (Outcome.TIE == res.getOutcome()) {
			selectionView.append(selectionA + " ties with " + selectionB);
		} else if (Outcome.WIN == res.getOutcome()) {
			selectionView.append(". Winner is " + res.getWinner() + ".");
		} else {
			selectionView.append("Invalid input.");
		}
	}

	class IconicDisplay extends ArrayAdapter<String> {

		IconicDisplay() {

			super(Home.this, R.layout.row, items);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = getLayoutInflater();

			View row = inflater.inflate(R.layout.row, parent, false);

			TextView choice = (TextView) row.findViewById(R.id.choice);

			choice.setText(items[position]);

			ImageView icon = (ImageView) row.findViewById(R.id.icon);
			
			//test comment
			
			icon.setImageResource(getResources().getIdentifier("com.abhi.rpsls:drawable/"+items[position].toLowerCase(), null, null));

			return row;
		}
	}

}