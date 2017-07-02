package vale.velu.com.eiga.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import vale.velu.com.eiga.R;

public class MainActivity extends AppCompatActivity{

    private MovieListFragment mMovieListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) loadMovieListFragment();
    }

    private void loadMovieListFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (mMovieListFragment == null)
            mMovieListFragment = MovieListFragment.newInstance();
        ft.replace(R.id.frame, mMovieListFragment);
        ft.commit();
    }
}
