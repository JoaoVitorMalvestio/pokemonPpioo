/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import static java.lang.Integer.parseInt;
import java.util.Random;
import javax.swing.JOptionPane;
import static javax.xml.bind.DatatypeConverter.parseDouble;

/**
 *
 * @author joaov
 */
public class Ataque {
    private int id;
    private String nome;
    private Tipo tipo;
    private double ppMax;
    private double ppAtual;
    private double power;
    private double accuracy;
    
    public Ataque(String[] parametros){
        this.id   = parseInt(parametros[0]);
        this.nome = parametros[1];
        this.tipo = Tipo.valueOf(parametros[2]);
        this.ppMax = parseDouble(parametros[3]);
        this.ppAtual = this.ppMax;
        this.power = parseDouble(parametros[4]);
        this.accuracy = parseDouble(parametros[5]);      
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPpMax() {
        return ppMax;
    }

    public double getPpAtual() {
        return ppAtual;
    }

    public double getPower() {
        return power;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public Tipo getTipo() {
        return tipo;
    }
    
    public void setPpAtual(double ppAtual){
        this.ppAtual = ppAtual;
        
    }
    
    public void efeito(Pokemon aliado,Pokemon inimigo){
        this.setPpAtual(this.getPpAtual() - 1);
        
        JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " usou " + this.getNome(), "", JOptionPane.PLAIN_MESSAGE);
        
        if (!this.calculoAcerto(aliado.calculoAccuracyEvasion(aliado.getModifierAccuracy()), inimigo.calculoAccuracyEvasion(inimigo.getModifierEvasion()), aliado.getStatus(), aliado.isFlinch())){
            JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " errou o ataque!", "", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        
        boolean critico = calculoCritico(aliado.getSpd());
        
        double dano = calculoDano(aliado,inimigo,critico);
        
        double hpAtual = inimigo.getHpAtual() - dano;
        
        inimigo.setHpAtual(hpAtual);
        JOptionPane.showMessageDialog(null,aliado.getEspecie().getNome() + " acertou o ataque e deu " + dano + " de dano!", "", JOptionPane.PLAIN_MESSAGE);
    }
    
    public boolean calculoCritico(double spdAliado){
        double isCritico = spdAliado/512;
        
        if(isCritico > Math.random()) return true;

        return false;  
    }
    
    public boolean calculoAcerto(double modifierAccuracy, double modifierEvasion, Status status, boolean flinch){        
        double isHit = this.accuracy * (modifierAccuracy/modifierEvasion);        
        double rand = Math.random()*100;
        
        if(status == Status.FROZEN || status == Status.SLEEP || flinch == true) rand = 100;

        if(status == Status.PARALYSIS) rand += 25;

        if(isHit > rand) return true;
        
        return false;
    }
    
    public double calculoDano(Pokemon aliado,Pokemon inimigo,boolean critico){
        double L = aliado.getLevel();
        double P = this.power;
        double A = 0;
        double D = 0;
        double dano = 0;
        Random rand = new Random();
        
        if(this.tipo == Tipo.valueOf("Normal") ||
           this.tipo == Tipo.valueOf("Fighting") ||
           this.tipo == Tipo.valueOf("Flying") ||
           this.tipo == Tipo.valueOf("Poison") ||
           this.tipo == Tipo.valueOf("Ground")  ||
           this.tipo == Tipo.valueOf("Rock") ||
           this.tipo == Tipo.valueOf("Bug") ||
           this.tipo == Tipo.valueOf("Ghost")){
            A = aliado.getAtk();
            D = inimigo.getDef();
        }else 
        if(this.tipo == Tipo.valueOf("Fire") ||
           this.tipo == Tipo.valueOf("Water") ||
           this.tipo == Tipo.valueOf("Electric") ||
           this.tipo == Tipo.valueOf("Grass") ||
           this.tipo == Tipo.valueOf("Ice") ||
           this.tipo == Tipo.valueOf("Psychic") ||
           this.tipo == Tipo.valueOf("Dragon")){
            A = aliado.getSpe();
            D = inimigo.getSpe();
        }
        
        if(critico) L *= 2;

        if(aliado.getStatus() == Status.valueOf("BURN")){
            A = (A < 0) ? 0 : (A/2);
        }

        dano = (L * A * P / D / 50) + 2;
        
        if(this.tipo == aliado.getEspecie().getTipo1() || this.tipo == aliado.getEspecie().getTipo2()){
            dano *= 1.5;
        }
        
        dano *= getMultiplicadorDano(this.getTipo().getIdx(),inimigo.getEspecie().getTipo1().getIdx()) * getMultiplicadorDano(this.getTipo().getIdx(),inimigo.getEspecie().getTipo2().getIdx());

        int R = (rand.nextInt(38)+217);
        dano = (dano * R)/255;
        return dano;
    }
    
    public String toString(){       
        return this.getNome() + "  PP: " + this.getPpAtual() + "  Tipo: " + this.getTipo().getNome();
    }
    
    public double getMultiplicadorDano(int tipoAtacante, int tipoDefensor){
        if (tipoDefensor==-1) return 1;
        
        double[][] tabela = {{1,1,1,1,1,0.5,1,0,1,1,1,1,1,1,1},
                             {2,1,0.5,0.5,1,2,0.5,0,1,1,1,1,0.5,2,1},
                             {1,2,1,1,1,0.5,2,1,1,1,2,0.5,1,1,1},
                             {1,1,1,0.5,0.5,0.5,2,0.5,1,1,2,1,1,1,1},
                             {1,1,0,2,1,2,0.5,1,2,1,0.5,2,1,1,1},
                             {1,0.5,2,1,0.5,1,2,1,2,1,1,1,1,2,1},
                             {1,0.5,0.5,2,1,1,1,0.5,0.5,1,2,1,2,1,1},
                             {0,1,1,1,1,1,1,2,1,1,1,1,0,1,1},
                             {1,1,1,1,1,0.5,2,1,0.5,0.5,2,1,1,2,0.5},
                             {1,1,1,1,2,2,1,1,2,0.5,0.5,1,1,1,0.5},
                             {1,1,0.5,0.5,2,2,0.5,1,0.5,2,0.5,1,1,1,0.5},
                             {1,1,2,1,0,1,1,1,1,2,0.5,0.5,1,1,0.5},
                             {1,2,1,2,1,1,1,1,1,1,1,1,0.5,1,1},
                             {1,1,2,1,2,1,1,1,1,0.5,2,1,1,0.5,2},
                             {1,1,1,1,1,1,1,1,1,1,1,1,1,1,2}};
        
        return tabela[tipoAtacante][tipoDefensor];
        
    }
}
