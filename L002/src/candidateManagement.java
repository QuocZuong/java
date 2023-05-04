import java.util.ArrayList;
import java.util.Scanner;

public class candidateManagement {

    ArrayList<candidate> storageCandidates = new ArrayList<>();

    public void menu() {
        Scanner sc = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.println("CANDIDATE MANAGEMENT SYSTEM");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            System.out.print("   Please choose: ");
            try {
                input = sc.next();
                System.out.println("---------------------------------");
                if (Integer.parseInt(input) == 1) {
                    inputExperience();
                } else if (Integer.parseInt(input) == 2) {
                    inputFresher();
                } else if (Integer.parseInt(input) == 3) {
                    inputIntern();
                } else if (Integer.parseInt(input) == 4) {
                    searchCandidate();
                } else if (Integer.parseInt(input) == 5) {
                    System.out.println("TAM BIET!!!");
                    sc.close();
                    System.exit(0);
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Vui long chon 1-5!");

            }

        }
    }

    public void inputExperience() {
        experience candidate = new experience();
        candidate.nhapTT();
        storageCandidates.add(candidate);
    }

    public void inputFresher() {
        fresher candidate = new fresher();
        candidate.nhapTT();
        storageCandidates.add(candidate);
    }

    public void inputIntern() {
        intern candidate = new intern();
        candidate.nhapTT();
        storageCandidates.add(candidate);
    }

    public void searchCandidate() {
        Scanner sc = new Scanner(System.in);
        String nameToSearch = "";
        int numberOfResultFound = 0;

        int typeOfCandidateToSearch;
        System.out.println("List of candidate:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (candidate each : storageCandidates) {
            if (each.getCandidatetype() == 0) {
                System.out.println(each.getFirstName() + " " + each.getLastName());

            }
        }
        System.out.println("==========FRESHER CANDIDATE==============");
        for (candidate each : storageCandidates) {
            if (each.getCandidatetype() == 1) {
                System.out.println(each.getFirstName() + " " + each.getLastName());

            }
        }
        System.out.println("==========INTERN CANDIDATE==============");
        for (candidate each : storageCandidates) {
            if (each.getCandidatetype() == 2) {
                System.out.println(each.getFirstName() + " " + each.getLastName());

            }
        }
        System.out.print("Input Candidate name (First name or Last name): ");
        nameToSearch = sc.nextLine();
        System.out.print("Input type of candidate:");
        typeOfCandidateToSearch = Integer.parseInt(sc.nextLine());
        System.out.println(
                "+---+----------------+-----------+----------------+------------+-------------------------+----+");
        System.out.println(
                "|No.|Fullname        |Birthdate  |Address         |Phone       |Email                    |Type|");
        System.out.println(
                "+---+----------------+-----------+----------------+------------+-------------------------+----+");

        for (candidate each : storageCandidates) {
            if ((each.getCandidatetype() == typeOfCandidateToSearch)
                    && (each.getFirstName().equalsIgnoreCase(nameToSearch)
                            || each.getLastName().equalsIgnoreCase(nameToSearch))) {
                numberOfResultFound++;
                System.out.printf("|%3s|%16s|%11s|%16s| %10s |%25s|%4s|\n", each.getCandidateId(),
                        each.getFirstName() + " " + each.getLastName(),
                        each.getBirthDate(), each.getAddress(), each.getPhone(), each.getEmail(),
                        each.getCandidatetype());

            }

        }
        System.out.println(
                "+---+----------------+-----------+----------------+------------+-------------------------+----+");
        if (numberOfResultFound == 0) {
            System.out.println("No result found!");
        }
    }

}