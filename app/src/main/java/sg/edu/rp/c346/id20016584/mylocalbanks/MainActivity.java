package sg.edu.rp.c346.id20016584.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS, tvOCBC, tvUOB;
    String wordclick="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS=findViewById(R.id.textViewDBS);
        tvOCBC=findViewById(R.id.textViewOCBC);
        tvUOB=findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        menu.add(0, 2, 2, "Favourites");
        if(v==tvDBS){
            wordclick="DBS";
        }else if(v==tvOCBC){
            wordclick="OCBC";
        }else{
            wordclick="UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(wordclick=="DBS"){
            if(item.getItemId()==0){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            }else if(item.getItemId()==1){
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+18001111111"));
                startActivity(intentCall);
            }else if(item.getItemId()==2){
                if(tvDBS.getCurrentTextColor()!=Color.RED){
                    tvDBS.setTextColor(Color.RED);
                }else{
                    tvDBS.setTextColor(Color.BLACK);
                }
            }
        }else if(wordclick=="UOB"){
            if(item.getItemId()==0){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            }else if(item.getItemId()==1){
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+18002222121"));
                startActivity(intentCall);
            }else if(item.getItemId()==2){
                if(tvUOB.getCurrentTextColor()!=Color.RED){
                    tvUOB.setTextColor(Color.RED);
                }else{
                    tvUOB.setTextColor(Color.BLACK);
                }
            }
        }else{
            if(item.getItemId()==0){
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            }else if(item.getItemId()==1){
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+18003633333"));
                startActivity(intentCall);
            }else if(item.getItemId()==2){
                if(tvOCBC.getCurrentTextColor()!=Color.RED){
                    tvOCBC.setTextColor(Color.RED);
                }else{
                    tvOCBC.setTextColor(Color.BLACK);
                }
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.englishselect){
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
        }else if(id==R.id.chineseselect){
            tvUOB.setText("大华银行");
            tvOCBC.setText("华侨银行");
            tvDBS.setText("星展银行");
        }else{
            tvUOB.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvDBS.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);
    }
}