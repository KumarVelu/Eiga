package vale.velu.com.eiga.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import vale.velu.com.eiga.R;
import vale.velu.com.eiga.model.Movie;
import vale.velu.com.eiga.utils.Constants;

/**
 * Created by kumar_velu on 27-12-2016.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> {


    private static final String TAG = MovieListAdapter.class.getSimpleName();
    private Context mContext;
    private List<Movie> mMovieList;
    private IMovieClickListener mClickHandler;
    private LayoutInflater mInflater;

    public MovieListAdapter(Context context, IMovieClickListener clickHandler) {
        mContext = context;
        mClickHandler = clickHandler;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MovieListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieListViewHolder(mInflater.inflate(R.layout.row_movie_list, parent,
                false));
    }

    @Override
    public void onBindViewHolder(MovieListViewHolder holder, int position) {
        final Movie movie = mMovieList.get(position);
        Picasso.with(mContext)
                .load(Constants.POSTER_PATH_PREFIX + movie.getPosterPath())
                .fit()
                .centerCrop()
                .into(holder.posterImage);
        holder.tvTitle.setText(movie.getTitle());
        holder.tvRating.setText(movie.getRating());
        holder.itemView.setTag(movie);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickHandler.onMovieClick(movie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMovieList == null ? 0 : mMovieList.size();
    }

    public void swapData(List<Movie> movieList) {
        mMovieList = movieList;
        notifyDataSetChanged();
    }

    public interface IMovieClickListener {
        void onMovieClick(Movie movie);
    }

    public class MovieListViewHolder extends RecyclerView.ViewHolder {

        ImageView posterImage;
        TextView tvTitle, tvRating;

        public MovieListViewHolder(View itemView) {
            super(itemView);
            posterImage = (ImageView) itemView.findViewById(R.id.poster_image);
            tvTitle = (TextView) itemView.findViewById(R.id.title);
            tvRating = (TextView) itemView.findViewById(R.id.rating);
        }
    }
}
