package com.aplikasi.presiden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailInformasi extends Activity {

	int gmb,ket;
	String nama;

	ImageView banimg;
	TextView txtnama, txtket;
	WebView webview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_informasi);

		gmb = getIntent().getExtras().getInt("gmb", 0);
		nama = getIntent().getExtras().getString("nama");
		ket = getIntent().getExtras().getInt("ket",0);

		banimg = (ImageView) findViewById(R.id.imgGmb);
		txtnama = (TextView) findViewById(R.id.txtNama);
		// txtket=(TextView)findViewById(R.id.txtKet);

		webview = (WebView) findViewById(R.id.soekarnoket);

		String content = loadStringFromRawResource(getResources(),
				ket);

		String mimeType = "text/html";
		String encoding = "UTF-8";

		webview.loadDataWithBaseURL("file:///android_asset", content, mimeType,
				encoding, null);

		banimg.setImageResource(gmb);
		txtnama.setText(nama);
		// txtket.setText(ket);

	}

	private String loadStringFromRawResource(Resources resources, int resId) {
		InputStream rawResource = resources.openRawResource(resId);
		String content = streamToString(rawResource);
		try {
			rawResource.close();
		} catch (IOException e) {
		}
		return content;

	}

	private String streamToString(InputStream in) {
		String l;
		BufferedReader r = new BufferedReader(new InputStreamReader(in));
		StringBuilder s = new StringBuilder();
		try {
			while ((l = r.readLine()) != null) {
				s.append(l + "\n");
			}
		} catch (IOException e) {
		}
		return s.toString();
	}

}
