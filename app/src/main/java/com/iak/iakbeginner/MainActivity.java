package com.iak.iakbeginner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // variable = tempat menampung nilai
    // int = angka
    // double = angka pakai koma
    // string = semua karakter
    // variable username
    // type_data(string, int, double) nama_variable
    private String username;
    private String bio;
    private String nomorHandphone;
    private String gender;

    // view TextView username
    private TextView textViewUsername;
    // view EditText bio
    private EditText editTextBio;
    // view EditText nomor handphone
    private EditText editTextNomorHandphone;
    // view RadioGroup gender
    private RadioGroup radioGroupGender;
    // view RadioButton gender pria
    private RadioButton radioButtonGenderPria;
    // view RadioButton gender wanita
    private RadioButton radioButtonGenderWanita;
    // view Button buttonSave
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // temukan TextView dengan id text_view_user_name
        textViewUsername = findViewById(R.id.text_view_user_name);
        // set text ke textViewUsername
        textViewUsername.setText("Devi Hawana");

        // temukan EditText dengan id edit_text_bio
        editTextBio = findViewById(R.id.edit_text_bio);

        // temukan EditText dengan id edit_text_nomor_handphone
        editTextNomorHandphone = findViewById(R.id.edit_text_nomor_handphone);

        // temukan RadioGroup dengan id radio_group_gender
        radioGroupGender = findViewById(R.id.radio_group_gender);

        // temukan RadioButton dengan id radio_button_pria
        radioButtonGenderPria = findViewById(R.id.radio_button_pria);

        // temukan RadioButton dengan id radio_button_wanita
        radioButtonGenderWanita = findViewById(R.id.radio_button_wanita);

        // temukan Button dengan id button_save
        buttonSave = findViewById(R.id.button_save);

        // empty string
        gender = "";

        // beri listener onCheckedChange pada RadioGroupGender
        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                // kode berikut akan diexecute ketika salah satu
                // radio button gender di pilih
                switch (id) {
                    case R.id.radio_button_pria:
                        gender = radioButtonGenderPria.getText().toString();
                        break;
                    case R.id.radio_button_wanita:
                        gender = radioButtonGenderWanita.getText().toString();
                        break;
                }
            }
        });

        // Beri listener on click ke buttonSave
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kode didalam ini akan diexecute ketika buttonSave ditekan

                // Ambil nilai text dari editTextBio dan
                // konversi ke dalam bentuk string
                bio = editTextBio.getText().toString();

                // Ambil nilai text dari editTextNomorHandphone dan
                // konversi ke dalam bentuk string
                nomorHandphone = editTextNomorHandphone.getText().toString();


                if (bio.isEmpty()) {
                    // Jika EditTextBio belum di isi oleh si pengguna
                    // maka, tampilkan pesan validasi gagal
                    Toast.makeText(
                            MainActivity.this,
                            "Anda belum mengisi field bio",
                            Toast.LENGTH_LONG
                    ).show();
                } else if (gender.isEmpty()) {
                    // Jika RadioGroupGender belum di pilih oleh si pengguna
                    // maka, tampilkan pesan validasi gagal
                    Toast.makeText(
                            MainActivity.this,
                            "Anda belum memilih gender",
                            Toast.LENGTH_LONG
                    ).show();
                } else if (nomorHandphone.isEmpty()) {
                    // Jika EditTextNomorHandphone belum di isi oleh si pengguna
                    // maka, tampilkan pesan validasi gagal
                    Toast.makeText(
                            MainActivity.this,
                            "Anda belum mengisi nomor handphone",
                            Toast.LENGTH_LONG
                    ).show();
                } else {
                    // Jika validasi berhasil

                    // Ambil nilai text dari textViewUsername dan
                    // konversi ke dalam bentuk string
                    username = textViewUsername.getText().toString();

                    // Tampilkan message kepada pengguna dalam bentuk Toast
                    Toast.makeText(
                            MainActivity.this,
                            "Data " + username + " berhasil disimpan",
                            Toast.LENGTH_LONG
                    ).show();
                }
            }
        });

    }
}
