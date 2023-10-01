package com.l20290958.miprimeraapp_login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //private HashMap<String,String> registeredUsers = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnIngresarTap(View view){
        //AlertDialog.Builder builder = new AlertDialog.Builder(this);  ¿Por qué comentó esto?

        //AlertDialog dialog = builder.create();    ¿Y esto?

        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etPass    = findViewById(R.id.etPass);

        String user,pass;
        user = etUsuario.getText().toString();
        pass = etPass.getText().toString();

        if( !registeredUsers.containsKey(user)){
            //dialog.setTitle("Atención ");           //INSTANCIA
            //dialog.setMessage("La contraseña no coincide");       ¿Por qué comentó esto?
            //dialog.show();
            this.createAlertDialog("Atención", "Usuario no registrado").show();
            return;
        }

        if( !registeredUsers.get(user).equals(pass) ){
            //dialog.setTitle("Felicidades, has iniciado sesión");
            //dialog.setMessage(String.format("Datos ingresados\nUsuario: %s\nPassword: %s",user,pass));        ¿Y esto?
            //dialog.show();
            this.createAlertDialog("Atención", "La contraseña no coincide").show();
            return;
        }


    }

}