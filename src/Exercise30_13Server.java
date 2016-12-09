import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Exercise30_13Server extends JFrame {
  // Text area for displaying contents
  private JTextArea jta = new JTextArea();

  // Mapping of sockets to output streams
  private Hashtable outputStreams = new Hashtable();

  // Server socket
  private ServerSocket serverSocket;

  public static void main(String[] args) {
    new Exercise30_13Server();
  }

  public Exercise30_13Server() {
    // Place text area on the frame
    setLayout(new BorderLayout());
    add(new JScrollPane(jta), BorderLayout.CENTER);

    setTitle("MultiThreadServer");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null); // Center the frame
    setVisible(true); // It is necessary to show the frame here!

    jta.setEditable(false); // Disable editing of server log

    // Listen for connections
    listen();
  }

  private void listen() {
      try {
        // Create a server socket
        serverSocket = new ServerSocket(8000);
        jta.append("MultiThreadServer started at " + new Date() + '\n');

      while (true) {
        // Listen for a new connection request
        Socket socket = serverSocket.accept();

        // Display the client number
        jta.append("Connection from " + socket + " at " + new Date() + '\n');

        // Create output stream
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

        // Save output stream to hashtable
        outputStreams.put(socket, dout);

        // Create a new thread for the connection
        new ServerThread(this, socket);
      }
    }
    catch(IOException ex) {
      System.err.println(ex);
    }
  }

  // Used to get the output streams
  Enumeration getOutputStreams(){
      return outputStreams.elements();
  }

  // Used to send message to all clients
  void sendToAll(String message){
      // Go through hashtable and send message to each output stream
      for (Enumeration e = getOutputStreams(); e.hasMoreElements();){
          DataOutputStream dout = (DataOutputStream)e.nextElement();
          try {
              // Write message
              dout.writeUTF(message);
          } catch (IOException ex) {
              System.err.println(ex);
          }
      }
  }


  class ServerThread extends Thread {

      private Exercise30_13Server server;

      private Socket socket;

      /** Construct a thread */
      public ServerThread(Exercise30_13Server server, Socket socket) {
          this.socket = socket;
          this.server = server;
          start();
      }

      /** Run a thread */
      public void run() {
          try {
              // Create data input and output streams
              DataInputStream din = new DataInputStream(socket.getInputStream());

              // Continuously serve the client
              while (true) {
                  String string = din.readUTF();

                  // Send text back to the clients
                  server.sendToAll(string);

                  // Add chat to the server jta
                  jta.append(string + '\n');
              }
          }
          catch(IOException e) {
              System.err.println(e);
          }
      }
  }
}
