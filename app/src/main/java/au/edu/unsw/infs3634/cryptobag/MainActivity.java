package au.edu.unsw.infs3634.cryptobag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = "MainActivity";
  private TextView btnLaunchDetailActivity;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnLaunchDetailActivity = findViewById(R.id.tvLaunchDetailActivity);
    // Implement onClickListener for the button
    btnLaunchDetailActivity.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        launchDetailActivity("BTC");
      }
    });
  }

  // Called when user clicks the launch detail activity button
  private void launchDetailActivity(String message){
    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
    intent.putExtra(DetailActivity.INTENT_MESSAGE, message);
    startActivity(intent);
  }

}