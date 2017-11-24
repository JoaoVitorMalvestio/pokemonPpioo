package Controle;

import Model.Consulta;
import Model.Medico;
import Model.Paciente;
import javax.swing.JOptionPane;
import static Controle.ControleInicial.manager;
import java.util.concurrent.ExecutionException;

public class ControleConsulta {
    public static boolean validaConsulta(String data, String horario, String tipo, Medico medico, Paciente paciente){
        return !(data.isEmpty()||
                horario.isEmpty() ||
                tipo.isEmpty() ||
                medico == null ||
                paciente == null);
    }
    
    public static void InserirConsulta(String data, String horario, String tipo, Medico medico, Paciente paciente ){
        Consulta consulta = new Consulta(data, horario, tipo, medico, paciente);
        try{
            manager.getTransaction().begin();
            manager.persist(consulta);
            manager.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }     
    
    public static void EditarConsulta(int codigo,String data, String horario, String tipo,Medico medico, Paciente paciente ){
        Consulta consulta = new Consulta();
        try{
            manager.getTransaction().begin();
            consulta = manager.find(Consulta.class, codigo);
            consulta.setData(data);
            consulta.setHorario(horario);
            consulta.setTipo(tipo);
            consulta.setMedico(medico);
            consulta.setPaciente(paciente);                
            manager.merge(consulta);
            manager.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }    
    } 
    
    public static void RemoverConsulta(int codigo){        
        Consulta consulta = new Consulta();
        try{
            manager.getTransaction().begin();
            consulta = manager.find(Consulta.class, codigo);
            consulta.setInativo(true);
            manager.merge(consulta);
            manager.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static Consulta retornaConsulta(int codigo){
        Consulta consulta = new Consulta();
        try{
            consulta = manager.find(Consulta.class, codigo);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return consulta;
    }
}
