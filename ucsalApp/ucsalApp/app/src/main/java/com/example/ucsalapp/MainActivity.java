package com.example.ucsalapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editEmail = findViewById(R.id.editEmail);
        EditText editSenha = findViewById(R.id.editSenha);
        Button btnEntrar = findViewById(R.id.btnEntrar);
        TextView textEsqueciSenha = findViewById(R.id.textEsqueciSenha);

        btnEntrar.setOnClickListener(v -> {
            String email = editEmail.getText().toString();
            String senha = editSenha.getText().toString();

            if (email.isEmpty()) {
                editEmail.setError("O e-mail é obrigatório");
                return;
            }

            if (senha.isEmpty()) {
                editSenha.setError("A senha é obrigatória");
                return;
            }

            if (email.equals("teste@ucsal.br") && senha.equals("123")) {
                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "E-mail ou senha inválidos", Toast.LENGTH_SHORT).show();
            }
        });

        textEsqueciSenha.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Recuperação de senha em breve!", Toast.LENGTH_SHORT).show();
        });
    }
}