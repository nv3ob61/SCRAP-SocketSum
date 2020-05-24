/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrap.socketsuma;

import java.io.Serializable;

/**
 *
 * @author Jonsui
 */
// must implement Serializable in order to be sent
public class Message implements Serializable{

  private static final long serialVersionUID = 1L;
  
    final String text;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
