package vale.velu.com.eiga.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kumar_velu on 27-12-2016.
 */
public class Movie implements Serializable {

    @SerializedName("title")
    private String title;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("vote_average")
    private String rating;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("backdrop_path")
    private String backDropPath;
    @SerializedName("overview")
    private String plotSynopsis;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getBackDropPath() {
        return backDropPath;
    }

    public void setBackDropPath(String backDropPath) {
        this.backDropPath = backDropPath;
    }

    public String getPlotSynopsis() {
        return plotSynopsis;
    }

    public void setPlotSynopsis(String plotSynopsis) {
        this.plotSynopsis = plotSynopsis;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", posterPath='" + posterPath + '\'' +
                ", rating='" + rating + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", backDropPath='" + backDropPath + '\'' +
                ", plotSynopsis='" + plotSynopsis + '\'' +
                '}';
    }
}
