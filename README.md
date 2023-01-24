# waiters:
> Avihay Finish , 208907113.

> Amit Rovshitz , 207701426.

- [Our Project](#our-project)
    - [Introduction](#introduction)
    - [Getting Started](#getting-started)
    - [callable](#callable)
    - [Factory](#factory)
    - [Run-Times](#run-times)
    - [Class diagram](#class-diagram)
    - [Classes](#classes)
    - [Tests](#tests)


# Our Project:

> our project divide to two parts. <br>
> **part 1:** part 1 is a program that create a file texts and counter how many lines created in three different ways - <br>
> 1. regular method that dont use threads. <br>
> 2. method that use threads. <br>
> 3. method that use threadpool. <br>

> **part 2:** in part 2 we create a threadpool that using priority queue, and we create a new task type, so that for each task have priority field. <br>
> the threadpool can submit this tasks by them priority. <br>


# Introduction

> this program being to tests some abilites of the computer. in **part 1** we learn about the abilites of threads and threadpool, and check who of them work faster. <br>
> we are running the program on the same problem with three ways to solve her. from the resulte we can learn a lot about threads and the speed them give us. <br>
> in **part 2** we build a threadpool and cheack how this work with priority queue. in this part we give to threade Callable objects type(about the Callable we extend later). and we use factory design pattern to create objects from Task class. <br>

# Getting started

> to get start this project, you just need to download the codes to your workspace and run them of any JDK. <br>
> for the part 1 you just need to run the main class, you can also change the amount of files in the CreateFiles function and see what happen. <br>
> for part 2 you can create task with priority and use the customExcuter for threadpool with priority queue.


# Callable 

> when we start an thread, he go to the "run()" method and invoke this function, so that the object that start the thred need to be from Runable type. <br>
> the disadvantge of the "run()" is that The run() method does not return any value and cannot throw a checked exception. <br>
> hence we have the Callable interface, the threads can get a Callable type too, and the function "Call()" of the Callable can return a generic value and throw exception.

# Factory

> the Factory desgien pattern is an creational desgien pattern that give us a flexebility of creating objects. in this desgien we create a interface that will be
> the object and we create a subclasses that implements this interface. in this way all the objects for each class will be from the interface object. after we build 
> the subclasses we will create a FactoryClass that will be our factory, in this class we will build the objects according to the information we pass to the 
> FactoryClass. now we can use this FactoryClass to build the objects as we want. 

# Run-Times

> here is a one test of the part 1 running and analysis of the results. we run part 1 of 10,000 files and this the results: <br>
> <img width="438" alt="כמות הקבצים" src="https://user-images.githubusercontent.com/119002109/213944125-cd239406-1284-4ea5-bfb6-e7742a3dfa29.png"> <br>
> <img width="292" alt="תוצאות הקבצים" src="https://user-images.githubusercontent.com/119002109/213944128-a488036d-63b9-4dbb-9af4-e76941ff087a.png"> <br>
> we can see that using the threadpool method is given the faster result, why? because when we use threads we use in optimal condition all the cores in the 
> computer, or at least more cores than without using threads. in generally when we work without threads we work on one core, that mean that all each 
> task wait that the pervious task finish. but why threadpool faster than regular thread? <br>
> the main reason that we are think about its because when i am using threadpool i create a several threads and work with them during all the program, but when I
> create a thread for all each task its take more time than the threadpool.

# Class diagram

> **class diagram for part 1:** <br>
> <img width="484" alt="דיאגרנה חלק א" src="https://user-images.githubusercontent.com/119002109/214382278-98184b22-1ce6-491c-bbe1-8961343ae337.png"> <br>
>  **class diagram for part 2:** <br>
> <img width="437" alt="דיאגרמה חלק ב" src="https://user-images.githubusercontent.com/119002109/214401620-20106c93-c818-4590-ad55-85bd24ab6c79.png"> <br>






# Classes

> **part 1:** <br>
> **Ex2:** this a main class, we make this to try our program on part 1, you can try to run this and change the number of files. <br>
> **Ex2_1:** this class have five functions: <br>
> - createTextFiles(), this function create the files, gives her names and put the names in array. <br>
> - getNumOfLines(), this function counter the lines without threads. <br>
> - getNumOfLinesThreads(), this function counter the lines with threads. <br>
> - getNumOfLinesThreadPool(), this function counter the lines with threadpool. <br>
> - delete(), this function delete the files we created. <br>
> 
> **MyThread:** this class is the realizition of the Run() function for the threads. <br>
> **MyThreadPool:** this class is the realizition of the Call() function for the threadpool. <br>
> 
> **part 2:** <br>
> **TaskType:** this class defination the type of the task <br>
> **Task:** this class create the tasks, in additional this class is the class that implements the Callable interface and realizition the Call() function <br>
> **CustomExecutor:** this class have the excuter to the threadpool, he realizition the submits function that we required to realizition. <br>
> in additional we have in the class the getCurrentMax function that give us the max priority in the  queue of the threadpool. how we realizition that: <br>
> we create a class array, when we invoke submit function we increase the arr index in the priority index, for example if we submit task with priority 1 
> we do arr[1]++. and if the queue is empty we equate to zero the arr. in the getCurrentMax we save the size of the queue and the number of submits we did until
> we unvoke the function, then we can to check the ratio between the size and the submitNumbers, for example if the size bigger than submitNumbers minus arr[1]
> (size > submitNumbers - arr[1]) i know that not all the tasks with priority 1 finish yet, hence the priorityMax is 1.

# Tests
> **part 1:** we make our tests in the main class we give here. <br>
> **part 2:** we use the tests we get in the assigment
