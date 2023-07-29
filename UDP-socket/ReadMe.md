# TCP Server and Client

This repository contains two Java programs: a TCP server and a TCP client. These programs demonstrate a basic implementation of a TCP client-server communication model.

## TCP Server

The TCP server program (`TCP.java`) creates a server that listens on a specific port (1234) for incoming client connections. When a client connects, the server receives messages from the client, counts the number of messages received, and echoes each message back to the client. The server stops receiving messages when the client sends the message "***CLOSE***".

### How to Run the TCP Server

1. Compile the `TCP.java` file using `javac`:
  
2. Run the server using `java`:
   
3. The server will start and wait for incoming connections on port 1234.

## TCP Client

The TCP client program (`Client.java`) connects to the TCP server running on the local machine (localhost) on port 1234. The client sends messages to the server, and the server responds by echoing the messages back. The client can send multiple messages until it sends the message "***CLOSE***", which indicates that it wants to close the connection.

### How to Run the TCP Client

1. Compile the `Client.java` file using `javac`:
   
2. Run the client using `java`:

3. The client will connect to the server on localhost:1234. You can then start entering messages to send to the server. To close the connection, enter "***CLOSE***" as a message.

Note: Make sure the server is already running before starting the client.

## Contributing

Feel free to contribute to this repository by submitting issues or pull requests.

## License

This project is licensed under the [MIT License](LICENSE).



