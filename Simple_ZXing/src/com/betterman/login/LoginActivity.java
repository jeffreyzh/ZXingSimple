package com.betterman.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.R;
import com.google.zxing.client.android.share.ShareActivity;

public class LoginActivity extends Activity {
	Button register;
	private Button history;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		lp.gravity = Gravity.CENTER;

		LinearLayout ll = new LinearLayout(this);
		ll.setOrientation(LinearLayout.VERTICAL);
		ll.setLayoutParams(lp);

		Button decode = new Button(this);
		decode.setText("解析二维码");
		decode.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this,
						CaptureActivity.class);
				LoginActivity.this.startActivity(intent);
				LoginActivity.this.finish();

			}
		});
		ll.addView(decode);

		Button encode = new Button(this);
		encode.setText("生成二维码");
		encode.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
				intent.setClassName(LoginActivity.this,
						ShareActivity.class.getName());
				startActivity(intent);
			}
		});
		ll.addView(encode);
		
		setContentView(ll);

	}

}
