package Controle;

import Model.Medico;
import Model.Paciente;
import Model.Prontuario;

import static Controle.ControleInicial.manager;
import static Controle.ControleInicial.usuarios;
import Model.Usuario;
import Model.Medico;

/**
 *
 * @author Leonardo
 */
public class ControleProntuario {

    public static boolean validaProntuario(String data, String horario, Medico medico, Paciente paciente, String sintomas, String diagnostico, String prescricao) {
        System.out.println(data);
        System.out.println(horario);
        System.out.println(medico);
        System.out.println(paciente);
        
        return !(data.isEmpty()
                || horario.isEmpty()
                || medico == null
                || paciente == null);
    }

    public static void InserirProntuario(String data, String horario, Medico medico, Paciente paciente, String sintomas, String diagnostico, String prescricao) {
        Prontuario prontuario = new Prontuario(medico, paciente, sintomas,diagnostico , prescricao, data, horario);
        try {
            manager.getTransaction().begin();
            manager.persist(prontuario);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void EditarProntuario(int codigo, String data, String horario, Medico medico, Paciente paciente, String sintomas, String diagnostico, String prescricao) {
        try {
            manager.getTransaction().begin();
            Prontuario prontuario = manager.find(Prontuario.class, codigo);
            prontuario.setDataModificacao(data);
            prontuario.setHoraModificacao(horario);
            prontuario.setMedico(medico);
            prontuario.setPaciente(paciente);
            prontuario.setSintoma(sintomas);
            prontuario.setDiagnostico(diagnostico);
            prontuario.setPrescricao(prescricao);
            manager.merge(prontuario);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void RemoverProntuario(Integer codigo) {
        try {
            manager.getTransaction().begin();
            Prontuario prontuario = manager.find(Prontuario.class, codigo);
            prontuario.setInativo(true);
            manager.merge(prontuario);
            manager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public static Prontuario retornaProntuario(int codigo) {
        Prontuario prontuario = new Prontuario();
         try {
            prontuario = manager.find(Prontuario.class, codigo);
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return prontuario;
    }

}
