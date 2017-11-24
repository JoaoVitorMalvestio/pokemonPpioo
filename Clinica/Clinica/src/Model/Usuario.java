package Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Leonardo
 */
@Entity
@Table (name="usuario")

@NamedQueries({ @NamedQuery(name="Usuario.findAll", query="SELECT U FROM Usuario U")})
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer codigo;
    @Column (name="login",nullable=false)
    private String  login;
    @Column (name="senha",nullable=false)
    private String  senha;
    @Column (name="tipo",nullable=false)
    private String  tipo;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name="medico",nullable=true)
    private Medico  medico; 
    
    @Column (name="inativo",nullable=false)
    private boolean inativo;

    public Usuario() {
        super();
    }
    public Usuario(String login, String senha, String tipo, Medico medico) {
        super();
        this.login  = login;
        this.senha  = senha;
        this.tipo   = tipo;
        this.medico = medico;
        this.inativo = false;
    }
       
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
    
    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "codigo=" + codigo + ", login=" + login + ", senha=" + senha + ", tipo=" + tipo + ", medico=" + medico + ", inativo=" + inativo + '}';
    }
    
    
}
