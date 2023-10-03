package com.l20290958.miprimeraapp_login.usuario.repository;
import java.util.HashMap;
import com.l20290958.miprimeraapp_login.usuario.model.Usuario;

public class UsuarioRepository {
    private static UsuarioRepository repository = null;
    private HashMap< String, HashMap<String, Usuario> > registeredUsers;

    private UsuarioRepository() {
        Usuario u1 = new Usuario("Coahuila", "1", "Solovino",
                21, 'h', "ptazos@gmail.com");
        Usuario u2 = new Usuario("Iris", "1", "gatumadre",
                45, 'm', "balazos@gmail.com");
        Usuario u3 = new Usuario("Siu", "1", "atum",
                96, 'm', "brgazos@gmail.com");

        this.registeredUsers = new HashMap<String, HashMap<String, Usuario> >();

        registeredUsers.put(u1.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u1.getUsuario()).put(u1.getPass(), u1);

        registeredUsers.put(u2.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u2.getUsuario()).put(u2.getPass(), u2);

        registeredUsers.put(u3.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u3.getUsuario()).put(u3.getPass(), u3);
    }

    public static UsuarioRepository getInstance() {
        if (repository == null)
            repository = new UsuarioRepository();

        return repository;
    }

    public HashMap<String, HashMap<String, Usuario>> getRegisteredUsers() {
        return registeredUsers;
    }
}