package com.android.fish.json;

import java.util.LinkedList;

import android.app.Activity;
import android.graphics.Paint.Join;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView textView;
	private Button button1;
	private Button button2;
	private Button button3;
	private String jsonData = "[{\"name\":\"Michael\",\"age\":20},{\"name\":\"Mike\",\"age\":21}]";
	private String jsonUser = "{\"name\":\"Michael\",\"age\":20}";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		textView = (TextView) findViewById(R.id.textView);
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				JsonUtils.parseJson(jsonData);
			}
		});
		
		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				User user = (User) JsonUtils.parseJsonToObject(jsonUser, User.class);
				textView.setText("key & val -> " + user.getName() + "|" + user.getAge());
			}
		});
		
		button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				LinkedList<Object> users = (LinkedList<Object>) JsonUtils.parseJsonToList(jsonData, User.class);
				StringBuilder sb = new StringBuilder();
				for (Object obj : users)
				{
					System.out.println("object : " + obj);
					/*User user = (User) obj;
					sb.append("key : ").append(user.getName());
					sb.append(" val : ").append(user.getAge());
					sb.append("\n");*/
				}
				textView.setText(sb);
			}
		});
		
	}
	
}