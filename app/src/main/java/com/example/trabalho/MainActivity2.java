package com.example.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends Activity implements OnItemClickListener {
    ListView listView;
    private ListView lvSelecoesCopa;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        lvSelecoesCopa = (ListView) findViewById( R.id.lvSelecoesCopa );

        String itens[] = { "Alemanha", "Argentina", "Holanda", "Colombia",
                "Belgica", "Uruguai", "Brasil" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String> ( this,
                android.R.layout.simple_list_item_1, itens );

        lvSelecoesCopa.setAdapter( adapter );

        lvSelecoesCopa.setOnItemClickListener( new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                tratarOpcoesItem( arg2 );

            }
        } );



        listView = (ListView) findViewById(R.id.sportsList);
        listView.setOnItemClickListener(this);

        TextView txtView = (TextView) findViewById(R.id.txtView);
        txtView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(),
                        "Você precionou de forma longaaaa:)", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "Não foi longo :(",
                        Toast.LENGTH_LONG).show();
            }
        });



        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(getApplicationContext(), button1);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.poupup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                getApplicationContext(),
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });

                popup.show();
            }
        });







        Button btn_china =  findViewById(R.id.button_vtn);
        btn_china.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                Toast.LENGTH_SHORT).show();
    }


    protected void tratarOpcoesItem( int posicao ) {
        int posFifa = posicao + 1;

        Toast.makeText( this, "Posição no Ranking: " + posFifa , Toast.LENGTH_LONG ).show();
    }
}