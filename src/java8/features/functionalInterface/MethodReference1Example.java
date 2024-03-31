package java8.features.functionalInterface;

import java8.features.repo.Person;
import java8.features.repo.PersonRepository;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReference1Example {
    public static void main(String[] args) {
        IUser iuser = User::new;
        User user = iuser.getUser("vivek");
        System.out.println(user.getName());

    }
}


@FunctionalInterface
interface IUser{
User getUser(String Name);
}

class User{
    private String name;
    public User(String name){
        super();
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}