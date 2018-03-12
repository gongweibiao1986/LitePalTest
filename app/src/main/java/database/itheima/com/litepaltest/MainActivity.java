package database.itheima.com.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase = (Button)findViewById(R.id.create_database);
        Button addData = (Button)findViewById(R.id.add_data);
        Button updateData = (Button)findViewById(R.id.update_data);
        Button deleteData = (Button)findViewById(R.id.delete_data);
        Button queryData = (Button)findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = DataSupport.findAll(Book.class);
                for(Book book:books){
                    Log.d("MainActivity","boo name is"+book.getName());
                    Log.d("MainActivity","boo author is"+book.getAuthor());
                    Log.d("MainActivity","boo pages is"+book.getPages());
                    Log.d("MainActivity","boo price is"+book.getPrice());
                    Log.d("MainActivity","boo press is"+book.getPress());

                }
            }
        });
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Book.class,"price<?","15");
            }
        });
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setPrice(14.95);
                book.setPress("Anchor");
                book.updateAll("name=? and author=?","The lost Symbol","Dan Brown");
            }
        });
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("Unknoe");
                book.save();
            }
        });
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });
    }
}
