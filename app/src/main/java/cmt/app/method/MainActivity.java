package cmt.app.method;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnclick(View view){
        long start = Utils.start();
        file();
        edit();
        view();
        Utils.end(start, this);

    }
    private void file(){
        long start = Utils.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
        Utils.end(start,this);

    }
    private void edit(){
        long start = Utils.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Utils.end(start,this);

    }
    private void view(){
        long start = Utils.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                code();
            }
        }).start();
        Utils.end(start,this);

    }
    private void code(){
        long start = Utils.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Utils.end(start,this);

    }
}
