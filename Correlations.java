import java.util.ArrayList;

public class Correlations {

    /* CHANNELS :
    EEG FP1-REF, EEG FP2-REF, EEG F3-REF, EEG F4-REF, EEG C3-REF, EEG C4-REF, EEG P3-REF,
    EEG P4-REF, EEG O1-REF, EEG O2-REF, EEG F7-REF, EEG F8-REF, EEG T3-REF, EEG T4-REF, EEG T5-REF,
    EEG T6-REF, EEG A1-REF, EEG A2-REF, EEG FZ-REF, EEG CZ-REF, EEG PZ-REF, EEG ROC-REF, EEG LOC-REF,
    EEG EKG1-REF, EMG-REF, EEG 26-REF, EEG 27-REF, EEG 28-REF,
    EEG 29-REF, EEG 30-REF, EEG T1-REF, EEG T2-REF, PHOTIC-REF, IBI, BURSTS, BURSTS
     */

    public static void main(String[] args) {
        ArrayList<String> channels = new ArrayList<>();
        channels.add("'EEG FP1-REF'");
        channels.add("'EEG FP2-REF'");
        channels.add("'EEG F3-REF'");
        channels.add("'EEG F4-REF'");
        channels.add("'EEG C3-REF'");
        channels.add("'EEG C4-REF'");
        channels.add("'EEG P3-REF'");
        channels.add("'EEG P4-REF'");
        channels.add("'EEG O1-REF'");
        channels.add("'EEG O2-REF'");
        channels.add("'EEG F7-REF'");
        channels.add("'EEG F8-REF'");
        channels.add("'EEG T3-REF'");
        channels.add("'EEG T4-REF'");
        channels.add("'EEG T5-REF'");
        channels.add("'EEG T6-REF'");
        channels.add("'EEG A1-REF'");
        channels.add("'EEG A2-REF'");
        channels.add("'EEG FZ-REF'");
        channels.add("'EEG CZ-REF'");
        channels.add("'EEG PZ-REF'");
        channels.add("'EEG ROC-REF'");
        channels.add("'EEG LOC-REF'");
        channels.add("'EEG EKG1-REF'");
        channels.add("'EMG-REF'");
        channels.add("'EEG 26-REF'");
        channels.add("'EEG 27-REF'");
        channels.add("'EEG 28-REF'");
        channels.add("'EEG 29-REF'");
        channels.add("'EEG 30-REF'");
        channels.add("'EEG T1-REF'");
        channels.add("'EEG T2-REF'");
        channels.add("'PHOTIC-REF'");
        //channels.add("'IBI'");
        //channels.add("'BURSTS'");


        //System.out.println(channels);
        //System.out.println(channels.size());

        //generate correlation statements for all possible combinations C(n,r) = C(34, 2) = 528
        int count = 1; //start at 1 to skip self-comparison for index position 0
        int num = 0;
        for (int i = 0; i < channels.size(); i++) {
            for (int j = count; j < channels.size(); j++) {
                System.out.println("v <- append(v, cor(sig$" + channels.get(i) + "$signal, sig$" + channels.get(j) + "$signal, method = 'pearson'), after = length(" + num + "))");
                num++;
            }

            count++; //increment count to perform correlation on count to channels.size()-1 and avoid repetition
        }

    }
}
