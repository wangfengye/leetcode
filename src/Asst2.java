import java.util.Scanner;

/**
 * Scanner
 */
public class Asst2 {
    private static final String FEMALE = "female";
    private static final String MALE = "male";
    private static final int MONTHS_YEAR = 12;//12 months a year
    private String name;// full name
    private boolean gender;// gender
    private int age;// age of month
    private boolean actOfViolence;//feeling violent or not

    @Override
    public String toString() {
        return name + " ("
                + (gender ? FEMALE : MALE)
                + ",aged " + age / MONTHS_YEAR + " years"
                + (actOfViolence ? ", feeling violent" : ", not feeling violent")
                + ") has a HI of: " + calHI();
    }

    /**
     * work out the user's Happy Index
     *
     * @return the result of HI
     */
    public double calHI() {
        double hi = 1.0;
        if (actOfViolence) {
            hi = hi * 7;
        }
        if (!gender) {
            hi = hi * 10;
        } else {
            hi = hi / 2;
        }
        if (age < 180 || age > 960) {
            hi = hi * 0;
        } else if (age <= 420) {
            hi = hi * 5;
        } else if (age >= 660) {
            hi = hi * 3;
        }
        hi = hi / 700 * 100;
        return hi;
    }

    public static void main(String[] args) {
        System.out.println("This program will provide Happy Indices \n");
        int counter = 0;
        while (true) {
            counter++;
            Scanner scanner = new Scanner(System.in);
            Asst2 asst2 = new Asst2();
            System.out.print("Please enter your name: ");
            asst2.name = scanner.nextLine();
            System.out.print("Please enter your gender (m/f): ");
            String genderInput = scanner.next();
            if (genderInput.equals("M") || genderInput.equals("m")) {
                asst2.gender = false;
            } else if (genderInput.equals("F") || genderInput.equals("f")) {
                asst2.gender = true;
            } else {
                System.out.println("Unable to identify. use default gender(male)");
                asst2.gender = false;
            }
            System.out.print("Please enter your age in months: ");
            try {
                asst2.age = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("It's not number, use default age 0");
                asst2.age = 0;
            }
            if (asst2.age < 0 || asst2.age > 1320) {
                System.out.println("out of rang [0,1320], use default age 0");
                asst2.age = 0;
            }
            System.out.print("True or false -- do you feel violent: ");
            String actOfViolenceInput = scanner.next();
            if (actOfViolenceInput.equals("true")) {
                asst2.actOfViolence = true;
            } else if (actOfViolenceInput.equals("false")) {
                asst2.actOfViolence = false;
            } else {
                System.out.println("It's not true/false,use default actOfViolence false");
                asst2.actOfViolence = false;
            }
            System.out.println(asst2.toString());
            System.out.print("Another? ");
            String con = scanner.next();
            if (!con.equals("Y") && !con.equals("y")) {
                //jump out of the loop
                break;
            }
        }
        System.out.println(counter + " Happy indices determined");
    }
}
