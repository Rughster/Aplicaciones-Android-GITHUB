package com.l20290958.miprimeraapp_login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.l20290958.miprimeraapp_login.usuario.model.Usuario;
import com.l20290958.miprimeraapp_login.usuario.repository.UsuarioRepository;

import com.l20290958.miprimeraapp_login.R;
public class DashboardUsuario extends AppCompatActivity {

    private UsuarioRepository ur;
    private Usuario userInfo;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_usuario);
        //
        ur = UsuarioRepository.getInstance();
        //Manera en que recibimos info de otro activity
        String usuario = getIntent().getStringExtra("usuario");
        String pass = getIntent().getStringExtra("pass");

        //Obtener info del usuario logueado
        userInfo = ur.getRegisteredUsers().get(usuario).get(pass);

        //toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
    }
}