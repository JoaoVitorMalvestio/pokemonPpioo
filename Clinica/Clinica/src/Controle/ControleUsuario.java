package Controle;

import static Controle.ControleInicial.manager;
import static Controle.ControleInicial.usuarios;
import Model.Usuario;
import Model.Medico;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Leonardo
 */
public class ControleUsuario {

    public static boolean validaUsuario(String login, String senha, String tipo, Medico medico) {
        if (tipo == "medico" && medico == null) {
            return false;
        }

        return !(login.isEmpty()
                || senha.isEmpty()
                || tipo.isEmpty());
    }

    public static void InserirUsuario(String login, String senha, String tipo, Medico medico) {
        Usuario usuario = new Usuario(login, senha, tipo, medico);
        try {
            manager.getTransaction().begin();
            manager.persist(usuario);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void EditarUsuario(int codigo, String login, String senha, String tipo, Medico medico) {
        try {
            manager.getTransaction().begin();
            Usuario usuario = manager.find(Usuario.class, codigo);
            usuario.setLogin(login);
            usuario.setSenha(senha);
            usuario.setTipo(tipo);
            usuario.setMedico(medico);

            manager.merge(usuario);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void RemoverUsuario(int codigo) {
        try {
            manager.getTransaction().begin();
            Usuario usuario = manager.find(Usuario.class, codigo);
            usuario.setInativo(true);
            manager.merge(usuario);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Usuario retornaUsuario(int codigo) {
        Usuario usuario = null;
        try {usuario = manager.find(Usuario.class, codigo);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public static Usuario validaUsuario(String login, String senha) {
        Usuario usuarioret = null;

        TypedQuery<Usuario> query = manager.createNamedQuery("Usuario.findAll", Usuario.class);
        List<Usuario> usuarios = query.getResultList();

        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                if (usuario.getSenha().equals(senha)) {
                    usuarioret = usuario;
                }
            }
        }
        return usuarioret;
    }
}
