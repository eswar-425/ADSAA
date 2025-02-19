import java.util.Arrays;

class Item{
    int weight,profit;
    double ratio;
    Item(int weight,int profit){
    this.weight = weight;
    this.profit = profit;
    this.ratio = (double)profit / weight;
    }
}

public class Knapsack{
    public static double getMaxprofit(Item[] items,int m){
        Arrays.sort(items,(a,b) -> Double.compare(b.ratio,a.ratio));
        double maxprofit = 0.0;
        System.out.println("Items placed in the bag:");
        for(Item item: items){
            if(item.weight <= m){
                maxprofit += item.profit;
                System.out.println("Item: (Weight: " + item.weight + ", profit: " + item.profit + ") - Taken Fully");
                m -= item.weight;
                }
            else{
                double fraction = (double)m / item.weight;
                maxprofit += item.profit * fraction;
                System.out.println("Item: (Weight: "+item.weight*fraction + " profit: " + item.profit * fraction + ") - Taken " + fraction * 100 + "%");
                break;
                }
            }
    return maxprofit;
    }
public static void main(String args[]){
    Item[] items = { new Item(10,60),new Item(20,100),new Item(30,120)};
    int m = 50;
    double maxprofit = getMaxprofit(items,m);
    System.out.println("Maximum profit in Knapsack: "+maxprofit);
    }
}

Output:
Items placed in the bag:
Item: (Weight: 10, profit: 60) - Taken Fully
Item: (Weight: 20, profit: 100) - Taken Fully
Item: (Weight: 20.0 profit: 80.0) - Taken 66.66666666666666%
Maximum profit in Knapsack: 240.0
