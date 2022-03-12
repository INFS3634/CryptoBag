package au.edu.unsw.infs3634.cryptobag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = "MainActivity";
  private RecyclerView mRecyclerView;
  private CoinAdapter mAdapter;
  private RecyclerView.LayoutManager mLayoutManager;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Get a handle to the RecyclerView
    mRecyclerView = findViewById(R.id.rvList);
    mRecyclerView.setHasFixedSize(true);

    // Instantiate a LinearLayoutManager
    mLayoutManager = new LinearLayoutManager(this);
    mRecyclerView.setLayoutManager(mLayoutManager);

    // Implement ClickListener for list items
    CoinAdapter.RecyclerViewClickListener listener = new CoinAdapter.RecyclerViewClickListener() {
      @Override
      public void onClick(View view, String coinSymbol) {
        launchDetailActivity(coinSymbol);
      }
    };
    // Create an adapter instance and supply the coins data to be displayed
    mAdapter = new CoinAdapter(Coin.getCoins(), listener);
    // Connect the adapter with the RecyclerView
    mRecyclerView.setAdapter(mAdapter);

  }

  // Called when user taps on a row on the RecyclerView
  private void launchDetailActivity(String message){
    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
    intent.putExtra(DetailActivity.INTENT_MESSAGE, message);
    startActivity(intent);
  }

}