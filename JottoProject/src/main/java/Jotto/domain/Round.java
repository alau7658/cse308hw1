package Jotto.domain;
import javax.persistence.*;
@Entity
@Table(name = "round")
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int round_id;
    private int game_id;
    private int round_number;
    private String user_guess;
    private String cpu_guess;

    public Round() {

    }

    public Round(int game_id, int round_number, String user_guess, String cpu_guess) {
        this.game_id = game_id;
        this.round_number = round_number;
        this.user_guess = user_guess;
        this.cpu_guess = cpu_guess;
    }

    public int getRound_id() {
        return round_id;
    }

    public void setRound_id(int round_id) {
        this.round_id = round_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getRound_number() {
        return round_number;
    }

    public void setRound_number(int round_number) {
        this.round_number = round_number;
    }

    public String getUser_guess() {
        return user_guess;
    }

    public void setUser_guess(String user_guess) {
        this.user_guess = user_guess;
    }

    public String getCpu_guess() {
        return cpu_guess;
    }

    public void setCpu_guess(String cpu_guess) {
        this.cpu_guess = cpu_guess;
    }

    @Override
    public String toString() {
        return "Round{" +
                "round_id=" + round_id +
                ", game_id=" + game_id +
                ", round_number=" + round_number +
                ", user_guess='" + user_guess + '\'' +
                ", cpu_guess='" + cpu_guess + '\'' +
                '}';
    }
}

