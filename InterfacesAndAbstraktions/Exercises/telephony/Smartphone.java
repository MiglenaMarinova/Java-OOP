package InterfacesAndAbstraktions.Exercises.telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable{

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    private boolean isInvalidURL(String url){
        for (char singleChar : url.toCharArray()){
            if (Character.isDigit(singleChar)){
                return true;
            }
        }
        return false;
    }


    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();
        for (String url : urls){
            if (isInvalidURL(url)){
                output.append(String.format("Invalid URL!%n"));
            }else {
                output.append(String.format("Browsing: %s!%n", url));
            }
        }

        return output.toString().trim();
    }
    private boolean isInvalidNumber (String number){
        for (char singleChar : number.toCharArray()){
            if (!Character.isDigit(singleChar)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String call() {
       StringBuilder output = new StringBuilder();
       for (String number : numbers){
           if (isInvalidNumber(number)){
               output.append(String.format("Invalid number!%n"));
           }else {
               output.append(String.format("Calling... %s%n", number));
           }
       }
       return output.toString().trim();
    }
}
