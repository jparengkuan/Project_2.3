package nl.jparengkuan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteTask implements Runnable {

    protected String xmlData;
    protected String stnNumber;

    public WriteTask(String xmlData, String stnNumber)
    {
        this.xmlData = xmlData;
        this.stnNumber = stnNumber;
    }

    @Override
    public void run() {



        String path = Main.directory + this.stnNumber+ ".xml";

        File file = new File(path);

        if (!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                FileOutputStream outputFile = new FileOutputStream(path, true);
                outputFile.write(this.xmlData.getBytes());
                outputFile.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
