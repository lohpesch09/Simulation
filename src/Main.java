import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static class User {
        private int ID;
        private String FirstName;
        private String LastName;
        private int age;
        private String Country;

        public User(int _ID, String _FirstName, String _LastName, int _age, String _Country) {
            ID = _ID;
            FirstName = _FirstName;
            LastName = _LastName;
            age = _age;
            Country = _Country;
        }

        public int getID() {
            return ID;
        }

        public void setID(int _ID) {
            ID = _ID;
        }

        public String getFirstName() {
            return FirstName;
        }

        public void setFirstName(String _FirstName) {
            FirstName = _FirstName;
        }

        public String getLastName() {
            return LastName;
        }

        public void setLastName(String _LastName) {
            LastName = _LastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int _age) {
            age = _age;
        }

        public String getCountry() {
            return Country;
        }

        public void setCountry(String _Country) {
            Country = _Country;
        }

        public void println() {
            System.out.println(ID + " " + FirstName + " " + LastName + " " + age + " " + Country);
        }
    }


    static void putUsersArrayList(ArrayList<User> users) {

        users.add(new User(123456789, "Nastia", "Starodub", 19, "Russia"));
        users.add(new User(123456788, "Lisa", "Gordova", 23, "USA"));
        users.add(new User(123456787, "Victor", "Pervushin", 20, "Japan"));
        users.add(new User(123456786, "Egor", "Zadvornov", 21, "Turkey"));
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();

        putUsersArrayList(users);

        Stream stream = users.stream();

        System.out.println("\nСортировка по фамилии:");

        users.stream()
                .sorted(Comparator.comparing(User::getLastName))
                .forEach(user -> System.out.println(user.getFirstName() + " " + user.getLastName()));

        System.out.println("\nСортировка по возрасту:");

        users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .forEach(user -> System.out.println(user.getFirstName() + " " + user.getLastName()));

        boolean a = users.stream()
                .allMatch(user -> user.getAge()>7);

        System.out.println("\nПроверка, что всем пользователям больше 7 лет - " + a);

        double averageAge = users.stream()
                .mapToDouble(User::getAge)
                .average().getAsDouble();

        System.out.println("\nСредний возраст пользователей: " + averageAge);

        int amountCountries = (int) users.stream()
                .map(User::getCountry)
                .distinct()
                .count();

        System.out.println("\nКоличество стран проживания: " + amountCountries);
    }
}
