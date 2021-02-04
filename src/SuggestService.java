import java.io.*;
import java.util.*;

/**
 *  created by malevinsky
 *  email: malevwork@gmail.com
 *  telegram: @theos_deus
 *  date: 03.02.2021
 */

public class SuggestService {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>(); //создаём ArrayList для списка компаний
        Solution.SuggestServices(list); //
    }
}

    class Solution {
        public static void SuggestServices(List<String> companyNames) throws IOException {

            /**
             * Первым делом создаём Scanner, чтобы можно было ввести строку и кол-во компаний.
             * Для удобства я вывела подсказки где что нужно ввести.
             * Создаём BufferReader для файла (yandex-scala/src/companies.txt), далее добавляем его содержимое(1000 назвний) в наш List companyNames.
             * Если будете запускать, измените путь на тот, где данный файл находится у вас на компьютере.
             * Передаём параметры в функцию suggest.
             * Закрываем поток.
             */

            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите строку с которой начинается название компании:");
            String searchString = scanner.next();
            System.out.println("Введите кол-во компаний, которые нужно вывести:");
            int numberOfWords = scanner.nextInt();
            BufferedReader buffer_reader = new BufferedReader(new FileReader("/home/theodora/Downloads/yandex-scala/src/companies.txt"));

            String line;
            while ((line = buffer_reader.readLine()) != null) {
                companyNames.add(line);
            }

            suggest(searchString, numberOfWords, companyNames);
            buffer_reader.close();
        }

        public static void suggest(String input, Integer numberOfSuggest, List<String> companyNames) {

            /**
             * Создаём счетчик для того, чтобы вывести нужное кол-во компаний.
             * Если счётчик меньше нужного числа и слово начинается с нужной строки, мы его печаем и увеличиваем счетчик.
             */

            int count = 0;
            System.out.println("Названия компаний:");
            for (String s : companyNames) {
                if (count < numberOfSuggest && s.startsWith(input)) {
                    count++;
                    System.out.println(s);
                }
            }
        }
    }


