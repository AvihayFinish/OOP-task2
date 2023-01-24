package part_a;
public class Ex2 {
    public static void main(String[] args) {
        String[]filename=Ex2_1.createTextFiles(10000,2,100);
        int count;
        long start_1,start_2,start_3,end_1,end_2,end_3;
        start_1 = System.currentTimeMillis(); // starting time
        count= Ex2_1.getNumOfLines(filename);// start of function
        // end of function
        end_1 = System.currentTimeMillis();// ending time
        Ex2_1 a=new Ex2_1();
        start_2 = System.currentTimeMillis(); // starting time
        count=a.getNumOfLinesThreads(filename);// start of function
        //end of function
        end_2 = System.currentTimeMillis();// start of function
        start_3 = System.currentTimeMillis(); // starting time
        count=a.getNumOfLinesThreadPool(filename);// start of function
        // end of function
        end_3 = System.currentTimeMillis();// start of function
        Ex2_1.delete(filename);
        System.out.println(count+" total lines without using Threads:" + (end_1 - start_1) + "ms.");
        System.out.println(count+" total lines with using Threads:" + (end_2 - start_2) + "ms");
        System.out.println(count+" total lines with using ThreadPool:" + (end_3 - start_3) + "ms");
    }
}
