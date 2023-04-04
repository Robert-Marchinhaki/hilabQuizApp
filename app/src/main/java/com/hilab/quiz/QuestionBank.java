package com.hilab.quiz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuestionBank {
    private static List<QuestionsList> easyQuestions() {

        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Qual é a capital do Brasil?", "São Paulo", "Brasília", "Rio de Janeiro", "Salvador", "Brasília", "");
        final QuestionsList question2 = new QuestionsList("Qual é o maior continente do mundo?", "África", "Europa", "Ásia", "América do Norte", "Ásia", "");
        final QuestionsList question3 = new QuestionsList("Qual é o maior planeta do sistema solar?", "Terra", "Júpiter", "Vênus", "Marte", "Júpiter", "");
        final QuestionsList question4 = new QuestionsList("Qual é o país que tem a maior população do mundo?", "Índia", "Rússia", "China", "Estados Unidos", "China", "");
        final QuestionsList question5 = new QuestionsList("Qual é o maior oceano do mundo?", "Atlântico", "Pacífico", "Índico", "Ártico", "Pacífico", "");
        final QuestionsList question6 = new QuestionsList("Qual é o nome do famoso monumento na cidade do Rio de Janeiro?", "Torre Eiffel", "Estátua da Liberdade", "Cristo Redentor", "Coliseu", "Cristo Redentor", "");
        final QuestionsList question7 = new QuestionsList("Qual é o nome do criador do Facebook?", "Bill Gates", "Steve Jobs", "Mark Zuckerberg", "Jeff Bezos", "Mark Zuckerberg", "");
        final QuestionsList question8 = new QuestionsList("Qual é a montanha mais alta do mundo?", "Monte Kilimanjaro", "Montanha do Everest", "Montanha Denali", "Monte Aconcágua", "Montanha do Everest", "");
        final QuestionsList question9 = new QuestionsList("Qual é a capital da Argentina?", "Santiago", "Buenos Aires", "Lima", "Bogotá", "Buenos Aires", "");
        final QuestionsList question10 = new QuestionsList("Qual é o nome da galáxia em que o nosso sistema solar está localizado?", "Via Láctea", "Andrômeda", "Nebulosa do Caranguejo", "Estrela Polar", "Via Láctea", "");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);

        Collections.shuffle(questionsLists);

        return questionsLists;
    }

    private static List<QuestionsList> hardQuestions() {
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Qual é o nome da maior cordilheira do mundo?", "Cordilheira dos Andes", "Cordilheira do Himalaia", "Cordilheira dos Alpes", "Cordilheira dos Apeninos", "Cordilheira do Himalaia", "");
        final QuestionsList question2 = new QuestionsList("Qual é a data exata em que a Guerra Fria terminou?", "9 de novembro de 1989", "25 de dezembro de 1991", "8 de agosto de 1988", "12 de junho de 1990", "25 de dezembro de 1991", "");
        final QuestionsList question3 = new QuestionsList("Qual é o nome do fenômeno meteorológico que provoca a diminuição da temperatura na superfície terrestre?", "El Niño", "La Niña", "Chuva ácida", "Inversão térmica", "Inversão térmica", "");
        final QuestionsList question4 = new QuestionsList("Qual é o nome da primeira pessoa a atingir o pico do Monte Everest?", "Tenzing Norgay", "Reinhold Messner", "Sir Edmund Hillary", "Maurice Herzog", "Sir Edmund Hillary", "");
        final QuestionsList question5 = new QuestionsList("Qual é o nome do elemento químico cujo símbolo é Au?", "Prata", "Ouro", "Cobre", "Ferro", "Ouro", "");
        final QuestionsList question6 = new QuestionsList("Qual é o nome do escritor brasileiro que escreveu o livro 'Memórias Póstumas de Brás Cubas'?", "Machado de Assis", "Graciliano Ramos", "Clarice Lispector", "Guimarães Rosa", "Machado de Assis", "");
        final QuestionsList question7 = new QuestionsList("Qual é o nome do líder soviético que instaurou a política de 'glasnost' e 'perestroika'?", "Mikhail Gorbachev", "Joseph Stalin", "Leonid Brezhnev", "Vladimir Putin", "Mikhail Gorbachev", "");
        final QuestionsList question8 = new QuestionsList("Qual é o nome do físico alemão que formulou a Teoria da Relatividade?", "Albert Einstein", "Isaac Newton", "Niels Bohr", "Galileu Galilei", "Albert Einstein", "");
        final QuestionsList question9 = new QuestionsList("Qual é o nome da cidade italiana conhecida como a 'cidade eterna'?", "Florença", "Milão", "Veneza", "Roma", "Roma", "");
        final QuestionsList question10 = new QuestionsList("Qual é o nome do filósofo grego que foi discípulo de Platão e mestre de Alexandre, o Grande?", "Aristóteles", "Sócrates", "Demócrito", "Epicuro", "Aristóteles", "");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);

        Collections.shuffle(questionsLists);

        return questionsLists;
    }

    public static List<QuestionsList> getQuestion(String selectedTopicName) {
        if ("Fácil".equals(selectedTopicName)) {
            return easyQuestions();
        }
        return hardQuestions();
    }
}
