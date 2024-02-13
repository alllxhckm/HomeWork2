import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        System.out.println();
        //Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        System.out.println("Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей)");
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(t -> t.getValue()))
                        .forEach(t -> System.out.println(t));
        System.out.println();
        System.out.println();

        //Вывести список неповторяющихся городов, в которых работают трейдеры.
        System.out.println("Вывести список неповторяющихся городов, в которых работают трейдеры.");
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(t -> System.out.println(t));
        System.out.println();
        System.out.println();

        //Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        System.out.println("Найти всех трейдеров из Кембриджа и отсортировать их по именам.");
        transactions.stream()
                .map(t -> t.getTrader())
                .distinct()
                .filter(t -> t.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(t -> t.getName()))
                .forEach(t -> System.out.println(t));
        System.out.println();
        System.out.println();

        //Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        System.out.println("Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.");
        transactions.stream()
                .map(t -> t.getTrader())
                .distinct()
                .map(t -> t.getName())
                .sorted()
                .forEach(t -> System.out.println(t));
        System.out.println();
        System.out.println();

        //Выяснить, существует ли хоть один трейдер из Милана.
        System.out.println("Выяснить, существует ли хоть один трейдер из Милана.");
        Optional<Trader> fromMilan = transactions.stream()
                .map(t -> t.getTrader())
                .distinct()
                .filter(t -> t.getCity().equals("Milan"))
                .findAny();
                if(fromMilan.isEmpty()){
                    System.out.println("We haven't some traders from Milan");
                }
                else {
                    System.out.println("We have some traders from Milan");
                }
        System.out.println();
        System.out.println();

        //Вывести суммы всех транзакций трейдеров из Кембриджа.
        System.out.println("Вывести суммы всех транзакций трейдеров из Кембриджа. \n" +
                transactions.stream()
                        .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                        .mapToInt(t -> t.getValue())
                        .sum());
        System.out.println();
        System.out.println();

        //Какова максимальная сумма среди всех транзакций?
        System.out.println("Какова максимальная сумма среди всех транзакций? \n" + transactions.stream()
                        .mapToInt(t -> t.getValue())
                .max()
                .orElse(0));
        System.out.println();
        System.out.println();

        //Найти транзакцию с минимальной суммой.
        System.out.println("Найти транзакцию с минимальной суммой. \n" +
                transactions.stream()
                        .mapToInt(t -> t.getValue())
                        .min()
                        .orElse(0));

    }
}
