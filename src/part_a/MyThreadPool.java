package part_a;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class MyThreadPool implements Callable <Integer>{
    String filename;

    public MyThreadPool(String s)
    {
        filename=s;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        try {
            File file = new File(filename);
            Scanner io = new Scanner(file);
            while (io.hasNext()) {
                count++;
                io.nextLine();
            }
            io.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
