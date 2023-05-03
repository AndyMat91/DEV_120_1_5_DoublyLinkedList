package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*list.addInBeginning("Head");          //УСТРАНИЛ ПРЕДЫДУЩИЕ ЗАМЕЧАНИЯ (ИЗ DEV_110),МОЖНО РАСКОМИТИТЬ И ПРОВЕРИТЬ
        list.addInBeginning("333");
        list.addInBeginning("333");
        list.addInBeginning("333");
        list.addInBeginning("333");
        list.addInEnd("245");
        list.addInEnd("111");
        list.addInEnd("How are you?");
        list.addInEnd("Tail");
        list.printAllDirectOrder();
        System.out.println("");
        list.remove("333");
        list.printAllDirectOrder();
        System.out.println("print");
        list.allReverseOrder().forEach(System.out::println);*/


        System.out.println("1). Создадим объект класса DoublyLinkedList<T>, параметризованный типом <String>, добавим значений\n" +
                "в начало и конец списка, а также выведем все значений на печать (в методе printAll использован перебор всего\n" +
                "содержимого списка от первого элемента до последнего, при помощи оператора «for-each»):");
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addInBeginning("333");
        list.addInBeginning("Head");
        list.addInEnd("245");
        list.addInEnd("111");
        list.addInEnd("How are you?");
        list.addInEnd("Tail");
        list.printAllDirectOrder();

        System.out.println("2). Перебирем при помощи оператора «for-each» содержимое списка от последнего элемента к первому при помощи оператора «for-each»:");
        list.allReverseOrder().forEach(System.out::println);
        System.out.println();

        System.out.println("3). Перебирем при помощи оператора «for-each» содержимое списка от головного узла до узла с заданным значением;\n" +
                "если список заданного значения не содержит, то должно быть перебрано всё содержимое списка;");
        System.out.println("Зададим значение 111:");
        list.listHeadToValue("111").forEach(System.out::println);
        System.out.println();
        System.out.println("Зададим значение 1234567890:");
        list.listHeadToValue("1234567890").forEach(System.out::println);
        System.out.println();

        System.out.println("4). Перебирем при помощи оператора «for-each» содержимое списка  от хвостового узла до узла с заданным значением;\n" +
                "если список заданного значения не содержит, то должно быть перебрано всё содержимое списка;");
        System.out.println("Зададим значение 111:");
        list.listTailToValue("111").forEach(System.out::println);
        System.out.println();
        System.out.println("Зададим значение 1234567890:");
        list.listTailToValue("1234567890").forEach(System.out::println);
        System.out.println();

        System.out.println("5). Перебирем при помощи оператора «for-each» содержимое списка  содержимое списка от узла с заданным значением до\n" +
                "конца(хвоста) списка; если список заданного значения не содержит, то ничего происходить не должно.");
        System.out.println("Зададим значение 245:");
        list.listValueToTail("245").forEach(System.out::println);
        System.out.println();
        System.out.println("Зададим значение 1234567890:");
        list.listValueToTail("1234567890").forEach(System.out::println);
        System.out.println("Ничего не произошло =)");
        System.out.println();

        System.out.println("6).Перебирем при помощи оператора «for-each» содержимое списка содержимое списка от узла с заданным значением до\n" +
                "начала(головы) списка; если список заданного значения не содержит, то ничего происходить не должно.");
        System.out.println("Зададим значение 245:");
        list.listValueToHead("245").forEach(System.out::println);
        System.out.println();
        System.out.println("Зададим значение 1234567890:");
        list.listValueToHead("1234567890").forEach(System.out::println);
        System.out.println("Ничего не произошло =)");
        System.out.println();

        System.out.println("7). Извлечение значения из начала списка без его удаления из списка:");
        Object i = list.extValueFromTheBeginningWithoutDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную");
        System.out.println("Значение осталось в списке:");
        list.printAllDirectOrder();

        System.out.println("8). Извлечение значения из начала списка с удалением его из списка:");
        i = list.extValueFromTheBeginningWithDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную.");
        System.out.println("Значение удалилось из списка:");
        list.printAllDirectOrder();

        System.out.println("9). Извлечение значения c конца списка без его удаления:");
        i = list.extValueFromTheEndWithoutDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную.");
        System.out.println("Значение осталось в списке:");
        list.printAllDirectOrder();

        System.out.println("10). Извлечение значения с конца списка с удалением его из списка:");
        i = list.extValueFromTheEndWithDeleting();
        System.out.println("Значение " + i + " извлекли и поместили в другую переменную.");
        System.out.println("Значение удалилось из списка:");
        list.printAllDirectOrder();

        System.out.println("11). Определим, является ли список пустым, или нет:");
        System.out.println("Список пуст? - " + (list.empty() ? "Да!" : "Нет!"));

        System.out.println("12). Определим, содержит ли список заданное значение, или нет:");
        System.out.println("Содержит ли список значенеие 245? - " + (list.searchValue("245") ? "Да!\n" : "Нет!\n") +
                "А значение 777? - " + (list.searchValue("777") ? "Да!" : "Нет!"));

        System.out.println("13). Удалим заданное значение из списка, например 245: ");
        list.remove("245");
        list.printAllDirectOrder();
        System.out.println("Удалим несуществующее значение из списка, например 7776: ");
        list.remove("7776");
        System.out.println("Ничего не произошло.");

        System.out.println("14). Проверим метод, который добавляет все значения (100,200,300) заданного массива в начало списка. Порядок значений дол-\n" +
                "жен сохраняться — первое значение массива должно стать первым значением списка:");
        list.addAllArrayValuesToTheBeginning("100", "200", "300");
        list.printAllDirectOrder();


        System.out.println("15). Проверим метод, который добавляет все значения (1,2,3) заданной коллекции в начало списка с сохранением порядка:");
        List<String> test = new ArrayList<>();
        Collections.addAll(test, "1", "2", "3");
        list.addAllCollectionValuesToTheBeginning(test);
        list.printAllDirectOrder();

        System.out.println("16). Проверим метод, который добавляет все значения (400,500,600) заданного массива в конец списка с сохранением порядка:");
        list.addAllArrayValuesToTheEnd("400", "500", "600");
        list.printAllDirectOrder();

        System.out.println("17). Проверим метод, который добавляет все значения (11,22,33) заданной коллекции в конец списка с сохранением порядка:");
        List<String> test2 = new ArrayList<>();
        Collections.addAll(test2, "11", "22", "33");
        list.addAllCollectionValuesToTheEnd(test2);
        list.printAllDirectOrder();


        System.out.println("18). Проверим метод, который поглощает список другим списком с добавлением значений второго в начало\n" +
                "первого списка; после поглощения второй список очистится:");
        System.out.println("Создадим и заполним новый список, выведем значение нового списка:");
        DoublyLinkedList<String> list2 = new DoublyLinkedList<>();
        list2.addInBeginning("Hello!");
        list2.printAllDirectOrder();
        System.out.println("Теперь поглотим новым списком старый список и выведем новый список на печать:");
        list2.absorbingTheListToTheTop(list);
        list2.printAllDirectOrder();
        System.out.println("Проверим осталось ли что то в старом списке:");
        list.printAllDirectOrder();
        System.out.println("------пусто-----");
        System.out.println();

        System.out.println("19). Проверим метод, который поглощает список другим списком с добавлением значений второго в конец\n" +
                "первого списка, после поглощения второй список очистится:");
        System.out.println("Добавим START в наш пустой список:");
        list.addInBeginning("START");
        list.printAllDirectOrder();
        System.out.println("Поглотим предыдущим, оставшимся пустым, списком второй список и выведем на печать:");
        list.absorbingTheListToTheEnd(list2);
        list.printAllDirectOrder();
        System.out.println("Проверим осталось ли что то в списке:");
        list2.printAllDirectOrder();
        System.out.println("------пусто-----");
        System.out.println();
    }
}