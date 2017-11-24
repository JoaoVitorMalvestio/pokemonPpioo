package Controle;
import Model.Paciente;
/**
 *
 * @author Leonardo
 */
import static Controle.ControleInicial.manager;

public class ControlePaciente {
    public static boolean validaPaciente(String nome, String cpf, String rg, String sexo, String dtNascimento, String endereco,String cidade, String uf, String telefone, String celular, String email, String convenio,String descConvenio,Boolean fumante, Boolean alcool, Boolean colesterol, Boolean diabetico, Boolean doencaCardiaca, Boolean cirurgia, String descCirurgia, Boolean alergia, String descAlergia){
     return !(nome.isEmpty()||
             cpf.isEmpty()||
             rg.isEmpty()||
             sexo.isEmpty()||
             dtNascimento.isEmpty()||
             endereco.isEmpty()||
             cidade.isEmpty()||
             uf.isEmpty()||
             telefone.isEmpty()||
             convenio.isEmpty());   
    }
    
    
    public static void InserirPaciente(String nome, String cpf, String rg, String sexo, String dtNascimento, String endereco,String cidade, String uf, String telefone, String celular, String email, String convenio,String descConvenio,Boolean fumante, Boolean alcool, Boolean colesterol, Boolean diabetico, Boolean doencaCardiaca, Boolean cirurgia, String descCirurgia, Boolean alergia, String descAlergia){
        Paciente paciente = new Paciente(nome, cpf, rg, sexo, dtNascimento, endereco, cidade, uf, telefone, celular, email, convenio, descConvenio, fumante, alcool, colesterol, diabetico, doencaCardiaca, cirurgia, descCirurgia, alergia, descAlergia);
        
        try{
           manager.getTransaction().begin();
           manager.persist(paciente);
           manager.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }     
    
    public static void EditarPaciente(int codigo,String nome, String cpf, String rg, String sexo, String dtNascimento, String endereco,String cidade, String uf, String telefone, String celular, String email, String convenio,String descConvenio,Boolean fumante, Boolean alcool, Boolean colesterol, Boolean diabetico, Boolean doencaCardiaca, Boolean cirurgia, String descCirurgia, Boolean alergia, String descAlergia){        
        try{
            manager.getTransaction().begin();
            Paciente paciente = manager.find(Paciente.class, codigo);
            paciente.setNome(nome);
            paciente.setCpf(cpf);
            paciente.setRg(rg);
            paciente.setSexo(sexo);
            paciente.setDtNascimento(dtNascimento);
            paciente.setEndereco(endereco);
            paciente.setCidade(cidade);
            paciente.setUf(uf);
            paciente.setTelefone(telefone);
            paciente.setCelular(celular);
            paciente.setEmail(email);
            paciente.setConvenio(convenio);
            paciente.setDescConvenio(descConvenio);
            paciente.setFumante(fumante);
            paciente.setAlcool(alcool);
            paciente.setColesterol(colesterol);
            paciente.setDiabetico(diabetico);
            paciente.setDoencaCardiaca(doencaCardiaca);
            paciente.setCirurgia(cirurgia);
            paciente.setDescCirurgia(descCirurgia);
            paciente.setAlergia(alergia);
            paciente.setDescAlergia(descAlergia);   
            manager.merge(paciente);
            manager.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    } 
    
    public static void RemoverPaciente(int codigo ){        
        try{
            manager.getTransaction().begin();
            Paciente paciente = manager.find(Paciente.class, codigo);
            paciente.setInativo(true);
            manager.merge(paciente);
            manager.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static Paciente retornaPaciente(int codigo){
        Paciente paciente = null;
        try{
            paciente = manager.find(Paciente.class, codigo);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return paciente;
    }
}
