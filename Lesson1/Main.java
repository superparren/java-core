package Lesson1;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        Course c = new Course(new String[]{"Стена", "Бассейн", "Бревно"}); // Создаем полосу препятствий
        Team team = new Team("Команда 1", new Player[]{
                new Player("Иванов", 25),
                new Player("Петров", 27),
                new Player("Сидоров", 30),
                new Player("Смирнов", 35)
        }); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу
        team.showResult(); // Показываем результаты
        System.out.println("-------------------");
        team.showTeamInfo(); // Показываем информацию о всех членах команды
        System.out.println("-------------------");
        c.showWinner(team); // Показываем победителя соревнования
    }
}
class Player {
    public String getName;
    private String name;
    private int age;
    private boolean onDistance;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        this.onDistance = true;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isOnDistance() {
        return onDistance;
    }
    public void run() {
        System.out.println(name + " бежит");
    }

    public void jump() {
        System.out.println(name + " прыгает");
    }

    public void swim() {
        System.out.println(name + " плывет");
    }

    public void setOnDistance(boolean onDistance) {
        this.onDistance = onDistance;
    }
}
class Team {
    private String name;
    private Player[] players;

    public Team(String name, Player[] players) {
        this.name = name;
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void showResult() {
        System.out.println("Прошли дистанцию:");
        for (Player p : players) {
            if (p.isOnDistance()) {
                System.out.println(p.getName());
            }
        }
    }
    public void showTeamInfo() {
        System.out.println("Состав команды:");
        for (Player p : players) {
            System.out.println(p.getName() + " - возраст: " + p.getAge() + ", на дистанции: " + p.isOnDistance());
        }
    }

    public void resetTeam() {
        for (Player p : players) {
            p.setOnDistance(true);
        }
    }

    public String getName() {
        return name;
    }
}
class Course {
    private String[] obstacles;

    public Course(String[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        System.out.println("Команда \"" + team.getName() + "\" начинает полосу препятствий:");
        for (Player p : team.getPlayers()) {
            for (String o : obstacles) {
                if (o.equals("Стена")) {
                    p.jump();
                    if (!p.isOnDistance()) {
                        break;
                    }
                } else if (o.equals("Бассейн")) {
                    p.swim();
                    if (!p.isOnDistance()) {
                        break;
                    }
                } else if (o.equals("Бревно")) {
                    p.run();
                    if (!p.isOnDistance()) {
                        break;
                    }
                }
            }
            if (!p.isOnDistance()) {
                System.out.println(p.getName() + " сошел с дистанции.");
            }
        }
    }

    public String getObstacles() {
        String obstaclesStr = "";
        for (String o : obstacles) {
            obstaclesStr += o + ", ";
        }
        return obstaclesStr.substring(0, obstaclesStr.length() - 2);
    }

    public void showWinner(Team team) {
        int winnerIndex = -1;
        for (int i = 0; i < team.getPlayers().length; i++) {
            if (team.getPlayers()[i].isOnDistance()) {
                if (winnerIndex == -1) {
                    winnerIndex = i;
                } else {
                    System.out.println("Ничья! Победителей несколько.");
                    return;
                }
            }
        }
        System.out.println("Победитель: " + team.getPlayers()[winnerIndex].getName);

    }
}