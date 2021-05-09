package sg.edu.np.madweek3practical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageButton;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView button = findViewById(R.id.imgProfile);
        button.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View v ){

              userQuery();


            }
        });





    }

    private int generateRandNum() {

        Random ran = new Random();
        int ranVal = ran.nextInt();
        return ranVal;

    }

    private void userQuery(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

       builder.setTitle("Profile");
       builder.setMessage("MADness");
       builder.setCancelable(true);
       builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {


               generateRandNum();
               Intent intent = new Intent(ListActivity.this, MainActivity.class);
               int number = generateRandNum();
               intent.putExtra("Integer", number);
               startActivity(intent);

           }
       });

        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();

    }

}



