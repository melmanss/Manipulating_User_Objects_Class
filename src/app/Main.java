package app;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        userRepository.addUser(new User(1, "Alice", "alice@example.com"));
        userRepository.addUser(new User(2, "Vlad", "vlad@example.com"));
        userRepository.addUser(new User(3, "Oleg", "oleg@example.com"));
        userRepository.addUser(new User(4, "Dima", "dima@example.com"));
        userRepository.addUser(new User(5, "Sasha", "sasha@example.com"));

        int searchId = 3;
        userRepository.findUserById(searchId)
                .ifPresentOrElse(
                        user -> System.out.println("Знайдено користувача: " + user),
                        () -> System.out.println("Користувача з id " + searchId + " не знайдено.")
                );

        String searchEmail = "boom@example.com";
        userRepository.findUserByEmail(searchEmail)
                .ifPresentOrElse(
                        user -> System.out.println("Знайдено користувача: " + user),
                        () -> System.out.println("Користувача з email " + searchEmail + " не знайдено.")
                );

        userRepository.findAllUsers()
                .ifPresentOrElse(
                        userList -> System.out.println("Кількість користувачів: " + userList.size()),
                        () -> System.out.println("Список користувачів порожній.")
                );
    }
}