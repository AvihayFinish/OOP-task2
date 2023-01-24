package part_a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex2_1 {

    public static String[] createTextFiles(int n, int seed, int bound)
    {
        int x=0;
        Random rand = new Random(seed);
        String[]filename;
        if (n<=0)
        {
            return null;
        }
        filename=new String[n];
        for (int i=0;i<n;i++)
        {
            String file="file_"+(i+1)+".txt";
            x = rand.nextInt(bound);
            try {
                File myObj = new File(file);
                FileWriter myWriter = new FileWriter(file);
                for (int j = 0; j < x - 1; j++) {
                    myWriter.write("World Hello\n");
                }
                myWriter.write("World Hello");
                myWriter.close();
                filename[i] = file;
                System.out.println("create the file" + myObj.getName());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return filename;

    }
    public static int getNumOfLines(String[] fileNames)
    {   int count=0;
        if (fileNames==null)
        {
            return 0;
        }
        for (int i=0;i<fileNames.length;i++)
        {
            try {
                File myObj = new File(fileNames[i]);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    count++;
                    myReader.nextLine();
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        return  count;
    }
    public  int getNumOfLinesThreads(String[] fileNames)
    {
        if (fileNames==null)
        {
            return 0;
        }

        int count=0;
        MyThread[]threads=new  MyThread[fileNames.length];
        for (int i=0;i<fileNames.length;i++)
        {
            threads[i]=new MyThread(fileNames[i]);
            threads[i].start();
        }
        for (int i=0;i<fileNames.length;i++)
        {
            try
            {
                threads[i].join();
                count+=threads[i].getCount();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        return  count;
    }
    public  int getNumOfLinesThreadPool(String[] fileNames)
    {
        if (fileNames==null)
        {
            return 0;
        }
        Future [] Farr = new Future[fileNames.length];
        int count=0;
        ExecutorService pool = Executors.newFixedThreadPool(fileNames.length);
        for (int i=0;i< fileNames.length;i++)
        {
            Farr[i] = pool.submit(new MyThreadPool(fileNames[i]));
        }
        for(int i = 0; i < fileNames.length;i++) {
            try {
                count+=(int)Farr[i].get();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        pool.shutdown();
        return count;
    }
    public static void delete(String[]fileNames)
    {
        if (fileNames==null)
            return;
        for (int i=0;i<fileNames.length;i++)
        {
            if (fileNames[i]!=null)
            {
                File myObj = new File(fileNames[i]);
                if (myObj.exists()) {
                    if (myObj.delete()) {
                        System.out.println("Deleted the file: " + myObj.getName());
                    } else {
                        System.out.println("Failed to delete the file.");
                    }

                }

            }
        }
    }



}
