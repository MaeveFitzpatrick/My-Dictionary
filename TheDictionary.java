package Dictionary;

import java.util.Scanner;
import java.util.*;

public class TheDictionary implements DictionaryInterface {

    @Override
    public List<String> beginning() {

        //create search
        Scanner scanner = new Scanner(System.in);
        int searchIndex = 1;
        for (int i = 0; i < searchIndex; i++) {
            System.out.print("Search [" + searchIndex + "] : ");
            //ArrayList for user input
            List<String> defArray = new ArrayList<String>(Arrays.asList(scanner.nextLine().toUpperCase().split(" ")));
            int size = defArray.size();
            for (int j = 0; j < size; j++) {
                if (size < 2) {
                    oneParameter();
                }
                if (size == 2) {
                    twoParameters();
                }
                if (size == 3) {
                    threeParameters();
                }
            }
            searchIndex++;
        }
        return oneParameter();
    }

    @Override
    public void instructions() {
        System.out.println("PARAMETER HOW-TO, please enter: \n 1. A search key, then \n 2. An optional part of speech, then" +
                "-then 3. An optional 'reverse'");
    }

    @Override
    public List<String> oneParameter() {
        //if there is one parameter
        String firstParameter;
        List<String> defArray = this.beginning();
        firstParameter = defArray.get(0);
        int size = defArray.size();
        if (firstParameter.equals("!help".toUpperCase())) {
            instructions();
        }
        if (firstParameter.equals("")) {
            instructions();
        }
        if (firstParameter.equals("!q".toUpperCase())) {
            System.out.println("-----THANK YOU-----");
            //findWord
        } else {
            for (Definition d : Definition.values()) {
                if ((firstParameter.equalsIgnoreCase(d.getWord()))) {
                    System.out.println(d);
                }
            }
        }
        return defArray;
    }

    @Override
    public void twoParameters() {
        List<String> defArray = this.beginning();
        String firstParameter = defArray.get(0);
        String secondParameter = defArray.get(1);
        for (Definition d : Definition.values()) {
            //PART OF SPEECH
            if ((firstParameter.equalsIgnoreCase(d.getWord()) && (secondParameter.equalsIgnoreCase(d.getPartOfSpeech())))) {
                System.out.println(d);
                //DISTINCT
            } else if (secondParameter.equals("reverse".toUpperCase())) {
                Definition[] reverseValues = Definition.values();
                //loops through enums backwards
                for (int b = reverseValues.length - 1; b >= 0; --b) {
                    Definition c = Definition.values()[b];
                    System.out.println(c);
                }
            } else {
                System.out.println("<The entered 2nd parameter '" + secondParameter + "' is NOT a part of speech.>" +
                        "\n <The entered 2nd parameter '" + secondParameter + "' is NOT 'reverse'.>" +
                        "\n <The entered 2nd parameter '" + secondParameter + "' was disregarded.>" +
                        "<The 2nd parameter should be a part of speech or 'reverse'.>");
            }
        }
    }


    @Override
    public void threeParameters() {
        List<String> defArray = this.beginning();
        int size = defArray.size();
        String thirdParameter = defArray.get(2);
        //ensures proper 3rd parameter
        if (thirdParameter.equals("reverse".toUpperCase()) || thirdParameter.isEmpty()) {
            // findReverse();
        } else {
            System.out.println("<The entered 3rd parameter '" + thirdParameter.toLowerCase() + "' is NOT 'distinct'.>\n" +
                    "<The entered 3rd parameter '" + thirdParameter.toLowerCase() + "' is NOT 'reverse'.>\n" +
                    "<The entered 3rd parameter " + thirdParameter + " was disregarded.>\n" +
                    "<The 3rd parameter should be 'distinct' or 'reverse'.>\n" +
                    "|\n");
        }
    }


    @Override
    public void findWord() {
        List<String> defArray = this.beginning();
        String firstParameter = defArray.get(0);
        for (Definition d : Definition.values()) {
            if ((firstParameter.equalsIgnoreCase(d.getWord()))) {
                System.out.println(d);
            }
        }
    }

    @Override
    public void findPartsOfSpeech() {
        List<String> defArray = this.beginning();
        String firstParameter = defArray.get(0);
        String secondParameter = defArray.get(1);
        for (Definition d : Definition.values()) {
            //PART OF SPEECH
            if ((firstParameter.equalsIgnoreCase(d.getWord()) && (secondParameter.equalsIgnoreCase(d.getPartOfSpeech())))) {
                System.out.println(d);
                //DISTINCT

            }
        }
    }


    @Override
    public void findReverse() {
        List<String> defArray = this.beginning();
        String firstParameter = defArray.get(0);
        String secondParameter = defArray.get(1);

        if (secondParameter.equals("reverse".toUpperCase())) {
            Definition[] reverseValues = Definition.values();
            //loops through enums backwards
            for (int b = reverseValues.length - 1; b >= 0; --b) {
                Definition c = Definition.values()[b];
                System.out.println(c);
            }
        }
    }
}







