package Controle;

import Model.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Leonardo
 */
public class ControleInicial {
    public static List<Paciente> pacientes = new ArrayList<Paciente>();
    public static List<Medico> medicos = new ArrayList<Medico>();
    public static List<Consulta> consultas = new ArrayList<Consulta>();    
    public static List<Prontuario> prontuarios = new ArrayList<Prontuario>();
    public static List<Usuario> usuarios = new ArrayList<Usuario>();
    public static Usuario usuarioLogado;
    
    public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("TrabalhoPooPU");
    public static EntityManager manager = factory.createEntityManager();
    
    public static void cargaInicial(){
        /*carga Inicial de medicos*/
        ControleMedico.InserirMedico("Rafael", "Ortopedista");
        ControleMedico.InserirMedico("Andressa", "Pediatra");
        
        ControlePaciente.InserirPaciente("Natanael", "054564659-80", "65464654","M", "03/06/1990", "rua do teste", "maringá", "pr", "30242525", "99856057", "email","PARTICULAR", "part", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, Boolean.FALSE, null);
        ControlePaciente.InserirPaciente("Jaqueline", "033444556-80", "13322345","F", "03/06/1994", "rua das meninas", "maringá", "pr", "30251111", "99049889", "email", "PLANO DE SAUDE", "Amil", Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, null, Boolean.FALSE, null);
        
        ControleConsulta.InserirConsulta("01/01/2016", "15:30:50", "RETORNO", ControleMedico.retornaMedico(1),ControlePaciente.retornaPaciente(3));
        ControleConsulta.InserirConsulta("05/08/2014", "15:30:00","NORMAL",ControleMedico.retornaMedico(2), ControlePaciente.retornaPaciente(4));
        
        ControleProntuario.InserirProntuario("01/01/2016", "15:35:00", ControleMedico.retornaMedico(1), ControlePaciente.retornaPaciente(3), "dor", "virose", "repouso");
        ControleProntuario.InserirProntuario("05/08/2014", "15:35:00", ControleMedico.retornaMedico(2), ControlePaciente.retornaPaciente(4), "dor", "virose", "repouso");
        
        ControleUsuario.InserirUsuario("adm","adm","adm",null);
        ControleUsuario.InserirUsuario("medico","medico","medico",ControleMedico.retornaMedico(2));
        ControleUsuario.InserirUsuario("secretaria","secretaria","secretaria",null);
    }
}
