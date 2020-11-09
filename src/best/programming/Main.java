package best.programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.run();
    }

    private void run(){
        List<String> names = new ArrayList<>();
        names.add("Iza");
        names.add("Agnieszka");
        names.add("Wojciech");
        names.add("Monika");
        names.add("Adrian");
        names.add("Mateusz");
        names.add("Kamil");
        names.add("Viki");
        names.add("Szymon");

        names.stream()
                .filter(s -> s.endsWith("n"))
                .map(name -> name + "!")
                .forEach(this::print);

        names = filter(names, name -> name.endsWith("a"));

        modifyAndDisplay(names, s -> s + "!");
    }

    private void print(String str){
        System.out.println(str);
    }

    private List<String> filter(List<String> input, Filter filter){
        List<String> resultList = new ArrayList<>();
        for(String name : input){
            if(filter.filter(name)){
                resultList.add(name);
            }
        }
        return resultList;
    }

    private void modifyAndDisplay(List<String> names, Modifier modifier) {
        List<String> modifiedNames = new ArrayList<>();

        for(String name : names){
            String modifiedName = modify(name, modifier);
            modifiedNames.add(modifiedName);
        }

        System.out.println(modifiedNames);
    }

    public String modify(String string, Modifier modifier){
        return modifier.modify(string);
    }
}
