package pl.sda.intermediate;

import org.junit.jupiter.api.RepeatedTest;
import pl.sda.intermediate.PlayLists.Movie;
import pl.sda.intermediate.PlayLists.Music;
import pl.sda.intermediate.PlayLists.PlayMode;
import pl.sda.intermediate.PlayLists.Playlist;

class PlaylistTest {

    @RepeatedTest(10)
    void shouldPlaySequentially() {
        Playlist playlist = new Playlist();

        playlist.setOrder(PlayMode.LOOP);
        Music m1 = new Music("Rolling Stones", "Brown Suger");
        Movie mv1 = new Movie("Casablanca");
        Movie mv2 = new Movie("Titanic");
        playlist.add(m1);
        playlist.add(mv1);
        playlist.add(mv2);

        Playlist subPlaylist = new Playlist();
        Music m2 = new Music("Kazik", "Baranek");
        Movie mv3 = new Movie("Pan Tadeusz");
        Movie mv4 = new Movie("Przedwiosnie");
        subPlaylist.add(m2);
        subPlaylist.add(mv3);
        subPlaylist.add(mv4);
        playlist.add(subPlaylist);

        System.out.println(playlist.play());
    }
}