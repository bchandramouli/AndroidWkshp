package or.connect.rottomcli;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by moulib on 11/8/14.
 */
public class BoxOfficeDetailActivity extends Activity {
    private ImageView ivPosterImage;
    private TextView tvTitle;
    private TextView tvSynopsis;
    private TextView tvCast;
    private TextView tvViewerScore;
    private TextView tvCriticsScore;
    private TextView tvCriticsConsensus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_office_detail);
        // Fetch views
        ivPosterImage = (ImageView) findViewById(R.id.ivPosterImage);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvSynopsis = (TextView) findViewById(R.id.tvSynopsis);
        tvCast = (TextView) findViewById(R.id.tvCast);
        tvCriticsConsensus = (TextView) findViewById(R.id.tvCriticsConsensus);
        tvViewerScore =  (TextView) findViewById(R.id.tvViewerScore);
        tvCriticsScore = (TextView) findViewById(R.id.tvCriticsScore);
        // Use the movie to populate the data into our views
        BoxOfficeMovie movie = (BoxOfficeMovie)
                getIntent().getSerializableExtra("movie");
        loadMovie(movie);
    }

    // Populate the data for the movie
    public void loadMovie(BoxOfficeMovie movie) {
        // Populate data
        tvTitle.setText(movie.getTitle());
        tvCriticsScore.setText(Html.fromHtml("<b>Critics Score:</b> " + movie.getCriticsScore() + "%"));
        tvViewerScore.setText(Html.fromHtml("<b>Audience Score:</b> " + movie.getViewerScore() + "%"));
        tvCast.setText(movie.getCastList());
        tvSynopsis.setText(Html.fromHtml("<b>Synopsis:</b> " + movie.getSynopsis()));
        tvCriticsConsensus.setText(Html.fromHtml("<b>Consensus:</b> " + movie.getCriticsConsensus()));
        // R.drawable.large_movie_poster from
        // http://content8.flixster.com/movie/11/15/86/11158674_pro.jpg -->
        Picasso.with(this).load(movie.getLargePosterUrl()).
                placeholder(R.drawable.large_movie_poster).
                into(ivPosterImage);
    }

}