package net.infofusion.tswisher.tracitestvideo;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import net.infofusion.tswisher.tracitestvideo.players.BasicPlaybackVideoPlayerActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.start_button);
        button.setOnClickListener(myListener);
//        button.setOnClickListener(new View.OnClick(this) {
//            @Override
//            public void onClick(Activity activity) {
//                Intent intent = BasicPlaybackVideoPlayerActivity.createIntent(activity);
//                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//                intent.putExtra("selection_name", "Test Video");
//                startActivity(intent);
//            }
//        });
    }

    private View.OnClickListener myListener = new View.OnClickListener(){
        public void onClick(View v){
            Intent intent = BasicPlaybackVideoPlayerActivity.createIntent(getBaseContext());
            startActivity(intent);
        }
    };

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
