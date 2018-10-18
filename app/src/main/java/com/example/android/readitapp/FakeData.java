package com.example.android.readitapp;

// In the constructor of this object we create all the hardcoded data. Later on, if we decide to
// implement a real database, we can simply discard this object and change the methods in the
// Database singleton.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class FakeData
{
    ArrayList<User> users;
    ArrayList<Challenge> challenges;
    ArrayList<ChallengeParticipation> challengeParticipations;
    ArrayList<Book> borrowedBooks;
    ArrayList<Book> returnedBooks;

    private static final FakeData ourInstance = new FakeData();

    public static FakeData getInstance()
    {
        return ourInstance;
    }


    private FakeData()
    {
        // Here we create all the hardcoded data.

        AppManager appManager = AppManager.getInstance();

        String pswHash;
        Achievements achievements;
        User user;
        ChallengeParticipation challengeParticipation;
        ArrayList<Book> books;
        int gems;

        books = new ArrayList<>();
        challenges = new ArrayList<>();
        challengeParticipations = new ArrayList<>();
        Book book;
        Challenge challenge;


        // initializing books
        book = new Book("9780747532743",
                "Harry Potter and the Philisopher's Stone",
                AgeGroupsEnum.DRAGONS,
                "Harry Potter is an ordinary boy who lives in a cupboard under the stairs at his Aunt Petunia and Uncle Vernon's house, which he thinks is normal for someone like him who's parents have been killed in a 'car crash'. He is bullied by them and his fat, spoilt cousin Dudley, and lives a very unremarkable life with only the odd hiccup (like his hair growing back overnight!) to cause him much to think about. That is until an owl turns up with a letter addressed to Harry and all hell breaks loose! He is literally rescued by a world where nothing is as it seems and magic lessons are the order of the day. Read and find out how Harry discovers his true heritage at Hogwarts School of Wizardry and Witchcraft, the reason behind his parents mysterious death, who is out to kill him, and how he uncovers the most amazing secret of all time, the fabled Philosopher's Stone! All this and muggles too. Now, what are they?",
                "No image");
        books.add(book);

        book = new Book("978074232743", "Harry Potter and the Chamber of Secrets",
                AgeGroupsEnum.DRAGONS,
                "Harry Potter’s summer has included the worst birthday ever, doomy warnings from a house-elf called Dobby, and rescue from the Dursleys by his friend Ron Weasley in a magical flying car! Back at Hogwarts School of Witchcraft And Wizardry for his second year, Harry hears strange whispers echo through empty corridors – and then the attacks start. Students are found as though turned to stone … Dobby’s sinister predictions seem to be coming true. ",
                "No image");
        books.add(book);


        // initializing challenges
        // create an array list of books for specific challenge, 
        challenge = new Challenge("Harry Potter Challenge", AgeGroupsEnum.DRAGONS,
                new Date(2018, 10, 20), new Date(2018, 12, 15),
                books, "Info is missing");
        challenges.add(challenge);

        // Init users list.
        users = new ArrayList<>();


        // Init user 1.

        pswHash = appManager.md5("1");
        achievements = new Achievements();

        challengeParticipation = new ChallengeParticipation(challenges.get(0), 100);
        challengeParticipations.add(challengeParticipation);

        borrowedBooks = new ArrayList<>();
        borrowedBooks.add(books.get(0));

        returnedBooks = new ArrayList<>();
        returnedBooks.add(books.get(1));

        user = new User(1, pswHash, "Edoardo", AgeGroupsEnum.DRAGONS,
                achievements, 50, borrowedBooks, returnedBooks, challengeParticipations);
        users.add(user);


        // Init user 2.

        pswHash = appManager.md5("p2");
        achievements = new Achievements();

        challengeParticipation = new ChallengeParticipation(challenges.get(0), 100);
        challengeParticipations.add(challengeParticipation);

        borrowedBooks = new ArrayList<>();
        borrowedBooks.add(books.get(0));

        returnedBooks = new ArrayList<>();
        returnedBooks.add(books.get(1));

        user = new User(2, pswHash, "Alessandro", AgeGroupsEnum.TIGERS,
                achievements, 173, borrowedBooks, returnedBooks, challengeParticipations);
        users.add(user);
    }


}
