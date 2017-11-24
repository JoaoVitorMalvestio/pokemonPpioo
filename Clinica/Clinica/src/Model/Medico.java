package Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author Leonardo
 */
@Entity
@DiscriminatorValue("MEDICO")
@NamedQueries({ @NamedQuery(name="Medico.findAll", query="SELECT U FROM Medico U")})

public class Medico extends Pessoa implements Serializable{
    @Column(name="ATUACAO_MEDICO", length=100, nullable=false)
    private String  atuacao;
    
    @Column(name="INATIVO_MEDICO", length=100, nullable=false)
    private boolean inativo;
   
    public Medico(){
        super();
    }

    public Medico(String nome, String atuacao) {
        this.setNome(nome);
        this.atuacao = atuacao;
        this.inativo   = false;
    }

    public String getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(String atuacao) {
        this.atuacao = atuacao;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }

    @Override
    public String toString() {
        return "Medico{" + "atuacao=" + atuacao + ", inativo=" + inativo + '}';
    }
      
}
