package com.l20290958.miprimeraapp_login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.l20290958.miprimeraapp_login.usuario.repository.UsuarioRepository;

public class MainActivity extends AppCompatActivity {
    private UsuarioRepository ur;
    //private HashMap<String,String> registeredUsers = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ur = UsuarioRepository.getInstance(); //No constructor ??
    }

    private AlertDialog createAlertDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(title).setMessage(message);        //<--Inovcación anidada
        return builder.create();
    }

    public void onBtnIngresarTap(View view){
        //AlertDialog.Builder builder = new AlertDialog.Builder(this);  ¿Por qué comentó esto?

        //AlertDialog dialog = builder.create();    ¿Y esto?

        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etPass    = findViewById(R.id.etPass);

        String user,pass;
        user = etUsuario.getText().toString();
        pass = etPass.getText().toString();

        if( !ur.getRegisteredUsers().containsKey(user) ){
            //dialog.setTitle("Atención ");           //INSTANCIA
            //dialog.setMessage("La contraseña no coincide");       ¿Por qué comentó esto?
            //dialog.show();
            this.createAlertDialog("Atención", "Usuario no registrado").show();
            return;
        }

        if( !ur.getRegisteredUsers().get(user).containsKey(pass) ){
            //dialog.setTitle("Felicidades, has iniciado sesión");
            //dialog.setMessage(String.format("Datos ingresados\nUsuario: %s\nPassword: %s",user,pass));        ¿Y esto?
            //dialog.show();
            this.createAlertDialog("Atención", "La contraseña no coincide").show();
            return;
        }

        String message="Felicidades ha iniciado sesión con éxito";
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, DashboardUsuario.class);    //Quien lo va a invocar, quien será invocado/lanzado
        i.putExtra("usuario",user);
        i.putExtra("pass",pass);
        startActivity(i);
    }

}