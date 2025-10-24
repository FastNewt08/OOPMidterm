package AdvancedObjectsAndClasses;

import java.util.ArrayList;

class Playlist{
    private String playlistName;
    private String creator;
    private ArrayList<String> songs;
    private ArrayList<Integer> durations;

    public Playlist(String name, String creator) {
        this.playlistName = name;
        this.creator = creator;
        //need mo pa ring i declare ito
        this.songs = new ArrayList<>();
        this.durations = new ArrayList<>();

    }
    public String getPlaylistName() {
        return playlistName;
    }
    public String getCreator() {
        return creator;
    }
    public void addSong(String title, int duration){
        //parallel
        songs.add(title);
        durations.add(duration);
    }
    public boolean removeSong(String title){
        int index = songs.indexOf(title);
        //if string yung given, need mo i-convert ng int para mahanap index
        if (index > 0) {
            songs.remove(index);
            durations.remove(index);
            return true;
        }
        return false;
    }
    public int getSongCount(){
        return songs.size();
    }
    public int getTotalDuration(){
        //need mo ipagplus lahat
        int total = 0;
        for (int duration : durations){
            total += duration;
        }
        return total;
    }
    public int findSong(String title){
        return songs.indexOf(title);
    }
    public String getSongAt(int index){
        return songs.get(index);
    }
    public int getDurationAt(int index){
        return durations.get(index);
    }
    public boolean isEmpty(){
        return songs.isEmpty();
    }
    public void clearPlaylist(){
        songs.clear();
        durations.clear();
    }
    public void displayPlaylist(){
        System.out.println("Playlist: " + playlistName + " by " + creator);
        if (isEmpty()){
            System.out.println("(Empty)");

            //need ng for loop para maprint isa isa yung reqs
        } else {
            for (int i = 0; i < songs.size(); i ++){
                System.out.println(songs.get(i) + " | " + durations.get(i));
            }
        }
    }
    public String getLongestSong(){
        if (songs.isEmpty()){
            return null;
        }

        int maxIndex= 0;
        int maxDuration = durations.get(0);
        for (int i = 1; i < durations.size(); i ++){
            if (durations.get(i) > maxDuration){
                maxDuration = durations.get(i);
                maxIndex = i;
            }
        }
        return songs.get(maxIndex); //ang irereturn nito is yung title ng song na may pinakamahaba since songs ang kinuha not duration
    }
    public String getShortestSong(){
        if (songs.isEmpty()){
            return null;
        }
        int minIndex= 0;
        int minDuration = durations.get(0);
        for (int i = 1; i < durations.size(); i ++){
            if (durations.get(i) < minDuration){
                minDuration = durations.get(i);
                minIndex = i;
            }
        }
        return songs.get(minIndex);
    }
}
public class PlaylistCompleteTest {
    public static void main(String[] args) {
        System.out.println("=== PLAYLIST CLASS - ALL METHODS TEST ===\n");

        // Create playlist instance
        Playlist playlist = new Playlist("My Favorites", "John Smith");

        // Test 1: getPlaylistName()
        System.out.println("TEST 1: getPlaylistName()");
        System.out.println("Result: " + playlist.getPlaylistName());
        System.out.println("Expected: My Favorites");
        System.out.println();

        // Test 2: getCreator()
        System.out.println("TEST 2: getCreator()");
        System.out.println("Result: " + playlist.getCreator());
        System.out.println("Expected: John Smith");
        System.out.println();

        // Test 3: isEmpty() - on empty playlist
        System.out.println("TEST 3: isEmpty() - empty playlist");
        System.out.println("Result: " + playlist.isEmpty());
        System.out.println("Expected: true");
        System.out.println();

        // Test 4: getSongCount() - on empty playlist
        System.out.println("TEST 4: getSongCount() - empty playlist");
        System.out.println("Result: " + playlist.getSongCount());
        System.out.println("Expected: 0");
        System.out.println();

        // Test 5: addSong()
        System.out.println("TEST 5: addSong()");
        playlist.addSong("Bohemian Rhapsody", 354);
        playlist.addSong("Stairway to Heaven", 482);
        playlist.addSong("Hotel California", 391);
        playlist.addSong("Imagine", 183);
        playlist.addSong("Hey Jude", 431);
        System.out.println("Added 5 songs");
        System.out.println("Current count: " + playlist.getSongCount());
        System.out.println("Expected: 5");
        System.out.println();

        // Test 6: isEmpty() - on populated playlist
        System.out.println("TEST 6: isEmpty() - populated playlist");
        System.out.println("Result: " + playlist.isEmpty());
        System.out.println("Expected: false");
        System.out.println();

        // Test 7: getSongCount() - after adding
        System.out.println("TEST 7: getSongCount() - after adding songs");
        System.out.println("Result: " + playlist.getSongCount());
        System.out.println("Expected: 5");
        System.out.println();

        // Test 8: findSong() - existing song
        System.out.println("TEST 8: findSong() - existing song");
        int index1 = playlist.findSong("Hotel California");
        System.out.println("Result: " + index1);
        System.out.println("Expected: 2 (or any valid index)");
        System.out.println();

        // Test 9: findSong() - non-existing song
        System.out.println("TEST 9: findSong() - non-existing song");
        int index2 = playlist.findSong("Fake Song");
        System.out.println("Result: " + index2);
        System.out.println("Expected: -1");
        System.out.println();

        // Test 10: getSongAt()
        System.out.println("TEST 10: getSongAt()");
        String song = playlist.getSongAt(0);
        System.out.println("Result: " + song);
        System.out.println("Expected: Bohemian Rhapsody");
        System.out.println();

        // Test 11: getDurationAt()
        System.out.println("TEST 11: getDurationAt()");
        int duration = playlist.getDurationAt(0);
        System.out.println("Result: " + duration);
        System.out.println("Expected: 354");
        System.out.println();

        // Test 12: getTotalDuration()
        System.out.println("TEST 12: getTotalDuration()");
        int total = playlist.getTotalDuration();
        System.out.println("Result: " + total + " seconds");
        System.out.println("Expected: 1841 seconds");
        System.out.println();

        // Test 13: getLongestSong()
        System.out.println("TEST 13: getLongestSong()");
        String longest = playlist.getLongestSong();
        System.out.println("Result: " + longest);
        System.out.println("Expected: Stairway to Heaven");
        System.out.println();

        // Test 14: getShortestSong()
        System.out.println("TEST 14: getShortestSong()");
        String shortest = playlist.getShortestSong();
        System.out.println("Result: " + shortest);
        System.out.println("Expected: Imagine");
        System.out.println();

        // Test 15: displayPlaylist()
        System.out.println("TEST 15: displayPlaylist()");
        playlist.displayPlaylist();
        System.out.println();

        // Test 16: removeSong() - existing song
        System.out.println("TEST 16: removeSong() - existing song");
        boolean removed1 = playlist.removeSong("Imagine");
        System.out.println("Result: " + removed1);
        System.out.println("Expected: true");
        System.out.println("New count: " + playlist.getSongCount());
        System.out.println("Expected count: 4");
        System.out.println();

        // Test 17: removeSong() - non-existing song
        System.out.println("TEST 17: removeSong() - non-existing song");
        boolean removed2 = playlist.removeSong("Nonexistent Song");
        System.out.println("Result: " + removed2);
        System.out.println("Expected: false");
        System.out.println("Count unchanged: " + playlist.getSongCount());
        System.out.println("Expected count: 4");
        System.out.println();

        // Test 18: clearPlaylist()
        System.out.println("TEST 18: clearPlaylist()");
        playlist.clearPlaylist();
        System.out.println("Playlist cleared");
        System.out.println("Is empty: " + playlist.isEmpty());
        System.out.println("Expected: true");
        System.out.println("Song count: " + playlist.getSongCount());
        System.out.println("Expected: 0");
        System.out.println();

        // Test 19: getLongestSong() - on empty playlist
        System.out.println("TEST 19: getLongestSong() - empty playlist");
        String longestEmpty = playlist.getLongestSong();
        System.out.println("Result: " + longestEmpty);
        System.out.println("Expected: null");
        System.out.println();

        // Test 20: getShortestSong() - on empty playlist
        System.out.println("TEST 20: getShortestSong() - empty playlist");
        String shortestEmpty = playlist.getShortestSong();
        System.out.println("Result: " + shortestEmpty);
        System.out.println("Expected: null");
        System.out.println();

        System.out.println("=== ALL TESTS COMPLETED ===");
        System.out.println("Total methods tested: 12");
        System.out.println("Total test cases: 20");
    }
}
