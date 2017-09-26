package net.infofusion.tswisher.tracitestvideo.players;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ooyala.android.OoyalaPlayer;
import com.ooyala.android.OoyalaPlayerLayout;
import com.ooyala.android.PlayerDomain;
import com.ooyala.android.ui.OoyalaPlayerLayoutController;

import net.infofusion.tswisher.tracitestvideo.R;


/**
 * This activity illustrates how you can play basicPlayback Video
 * you can also play Ooyala and VAST advertisements programmatically
 * through the SDK
 *
 */
public class BasicPlaybackVideoPlayerActivity extends AbstractHookActivity {

    final String PCODE = "htaTkyOrNrh23_19b-8WhTYHtl5F";
    final String EMBED = "04dGxlNDE68bSwyiatBP7vkVxcPt8FJm";
    final String DOMAIN = "http://www.ooyala.com";


    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, BasicPlaybackVideoPlayerActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra("selection_name", "Test Video");

        return intent;
    }

    @Override
    void completePlayerSetup(boolean asked) {
        if (asked) {
            player = new OoyalaPlayer(PCODE, new PlayerDomain(DOMAIN));
            playerLayout = (OoyalaPlayerLayout) findViewById(R.id.ooyalaPlayer);

            playerLayoutController = new OoyalaPlayerLayoutController(playerLayout, player);
            player.addObserver(this);

            if (player.setEmbedCode(EMBED)) {
                player.play();
            }
            else {
                Log.e(TAG, "Asset Failure");
            }
        }
    }
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_simple_layout);
        completePlayerSetup(asked);
    }
}


