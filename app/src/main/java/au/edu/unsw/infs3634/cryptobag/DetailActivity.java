package au.edu.unsw.infs3634.cryptobag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("Detail Activity");
        Intent intent = getIntent();
        String msg = intent.getStringExtra("key");
        Log.d(TAG, "Received Message: " + msg);
        TextView tvMsg = findViewById(R.id.tvMessage);
        tvMsg.setText(msg);

        // Play video
        // Get the handle to the play video button
        Button btnPlayVideo = findViewById(R.id.btnVideo);
        // Implement onClickListener for the button object
        btnPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               playVideo("https://www.youtube.com/watch?v=jVyAHVGrs3E");
            }
        });
    }

    void playVideo(String url) {
        Intent impIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(impIntent);
    }
}