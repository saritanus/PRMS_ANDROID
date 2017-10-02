package sg.edu.nus.iss.phoenix.schedule.android.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import sg.edu.nus.iss.phoenix.R;
import sg.edu.nus.iss.phoenix.core.android.controller.ControlFactory;

/**
 * @author The Administrator
 * @version 1.0
 * @created 20-Sep-2017 1:01:59 AM
 */
public class ScheduleListScreen extends AppCompatActivity {


	RecyclerView recyclerView;
	RecyclerView.LayoutManager layoutManager;
	RecyclerView.Adapter adapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_schedule_list);
		// Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		// setSupportActionBar(toolbar);

		recyclerView =
				(RecyclerView) findViewById(R.id.recycler_view);

		layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);

		adapter = new ScheduleAdapter();
		recyclerView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_card_demo, menu);
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









	public void finalize() throws Throwable {
		super.finalize();
	}
	public void ScheduleListScreen(){

	}

	public void Activity(){

	}

	protected void onCreate(){

	}

	public void onDisplayScheduleList(){

	}

	protected void onPostCreate(){

	}

	public void selectViewProgramSlot(){

	}

	public void showProgramSlots(){

	}
}//end ScheduleListScreen