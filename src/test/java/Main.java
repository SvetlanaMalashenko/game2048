/**
 * Created by svetlana on 14.05.16
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        PlayGame playing = new PlayGame();
        playing.setup();
        playing.startPlay();
        playing.playGameWithArrows();
        playing.closeWindow();
    }
}
