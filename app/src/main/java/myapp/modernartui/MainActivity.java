package myapp.modernartui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

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
    // Create Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Moma");
        builder.setMessage("Should we take a look?");
        builder.setPositiveButton("Visit Moma", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.moma.org/"));
                startActivity(browserIntent);
            }
        });
        builder.setNegativeButton("Not now", null);
        builder.show();
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                alterColor(findViewById(R.id.one), progress, ResourcesCompat.getColor(getResources(),  R.color.one, null));
                alterColor(findViewById(R.id.two), progress, ResourcesCompat.getColor(getResources(),  R.color.two, null));
                alterColor( findViewById(R.id.threea), progress, ResourcesCompat.getColor(getResources(),  R.color.three, null));
                alterColor(findViewById(R.id.threeb), progress, ResourcesCompat.getColor(getResources(),  R.color.three, null));
                alterColor(findViewById(R.id.four), progress, ResourcesCompat.getColor(getResources(),  R.color.four, null));
                alterColor(findViewById(R.id.five), progress, ResourcesCompat.getColor(getResources(),  R.color.five, null));
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
                //nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //nothing
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

