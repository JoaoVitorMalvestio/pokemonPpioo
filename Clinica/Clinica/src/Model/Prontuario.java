package Model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name="Prontuario")
@NamedQueries({ @NamedQuery(name="Prontuario.findAll", query="SELECT U FROM Prontuario U")})
public class Prontuario implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer  codigo;
    @JoinColumn (name="MEDICO",nullable=false)
    private Medico   medico;
    @JoinColumn (name="PACIENTE",nullable=false)
    private Paciente paciente;
    
    private String   sintoma;
    private String   diagnostico;
    private String   prescricao;
    private String   dataModificacao;
    private String   horaModificacao; 
    private boolean  inativo;
    
    public Prontuario(){
        super();
    }

    public Prontuario(Medico medico, Paciente paciente, String sintoma, String diagnostico, String prescricao, String dataModificacao, String horaModificacao) {
        this.medico          = medico;
        this.paciente        = paciente;
        this.sintoma         = sintoma;
        this.diagnostico     = diagnostico;
        this.prescricao      = prescricao;
        this.dataModificacao = dataModificacao;
        this.horaModificacao = horaModificacao;
        this.inativo         = false;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(String dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public String getHoraModificacao() {
        return horaModificacao;
    }

    public void setHoraModificacao(String horaModificacao) {
        this.horaModificacao = horaModificacao;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }
    
    
    
}
