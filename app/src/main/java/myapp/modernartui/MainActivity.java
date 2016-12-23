package myapp.modernartui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                View one = findViewById(R.id.one);
                View two = findViewById(R.id.two);
                View three1 = findViewById(R.id.threea);
                View three2 = findViewById(R.id.threeb);
                View four = findViewById(R.id.four);
                View five = findViewById(R.id.five);
                alterColor(one, progress, ResourcesCompat.getColor(getResources(),  R.color.one, null));
                alterColor(two, progress, ResourcesCompat.getColor(getResources(),  R.color.two, null));
                alterColor(three1, progress, ResourcesCompat.getColor(getResources(),  R.color.three, null));
                alterColor(three2, progress, ResourcesCompat.getColor(getResources(),  R.color.three, null));
                alterColor(four, progress, ResourcesCompat.getColor(getResources(),  R.color.four, null));
                alterColor(five, progress, ResourcesCompat.getColor(getResources(),  R.color.five, null));

            }

            /**
             * Set the color of the view to an altered color.
             *
             * @param view        - view for which the color will be set
             * @param alterFactor - factor by which the color will be altered
             * @param basecollor  the color int to alter
             */
            private void alterColor(View view, int alterFactor, int basecollor) {
                int origR = (basecollor >> 16) & 0x000000FF;
                int origG = (basecollor >> 8) & 0x000000FF;
                int origB = basecollor & 0x000000FF;
                view.setBackgroundColor( Color.rgb(
                        ( int ) (Math.abs( origR +  (alterFactor-50) )),
                        ( int ) (Math.abs( origG +  (alterFactor-50) )),
                        ( int ) (Math.abs( origB +  (alterFactor-50) )) ));

//                view.setBackgroundColor();


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}

