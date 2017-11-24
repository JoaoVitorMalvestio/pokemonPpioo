package Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("PACIENTE")
@NamedQueries({ @NamedQuery(name="Paciente.findAll", query="SELECT U FROM Paciente U")})
public class Paciente extends Pessoa{
    @Column(name="CPF", length=100, nullable=false)
    private String  cpf;
    @Column(name="RG", length=100, nullable=false)
    private String  rg;
    @Column(name="SEXO", length=100, nullable=false)
    private String sexo;
    @Column(name="DATA_NASCIMENTO", length=100, nullable=false)
    private String  dtNascimento;
    @Column(name="ENDERECO", length=100, nullable=false)
    private String  endereco;
    @Column(name="CIDADE", length=100, nullable=false)
    private String  cidade;
    @Column(name="UF", length=100, nullable=false)
    private String  uf;
    @Column(name="TELEFONE", length=100, nullable=false)
    private String  telefone;
    @Column(name="CELULAR", length=100, nullable=false)
    private String  celular;
    @Column(name="EMAIL", length=100, nullable=false)
    private String  email;
    @Column(name="CONVENIO", length=100, nullable=false)
    private String  convenio;
    @Column(name="DESC_CONVENIO", length=100, nullable=false)
    private String  descConvenio;
    @Column(name="FUMANTE", length=100, nullable=false)
    private Boolean fumante;
    @Column(name="ALCOOL", length=100, nullable=true)
    private Boolean alcool;
    @Column(name="COLESTEROL", length=100, nullable=true)
    private Boolean colesterol;
    @Column(name="DIABETICO", length=100, nullable=true)
    private Boolean diabetico;
    @Column(name="DOENCA_CARDIACA", length=100, nullable=true)
    private Boolean doencaCardiaca;
    @Column(name="CIRURGIA", length=100, nullable=true)
    private Boolean cirurgia;
    @Column(name="DESC_CIRURGIA", length=100, nullable=true)
    private String  descCirurgia;
    @Column(name="ALERGIA", length=100, nullable=true)
    private Boolean alergia;
    @Column(name="DESC_ALERGIA", length=100, nullable=true)
    private String  descAlergia;
    @Column(name="INATIVO", length=100, nullable=true)
    private boolean inativo;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Consulta possuiConsulta;

    public Paciente(){
        super();
    }

    public Paciente(String nome,String cpf, String rg,String sexo, String dtNascimento, String endereco, String cidade, String uf, String telefone, String celular, String email, String convenio, String descConvenio, Boolean fumante, Boolean alcool, Boolean colesterol, Boolean diabetico, Boolean oencaCardiaca, Boolean cirurgia, String descCirurgia, Boolean alergia, String descAlergia) {
        this.setNome(nome);
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
        this.cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.convenio = convenio;
        this.descConvenio = descConvenio;
        this.fumante = fumante;
        this.alcool = alcool;
        this.colesterol = colesterol;
        this.diabetico = diabetico;
        this.doencaCardiaca = oencaCardiaca;
        this.cirurgia = cirurgia;
        this.descCirurgia = descCirurgia;
        this.alergia = alergia;
        this.descAlergia = descAlergia;
    }
       

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getDescConvenio() {
        return descConvenio;
    }

    public void setDescConvenio(String descConvenio) {
        this.descConvenio = descConvenio;
    }

    public Boolean getFumante() {
        return fumante;
    }

    public void setFumante(Boolean fumante) {
        this.fumante = fumante;
    }

    public Boolean getAlcool() {
        return alcool;
    }

    public void setAlcool(Boolean alcool) {
        this.alcool = alcool;
    }

    public Boolean getColesterol() {
        return colesterol;
    }

    public void setColesterol(Boolean colesterol) {
        this.colesterol = colesterol;
    }

    public Boolean getDiabetico() {
        return diabetico;
    }

    public void setDiabetico(Boolean diabetico) {
        this.diabetico = diabetico;
    }

    public Boolean getDoencaCardiaca() {
        return doencaCardiaca;
    }

    public void setDoencaCardiaca(Boolean oencaCardiaca) {
        this.doencaCardiaca = oencaCardiaca;
    }

    public Boolean getCirurgia() {
        return cirurgia;
    }

    public void setCirurgia(Boolean cirurgia) {
        this.cirurgia = cirurgia;
    }

    public String getDescCirurgia() {
        return descCirurgia;
    }

    public void setDescCirurgia(String descCirurgia) {
        this.descCirurgia = descCirurgia;
    }

    public Boolean getAlergia() {
        return alergia;
    }

    public void setAlergia(Boolean alergia) {
        this.alergia = alergia;
    }

    public String getDescAlergia() {
        return descAlergia;
    }

    public void setDescAlergia(String descAlergia) {
        this.descAlergia = descAlergia;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Paciente{" + "cpf=" + cpf + ", rg=" + rg + ", sexo=" + sexo + ", dtNascimento=" + dtNascimento + ", endereco=" + endereco + ", cidade=" + cidade + ", uf=" + uf + ", telefone=" + telefone + ", celular=" + celular + ", email=" + email + ", convenio=" + convenio + ", descConvenio=" + descConvenio + ", fumante=" + fumante + ", alcool=" + alcool + ", colesterol=" + colesterol + ", diabetico=" + diabetico + ", doencaCardiaca=" + doencaCardiaca + ", cirurgia=" + cirurgia + ", descCirurgia=" + descCirurgia + ", alergia=" + alergia + ", descAlergia=" + descAlergia + ", inativo=" + inativo + '}';
    }
}
