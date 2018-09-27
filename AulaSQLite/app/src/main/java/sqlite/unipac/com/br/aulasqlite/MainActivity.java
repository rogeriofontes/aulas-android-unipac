package sqlite.unipac.com.br.aulasqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookDAO db = new BookDAO(this);

        //db.addBook(new Book("Android Application Development Cookbook", "Wei Meng Lee"));
        //db.addBook(new Book("Android Programming: The Big Nerd Ranch Guide", "Bill Phillips and Brian Hardy"));
        //db.addBook(new Book("Learn Android App Development", "Wallace Jackson"));

        db.addBook(new Book("Livro de Java", "Rogério Fontes"));
        db.addBook(new Book("Livro de Java 2", "Rogério Fontes"));
        db.addBook(new Book("Livro de Java 3", "Rogério Fontes"));

        List<Book> list = db.getAllBooks();
        for (Book b: list) {
            Log.i("Data","Book " + b.toString());
        }
        db.deleteBook(list.get(0));
        db.getAllBooks();
    }
}
