package Controle;

import Model.Medico;
import static Controle.ControleInicial.manager;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Leonardo
 */
public class ControleMedico {

    public static boolean validaMedico(String nome, String atuacao) {
        return !(nome.isEmpty() || atuacao.isEmpty());
    }

    public static void InserirMedico(String nome, String atuacao) {
        Medico medico = new Medico(nome, atuacao);
        try {
            manager.getTransaction().begin();
            manager.persist(medico);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void EditarMedico(int codigo, String nome, String atuacao) {
        try {
            manager.getTransaction().begin();
            Medico medico = manager.find(Medico.class, codigo);
            medico.setNome(nome);
            medico.setAtuacao(atuacao);
            manager.merge(medico);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void RemoverMedico(int codigo) {
        try {
            manager.getTransaction().begin();
            Medico medico = manager.find(Medico.class, codigo);
            medico.setInativo(true);
            manager.merge(medico);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Medico retornaMedico(int codigo) {
        Medico medico = null;
        try {
            medico = manager.find(Medico.class, codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medico;
    }

}
