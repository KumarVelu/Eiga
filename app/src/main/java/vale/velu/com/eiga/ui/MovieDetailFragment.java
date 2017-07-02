package vale.velu.com.eiga.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import vale.velu.com.eiga.R;
import vale.velu.com.eiga.model.Movie;
import vale.velu.com.eiga.utils.Constants;
import vale.velu.com.eiga.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends BaseFragment {
    public static final String MOVIE_KEY = "movie";
    private static final String TAG = MovieDetailFragment.class.getSimpleName();
    Toolbar mToolbar;
    @Bind(R.id.backdrop)
    ImageView backDropImage;
    @Bind(R.id.poster_image)
    ImageView posterImage;
    @Bind(R.id.title)
    TextView tvTitle;
    @Bind(R.id.release_date)
    TextView tvReleaseDate;
    @Bind(R.id.rating)
    TextView tvRating;
    @Bind(R.id.plot_synopsis)
    TextView tvPlotSynopsis;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Context mContext;
    private Movie mMovie;

    public static MovieDetailFragment newInstance() {
        return new MovieDetailFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        if (getArguments() != null) {
            mMovie = (Movie) getArguments().getSerializable(MOVIE_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, rootView);
        mToolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        // ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) rootView.findViewById(R.id.collapsing_toolbar);

        setUiWithMovieDetails();
        return rootView;
    }


    private void setUiWithMovieDetails() {

        Picasso.with(mContext).load(Constants.POSTER_PATH_PREFIX + mMovie.getPosterPath()).
                into(posterImage);
        Picasso.with(mContext).load(Constants.BACKDROP_PATH_PREFIX + mMovie.getBackDropPath()).
                into(backDropImage);

        mCollapsingToolbarLayout.setTitle(mMovie.getTitle().trim());
        tvTitle.setText(mMovie.getTitle());
        tvReleaseDate.setText(Utils.formatReleaseDate(mMovie.getReleaseDate()));
        tvRating.setText(mMovie.getRating());
        tvPlotSynopsis.setText(mMovie.getPlotSynopsis());

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMovie = null;
                closeFragment();
            }
        });
    }
}
