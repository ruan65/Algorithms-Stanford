package stanford_ass;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Ass3_MinCat {

    public static void contract(Map<Integer, ArrayList<Integer>> net, int getOut, int stay) {

        net.remove(getOut).stream()
                .filter(i -> i != getOut && i != stay)
                .forEach(i -> net.get(stay).add(i));

        List<Integer> stayNode = net.get(stay);

        new ArrayList<>(stayNode).stream().filter(i -> i == getOut)
                .forEach(i -> stayNode.remove(stayNode.indexOf(i)));

        for (int key : net.keySet()) {
            List<Integer> node = net.get(key);
            for (int i = 0; i < node.size(); i++) {
                if (node.get(i) == getOut) {
                    node.set(i, stay);
                }
            }
        }

    }

    public static void findRandomlyAdjacentNodesAndContract(Map<Integer, ArrayList<Integer>> net) {

        List<Integer> keys = new ArrayList<>(net.keySet());

        Integer stay = keys.get(ThreadLocalRandom.current().nextInt(keys.size()));

        List<Integer> stayNode = net.get(stay);

        Integer getOut = stayNode.get(ThreadLocalRandom.current().nextInt(stayNode.size()));

        contract(net, getOut, stay);
    }

    public static int findCut(Map<Integer, ArrayList<Integer>> net) {

        while (net.size() > 2) {
            findRandomlyAdjacentNodesAndContract(net);
        }
        return net.get(net.keySet().iterator().next()).size();
    }

    public static Map<Integer, ArrayList<Integer>> deepCopyNet(Map<Integer, ArrayList<Integer>> original) {

        Map<Integer, ArrayList<Integer>> copy = new HashMap<>(original.size());

        for (int i : original.keySet()) {
            ArrayList<Integer> list = original.get(i);

            copy.put(i, (ArrayList<Integer>) list.clone());
        }
        return copy;
    }

    public static void main(String[] args) throws IOException {

        HashMap<Integer, ArrayList<Integer>> net = new HashMap<>();


        Scanner sc = new Scanner(new File("KargerMinCut.txt"));

//        Scanner sc = new Scanner(new File("testGraph1.txt"));

        while (sc.hasNextLine()) {

            String[] nodeString = sc.nextLine().split("\\s+");

            ArrayList<Integer> node = new ArrayList<>();

            for (String s : nodeString) {
                node.add(Integer.parseInt(s));

            }
            Integer indx = node.remove(0);
            net.put(indx, node);
        }

        System.out.println(net);



        int minCut = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {

            Map<Integer, ArrayList<Integer>> clone = deepCopyNet(net);
            int min = findCut(clone);
            if (min < minCut) {
                minCut = min;
            }
        }

        System.out.println("min cut = " + minCut);

        System.out.println(net);

    }
}
