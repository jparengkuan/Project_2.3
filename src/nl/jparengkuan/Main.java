package nl.jparengkuan;

import java.util.Scanner;

public class Main {

    public static int nThreads;
    public static String directory;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Specify how many threads can write to the system\n");
        System.out.println("[Thread pool size]:  ");
        Main.nThreads = scanner.nextInt();

        System.out.println("[OutputDirectory]: ");
        Main.directory = scanner.next();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Server started!");


        MultiThreadedServer server = new MultiThreadedServer(7789);
        new Thread(server).start();

    }
}
