package Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Leonardo
 */

@Entity
@Table(name = "CONSULTA")
@NamedQueries({ @NamedQuery(name="Consulta.findAll", query="SELECT U FROM Consulta U")})

public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer  codigo;
    
    @Column(length = 100, name = "DATA_CONSULTA", nullable = false)
    private String   data;
    
    @Column(length = 100, name = "HORARIO_CONSULTA", nullable = false)
    private String   horario;
    
    @Column(length = 100, name = "TIPO_CONSULTA", nullable = false)
    private String   tipo;
    
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_MEDICO", nullable = false)
    private Medico   medico;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_PACIENTE", nullable = false)
    private Paciente paciente;
    
    @Column(length = 100, name = "INATIVO_CONSULTA", nullable = false)
    private boolean  inativo;

    public Consulta() {
    }

    public Consulta(String data, String horario, String tipo, Medico medico, Paciente paciente) {
        this.data = data;
        this.horario = horario;
        this.tipo = tipo;
        this.medico = medico;
        this.paciente = paciente;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }

    @Override
    public String toString() {
        return "Consulta{" + "codigo=" + codigo + ", data=" + data + ", horario=" + horario + ", tipo=" + tipo + ", medico=" + medico + ", paciente=" + paciente + '}';
    }
}
