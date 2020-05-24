/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrap.socketsuma;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import scrap.socketsuma.libraries.UtilesEntrada;

/**
 *
 * @author Jonsui
 */
public class Client {

  public static final void main(String[] args) throws IOException {
    String mess;
    do {

      try ( // socket local y puerto
              Socket socket = new Socket("localhost", 7777)) {
        System.out.println("Conectado!");

        // coger la salida del socket con el outputstream
        OutputStream outputStream = socket.getOutputStream();
        //el mensaje en cuestión
        try ( // creamos el OutputStram del socket para enviar el mensaje
                ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(outputStream)) {
          //el mensaje en cuestión
          mess = UtilesEntrada.leerTexto("Introduce un número: ");
          Message m = new Message(mess);

          //info
          System.out.println("Enviando el mensaje al ServerSocket");
          objectOutputStream.writeObject(m);

          System.out.println("Cerramos socket y terminamos el programa.");
        }
      }
    } while (!mess.equals("exit"));
  }
}
