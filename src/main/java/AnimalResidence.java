import animals.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.time.Year;


import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

public class AnimalResidence {
    public static void main(String[] args) throws IOException {
        System.out.println("Добрый день! Вы вошли в систему учета животных питомника AnimalResidence!" +
                "\nВыбирайте нужные вам опции из меню, вводя их номер");
        while (true) {
            System.out.println("_".repeat(72));
            System.out.println("""
                    !!!МЕНЮ!!!
                    1)Добавить в реестр новое животное
                    2)Увидеть список домашних животных питомника
                    3)Увидеть список вьючных животных питомника
                    4)Увидеть список всех животных питомника
                    5)Увидеть все записи реестра питомника
                    6)Обучить животное новым командам
                    7)Выход""");
            Scanner scanner = new Scanner(System.in);
            String choiceString = scanner.nextLine();
            int choice = 0;
            if (isNumeric(choiceString)) {
                choice = parseInt(choiceString);
            } else {
                System.out.println("Просим быть более внимательными при выборе опции. Повторите вход в систему снова");
                break;
            }

            switch (choice) {
                case 1 -> {
                    System.out.println("""
                            Вы хотите добавить в реестр домашнее или вьючное животное?
                            Если домашнее животное, нажмите цифру 6
                            Если вьючное животное, нажмите цифру 7
                            Если передумали ввводить животное, нажмите цифру 0""");
                    String choiceInCase1String = scanner.nextLine();
                    int choiceInCase1;
                    if (isNumeric(choiceInCase1String)) {
                        choiceInCase1 = parseInt(choiceInCase1String);
                    } else {
                        System.out.println("Просим быть более внимательными при выборе опции.");
                        break;
                    }
                    switch (choiceInCase1) {
                        case 6 -> {
                            System.out.println("""
                                    В настоящее время из домашних животных
                                    мы можем принимать только собак, кошек и хомяков
                                    Если хотите добавить собаку, нажмите 1
                                    Если хотите добавить кошку, нажмите 2
                                    Если хотите добавить хомяка, нажмите 3
                                    Если хотите выйти из этого подменю, нажмите 0""");
                            String choiceinCase16String = scanner.nextLine();
                            int choiceInCase16;
                            if (isNumeric(choiceinCase16String)) {
                                choiceInCase16 = parseInt(choiceinCase16String);
                            } else {
                                System.out.println("Просим быть более внимательными при выборе вида животного");
                                break;
                            }
                            if (choiceInCase16 >= 1 && choiceInCase16 <= 3) {
                                System.out.println("Просим быть внимательными при вводе ответов на следующие вопросы");
                            } else {
                                break;
                            }
                            String name = askName();
                            ArrayList<String> essentialData = askDateBirth();
                            String year = essentialData.get(0);
                            String month = essentialData.get(1);
                            String day = essentialData.get(2);
                            String birthDate = validationBirthDate(year, month, day);
                            if (birthDate.equals("")) {
                                System.out.println("Данные заполнены некорректно. Попытайтесь заново." +
                                        "\nУделите внимание году рождения и корректности месяца, числа");
                                break;
                            }
                            System.out.println("Данные валидны");
                            String comms = askCommands();
                            System.out.println(comms);
                            ArrayList<String> commandsList_ = new ArrayList<>();
                            if (!comms.equals("")) {
                                String[] parts = comms.split(" ");
                                commandsList_.addAll(Arrays.asList(parts));
                                System.out.println(commandsList_);
                            }
                            if (choiceInCase16 == 1) {
                                Dog dog;
                                if (commandsList_.size() > 0) {
                                    dog = new Dog(name, birthDate, commandsList_);
                                } else {
                                    dog = new Dog(name, birthDate);
                                }
                                System.out.println(dog.getInfo());
                                saveRecord(dog.getInfo());
                            }
                            if (choiceInCase16 == 2) {
                                Cat cat;
                                if (commandsList_.size() > 0) {
                                    cat = new Cat(name, birthDate, commandsList_);
                                } else {
                                    cat = new Cat(name, birthDate);
                                }
                                System.out.println(cat.getInfo());
                                saveRecord(cat.getInfo());
                            }
                            if (choiceInCase16 == 3) {
                                Hamster hamster;
                                if (commandsList_.size() > 0) {
                                    hamster = new Hamster(name, birthDate, commandsList_);
                                } else {
                                    hamster = new Hamster(name, birthDate);
                                }
                                System.out.println(hamster.getInfo());
                                saveRecord(hamster.getInfo());
                            }
                        }
                        case 7 -> {
                            System.out.println("""
                                    В настоящее время из вьючных животных
                                    мы можем принимать только лошадей, верблюдов и ослов
                                    Если хотите добавить лошадь, нажмите 4
                                    Если хотите добавить верблюда, нажмите 5
                                    Если хотите добавить осла, нажмите 6
                                    Если хотите выйти из этого подменю, нажмите 0""");
                            String choiceinCase17String = scanner.nextLine();
                            int choiceInCase17;
                            if (isNumeric(choiceinCase17String)) {
                                choiceInCase17 = parseInt(choiceinCase17String);
                            } else {
                                System.out.println("Просим быть более внимательными при выборе вида животного");
                                break;
                            }
                            if (choiceInCase17 >= 4 && choiceInCase17 <= 6) {
                                System.out.println("Просим быть внимательными при вводе ответов на следующие вопросы");
                            } else {
                                break;
                            }
                            String name__ = askName();
                            ArrayList<String> essentialData__ = askDateBirth();
                            String year__ = essentialData__.get(0);
                            String month__ = essentialData__.get(1);
                            String day__ = essentialData__.get(2);
                            String birthDate__ = validationBirthDate(year__, month__, day__);
                            if (birthDate__.equals("")) {
                                System.out.println("""
                                        Данные заполнены некорректно. Попытайтесь заново.
                                        Уделите внимание году рождения и корректности месяца, числа.
                                        Не ставьте ненужные пробелы\s""");
                                break;
                            }
                            System.out.println("Данные валидны");
                            String comms__ = askCommands();
                            System.out.println(comms__);
                            ArrayList<String> commandsList___ = new ArrayList<>();
                            if (!comms__.equals("")) {
                                String[] parts = comms__.split(" ");
                                commandsList___.addAll(Arrays.asList(parts));
                                System.out.println(commandsList___);
                            }
                            if (choiceInCase17 == 4) {
                                Horse horse;
                                if (commandsList___.size() > 0) {
                                    horse = new Horse(name__, birthDate__, commandsList___);
                                } else {
                                    horse = new Horse(name__, birthDate__);
                                }
                                System.out.println(horse.getInfo());
                                saveRecord(horse.getInfo());
                            }
                            if (choiceInCase17 == 5) {
                                Camel camel;
                                if (commandsList___.size() > 0) {
                                    camel = new Camel(name__, birthDate__, commandsList___);
                                } else {
                                    camel = new Camel(name__, birthDate__);
                                }
                                System.out.println(camel.getInfo());
                                saveRecord(camel.getInfo());
                            }
                            if (choiceInCase17 == 6) {
                                Donkey donkey;
                                if (commandsList___.size() > 0) {
                                    donkey = new Donkey(name__, birthDate__, commandsList___);
                                } else {
                                    donkey = new Donkey(name__, birthDate__);
                                }
                                System.out.println(donkey.getInfo());
                                saveRecord(donkey.getInfo());
                            }
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Вывожу список наших домашних животных");
                    HashMap<String, String> petMap = new HashMap<>();
                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("animalsList.txt"))) {
                        String st;
                        while ((st = bufferedReader.readLine()) != null) {
                            if (!st.isEmpty()) {
                                String[] sts = st.split(" ");
                                if (sts[2].equals("собака") || sts[2].equals("кошка") || sts[2].equals("хомяк")) {
                                    String key_ = sts[0] + " " + sts[1] + " " + sts[2] + " " + sts[3];
                                    StringBuilder valueBuilderPetMap = new StringBuilder();
                                    for (int i = 4; i < sts.length; i++) {
                                        valueBuilderPetMap.append(sts[i]).append(" ");
                                    }
                                    String value_ = valueBuilderPetMap.toString();
                                    petMap.put(key_, value_);
                                }
                            }
                        }
                        System.out.println("Домашних животных всего в питомнике: " + petMap.size());
                        petMap.forEach((key, value) -> System.out.println(key + " : " + value));
                    } catch (FileNotFoundException e) {
                        System.out.println("Рекомендуем сначала внести какие-то записи в реестр");
                    }
                }
                case 3 -> {
                    System.out.println("Вывожу список наших вьючных животных");
                    HashMap<String, String> packMap = new HashMap<>();
                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("animalsList.txt"))) {
                        String sn;
                        while ((sn = bufferedReader.readLine()) != null) {
                            if (!sn.isEmpty()) {
                                String[] sns = sn.split(" ");
                                if (sns[2].equals("лошадь") || sns[2].equals("верблюд") || sns[2].equals("осел")) {
                                    String key_ = sns[0] + " " + sns[1] + " " + sns[2] + " " + sns[3];
                                    StringBuilder valueBuilderPackMap = new StringBuilder();
                                    for (int i = 4; i < sns.length; i++) {
                                        valueBuilderPackMap.append(sns[i]).append(" ");
                                    }
                                    String value_ = valueBuilderPackMap.toString();
                                    packMap.put(key_, value_);
                                }
                            }
                        }
                        System.out.println("Вьючных животных всего в питомнике: " + packMap.size());
                        packMap.forEach((key, value) -> System.out.println(key + " : " + value));
                    } catch (FileNotFoundException e) {
                        System.out.println("Рекомендуем сначала внести какие-то записи в реестр");
                    }
                }
                case 4 -> {
                    System.out.println("Вывожу список всех животных питомника");
                    HashMap<String, String> map = new HashMap<>();
                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("animalsList.txt"))) {
                        String sr;
                        while ((sr = bufferedReader.readLine()) != null) {
                            if (!sr.isEmpty()) {
                                String[] srs = sr.split(" ");
                                String key_ = srs[0] + " " + srs[1] + " " + srs[2] + " " + srs[3];
                                StringBuilder valueBuilder_ = new StringBuilder();
                                for (int i = 4; i < srs.length; i++) {
                                    valueBuilder_.append(srs[i]).append(" ");
                                }
                                String value_ = valueBuilder_.toString();
                                map.put(key_, value_);
                            }
                        }
                        System.out.println("Животных всего в питомнике: " + map.size());
                        map.forEach((key, value) -> System.out.println(key + " : " + value));
                    } catch (FileNotFoundException e) {
                        System.out.println("Рекомендуем сначала внести какие-то записи в реестр");
                    }
                }
                case 5 -> {
                    System.out.println("Вывожу все записи реестра питомника.");
                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("animalsList.txt"))) {
                        String str;
                        while ((str = bufferedReader.readLine()) != null) {
                            if (!str.isEmpty()) {
                                System.out.println(str);
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Рекомендуем сначала внести какие-то записи в реестр");
                    }
                }
                case 6 -> {
                    System.out.print("Давайте обновим список команд, которое знает животное из нашей системы" +
                            "\nВведите имя животного: ");
                    String name_ = scanner.nextLine();
                    try (BufferedReader br = new BufferedReader(new FileReader("animalsList.txt"))) {
                        String stri;
                        while ((stri = br.readLine()) != null) {
                            if (!stri.isEmpty()) {
                                String[] strings = stri.split(" ");
                                if (strings[0].equals(name_)) {
                                    String oldData = strings[0] + " " + strings[1] + " " + strings[2] + " " + strings[3];
                                    System.out.println(oldData);
                                    oldData += " ";
                                    System.out.print("Сколько команд в целом теперь знает животное? ");
                                    String num_ = scanner.nextLine();
                                    int numint;
                                    StringBuilder newData = new StringBuilder();
                                    newData.append("знает команды: ");
                                    if ((isNumeric(num_)) && Integer.parseInt(num_) > 0) {
                                        numint = Integer.parseInt(num_);
                                        System.out.println("Теперь попросим вас перечислить весь перечень команд, старых и новых");
                                        for (int i = 0; i < numint; i++) {
                                            System.out.print("Введите команду, не используя пробел, иначе команда не будет засчитана: ");
                                            String comm_ = scanner.nextLine().trim();
                                            assert false;
                                            if (comm_.split(" ").length == 1) newData.append(comm_).append(" ");
                                        }

                                        System.out.println(newData);
                                        String newData_ = newData.toString();
                                        if (newData_.split(" ").length == 2) newData_ = "не знает команд";
                                        assert false;
                                        saveRecord(oldData + newData_);

                                    } else {
                                        System.out.println("Вы ввели некорректные данные. Попытайтесь заново");
                                    }
                                    break;
                                }
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Рекомендуем сначала внести какие-то записи в реестр");
                    }
                }
                case 7 -> {
                    System.out.println("Спасибо за работу с нашей системой учета!");
                    scanner.close();
                    exit(0);
                }
            }
        }
    }

    public static String askName() {
        System.out.print("Введите имя животного, не используя пробел: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine().trim();
        if (name.isEmpty() || name.split(" ").length > 1) name = askName();
        return name;
    }

    public static ArrayList<String> askDateBirth() {
        ArrayList<String> dataForValidation = new ArrayList<>(3);
        System.out.print("Введите год рождения: ");
        Scanner sc = new Scanner(System.in);
        dataForValidation.add(sc.nextLine());
        System.out.print("Введите месяц рождения: ");
        dataForValidation.add(sc.nextLine());
        System.out.print("Введите число месяца рождения: ");
        dataForValidation.add(sc.nextLine());
        return dataForValidation;
    }

    public static String validationBirthDate(String year, String month, String day) {
        String birthDateChecked = "";
        int currentYear = Year.now().getValue();
        if (isNumeric(year)) {
            int yearInt = parseInt(year);
            if (yearInt < 1950 || yearInt > currentYear) {
                System.out.println("Некорректный год рождения");
            } else {
                birthDateChecked = String.valueOf(yearInt);
                if (isNumeric(month)) {
                    int monthInt = parseInt(month);
                    if (monthInt < 1 || monthInt > 12) {
                        System.out.println("Некорректный месяц рождения");
                    } else {
                        if (monthInt < 10) {
                            birthDateChecked += "-0" + monthInt;
                        } else {
                            birthDateChecked += "-" + monthInt;
                        }
                        if (isNumeric(day)) {
                            int dayInt = parseInt(day);
                            if (dayInt < 1 || dayInt > 31) {
                                System.out.println("Некорректное число месяца рождения");
                            } else {
                                if (dayInt < 10) {
                                    birthDateChecked += "-0" + dayInt;
                                } else {
                                    birthDateChecked += "-" + dayInt;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (birthDateChecked.length() < 10) birthDateChecked = "";
        return birthDateChecked;
    }

    public static String askCommands() {
        String commands_ = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Какие команды знает ваше животное? Если никаких, нажмите 0." +
                "\nЕсли знает хотя бы одну команду, наберите в ответе количество команд: ");
        String numberStr = sc.nextLine();
        if (isNumeric(numberStr)) {
            if (Integer.parseInt(numberStr) < 0 || Integer.parseInt(numberStr) == 0) commands_ = "";
            else {
                int numberInt = Integer.parseInt(numberStr);
                commands_ = commandsQuestionnaire(numberInt);
            }
        } else commands_ = "";

        return commands_;
    }

    public static String commandsQuestionnaire(int num) {
        StringBuilder commands = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < num; i++) {
            System.out.print("Введите команду, не используя пробел: ");
            String command = sc.nextLine().trim();
            if (command.split(" ").length > 1) System.out.println("Просим не использовать пробел!");
            ;
            if (command.split(" ").length == 1) commands.append(command).append(" ");
        }
        return commands.toString();
    }

    public static void saveRecord(String record) {
        try (FileWriter fileWriter = new FileWriter("animalsList.txt", true)) {
            fileWriter.write(record);
            fileWriter.append('\n');
            fileWriter.flush();
            System.out.println("Запись о вашем животном внесена в систему");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}