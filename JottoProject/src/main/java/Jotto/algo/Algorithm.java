package Jotto.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Algorithm {


    public static List<Character> mustIn = new ArrayList<>();
    public static List<Character> notIn = new ArrayList<>();
    public static List<String> l11111 = new ArrayList<String>();
    public static List<String> l1112 = new ArrayList<String>();
    public static List<String> l122 = new ArrayList<String>();
    public static List<String> l113 = new ArrayList<String>();
    public static List<String> l23 = new ArrayList<String>();
    public static List<String> allWords = new ArrayList<>();
    public static int round = 0;
    public static String given = null;
    public static String AIgiven = null;
    public static List<String> wordList = new ArrayList<>();
    public static boolean userWin = false;
    public static int status = 0;
    public static String guess = "null!";



    // start game
    public static void emptyAll(){
        round = 0;
        mustIn.clear();
        notIn.clear();
        l11111.clear();
        l1112.clear();
        l122.clear();
        l113.clear();
        l23.clear();
        allWords.clear();
        wordList.clear();
        userWin = false;
        given = null;
        AIgiven = null;
        status = 0;
        guess = "null!";
    }

    // set all word to different lists
    public static void initialSet(){
        // open file, relative path
        File f11111 = new File(".\\src\\main\\resources\\list\\11111.txt");
        File f1112 = new File(".\\src\\main\\resources\\list\\1112.txt");
        File f122 = new File(".\\src\\main\\resources\\list\\122.txt");
        File f113 = new File(".\\src\\main\\resources\\list\\113.txt");
        File f23 = new File(".\\src\\main\\resources\\list\\23.txt");

        // read each file, split to words and insert to list
        try {
            BufferedReader r11111 = new BufferedReader(new FileReader(f11111));
            BufferedReader r1112 = new BufferedReader(new FileReader(f1112));
            BufferedReader r122 = new BufferedReader(new FileReader(f122));
            BufferedReader r113 = new BufferedReader(new FileReader(f113));
            BufferedReader r23 = new BufferedReader(new FileReader(f23));

            String text = null;
            while ((text = r11111.readLine()) != null) {
                String[] temp = text.split(" ");
                for (String a : temp)
                    l11111.add(a);
            }
            text = null;
            while ((text = r1112.readLine()) != null) {
                String[] temp = text.split(" ");
                for (String a : temp)
                    l1112.add(a);
            }
            text = null;
            while ((text = r122.readLine()) != null) {
                String[] temp = text.split(" ");
                for (String a : temp)
                    l122.add(a);
            }
            text = null;
            while ((text = r113.readLine()) != null) {
                String[] temp = text.split(" ");
                for (String a : temp)
                    l113.add(a);
            }
            text = null;
            while ((text = r23.readLine()) != null) {
                String[] temp = text.split(" ");
                for (String a : temp)
                    l23.add(a);
            }
            for(String a: l11111)
                allWords.add(a);
            for(String a: l1112)
                allWords.add(a);
            for(String a: l122)
                allWords.add(a);
            for(String a: l113)
                allWords.add(a);
            for(String a: l23)
                allWords.add(a);
        }catch(Exception e){
            System.out.println("Error @ 86");
        }
    }


    // user wanna start a new game, user input a 5-letter word, AI random chose from list, then start user guess
    public static void startgame(String input_word){

        // user initial word: input_word
        given = input_word;

        // AI random chose a word
        Random rand = new Random();
        AIgiven = l11111.get(rand.nextInt(l11111.size()));

        // add these two word into DB
        addToDB(given, AIgiven);
    }

    // add user 'given' word and AI 'AIgiven' word into database
    public static void addToDB(String user, String AI){

    }


    // user turn
    // user guess in new game, then invoke AI turn
    public static void userRound(String AIgiven, String given, String guess_word){
        round++;
        String userGuess = guess_word;
        int num = checkNum(AIgiven.toLowerCase(),userGuess.toLowerCase());
        System.out.println("User Guess:\t" + userGuess + "\t\t\tsame: " + num);
        userWin = AIgiven.toLowerCase().equals(userGuess.toLowerCase());
        addToDBround(userGuess,num,'u');
        if(userWin){
            // User win, should return sth to let html know
            status = 1;
            System.out.println("\nGame Over, YOU WIN!");
            System.out.println("Your word is \"" + given + "\"\t\tAI's word is \"" + AIgiven + "\"");
        }else if(!userWin){
            // AI start guess
            rand(3, AIgiven, given);
        }
    }

    // for each round, add into DB
    public static void addToDBround(String guess, int same, char who){
        if(who=='u'){
            // this is user's guess


        }else if(who=='a'){
            // this is AI's guess

        }
    }


    // AI turn
    // random a number for select word list
    public static void rand(int num, String AIgiven, String given){
        Random rand = new Random();

        int list = rand.nextInt(num);
        if(mustIn.size()<5) {
            if (list == 0) {
                if (l122.size() != 0) {
                    // random selecte a word in 122
                    guess = l122.get(rand.nextInt(l122.size()));
                    list122(AIgiven, given,  'n');
                }else
                    rand(3, AIgiven, given);
            } else if (list == 1) {
                if (l113.size() != 0) {
                    // random select a word in 113
                    guess = l113.get(rand.nextInt(l113.size()));
                    list113(AIgiven, given, 'n');
                }else
                    rand(3, AIgiven, given);
            } else if (list == 2) {
                if (l23.size() != 0) {
                    // random select word in 23
                    guess = l23.get(rand.nextInt(l23.size()));
                    list23(AIgiven, given, 'n');
                }else
                    rand(3, AIgiven, given);
            } else {
                System.out.println("error @ 328");
                java.lang.System.exit(0);
            }
        }else{
            addToDBround(wordList.get(0),5,'a');
            guess = wordList.get(0);
            // already get wordList, should print one-by-one
            if(wordList.get(0).toLowerCase().equals(given.toLowerCase())){
                // AI win, should return something to let html know
                status = 2;
                System.out.println("AI Guess:\t" + wordList.get(0) + "\t\t\tsame: 5" );
                System.out.println("\nGame Over, AI WIN!");
                System.out.println("Your word is \"" + given + "\"\t\tAI's word is \"" + AIgiven + "\"");
            }else{
                System.out.println("AI Guess:\t" + wordList.get(0) + "\t\t\tsame: 5" );
                wordList.remove(0);
            }
        }
    }

    // random select a word in 122,
    public static void list122(String AIgiven, String given, char which){

        // if has a "mustIn" or "notIn" letter as key (show 1 times in word), delete it
        boolean isDelete = false;
        for(char a : mustIn){
            if(Character.toLowerCase(getChar(guess,1).get(0))==Character.toLowerCase(a)) {
                isDelete = true;
                break;
            }
        }
        for(char a : notIn){
            if(Character.toLowerCase(getChar(guess,1).get(0))==Character.toLowerCase(a)) {
                isDelete = true;
                break;
            }
        }
        if(isDelete) {
            l122.remove(guess);
            rand(3, AIgiven, given);
            return;
        }

        // check how many same letter
        int same = checkNum(given.toLowerCase(),guess.toLowerCase());
        l122.remove(guess);

        // case of different same number letter
        if(same == 0){
            addIn(notIn,getAllChar(guess));
        }else if(same == 1){
            addIn(mustIn,getChar(guess,1));
            addIn(notIn,getChar(guess,2));
        }else if(same == 2){
            addIn(notIn,getChar(guess,1));
        }else if(same == 3) {
            addIn(mustIn,getChar(guess,1));
            // test other 2 which in
        }else if(same == 4){
            addIn(mustIn,getChar(guess,2));
            addIn(notIn,getChar(guess,1));
        }else if(same == 5){
            addIn(mustIn,getAllChar(guess));
        }else{
            System.out.println("Error @ 378");
            java.lang.System.exit(0);
        }

        addToDBround(guess,same,'a');

        if(which=='c'||which=='n'){
            System.out.println("AI Guess:\t" + guess + "\t\t\tsame: " + same);
        }else{
            System.out.println("Error @ 386");
            java.lang.System.exit(0);
        }
        System.out.println();


        if(mustIn.size()==5)
            wordList = findWord();
    }

    // random select a word in 113, then check letter in or not
    public static void list113(String AIgiven, String given, char which){

        // if contain a "mustIn" or "notIn" letter as key letter (repeat 3 times), delete it
        boolean isDelete = false;
        for(char a : mustIn){
            if(Character.toLowerCase(getChar(guess,3).get(0))==Character.toLowerCase(a)) {
                isDelete = true;
                break;
            }
        }
        for(char a : notIn){
            if(Character.toLowerCase(getChar(guess,3).get(0))==Character.toLowerCase(a)) {
                isDelete = true;
                break;
            }
        }
        if (isDelete) {
            l113.remove(guess);
            rand(3, AIgiven, given);
            return;
        }

        // check how many letter same as the input word
        int same = checkNum(given.toLowerCase(),guess.toLowerCase());
        l113.remove(guess);

        // case of different same number letter
        if(same == 0){
            addIn(notIn,getAllChar(guess));
        }else if(same == 1){
            addIn(notIn,getChar(guess,3));
        }else if(same == 2){
            addIn(mustIn,getChar(guess,1));
            addIn(notIn,getChar(guess,3));
        }else if(same == 3){
            addIn(mustIn,getChar(guess,3));
            addIn(notIn,getChar(guess,1));
        }else if(same == 4){
            addIn(mustIn,getChar(guess,3));
        }else if(same ==5){
            addIn(mustIn,getAllChar(guess));
        }else{
            System.out.println("Error @ 441");
            java.lang.System.exit(0);
        }
        addToDBround(guess,same,'a');

        if(which=='c'||which=='n')
            System.out.println("AI Guess:\t" + guess + "\t\t\tsame: " + same);
        else{
            System.out.println("Error @ 449");
            java.lang.System.exit(0);
        }
System.out.println();

        if(mustIn.size()==5)
            wordList = findWord();
    }

    // random select a word in 23, then in or not
    public static void list23(String AIgiven, String given, char which){

        // check same number, delete
        int same = checkNum(given.toLowerCase(),guess.toLowerCase());
        l23.remove(guess);

        // case of different same number letter
        if(same == 0){
            addIn(notIn,getAllChar(guess));
            // start again
        }else if(same == 2){
            addIn(notIn,getChar(guess,3));
            addIn(mustIn,getChar(guess,2));
        }else if(same == 3){
            addIn(notIn,getChar(guess,2));
            addIn(mustIn,getChar(guess,3));
        }else if(same == 5){
            addIn(mustIn,getAllChar(guess));
        }else{
            System.out.println("error @ 416");
            java.lang.System.exit(0);
        }

        addToDBround(guess,same,'a');

        if(which=='c'||which=='n')
            System.out.println("AI Guess:\t" + guess + "\t\t\tsame: " + same);
        else{
            System.out.println("Error @ 489");
            java.lang.System.exit(0);
        }
        System.out.println();

        if(mustIn.size()==5)
            wordList = findWord();
    }




    // other help function
    // check user input word is in 11111
    public static boolean checkInput(String input_word){
        boolean isIn = false;
        for(String a: l11111){
            if(a.toLowerCase().equals(input_word.toLowerCase())){
                isIn = true;
                break;
            }
        }
        return isIn;
    }

    // check user guess word is in all words list
    public static boolean checkGuess(String guess_word){
        boolean isIn = false;
        for(String a: allWords){
            if(a.toLowerCase().equals(guess_word.toLowerCase())){
                isIn = true;
                break;
            }
        }
        return isIn;
    }

    // if the letter not in the list "addTo", add it
    public static void addIn(List<Character> addTo, List<Character> addList){
        for(char a: addList){
            if (!addTo.contains(Character.toUpperCase(a))){
                addTo.add(Character.toUpperCase(a));
            }
        }

    }

    // check how many same letter btw given word and guess word
    public static int checkNum(String given, String guess1){
        String[] gv = given.split("");
        String[] gs = guess1.split("");
        int count = 0;
        for (String s : gs){
            for(String v : gv){
                if (s.equals(v)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    // list all the letter in given
    public static List<Character> getAllChar(String given){
        String[] gv = given.split("");
        List<Character> rt = new ArrayList<Character>();
        for(String a : gv){
            if (!rt.contains(a.charAt(0))){
                rt.add(a.charAt(0));
            }
        }
        return rt;
    }

    // list letters repeat exactlly "num" times in the give
    public static List<Character> getChar(String given, int num){
        String[] gv = given.split("");
        String[] c = new String[5];
        int[] numb = new int[5];
        for (int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(gv[i].equals(c[j])) {
                    numb[j]++;
                    break;
                }
                if((!gv[i].equals(c[j]))&&c[j]==null){
                    c[j] = gv[i];
                    numb[j]++;
                    break;
                }
            }
        }
        List<Character> rt = new ArrayList<Character>();
        for (int i=0;i<5;i++){
            if(numb[i]==num){
                rt.add(c[i].charAt(0));
            }
        }
        return rt;
    }

    // find the word in the 11111 list
    public static List<String> findWord(){
        List<String> rt = new ArrayList<>();
        for(String word : l11111){
            String[] spl = word.split("");
            int i = 0;
            for(String n : spl) {
                for (char c : mustIn) {
                    if (Character.toLowerCase(n.charAt(0))==Character.toLowerCase(c)){
                        i++;
                    }
                }
                if(i==5)
                    rt.add(word);
            }
        }
        return rt;
    }

    // get status
    public static int getStatus(){
        return status;
    }

}
