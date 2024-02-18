package Chapter15.Package09;

// Пример применения ссылки ссылки на конструктор

//В функциональном интерфейсе MyFunc определяется метод, возвращающий ссылку на класс MyClass
interface MyFunc {
    MyClass func(int n);
}

class MyClass {
    private int val;

    // Конструктор с одним аргументом
    MyClass(int val) {
        this.val = val;
    }

    // Конструктор по умолчанию
    MyClass() {
        this.val = 0;
    }

    int getVal() {
        return this.val;
    }
}

class ConstructorRefDemo {
    public static void main(String[] args) {
        // Создать ссылку на конструктор класса MyClass.
        // Метод func() из интерфейса MyFunc принимает аргумент,
        // поэтому в операции new вызывается параметризованный
        // конструктор класса MyClass, а не конструктор по умолчанию.
        MyFunc myClassCons = MyClass::new;

        // Создадим экземпляр класса MyClass по ссылке на его конструктор
        MyClass mcOb = myClassCons.func(88);

        // Используем только что созданный экземпляр класса MyClass
        System.out.println("Значение val в объекте mcOb равно: " + mcOb.getVal());
    }
}
/*
  MyFunc myClassCons = MyClass: :new;
В этой строке кода создается ссылка на конструктор класса МуСlass в выражении MyClass::new.
В данном случае ссылка делается наконструктор МуСlаss(int v), поскольку метод func()
из интерфейса MyFunc принимает параметр типа int, а с ним совпадает именно этот конструктор.
Обратите также внимание на то, что ссылка на этот конструктор присваивается переменной myClassCons
ссылки на функциональный интерфейс MyFunc. После выполнения данной строки кода переменную myClassCons
можно использовать для создания экземпляра класса MyClass. По существу, переменная myClassCons
предоставляет еще один способ вызвать конструктор MyClass(int v).
  MyClass mc = myClassCons.func(88);
Аналогичным образом создаются ссылки на конструкторы обобщенных классов.
Единственное отличие состоит в том, что в данном случае может быть указан аргумент типа.
И делается это после имени класса, как и при создании ссылки на обобщенный метод.

Вывод в консоль:
----------------------------------
Значение val в объекте mcOb равно: 88
 */
