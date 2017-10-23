package com.test;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ListenYoung on 2017/5/8.
 */

class Person{
    private Long id;
    private String name;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static Person createPerson(){
        return new Person((long)(Math.random() * 1000), "test", 18);
    }
}

public class TestLambda {
    public static void main(String[] args){
//        JButton button = new JButton();
//        button.addActionListener(event -> System.out.print(event.getActionCommand()));
        List<Person> persons = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i ++){
            persons.add(Person.createPerson());
        }
//简单应用 不过在filter上有问题，下面正是问题的所在 使用peek方法来解决这个问题
        persons.stream()
                .filter(person -> person.getId() > 500)
                .peek(person -> System.out.println("this is peek:" + person.getId()))
                .count();
        //System.out.print(count);

        //collect操作 整合结果形式
        List<Person> personList = Stream.of(Person.createPerson(), Person.createPerson(), Person.createPerson())
                .collect(Collectors.toList());
        personList.stream().filter(person -> {
            System.out.println("this is a collect : " + person);
           return true;
        }).count();

        //map操作 果然可以先过滤 再转化 转化
        List<String> idStrList = Stream.of(Person.createPerson(), Person.createPerson(), Person.createPerson())
                                        .filter(person -> person.getId() > 500)
                                        .map(person -> new Long(person.getId()).toString())
                                        .collect(Collectors.toList());
        idStrList.stream().filter(id -> {
            System.out.println("this is map:" + id);
            return true;
        }).count();

        //filter + collect 过滤之后 剩余值变成了新的list
        List<Person> newPersonList = persons.stream()
                .filter(person -> person.getId() > 500).collect(Collectors.toList());
        newPersonList.stream()
                .filter(person -> {
                    System.out.println("this is filter : " + person.getId());
                    return true;
                }).count();
        //潜力在这里 joining，妙啊
        String result = persons.stream().map(person -> person.getName())
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(result);

        // flatMap 操作 可以传不同类型的进去 最后进行任意组合 牛逼啊 混合成一个流
        List<String> tempStrList = Arrays.asList(new String[]{"12", "23", "34"});
        List<Long> tempLongList = Arrays.asList(new Long[]{122L,342L,56L});
        List<String> testType = Stream.of(tempLongList, tempStrList)
                .flatMap(list -> list.stream().map(every -> every.toString()))
                .collect(Collectors.toList());
        testType.stream().filter(t -> {
            System.out.println("this is flatMap:" + t);
            return true;
        }).count();

        //min 操作
        Person minPerson = persons.stream()
                .min(Comparator.comparing(person -> person.getId())).get();
        System.out.println("this is min:" + minPerson.getId());

        //reduce 操作 reduce操作是不是更有潜力 还有待开发 比如拼接person里面所有的name
        StringBuffer names = new StringBuffer();
        persons.forEach(person -> names.append(person.getName()).append(","));
        Long longS = tempLongList.stream()
                .reduce(0L, (acc, every) -> acc + every);

        //使用reduce 实现了map 不过这样效率好低啊
        List<String> reduceMapList = tempLongList.stream().reduce(new ArrayList<String>(), (acc, every) -> {
            List<String> newAcc = new ArrayList<String>(acc);
            newAcc.add(every.toString());
            return newAcc;
        }, (List<String> left, List<String> right) -> {
            List<String> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        });
        reduceMapList.stream().forEach(str -> System.out.println("reduce -> map:" + str));

        //使用reduce 实现filter
        List<Long> reduceFilterList = tempLongList.stream().reduce(new ArrayList<Long>(), (acc, every) -> {
            if(every > 100){
                List<Long> newAcc = new ArrayList<Long>(acc);
                newAcc.add(every);
                return newAcc;
            }else{
                return acc;
            }
        }, (List<Long> left, List<Long> right) -> {
            List<Long> newLeft = new ArrayList<Long>(left);
            newLeft.addAll(right);
            return newLeft;
        });
        reduceFilterList.stream().forEach(l -> System.out.println("reduce -> filter:" + l));
        //寻找老的逻辑 放弃joining方法来尝试使用reduce来拼接
        StringBuffer reduceIds = persons.stream().reduce(new StringBuffer(), (acc, every) -> {
            if(every.getId() > 500){
                acc.append(every.getName()).append(",");
            }
            return acc;
        }, ( left, right) -> {
            return left.append(right);
        });
        System.out.println("reduce -> ids : " + reduceIds);

        //统计值系列 + 拆包stream
        persons.stream().mapToLong(person -> person.getId()).summaryStatistics();

        //optional 代替null的新对象
        Optional optional = Optional.ofNullable(null);
        optional.orElseGet(() -> "null");

        //尝试排序 这个排序并不是永久的 你懂的
        persons.stream().sorted(Comparator.comparing(person -> person.getId()))
                        .forEach(person -> System.out.println("this is sorted : " + person.getId()));
        //等同于上述操作,但前提是这个流中的对象要实现比较器接口
        persons.stream().forEachOrdered(person -> System.out.println("this is forEachOreer : " + person.getId()));

        //collect的数值用法代表
        Double average = persons.stream().collect(Collectors.averagingInt(Person :: getAge));
        //通过collect来进行分区 这个只能分两组
         Map<Boolean, List<Person>> fiveHPs = persons.stream().collect(
                 Collectors.partitioningBy(person -> person.getId() > 500));
        //更多的花式分组通过groupingBy来搞定
        Map<String, Double> averMap = persons.stream().collect(
          Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getId))
        );
        Map<String, List<String>> strMap = persons.stream().collect(
                Collectors.groupingBy(Person::getName,
                        Collectors.mapping(person ->person.getId().toString(), Collectors.toList()))
        );
        //类似Python的map迭代
        averMap.forEach((name, averId) ->{
            System.out.println("this is map for each : " + name + "," + averId.toString());
        });

        //简单的并行化处理
        persons.parallelStream().mapToLong(Person::getId).sum();

        //method for arrays
        Double[] doubles = new Double[20];
        Arrays.parallelSetAll(doubles, i -> {
            return i * 2.5;
        });
        List<Double> doubleList = Arrays.asList(doubles);
        doubleList.forEach(d -> System.out.println("this is arrays : " + d));
    }
}


























