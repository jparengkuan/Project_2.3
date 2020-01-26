package nl.jparengkuan;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class OutputWriter {

    private static OutputWriter single_instance = null;
    private ThreadPoolExecutor executor;

    private OutputWriter(){
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Main.nThreads);
    }

    public static OutputWriter getInstance(){
        if (single_instance == null){
            return new OutputWriter();
        }
        return single_instance;
    }

    public void writeXml(String xmlData, String stnNumber){
        WriteTask task =  new WriteTask(xmlData, stnNumber);
        this.executor.execute(task);
    }

}
