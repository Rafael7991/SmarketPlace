package com.mycompany.marketplace;

import java.util.ArrayList;
import java.util.List;

public class AppManager {

    private static AppManager instance;
    private List<Usuario> usuarios;

    private AppManager() {
        usuarios = new ArrayList<>();
        Master master = new Master("admin", "admin");
        master.setNome("administrador");
        Cliente cliente = new Cliente("c","c");
        cliente.setNome("cliente");
        Filiada filiada = new Filiada("a","a");
        filiada.setNome("Regina");
        usuarios.add(master);
        usuarios.add(cliente);
        usuarios.add(filiada);
    }

    public static AppManager getInstance() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);

        for (Usuario a : usuarios) {

            System.out.println("username: " + a.getUserName());
            System.out.println("senha: " + a.getSenha());

        }
    }

    public Usuario autenticarUsuario(String userName, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUserName().equals(userName) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }
}
