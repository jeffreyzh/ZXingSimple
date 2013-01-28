package com.betterman.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.R;

public class LoginActivity extends Activity
{
	Button register;
	private Button history;
  
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
      // TODO Auto-generated method stub
      super.onCreate(savedInstanceState);
      setContentView(R.layout.register);
      

      register = (Button)findViewById(R.id.ok);
      
      history =(Button) findViewById(R.id.history);
      
      register.setOnClickListener(new OnClickListener()
      {
          
          @Override
          public void onClick(View v)
          {
              Intent intent = new Intent(LoginActivity.this,CaptureActivity.class);
              LoginActivity.this.startActivity(intent);
              LoginActivity.this.finish();
              
          }
      });
      
      history.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
//		    Intent intent = new Intent(LoginActivity.this,HistoryActivity.class);
//            LoginActivity.this.startActivity(intent);
//            LoginActivity.this.finish();
		}
	});
      
  }

}
