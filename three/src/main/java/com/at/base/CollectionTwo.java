package com.at.base;

import com.at.base.pclass.Account;
import com.at.base.pclass.Car;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionTwo {
    public ArrayList<String> collect() {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("1", "22", "333"));
        String[] strings = {"1", "2", "3"};
        ArrayList<String> arrayList1 = new ArrayList<>(Arrays.asList(strings));
        Stream<String> stream = arrayList.stream().filter(x -> {
            if (x.length() <= 1) {
                System.out.println(x);
                return false;
            }
            return true;
        });
        System.out.println(Arrays.toString(stream.toArray()));

        String s = Stream.of("100", "22", "33", "4").max(Comparator.comparing(x -> {
            return x.length();
        })).get();
        System.out.println(s);

        return null;
    }

    public ArrayList<String> collect1() {
//        TreeSet<String> collect = Stream.of("10", "21", "3", "444").collect(Collectors.toCollection(TreeSet::new));
        ArrayList<String> collect = Stream.of("10", "21", "3", "444").collect(Collectors.toCollection(ArrayList::new));
//        Set<String> collect = Stream.of("10", "21", "3", "444").collect(Collectors.toSet());
        System.out.println(collect);
        Function<String, Integer> getLen = x -> x.length();
        Optional<String> collect1 = collect.stream().collect(Collectors.maxBy(Comparator.comparing(getLen)));
        Double collect2 = collect.stream().collect(Collectors.averagingInt(x -> x.length()));
        System.out.println(collect2);
        // 拼接字符串
        String collect3 = collect.stream().collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect3);
        return null;
    }

    public void collectReduce() {
        ArrayList<String> collect = Stream.of("10", "21", "3", "444").collect(Collectors.toCollection(ArrayList::new));
        StringJoiner reduce = collect.stream()
                .reduce(new StringJoiner(",", "[", "]"),
                        StringJoiner::add,
                        StringJoiner::merge);
        System.out.println(reduce);
        String reduce1 = collect.stream().reduce("", (x, y) -> {
            y = y + "123";
            return x + y;
        });
        System.out.println(reduce1);
    }

    public void collectMap(){
        Car car = new Car("3", "v6");
        Car car1 = new Car("1", "v8");
        Car car2 = new Car("2", "v8");
        Car car3 = new Car("1", "v8");
        // 转map，第一个参数 键mapper，第二个参数 值mapper， 第三个参数 当键重复时，选用第一个保留不变
        Map<String, Car> collectMap = Stream.of(car, car1, car2).collect(Collectors.toMap(t -> t.getWheel(), t -> t, (n1, n2) -> n1));
        // 效果同上写法
        Map<String, Car> collectMap2 = Stream.of(car, car1, car2).collect(Collectors.toMap(Car::getWheel, Function.identity(), (n1, n2) -> n1));
        // 为保证有序，需要提供第四个参数
        LinkedHashMap<String, Car> collectLinkedHashMap = Stream.of(car, car1, car2, car3).collect(Collectors.toMap(t -> t.getWheel(), t -> t, (n1, n2) -> n1, LinkedHashMap::new));
        System.out.println(collectLinkedHashMap);
        System.out.println(collectMap2);
    }

    public void hashSet(){
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("1");
        HashSet<String> strings = new HashSet<>(Arrays.asList("1", "2", "1"));
        System.out.println(strings);
    }

    public void sort1(){
        Account a = new Account(100, "a");
        Account b = new Account(80, "b");
        Account c = new Account(120, "c");
        Account d = new Account(70, "d");
        Account e = new Account(80, "a");
        List<Account> accounts = Arrays.asList(a, b, c, d, e);
        accounts.sort(Comparator.comparing(Account::getMoney).reversed());
        System.out.println(accounts);

        Comparator<Account> sortByMoney = (Account t1, Account t2) -> (t2.getMoney() - t1.getMoney()) ;
        List<Account> accounts2 = Arrays.asList(a, b, c, d, e);
        accounts2.sort(sortByMoney);
        System.out.println(accounts2);

        Stream<Account> sorted = Stream.of(a, b, c, d, e).sorted(Comparator.comparing(Account::getMoney).reversed().thenComparing(Account::getAname));
        List<Account> collect = sorted.collect(Collectors.toList());
        System.out.println(collect);
        ArrayList<Object> objects = new ArrayList<>();
        List<Object> list = objects.stream().filter(Objects::nonNull).map(n -> {
            return n;
        }).collect(Collectors.toList());
        System.out.println(list);
    }

    public static void main(String[] args) {
        CollectionTwo two = new CollectionTwo();
        two.collect();
        BinaryOperator<Long> run = (x, y) -> x + y;
        Long apply = run.apply(1L, 2L);
        two.collect1();
        System.out.println("---------------collectReduce");
        two.collectReduce();
        System.out.println("---------------collectMap");
        two.collectMap();
        System.out.println("---------------hashSet");
        two.hashSet();
        Account ccc = new Account(100, "ccc");
        Account ddd = new Account(200, "ddd");
        Account eee = new Account(300, "eee");
        List<Account> list = Arrays.asList(ccc, ddd, eee);
        long sum = list.stream().mapToLong(Account::getMoney).sum();
//        ArrayList<Object> list1 = new ArrayList<>();
//        long sum1 = list1.stream().mapToLong(Account::getMoney).sum();
//        System.out.println(sum1);
        two.sort1();
        System.out.println(list.size());

        Set<Long> longSet = new HashSet<Long>();
        longSet.add(1L);
        longSet.add(1L);
        List<Integer> asList = Arrays.asList(1, 1, 1, 1, 2);
        HashSet<Long> hashSet = new HashSet<>();
        hashSet.add(1L);
        System.out.println(hashSet);;

    }
}
