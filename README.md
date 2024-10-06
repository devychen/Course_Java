<h1>Java101</h1>

<h3>Freq. Used</h3>
<p>String <a href="https://www.w3schools.com/java/java_ref_string.asp">methods</a></p>
<p><code>replace(OldChar, NewChar)</code>, 可以直接是token.</p>
<p>Scanner <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html">methods</a></p>

<p>对于字符串 "happy"，其 <code>.length()</code> 方法返回的长度是 5。</p>
<p>这是因为 String 的 <code>length()</code> 方法返回的是字符串中字符的数量。</p>
<p>在 Java 中，<code>String.length()</code> 计算的是字符数而不是字节数，因此它会按字符计数，包括空格、标点符号等。</p>

---

### 关于`super` <br>
让我们一步步来解释 `super()`、`super()` 带参数的用法，以及 `super.某个method` 之间的区别，以及它们各自的用法场景。

##### `super()` vs. `super(参数)`

1. **`super()`**:  
   当您在子类的构造方法中使用 `super()` 时，您是在调用父类的**无参数构造方法**。如果父类有一个无参数构造方法，您可以直接使用 `super()`，即使您不写 `super()`，Java 也会默认调用父类的无参构造方法。

2. **`super(参数)`**:  
   当您在子类的构造方法中使用 `super(参数)` 时，您是在调用父类的**带参数构造方法**。参数的类型和顺序必须与父类的构造方法匹配。这通常用于在创建子类对象时，需要为父类的部分属性赋值。

   在您的例子中：
   ```java
   public Patient(String aName, String aSsn){
       super(aName); // 调用 Person 类的构造方法，并传入 aName 参数
       setSsn(aSsn); // 设置 Patient 类特有的属性 ssn
   }
   ```
   这里的 `super(aName)` 意味着调用 `Person` 类的构造方法，并把 `aName` 传递给它，用于初始化 `Person` 的 `name` 属性。

##### `super.某个method`

- **`super.某个method`**:  
  当您使用 `super.某个method` 时，您是在调用父类的一个方法，而不是构造方法。这种用法通常在子类重写了父类的方法，但仍然希望在某些情况下调用父类的原始方法时使用。

  比如，如果 `Patient` 类重写了 `setName` 方法，但您在某些情况下希望调用 `Person` 类中的 `setName` 方法，可以这样做：

  ```java
  @Override
  public void setName(String name) {
      // 这里可以做一些额外的处理，然后调用父类的方法
      super.setName(name); // 调用父类 Person 的 setName 方法
  }
  ```

##### 如何知道什么时候用 `super()` 和 `super.某个method`

1. **调用父类构造方法**:
    - 当您希望在子类构造方法中初始化父类的部分（通常是通过父类的构造方法），您会使用 `super()` 或 `super(参数)`。
    - 例如，在构造 `Patient` 对象时，`super(aName)` 用于确保 `Person` 类中的 `name` 属性正确初始化。

2. **调用父类方法**:
    - 当您希望在子类中调用父类的方法（而非构造方法），例如当子类重写了一个方法，但在重写的过程中还需要使用父类的逻辑时，您会使用 `super.某个method`。
    - 例如，如果 `Patient` 类重写了 `setName`，但希望在新的逻辑中仍然使用 `Person` 类的 `setName` 方法，可以使用 `super.setName(aName)`。

##### 为什么不能用 `super.setName(aName)` 替代 `super(aName)`？

- **`super(aName)` 是调用构造方法**：这是在初始化对象的时候进行的操作，是在对象创建之初，调用父类构造函数以正确地设置或初始化父类的成员变量。

- **`super.setName(aName)` 是调用一个普通方法**：这是在对象创建之后，调用父类中的一个方法进行操作。

构造方法和普通方法是不同的概念，构造方法是用来创建和初始化对象的，必须在对象创建时执行。而普通方法可以在对象存在的整个生命周期内随时调用。因此，`super(aName)` 不能被 `super.setName(aName)` 取代，因为它们的职责不同。

##### 总结

- 使用 `super()` 或 `super(参数)` 来调用父类的构造方法，确保父类的部分正确初始化。
- 使用 `super.某个method` 来调用父类的普通方法，特别是当子类重写了该方法但仍希望使用父类的实现时。
- 什么时候使用哪种方式，取决于您是在构造对象时初始化父类的部分，还是在对象的生命周期内调用父类的行为。


### Functional Interface
函数式接口（Functional Interface）。函数式接口是指只包含一个抽象方法的接口。
A Functional Interface is an Interface which allows only one Abstract method within the Interface scope

### Predicate<String>
- Predicate 看起来抽象，是因为它是一个“行为的抽象”——它描述了一种行为（即判断某个条件是否成立），而不像 ArrayList 那样是一个实际的数据结构。  
- 你可以认为 Predicate 提供了一种“规则”，而不是“存储数据”的地方。这种抽象使得它非常灵活，可以应用在各种情况下进行条件判断，比如过滤集合、校验输入值等。  
- 理解 Predicate 的关键是把它看作一个逻辑判断的“模板”或“过滤器”，而不是一个数据容器。
- `Predicate<String> nameMatch = s -> s.equals("snook.moo");` 这句代码可以用自然语言描述为：“创建了一个名为 nameMatch 的 Predicate 对象，它用于检查某个字符串是否等于 "snook.moo"。”

### Iterator
什么时候使用 Iterator？
- 需要在遍历中删除或修改元素时：
   - 如果你需要在遍历集合时进行删除操作（例如删除所有满足某个条件的元素），使用 Iterator 是最合适的。
- 集合类型是 Set 或其他无序集合时：
   - for-each 循环适用于按顺序遍历的集合，而 Iterator 则不受限于此，可以适用于无序的 Set 或 Map。
- 更复杂的遍历逻辑时：
   - 如果在遍历中，你需要同时进行多种操作，如动态地添加、删除、替换元素，那么 Iterator 会比其他遍历方式更好控制。
 
```java
import java.util.ArrayList;
import java.util.Iterator;

public class IteratorComparison {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // 1. 使用for循环
        System.out.println("Using for loop:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // 2. 使用增强型for-each循环
        System.out.println("\nUsing enhanced for-each loop:");
        for (String fruit : list) {
            System.out.println(fruit);
        }

        // 3. 使用Iterator进行遍历和删除元素
        System.out.println("\nUsing Iterator (with removal operation):");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String fruit = iter.next();
            if (fruit.equals("Banana")) {
                iter.remove();  // 删除当前遍历到的元素
            } else {
                System.out.println(fruit);
            }
        }

        // 输出修改后的集合
        System.out.println("\nAfter removing 'Banana', the final list is: " + list);
    }
}

```

### `Comparable` Interface
Comparable 接口在 Java 中用于定义对象的自然排序顺序。通过实现 Comparable 接口，类的实例可以与同类的其他实例进行比较，从而能够在排序时使用（例如，在 Collections.sort() 或 Arrays.sort() 中）。

##### Comparable 的使用
Comparable 接口中只有一个方法 compareTo(T o)，其定义如下：
`int compareTo(T o);`
返回值：
如果当前对象小于 o，则返回负整数；
如果当前对象等于 o，则返回零；
如果当前对象大于 o，则返回正整数。
##### 具体例子
假设我们有一个 Student 类，希望按照学生的年龄对学生对象进行排序。我们可以通过实现 Comparable 接口并覆盖 compareTo 方法来定义排序规则。

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 实现 compareTo 方法，根据年龄排序
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + '}';
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 18));
        students.add(new Student("Charlie", 22));

        // 排序前
        System.out.println("Before sorting: " + students);

        // 对学生列表进行排序
        Collections.sort(students);

        // 排序后
        System.out.println("After sorting: " + students);
    }
}
```
运行结果  
Before sorting: [Student{name='Alice', age=20}, Student{name='Bob', age=18}, Student{name='Charlie', age=22}]
After sorting: [Student{name='Bob', age=18}, Student{name='Alice', age=20}, Student{name='Charlie', age=22}]
解释  
在 Student 类中实现了 Comparable<Student> 接口，并重写了 compareTo 方法。  
compareTo 方法中使用 Integer.compare(this.age, other.age) 进行比较：  
如果 this.age < other.age，返回负数，表示当前学生比 other 学生小。  
如果 this.age > other.age，返回正数，表示当前学生比 other 学生大。  
如果 this.age == other.age，返回零，表示两者相等。  
通过调用 Collections.sort(students)，能够按照年龄对 students 列表中的元素进行升序排序。最终排序结果显示，Bob（18岁）在最前，Charlie（22岁）在最后。  

这种方式非常适合用于简单的排序需求，但如果需要多重排序条件（如先按年龄排序，再按姓名排序），可以考虑使用 Comparator 接口。
