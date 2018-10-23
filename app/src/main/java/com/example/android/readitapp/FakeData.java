package com.example.android.readitapp;

// In the constructor of this object we create all the hardcoded data. Later on, if we decide to
// implement a real database, we can simply discard this object and change the methods in the
// Database singleton.

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FakeData
{
    public ArrayList<User> users;
    public ArrayList<Book> booksHarryPotter;
    public ArrayList<Book> booksHistory;
    public ArrayList<Challenge> challenges;

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
        booksHarryPotter = new ArrayList<>();
        booksHistory = new ArrayList<>();
        challenges = new ArrayList<>();

        // Now we declare the variable we will use to create new objects to populate the fake
        // database. Remember to declare as few as possible, trying always to recycle the same ones.
        String pswHash;
        Achievements achievements;
        User user;
        ArrayList<Book> borrowedBooks;
        ArrayList<Book> returnedBooks;
        ArrayList<ChallengeParticipation> challengesParticipations;
        Book book;
        Challenge challenge;
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

        booksHarryPotter.add(book);


        // Init quiz for HP2 and then init the HP2 book object.

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

        booksHarryPotter.add(book);


        book = new Book("954074232743","Harry Potter and the Prisoner of Azkaban",
                AgeGroupsEnum.DRAGONS,
                "When the Knight Bus crashes through the darkness and screeches to a halt in front of him, it’s the start of another far from ordinary year at Hogwarts for Harry Potter. Sirius Black, escaped mass-murderer and follower of Lord Voldemort, is on the run – and they say he is coming after Harry. In his first ever Divination class, Professor Trelawney sees an omen of death in Harry’s tea leaves … But perhaps most terrifying of all are the Dementors patrolling the school grounds, with their soul-sucking kiss",
                R.drawable.harry_potter_3_bc);

        booksHarryPotter.add(book);



        book = new Book("683094232743","Carrie’s War",
                AgeGroupsEnum.DRAGONS,
                "Carrie’s War is a coming of age story with a twist. While visiting the small Welsh mining town where she was billeted during World War II, Carrie Willow, a 42 year old widow with four children, tells them the story of her evacuation. At the start of the war, Carrie, then 11 and her younger brother Nick, 9, were put on a train along with so many other school children, to escape the anticipated bombing of London by the Germans. ",
                R.drawable.carries_war_bc);
        booksHistory.add(book);

        book = new Book("777094232743","The Girl in the Mask",
                AgeGroupsEnum.DRAGONS,
                "Sophia and her cousin Jack have been very much on their own, after Sophia's father left four years earlier for Jamaica in the West Indies, where he owns a plantation. When he unexpectedly returns home, bringing Sophia's Aunt Amelia with him, he finds Sophia is not the lady he expected. His steward has been fired by Sophia for stealing from the estate, as well as her governess who was to teach and chaperone her. Instead he finds her learning Latin, Greek and mathematics, all subjects that to her father's thinking won't be of use to her as a married woman. As a lady of birth and breeding he expects her to be accomplished in things that matter; embroidery, painting and dancing.",
                R.drawable.the_girl_in_the_mask);
        booksHistory.add(book);

        book = new Book("990074232743","Anne of Green Gables",
                AgeGroupsEnum.DRAGONS,
                "Anne of Green Gables, novel by Canadian novelist Lucy Maud Montgomery published in 1908. A charming but sentimental story of a spirited and unconventional orphan girl who finds a home with an elderly couple, the novel was based on the author’s own girlhood experiences and on the rural life and traditions of Prince Edward Island. A former journalist and schoolteacher, Montgomery achieved worldwide success with both adults and children after the novel’s publication. Its six sequels, tracing Anne from girlhood to motherhood, were less popular.",
                R.drawable.anne_green_gables);
        booksHistory.add(book);

        // Init challenges

        challenge = new Challenge("Harry Potter Challenge", AgeGroupsEnum.DRAGONS,
                new Date(118, Calendar.OCTOBER, 26), new Date(2018, 12, 15),
                booksHarryPotter, "Info is missing",
                R.drawable.hp_challenge_cover);
        challenges.add(challenge);

        challenge = new Challenge("History Challenge", AgeGroupsEnum.DRAGONS,
                new Date(117,10,1), new Date (2018,1,29),
                booksHistory,"No info yet",
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
        badge = new Badge( "Hogwarts Medal", R.drawable.ic_badge_medal_2, new Date(2018, 06, 20) );
        badges.add(badge);
        badge = new Badge( "Quidditch Trophy", R.drawable.ic_badge_trophy, new Date(2018, 05, 15) );
        badges.add(badge);
        achievements = new Achievements( 50, badges );

        borrowedBooks = new ArrayList<>();
        borrowedBooks.add(booksHarryPotter.get(0)); // HP1
        borrowedBooks.add(booksHarryPotter.get(2)); // HP3

        returnedBooks = new ArrayList<>();
        returnedBooks.add(booksHarryPotter.get(1));
        //returnedBooks.add(booksHarryPotter.get()); // Book4
        //returnedBooks.add(booksHarryPotter.get(4)); // Book5
        //returnedBooks.add(booksHarryPotter.get(5)); // Book6
        //returnedBooks.add(booksHarryPotter.get(6)); // Book7
        //returnedBooks.add(booksHarryPotter.get(7)); // Book8

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
        borrowedBooks.add(booksHarryPotter.get(0));

        returnedBooks = new ArrayList<>();
        returnedBooks.add(booksHarryPotter.get(1));

        challengesParticipations = new ArrayList<>();
        challengesParticipations.add(new ChallengeParticipation(challenges.get(0),70));

        user = new User(2, pswHash, "Alessandro", AgeGroupsEnum.TIGERS,
                achievements, 173, borrowedBooks, returnedBooks, challengesParticipations);
        users.add(user);
    }


}
