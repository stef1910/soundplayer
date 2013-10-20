//don't forget to import the midi package
import javax.sound.midi.*;

public class MiniMiniMusicApp {
	
	public static void main(String[] args) {
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		mini.play();
	}//close main

	public void play() {

		try {

			//get a Sequencer and open it (so we can use it..a Sequencer doesn't come already open)
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			//ask the Sequence for a Track. Remember > the Track lives in the Sequence, and the MIDI data lives in the Track
			Track track = seq.createTrack();

			//put some MidiEvents into the Track. The only thing you have to care about are the arguments to the
			//setMessage() method, and the arguments to the MidiEvent constructor
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, 44, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);

			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 100);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);

			//give the Sequence to the Sequencer 
			player.setSequence(seq);

			//start() the Sequencer
			player.start();

		} catch (Exception ex) {

			ex.printStackTrace();

		}
	} // close play
}// close class