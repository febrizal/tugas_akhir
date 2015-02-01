package com.aplikasi.presiden;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

public class PresidenActivity extends Activity implements OnItemClickListener {
	private ListView Is_menu;

	String[] kategori = new String[] { "Ir. Soekarno", "Soeharto", "Habibie",
			"Abdurrahman Wahid", "Megawati","Soesilo Bambang Yudhoyono ","Joko widodo"

	};
	String[] Desk = new String[] { "1945-1966", "1966-1998","1998-1999", "1999-2001",
			"2001-2004", "2004-2014","2014-Sekarang"

	};
	int[] logoimg = new int[] { R.drawable.pertama, R.drawable.kedua,
			R.drawable.ketiga, R.drawable.keempat, R.drawable.kelima,R.drawable.keenam,
			R.drawable.presiden2

	};
	int[] deskripsi = new int[] { R.raw.presiden,R.raw.presiden2,R.raw.presiden3,
			R.raw.presiden4,R.raw.presiden1,R.raw.presiden7,R.raw.presidenjok
	};

	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_presiden);

		List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < 7; i++) {
			HashMap<String, String> hm = new HashMap<String, String>();

			hm.put("Judul", kategori[i]);
			hm.put("Deskripsi", Desk[i]);
			hm.put("Logo", Integer.toString(logoimg[i]));
			aList.add(hm);

			String[] from = { "Logo", "Judul", "Deskripsi" };
			int[] to = { R.id.descimg, R.id.judtxt, R.id.destxt };
			SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList,
					R.layout.menu_nama, from, to);
			Is_menu = (ListView) findViewById(R.id.listView1);
			Is_menu.setAdapter(adapter);
			Is_menu.setOnItemClickListener(this);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int posisi, long arg3) {
		// TODO Auto-generated method stub
		Intent i = new Intent(getApplicationContext(), DetailInformasi.class);
		i.putExtra("gmb", logoimg[posisi]);
		i.putExtra("nama", kategori[posisi]);
		i.putExtra("ket", deskripsi[posisi]);
		startActivity(i);
	}
}