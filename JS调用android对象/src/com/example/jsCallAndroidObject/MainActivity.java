package com.example.jsCallAndroidObject;

import JS.MyJSObject;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private WebView mWebView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		
		testWebView();
		
		
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@SuppressLint("JavascriptInterface")
	private void testWebView() {
		WebSettings webSettings= mWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		//使用file协议加载本地asset目录下的html文件
		mWebView.loadUrl("file:///android_asset/FirstHtml.html");
		//将MyJSObject 对象以 "FirstJSCallAndroidObject" js对象名   暴露给JS对象，  JS对象名为"FirstJSCallAndroidObject"  
		mWebView.addJavascriptInterface(new MyJSObject(MainActivity.this), "FirstJSCallAndroidObject");
		
	}

	private void initView() {
		mWebView=(WebView)this.findViewById(R.id.wv_test);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
