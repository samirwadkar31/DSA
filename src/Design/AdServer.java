package Design;

import java.util.PriorityQueue;

class Solution{
    public static void main(String[] args) {
        AdServer obj = new AdServer();
        obj.addAD(2,3);
        obj.addAD(5,13);
        obj.addAD(12,10);
        obj.addAD(12,13);
        obj.addAD(8,9);

        System.out.println(obj.getAD());
        System.out.println(obj.getAD());
        System.out.println(obj.getAD());
        System.out.println(obj.getAD());
        System.out.println(obj.getAD());
    }
}

public class AdServer {

    private Pair lastServe;
    private PriorityQueue<Pair> adServer;

    public AdServer(){
        lastServe = null;
        adServer = new PriorityQueue<>((a, b) -> b.score - a.score);
    }

    public void addAD(int content, int score){
        adServer.offer(new Pair(content, score));
    }

    public int getAD(){
        if(adServer.isEmpty()) return -1;

        Pair bestAd = adServer.poll();
        if (lastServe != null && bestAd.content == lastServe.content) {
            if (adServer.isEmpty()) {
                return bestAd.content;
            }
            Pair nextBestAd = adServer.poll();
            adServer.offer(bestAd);
            bestAd = nextBestAd;
        }

        bestAd.score--;
        if (bestAd.score > 0) {
            adServer.offer(bestAd);
        }

        lastServe = bestAd;
        return bestAd.content;
    }
}

class Pair {
    int content;
    int score;

    public Pair(int content, int score){
        this.content = content;
        this.score = score;
    }
}
