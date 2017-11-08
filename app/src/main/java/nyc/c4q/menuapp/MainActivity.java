package nyc.c4q.menuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    private Button contextButton;
    private final String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contextButton = (Button) findViewById(R.id.context_button);
        registerForContextMenu(contextButton);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionsmenu, menu);
        //return super.onCreateOptionsMenu(menu); if you want to create your menu conditionally? want to open menu only if...
        return true;// common patter calling super or return true.
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionsmenu, menu);
    }
    //doesnt need to be overrided, because isnt displayed by default, displayed by events
    public void onCreatePopupMenu(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        popup.setOnMenuItemClickListener(this);
        inflater.inflate(R.menu.optionsmenu, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();// gts, googlt this shit
         /*switch (item.getItemId()) {
           case R.id.edit:
                editNote(info.id);
                return true;
            case R.id.delete:
                deleteNote(info.id);
                return true;
            default:
                return super.onContextItemSelected(item);*/
            switch(item.getItemId()){
                case R.id.search_item:
                    Log.e(TAG, "search was clicked");
                    break;
                case R.id.feedback_item:
                    Log.e(TAG, "Feedback was clicked");
                    break;
                case R.id.settings_item:
                    Log.e(TAG, "Settings was clicked");
                    break;
                case R.id.help_item:
                    Log.e(TAG, "Help was clicked");
                    Intent helpIntent = new Intent(this, HelpActivity.class);
                    startActivity(helpIntent);
                    break;
            }
            return true;

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.search_item:
                Log.e(TAG, "search was clicked");
                break;
            case R.id.feedback_item:
                Log.e(TAG, "Feedback was clicked");
                break;
            case R.id.settings_item:
                Log.e(TAG, "Settings was clicked");
                break;
            case R.id.help_item:
                Log.e(TAG, "Help was clicked");
                Intent helpIntent = new Intent(this, HelpActivity.class);
                startActivity(helpIntent);
                break;
        }
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.search_item:
                Log.e(TAG, "search was clicked");
                break;
            case R.id.feedback_item:
                Log.e(TAG, "Feedback was clicked");
                break;
            case R.id.settings_item:
                Log.e(TAG, "Settings was clicked");
                break;
            case R.id.help_item:
                Log.e(TAG, "Popup: Help was clicked");
                Intent helpIntent = new Intent(this, HelpActivity.class);
                startActivity(helpIntent);
                break;
        }
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
