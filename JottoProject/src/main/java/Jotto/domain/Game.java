package Jotto.domain;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int game_id;
    public String username;
    @Enumerated(EnumType.STRING)
    public GameState game_state = GameState.INCOMPLETE;
    public String user_word;
    public String cpu_word;
    public Date date_created = new Date();
    public Game(){

    }

    public Game(String username, GameState game_state, String user_word, String cpu_word, Date date_created) {
        this.username = username;
        this.game_state = game_state;
        this.user_word = user_word;
        this.cpu_word = cpu_word;
        this.date_created = date_created;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public GameState getGame_state() {
        return game_state;
    }

    public void setGame_state(GameState game_state) {
        this.game_state = game_state;
    }

    public String getUser_word() {
        return user_word;
    }

    public void setUser_word(String user_word) {
        this.user_word = user_word;
    }

    public String getCpu_word() {
        return cpu_word;
    }

    public void setCpu_word(String cpu_word) {
        this.cpu_word = cpu_word;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    @Override
    public String toString() {
        return "Game{" +
                "game_id=" + game_id +
                ", username=" + username +
                ", game_state='" + game_state + '\'' +
                ", user_word='" + user_word + '\'' +
                ", cpu_word='" + cpu_word + '\'' +
                ", date_created=" + date_created +
                '}';
    }
}
