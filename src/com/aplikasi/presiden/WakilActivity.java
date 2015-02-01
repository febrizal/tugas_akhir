package com.aplikasi.presiden;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class WakilActivity extends Activity implements OnItemClickListener {

	private ListView Is_menu;

	String[] kategori = new String[] { "Mohammad Hatta", "Hamengkubuwana IX", "Adam Malik",
			"Umar Wirahadikusumah", "Soedharmono","Try Sutrisno","Bacharuddin Jusuf Habibie",
			"Megawati Soekarnoputri","Hamzah Haz","Muhammad Jusuf Kalla","Boediono"

	};
	String[] Desk = new String[] { "1984-1973", "1973-1978","1978-1983", "1983-1988",
			"1988-1993", "1993-1998","1998","1999-2001","2001-2004","2004-2009/2015","2009-2014"

	};
	int[] logoimg = new int[] { R.drawable.wakil, R.drawable.wakil2,
			R.drawable.wakil3, R.drawable.wakil4, R.drawable.wakil5,R.drawable.wakil6,
			R.drawable.wakil7,R.drawable.kelima,R.drawable.wakil9,R.drawable.wakil10,
			R.drawable.wakil11

	};

	int[] deskripsi = new int[] { R.raw.wakil1,R.raw.wakil2,R.raw.wakil3,
			R.raw.wakil4,R.raw.wakil5,R.raw.wakil6,R.raw.wakil7,R.raw.wakil8,
			R.raw.wakil9,R.raw.wakil10,R.raw.wakil11
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wakil);
		List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < 11; i++) {
			HashMap<String, String> hm = new HashMap<String, String>();

			hm.put("Judul", kategori[i]);
			hm.put("Deskripsi", Desk[i]);
			hm.put("Logo", Integer.toString(logoimg[i]));
			aList.add(hm);

			String[] from = { "Logo", "Judul", "Deskripsi" };
			int[] to = { R.id.descimg, R.id.judtxt, R.id.destxt };
			SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList,
					R.layout.menu_nama2, from, to);
			Is_menu = (ListView) findViewById(R.id.listView1);
			Is_menu.setAdapter(adapter);
			Is_menu.setOnItemClickListener(this);
		}
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int posisi, long arg3) {
		// TODO Auto-generated method stub
		Intent i = new Intent(getApplicationContext(), DetailInformasi.class);
		i.putExtra("gmb",logoimg[posisi]);
		i.putExtra("nama", kategori[posisi]);
		i.putExtra("ket", deskripsi[posisi]);
		startActivity(i);
	}
}