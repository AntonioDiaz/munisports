package com.adiaz.munisports.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.adiaz.munisports.R;
import com.adiaz.munisports.utilities.MuniSportsConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class FootballActivity extends AppCompatActivity {

	@BindView(R.id.toolbar) Toolbar toolbar;
	@BindView(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbar;
	@BindView(R.id.tv_title) TextView tvTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_football);
		ButterKnife.bind(this);
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		collapsingToolbar.setTitle(getString(R.string.football));
		SharedPreferences preferences = getDefaultSharedPreferences(this);
		String townSelect = preferences.getString(MuniSportsConstants.KEY_TOWN_NAME, null);
		tvTitle.setText(townSelect + " - " + getString(R.string.app_name));
	}

	@Override
	public boolean onSupportNavigateUp() {
		onBackPressed();
		return true;
	}

	public void openFootball(View view) {
		Intent intent = new Intent(this, SelectCompetitionActivity.class);
		intent.putExtra(MuniSportsConstants.INTENT_SPORT_TAG, (String)view.getTag());
		startActivity(intent);
	}
}
