package Dictionary;

import java.util.*;

public enum Definition {
    //enums
    ARROW1("Arrow", "noun", "Here is one arrow: <IMG> -=>> </IMG>"),
    BOOK1("Book", "noun", "A set of pages."),
    BOOK2("Book", "noun", "A written work published in printed or electronic form."),
    BOOK3("Book", "verb", "To arrange for someone to have a seat on a plane."),
    BOOK4("Book", "verb", "To arrange something on a particular date."),
    DISTINCT1("Distinct", "adjective", "Familiar. Worked in Java."),
    DISTINCT2("Distinct", "adjective", "Unique. No duplicates. Clearly different or of a different kind."),
    DISTINCT3("Distinct", "adverb", "Uniquely. Written \"distinctly\"."),
    DISTINCT4("Distinct", "noun", "A keyword in this assignment."),
    DISTINCT5("Distinct", "noun", "A keyword in this assignment."),
    DISTINCT6("Distinct", "noun", "A keyword in this assignment."),
    DISTINCT7("Distinct", "noun", "An advanced search option."),
    DISTINCT8("Distinct", "noun", "Distinct is a parameter in this assignment."),
    PLACEHOLDER01("Placeholder", "adjective", "To be updated..."),
    PLACEHOLDER02("Placeholder", "adjective", "To be updated..."),
    PLACEHOLDER03("Placeholder", "adverb", "To be updated..."),
    PLACEHOLDER04("Placeholder", "conjunction", "To be updated..."),
    PLACEHOLDER05("Placeholder", "interjection", "To be updated..."),
    PLACEHOLDER06("Placeholder", "noun", "To be updated..."),
    PLACEHOLDER07("Placeholder", "noun", "To be updated..."),
    PLACEHOLDER08("Placeholder", "noun", "To be updated..."),
    PLACEHOLDER09("Placeholder", "preposition", "To be updated..."),
    PLACEHOLDER10("Placeholder", "pronoun", "To be updated..."),
    PLACEHOLDER11("Placeholder", "verb", "To be updated..."),
    REVERSE01("Reverse", "adjective", "On back side."),
    REVERSE02("Reverse", "adjective", "Opposite to usual or previous arrangement."),
    REVERSE03("Reverse", "noun", "A dictionary program's parameter."),
    REVERSE04("Reverse", "noun", "Change to opposite direction."),
    REVERSE05("Reverse", "noun", "The opposite."),
    REVERSE06("Reverse", "noun", "To be updated...."),
    REVERSE07("Reverse", "noun", "To be updated...."),
    REVERSE08("Reverse", "noun", "To be updated...."),
    REVERSE09("Reverse", "noun", "To be updated...."),
    REVERSE10("Reverse", "verb", "Change something to opposite."),
    REVERSE11("Reverse", "verb", "Go back"),
    REVERSE12("Reverse", "verb", "Revoke ruling."),
    REVERSE13("Reverse", "verb", "To be updated...."),
    REVERSE14("Reverse", "verb", "To be updated...."),
    REVERSE15("Reverse", "verb", "Turn something inside out."),
    ;
    //variables
    private String word;
    private String partOfSpeech;
    private String definition;

    //constructors
    private Definition(String word, String partOfSpeech, String definition) {
        this.word = word;
        this.partOfSpeech = partOfSpeech;
        this.definition = definition;
    }

    //getters & setters
    public String getWord() {
        return word;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    //toString method
    @Override
    public String toString() {
        return this.word + " [" + this.partOfSpeech + "] : " + this.definition;
    }

    public static void main(String[] args) {
        System.out.println("Dictionary: (There are " + Definition.values().length + " definitions to choose from)\n");

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
                    //if there is one parameter
                    String firstParameter;
                    firstParameter = defArray.get(0);
                    if (firstParameter.equals("!help".toUpperCase())) {
                        System.out.println("| \n PARAMETER HOW-TO, please enter: \n 1. A search key \n 2. An optional part of speech" +
                                "\n 3. An optional 'reverse' to reverse the order of the definitions \n |");
                    }
                    if (firstParameter.equals("")) {
                        System.out.println("| \n PARAMETER HOW-TO, please enter: \n 1. A search key -then 2. An optional part of speech -then" +
                                "\n 3. An optional 'reverse'");
                    }
                    if (firstParameter.equals("!quit".toUpperCase())) {
                        System.out.println("Thank you for participating!");
                        //findWord
                    } else {
                        for (Definition d : Definition.values()) {
                            if ((firstParameter.equalsIgnoreCase(d.getWord()))) {
                                System.out.println(d);
                            }
                        }
                    }
                }
                if (size == 2) {
                    String firstParameter = defArray.get(0);
                    String secondParameter = defArray.get(1);
                    if (secondParameter.equals("reverse".toUpperCase())) {
                        Definition[] reverseValues = Definition.values();
                        //loops through enums backwards
                        for (int b = reverseValues.length - 1; b >= 0; --b) {
                            Definition c = Definition.values()[b];
                            if ((firstParameter.equalsIgnoreCase(c.word))) {
                                System.out.println(c);
                            }
                        }
                    } else {
                        for (Definition d : Definition.values()) {
                            //PART OF SPEECH
                            if ((firstParameter.equalsIgnoreCase(d.getWord()) && (secondParameter.equalsIgnoreCase(d.getPartOfSpeech())))) {
                                System.out.println(d);
                            }
                        }
                    }
                }
                    if (size == 3) {
                        String thirdParameter = defArray.get(2);
                        if (thirdParameter.equals("reverse".toUpperCase())) {
                            Definition[] reverseValues = Definition.values();
                            //loops through enums backwards
                            for (int b = reverseValues.length - 1; b >= 0; --b) {
                                Definition c = Definition.values()[b];
                                System.out.println(c);
                            }
                        } else {
                            System.out.println("<The entered 3rd parameter '" + thirdParameter.toLowerCase() + "' is NOT 'reverse'.>\n" +
                                    "<The entered 3rd parameter " + thirdParameter + " was disregarded.>\n" +
                                    "<The 3rd parameter should be 'reverse'.>\n" +
                                    "|\n");
                        }
                    }

                }
                searchIndex++;
            }

        }
    }








