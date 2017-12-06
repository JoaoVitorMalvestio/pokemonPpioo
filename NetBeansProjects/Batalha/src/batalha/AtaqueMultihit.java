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
public class AtaqueMultihit extends Ataque{
    private int min;
    private int max;

    public AtaqueMultihit(String[] parametros){
        super(parametros);
        
        this.min = parseInt(parametros[7].split(",")[0]);
        this.max = parseInt(parametros[7].split(",")[1]);
    }
    
    @Override
    public void efeito(){
        
    }
}
