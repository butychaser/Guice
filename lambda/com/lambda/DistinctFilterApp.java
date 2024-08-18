package com.lambda;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DistinctFilterApp {

    public static class User{
        public User(String name){ this.name = name;}
        private String  name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }

        public String toString(){
            return name;
        }
    }

    public static <T> Predicate<T> distinctFilter(Function<? super T,?> f) {
        Set<Object> distinctKey = new ConcurrentHashMap<>().keySet(new Object());
        return t-> distinctKey.add(f.apply(t));
    }
    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User("1"), new User("2"), new User("1"));
        User oneUser = new User("1");
        User twoUser = new User("2");
        User threeUser = new User("3");

        List<User> mutableUsers = Arrays.asList(oneUser, twoUser, threeUser);
        oneUser.setName("2");
        mutableUsers.size();

        Function<User,Object> f = User::getName;

        int length = users.stream().filter(distinctFilter(f)).collect(Collectors.toList()).size();
        System.out.println(length);

        length = mutableUsers.stream().filter(distinctFilter(f)).collect(Collectors.toList()).size();
        System.out.println(length);

    }
}
