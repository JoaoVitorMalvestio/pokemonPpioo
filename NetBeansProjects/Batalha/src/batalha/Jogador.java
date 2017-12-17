/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author joaov
 */
public class Jogador {
    private List<Pokemon> listaPokemon = new ArrayList();
    int idJogador;
    
    public Jogador (int idJogador){
        this.idJogador = idJogador;    
    }
    
    public int escolherComando(Pokemon pkm){
        //Função não usada
        return 0;
    }
    
    public void trocarPokemon(){
        String escolhaString = "";
        Integer escolha = 0;
        String listaPokemonString = "";
        int i = 0;
        
        for (Pokemon pokemon : listaPokemon) {
            listaPokemonString += (i==0?"Atual ":i) + "- " + pokemon.toString() + "\n";
            i++;
        }
        
        while(true){
            try{
                escolhaString = JOptionPane.showInputDialog("Sua equipe:\n" + listaPokemonString + "Entre com o numero do pokemon que deseja usar:","");
                
                if(escolhaString==null) Batalha.fechaJogo(); //Caso fechar a janela, fecha o jogo
                
                escolha = parseInt(escolhaString);
                if (listaPokemon.get(escolha).getStatus()==Status.FAINTED){
                    JOptionPane.showMessageDialog(null, "O pokemon escolhido nao está apto a lutar.", "", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                if (escolha==0){
                    JOptionPane.showMessageDialog(null, "O pokemon escolhido é o atual.", "", JOptionPane.ERROR_MESSAGE);
                    continue;                   
                }
                if (escolha!=0) break;
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Entre com um numero valido.", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            } catch (IndexOutOfBoundsException e){                
                JOptionPane.showMessageDialog(null, "Seu time nao possui esse pokemon.", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }                      
        }             
        Pokemon novoPrimeiro = this.listaPokemon.get(escolha);
        this.listaPokemon.remove(novoPrimeiro);
        this.listaPokemon.add(0,novoPrimeiro);
        
        JOptionPane.showMessageDialog(null, this.listaPokemon.get(1).getEspecie().getNome() + " foi substituido pelo " + novoPrimeiro.getEspecie().getNome(), "", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void usarAtaque(Pokemon pkmInimigo){
        int i = 0, escolha = -1;        
        Pokemon pokemon    = this.getPrimeiroPokemon();
        Ataque ataque      = null;
        String listaAtaque = "", escolhaString = "";
        
        //Gera lista de ataque em string para mostrar
        for (Ataque atk : pokemon.getListaAtaque()) listaAtaque += i++ + "- "+ atk.toString() + "\n";

        while(true){
            try{                
                escolhaString = JOptionPane.showInputDialog("Jogador " + this.idJogador + " irá atacar!\n" +
                                                            "Pokemon Atual: " + this.getPrimeiroPokemon().toString() + "\n" +
                                                            "Ataque disponiveis:\n" + listaAtaque + "Entre com o numero do ataque que deseja usar:","");
                
                if(escolhaString==null) Batalha.fechaJogo(); //Caso fechar a janela, fecha o jogo
                
                escolha = parseInt(escolhaString);
                
                ataque = pokemon.getListaAtaque().get(escolha);
                
                if (ataque.getPpAtual()==0){
                    JOptionPane.showMessageDialog(null, "O ataque escolhido não possui PP!", "Erro", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                if (escolha!=-1) break;
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Entre com um numero valido.", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            } catch (IndexOutOfBoundsException e){                
                JOptionPane.showMessageDialog(null, "Seu pokemon nao possui essa ataque.", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }                      
        }
        
        ataque.efeito(pokemon,pkmInimigo);                
    }    

    public List getListaPokemon(){
        return this.listaPokemon;
    }   
    
    public boolean temPokemonVivo(){
        for (Pokemon pokemon : listaPokemon) {
            if (pokemon.getStatus()!=Status.FAINTED) return true;
        }
        return false;
    }
    
    public Pokemon getPrimeiroPokemon(){
        return listaPokemon.get(0);        
    }
    
    public boolean podeTrocarPokemon(){
        int i = 0;
        
        for(Pokemon pokemon:listaPokemon){
            if (pokemon.getStatus()!=Status.FAINTED) i++; 
        } 
        
        if (i<2) return false;
        
        return true;
    }
    
    public void forcaTroca(){
        int i = 0;
        Pokemon pkmApto = null;
        
        for(Pokemon pkm : this.listaPokemon){
            pkmApto = pkm;
            if (pkm.getStatus()!=Status.FAINTED) break;
            i++;
        };
        
        if (pkmApto==null) return;
        JOptionPane.showMessageDialog(null,"Jogador " + this.idJogador + ":\n" +
                                           this.getPrimeiroPokemon().getEspecie().getNome() + " será substituido pelo " + pkmApto.getEspecie().getNome(),"", JOptionPane.PLAIN_MESSAGE);
        this.listaPokemon.remove(pkmApto);
        this.listaPokemon.add(0,pkmApto);
    }
}
