/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalha;

import static java.lang.Integer.parseInt;

/**
 *
 * @author joaov
 */
public class AtaqueHP extends Ataque{
    private int valor;
    private int porcentagem;

    public AtaqueHP(String[] parametros){
        super(parametros);
        
        this.valor = parseInt(parametros[7].split(",")[0]);
        this.porcentagem = parseInt(parametros[7].split(",")[1]);
    }
    
    @Override
    public void efeito(){
        
    }
}
