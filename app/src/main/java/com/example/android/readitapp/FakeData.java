package com.example.android.readitapp;

// In the constructor of this object we create all the hardcoded data. Later on, if we decide to
// implement a real database, we can simply discard this object and change the methods in the
// Database singleton.

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FakeData
{
    ArrayList<User> users;
    ArrayList<Book> books;
    ArrayList<Challenge> challenges;

    private static final FakeData ourInstance = new FakeData();

    public static FakeData getInstance()
    {
        return ourInstance;
    }


    private FakeData()
    {
        // Here we create all the hardcoded data. Let's try to have some structure if possible.

        // We need the appManager only to use the md5 hashing function.
        AppManager appManager = AppManager.getInstance();

        // Init the lists declared outside the constructor: we will need to access them from
        // outside the object FakeData.
        users = new ArrayList<>();
        books = new ArrayList<>();
        challenges = new ArrayList<>();

        // Now we declare the variable we will use to create new objects to populate the fake
        // database. Remember to declare as few as possible, trying always to recycle the same ones.
        String pswHash;
        Achievements achievements;
        User user;
        int gems;
        ArrayList<Book> borrowedBooks;
        ArrayList<Book> returnedBooks;
        ArrayList<ChallengeParticipation> challengesParticipations;
        Book book;
        Challenge challenge;
        ArrayList<Book> challengeBooks;
        String question;
        String[] answers;
        int correctAnswer;
        MultipleChoice multipleChoice;
        ArrayList<Question> questions;
        Quiz quiz;
        Badge badge;
        ArrayList<Badge> badges;


        // Init quiz for a book and then init the corresponding book.

        question = "What are the names of the Weasley twins?";
        answers = new String[]{
                "Neville and Fred",
                "Fred and George",
                "Harry and Ron",
                "None of the above"
        };
        correctAnswer = 2;
        multipleChoice = new MultipleChoice( question, answers, correctAnswer-1 );
        questions = new ArrayList<>();
        questions.add(multipleChoice);
        quiz = new Quiz(questions);

        book = new Book("9780747532720", "Harry Potter and the Philosopher's Stone",
                AgeGroupsEnum.DRAGONS,
                "Harry Potter is an ordinary boy who lives in a cupboard under the " +
                        "stairs at his Aunt Petunia and Uncle Vernon's house, which he thinks " +
                        "is normal for someone like him who's parents have been killed in a " +
                        "'car crash'. He is bullied by them and his fat, spoilt cousin Dudley, " +
                        "and lives a very unremarkable life with only the odd hiccup (like his " +
                        "hair growing back overnight!) to cause him much to think about. That " +
                        "is until an owl turns up with a letter addressed to Harry and all hell " +
                        "breaks loose! He is literally rescued by a world where nothing is as " +
                        "it seems and magic lessons are the order of the day. Read and find out " +
                        "how Harry discovers his true heritage at Hogwarts School of Wizardry " +
                        "and Witchcraft, the reason behind his parents mysterious death, who is " +
                        "out to kill him, and how he uncovers the most amazing secret of all " +
                        "time, the fabled Philosopher's Stone! All this and muggles too. Now, " +
                        "what are they?",
                R.drawable.harry_potter_1_bc);
        book.setQuiz(quiz);
        books.add(book);


        // Init quiz for a book and then init the corresponding book.

        questions = new ArrayList<>();

        question = "What animal Harry and Ron find in the forest?";
        answers = new String[]{
                "Big dog with three heads",
                "Huge black spider",
                "White unicorn",
                "None of the above"
        };
        correctAnswer = 2;
        multipleChoice = new MultipleChoice( question, answers, correctAnswer-1 );
        questions.add(multipleChoice);

        question = "How do Harry and Ron reach Howgwarts?";
        answers = new String[]{
                "On a flying car",
                "On a magic train",
                "Using magic powder",
                "None of the above"
        };
        correctAnswer = 1;
        multipleChoice = new MultipleChoice( question, answers, correctAnswer-1 );
        questions.add(multipleChoice);

        quiz = new Quiz(questions);

        book = new Book("978074232743", "Harry Potter and the Chamber of Secrets",
                AgeGroupsEnum.DRAGONS,
                "Harry Potter’s summer has included the worst birthday ever, doomy warnings from a house-elf called Dobby, and rescue from the Dursleys by his friend Ron Weasley in a magical flying car! Back at Hogwarts School of Witchcraft And Wizardry for his second year, Harry hears strange whispers echo through empty corridors – and then the attacks start. Students are found as though turned to stone … Dobby’s sinister predictions seem to be coming true. ",
                R.drawable.harry_potter_2_bc);
        book.setQuiz(quiz);
        books.add(book);


        book = new Book("954074232743","Harry Potter and the Prisoner of Azkaban",
                AgeGroupsEnum.DRAGONS,
                "When the Knight Bus crashes through the darkness and screeches to a halt in front of him, it’s the start of another far from ordinary year at Hogwarts for Harry Potter. Sirius Black, escaped mass-murderer and follower of Lord Voldemort, is on the run – and they say he is coming after Harry. In his first ever Divination class, Professor Trelawney sees an omen of death in Harry’s tea leaves … But perhaps most terrifying of all are the Dementors patrolling the school grounds, with their soul-sucking kiss",
                R.drawable.harry_potter_3_bc);

        books.add(book);

        book = new Book("444444444444","Book 4",
                AgeGroupsEnum.DRAGONS,
                "Description 4",
                R.drawable.dragon);
        books.add(book);

        book = new Book("555555555555","Book 5",
                AgeGroupsEnum.DRAGONS,
                "Description 5",
                R.drawable.dragon);
        books.add(book);

        book = new Book("666666666666","Book 6",
                AgeGroupsEnum.DRAGONS,
                "Description 6",
                R.drawable.dragon);
        books.add(book);

        book = new Book("777777777777","Book 7",
                AgeGroupsEnum.DRAGONS,
                "Description 7",
                R.drawable.dragon);
        books.add(book);

        book = new Book("888888888888","Book 8",
                AgeGroupsEnum.DRAGONS,
                "Description 6",
                R.drawable.dragon);
        books.add(book);



        // Init challenges

        // Create an array list of books for specific challenge.
        challengeBooks = new ArrayList<>();
        challengeBooks.add(books.get(0));
        challengeBooks.add(books.get(1));
        challengeBooks.add(books.get(3));
        challengeBooks.add(books.get(4));

        challenge = new Challenge("Harry Potter Challenge", AgeGroupsEnum.DRAGONS,
                new Date(118, Calendar.OCTOBER, 26), new Date(2018, 12, 15),
                challengeBooks, "Info is missing",
                R.drawable.hp_challenge_cover);
        challenges.add(challenge);

        // Create an array list of books for specific challenge.
        challengeBooks = new ArrayList<>();
        challengeBooks.add(books.get(1));
        challengeBooks.add(books.get(2));
        challengeBooks.add(books.get(3));

        challenge = new Challenge("Grimm's fairy tales", AgeGroupsEnum.BUNNIES,
                new Date(117,10,1), new Date (2018,1,29),
                challengeBooks,"No info yet",
                R.drawable.default_picture);
        challenges.add(challenge);


        // Init users list.
        users = new ArrayList<>();


        // Init user 1.

        pswHash = appManager.md5("1");

        // TODO Fill achievements, empty for now.
        badges = new ArrayList<>();
        badge = new Badge( "Griffindor Badge", R.drawable.ic_badge_1, new Date(2018, 07, 25) );
        badges.add(badge);
        badge = new Badge( "Hogwarts Medal", R.drawable.ic_badge_medal, new Date(2018, 06, 20) );
        badges.add(badge);
        badge = new Badge( "Quidditch Trophy", R.drawable.ic_badge_trophy, new Date(2018, 05, 15) );
        badges.add(badge);
        achievements = new Achievements( 50, badges );

        borrowedBooks = new ArrayList<>();
        borrowedBooks.add(books.get(0)); // HP1
        borrowedBooks.add(books.get(2)); // HP3

        returnedBooks = new ArrayList<>();
        returnedBooks.add(books.get(1));
        returnedBooks.add(books.get(3)); // Book4
        returnedBooks.add(books.get(4)); // Book5
        returnedBooks.add(books.get(5)); // Book6
        returnedBooks.add(books.get(6)); // Book7
        returnedBooks.add(books.get(7)); // Book8

        challengesParticipations = new ArrayList<>();
        challengesParticipations.add(new ChallengeParticipation(challenges.get(0),500));
        challengesParticipations.add(new ChallengeParticipation(challenges.get(1),200));


        user = new User(1, pswHash, "Edoardo", AgeGroupsEnum.DRAGONS,
                achievements, 50, borrowedBooks, returnedBooks, challengesParticipations);
        users.add(user);


        // Init user 2.

        pswHash = appManager.md5("2");

        // TODO Fill achievements, empty for now.
//        achievements = new Achievements();

        borrowedBooks = new ArrayList<>();
        borrowedBooks.add(books.get(0));

        returnedBooks = new ArrayList<>();
        returnedBooks.add(books.get(1));

        challengesParticipations = new ArrayList<>();
        challengesParticipations.add(new ChallengeParticipation(challenges.get(0),70));

        user = new User(2, pswHash, "Alessandro", AgeGroupsEnum.TIGERS,
                achievements, 173, borrowedBooks, returnedBooks, challengesParticipations);
        users.add(user);
    }


}
