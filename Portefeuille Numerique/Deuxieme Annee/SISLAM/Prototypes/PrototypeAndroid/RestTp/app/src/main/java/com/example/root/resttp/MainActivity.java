package com.example.root.resttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtView = (TextView) findViewById(R.id.txt);
        final TextView txtResult = (TextView) findViewById(R.id.textResult);
        final EditText txtId = (EditText) findViewById(R.id.editText);
        final EditText txtLogin = (EditText) findViewById(R.id.editText2);
        final EditText txtUser = (EditText) findViewById(R.id.editText3);
        final EditText txtId2 = (EditText) findViewById(R.id.editId2);

        Button valider  = (Button) findViewById(R.id.button);
        Button select = (Button) findViewById(R.id.button2);

        final RequestQueue queue = Volley.newRequestQueue(this);

        valider.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                String url ="http://192.168.43.115/tpRestServer/utilisateurs/"+txtId.getText().toString()+"/"+txtLogin.getText().toString()+"/"+txtUser.getText().toString();
                StringRequest stRq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String[] list = response.split(" ");
                        for(int i = 0; i<list.length; i++)
                        {
                            txtView.setText(list[i]);
                        }


                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        txtView.setText("That didn't work!");
                    }

                }
                );
                queue.add(stRq);

            }
        });

        select.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String url ="http://192.168.43.115/tpRestServer/utilisateurs/"+txtId2.getText().toString();
                StringRequest stRq = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        int x = 0, y = 0;
                        x = response.indexOf("{");
                        y = response.indexOf("}") + 2;
                        txtResult.setText(response.substring(x, y));
                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        txtResult.setText("That didn't work!");
                    }

                }
                );
                queue.add(stRq);

            }
        });
    }
}


