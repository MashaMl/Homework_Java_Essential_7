package Task2;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


class Worker {
    private String surname_and_initials;
    private String job_title;
    private int year;

    public Worker(String surname_and_initials, String job_title, int year) {
        this.surname_and_initials = surname_and_initials;
        this.job_title = job_title;
        this.year = year;
    }
    public Worker() {}

    public String getSurname_and_initials() {
        return surname_and_initials;
    }

    public void setSurname_and_initials(String surname_and_initials) {
        this.surname_and_initials = surname_and_initials;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return "Name - " + surname_and_initials + ", year of starting work - " + year + ", job title - " + job_title;
    }
}


public class Main extends Exception{

    public static void fill(Worker[] workers) {


        for(int i = 0; i < workers.length; ++i) {
            Scanner scanner = new Scanner(System.in);
            workers[i] = new Worker();
            System.out.println("Surname and initials of " + (i+1) + " worker:");
            workers[i].setSurname_and_initials(scanner.nextLine());

            int buf;
            Exception Exception = new Exception("Wrong date, worker can't start work later than 2023 year");

            try {
                System.out.println("Year of starting work of " + (i+1) + " worker:");
                buf = scanner.nextInt();
                if(buf > 2023)
                    throw Exception;
                workers[i].setYear(buf);
            }catch (Exception e) {
                System.out.println("Exception Handling");
                System.out.println(e.getMessage());
                System.out.println("Please reenter data");
                System.out.println();
               fill(workers);
            }

            System.out.println("Job title of " + (i+1) + " worker:");
            workers[i].setJob_title(scanner.next());
        }
        Comparator<Worker> workerNameComparator = Comparator.comparing(Worker::getSurname_and_initials);
        Arrays.sort(workers, workerNameComparator);
    }

    public static void main(String[] args) {
        Worker[] workers = new Worker[5];

        fill(workers);

        for(int i = 0; i < workers.length; ++i) {
            System.out.println(workers[i].toString());
        }

    }
}
