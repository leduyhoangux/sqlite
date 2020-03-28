package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtHoTen , edtNS , edtTruong;
    RadioButton rdNam , rdNu;
    CheckBox cbTheThao , cbDuLich , cbDocSach;
    Button btnNhap ,btnNhapLai;

    SinhVienDaTaBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtHoTen = findViewById(R.id.editHoTen);
        edtNS = findViewById(R.id.edtNS);
        edtTruong=findViewById(R.id.edtTruong);

        rdNam = findViewById(R.id.rdNam);
        rdNu = findViewById(R.id.rdNu);

        cbDocSach = findViewById(R.id.cbDocSach);
        cbDuLich = findViewById(R.id.cbDuLich);
        cbTheThao = findViewById(R.id.cbTheThao);

        btnNhap = findViewById(R.id.btnNhap);
        btnNhapLai = findViewById(R.id.btnNhaplai);
        btnNhapLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtHoTen.setText(" ");
                edtNS.setText(" ");
                edtTruong.setText(" ");
                rdNam.setChecked(true);
                cbDocSach.setChecked(false);
                cbDuLich.setChecked(false);
                cbTheThao.setChecked(false);



            }
        });
            btnNhap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int gt =0;
                    String soThich = " ";
                    String hoTen = edtHoTen.getText().toString();
                    String namSinh = edtNS.getText().toString();
                    String truong = edtTruong.getText().toString();

                    if(rdNu.isChecked()){
                        gt =1;
                    }
                    if(cbTheThao.isChecked()){
                        soThich +="," + cbTheThao.getText().toString();

                    }if (cbDuLich.isChecked()){
                        soThich +="," + cbDuLich.getText().toString();
                    }if (cbDocSach.isChecked()){
                        soThich +="," + cbDocSach.getText().toString();
                    }
                    SinhVienModel svThem = new SinhVienModel(hoTen , namSinh,truong,soThich,gt);
                    if(svThem==null ){
                        db.ThemSinhVien(svThem);
                        Toast.makeText(MainActivity.this, "Thành Công", Toast.LENGTH_SHORT).show();
                    }

                }
            });



    }
}
