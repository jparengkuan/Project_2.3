package nl.jparengkuan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class WorkerRunnable implements Runnable {

    protected Socket clientSocket = null;

    public WorkerRunnable(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));

            String input;
            String buffer = "";

            while((input = in.readLine()) != null)
            {
                if (input.equals("\t<MEASUREMENT>")) {
                    buffer = "";
                }


                buffer = buffer + input + "\n";

                if (input.equals("\t</MEASUREMENT>")) {

                   String stnNumber = buffer.split(">")[2].replace("</STN", "");

                   OutputWriter.getInstance().writeXml(buffer, stnNumber);

                   stnNumber = "";

                }


            }

            in.close();

        } catch (IOException e) {
            //report exception somewhere.
            e.printStackTrace();
        }
    }

}
