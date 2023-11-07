package com.aakkaya.androidjavasqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //Veritabanı ve Tablo Oluşturuldu
            SQLiteDatabase database=this.openOrCreateDatabase("UrfaMuzigi",MODE_PRIVATE,null);
            //muzikler isminde id,name ve age alanları bulunan bir tablo oluşturuldu.
            database.execSQL("CREATE TABLE IF NOT EXISTS muzikler (id INTEGER PRIMARY KEY,name VARCHAR,age INT)");

            //Veri Ekleme
            //alttaki 3 satırlık kod alanı kayıt ekleme işlemini yapar.
            //database.execSQL("INSERT INTO muzikler(name,age) VALUES('Kazancı Bedih',70)");
            //database.execSQL("INSERT INTO muzikler(name,age) VALUES('Seyfettin Sucu',60)");
            //database.execSQL("INSERT INTO muzikler(name,age) VALUES('İbrahim Tatlıses',72)");

            //Güncelleme İşlemleri
            //Kayıtlarda bulunan Kazancı Bedih isimli kaydın yaşı 85 olarak güncelleyelim
            //database.execSQL("UPDATE muzikler SET age=85 WHERE name='Kazancı Bedih'");
            //id si 2 olan kaydın ismini Keddare olarak değiştirelim.
            //database.execSQL("UPDATE muzikler SET name='Keddare' WHERE id=2");

            //Silme İşlemleri
            //id si 2 olan kaydı silelim
            //database.execSQL("DELETE FROM muzikler WHERE id=2");

            //Sorgu ve Filtreleme İşlemleri
            //Cursor cursor=database.rawQuery("SELECT * FROM muzikler WHERE name='Kazancı Bedih'",null);
            //Cursor cursor = database.rawQuery("SELECT * FROM muzikler WHERE name LIKE 'K%'",null);

            //Cursor nesnesi tüm kayıtlar üzerinde gezinme işlemi yapar
            Cursor cursor=database.rawQuery("SELECT * FROM muzikler",null);
            //alttaki 3 satırlık tanımlamalarda alanlara ilişkin indexler oluşturuldu


            int idIx=cursor.getColumnIndex("id");
            int ageIx=cursor.getColumnIndex("age");
            int nameIx=cursor.getColumnIndex("name");

            while (cursor.moveToNext()){
                System.out.println("Sanatçı id : "+cursor.getString(idIx));
                System.out.println("Sanatçı adı : "+cursor.getString(nameIx));
                System.out.println("Sanatçı Yaşı : "+cursor.getString(ageIx));
            }

            cursor.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}