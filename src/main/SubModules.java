/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

/**
 *
 * @author DelaTorreNelson
 */
public class SubModules {
    public String getSelectedRadioButton(ButtonGroup btnGrp){        
        for(Enumeration buttons = btnGrp.getElements(); buttons.hasMoreElements();){
            AbstractButton button  = (AbstractButton) buttons.nextElement();
            if(button.isSelected()){
                return button.getText();
            }
        }
        return null;
    }  
}
