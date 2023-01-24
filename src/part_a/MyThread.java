package part_a;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.lang.Thread;
public class MyThread extends Thread {
    private int  count;
    String filename;
    public MyThread(String filename)
    {
        this.filename=filename;
        this.count=0;
    }

    public int getCount()
    {
        return count;
    }

    @Override
    public void run() {
        try
        {
            File file=new File(filename);
            Scanner io=new Scanner(file);
            while (io.hasNext())
            {
                count++;
                io.nextLine();
            }
            io.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
