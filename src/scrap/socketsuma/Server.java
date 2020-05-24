/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrap.socketsuma;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Jonsui
 */
public class Server {

  public static void start() throws IOException, ClassNotFoundException {
    //creamos el objeto mensaje para recibirlo.
    Message mens = null;

    Socket socket;

    boolean exit = false;

    try ( // el socket será en la máquina local.
            ServerSocket ss = new ServerSocket(7777)) {
      System.out.println("ServerSocket esperando conexiones...");
      do {
        //a la espera hasta que le entre por el puerto
        socket = ss.accept(); //
        System.out.println("Conexión desde " + socket + "!");
        //separador
        System.out.println();
        // inputstream del socket...
        InputStream inputStream = socket.getInputStream();
        // crear un DataInputStream para leer los datos del mensaje
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        // lee el objeto
        mens = (Message) objectInputStream.readObject();
        System.out.println("Recibido [" + mens.getText() + "] de: " + socket);
        //test
        //    System.out.println(mens.text);
        //salida
        try {
          System.out.println("TOTAL SUMA SOCKET: 1 + "
                  + mens.getText() + " = " + (1 + Integer.parseInt(mens.getText())));
          System.out.println("Cerramos sockets.");
        } catch (NumberFormatException numberFormatException) {
          exit = finProg(socket, mens);
        }
      } while (exit == false);
    }
    socket.close();
  }

  private static boolean finProg(Socket socket, Message mens) throws IOException {
    boolean fin = false;
    if (mens.getText().equals("exit")) {
      System.out.println("SALIDA DEL PROGRAMA");
      fin = true;
    } else {
      System.out.println("ERROR: Valor introducido incorrecto");
    }
    return fin;
  }
}
