package code;

import code.entites.Node;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import code.entites.State;
import code.search.AStar;
import code.search.BFS;
import code.search.DFS;
import code.search.GeneralSearch;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class Main {

    public static void main(String[] args) {
    	OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        pq.add(4);
        pq.add(3);

        String p1 = "5;4;" + "b,y,r,b;" + "b,y,r,r;" + "y,r,b,y;" + "e,e,e,e;" + "e,e,e,e;";
        String p2 = "3;4;" + "b,b,b,r;" + "r,r,r,b;" + "e,e,e,e;";
        String p3nosolution = "3;3;" + "b,r,r;" + "b,b,r;" + "y,e,e;";
        String p4 = "3;3;" + "b,b,b;" + "r,r,r;" + "y,y,y;";
        String grid0 = "3;" +
                "4;" +
                "r,y,r,y;" +
                "y,r,y,r;" +
                "e,e,e,e;";

        String grid1= "5;" +
                "4;" +
                "b,y,r,b;" +
                "b,y,r,r;" +
                "y,r,b,y;" +
                "e,e,e,e;" +
                "e,e,e,e;";
        String grid2 = "5;" +
                "4;" +
                "b,r,o,b;" +
                "b,r,o,o;" +
                "r,o,b,r;" +
                "e,e,e,e;" +
                "e,e,e,e;";
        String grid3 = "6;" +
                "4;" +
                "g,g,g,r;" +
                "g,y,r,o;" +
                "o,r,o,y;" +
                "y,o,y,b;" +
                "r,b,b,b;" +
                "e,e,e,e;";
        String grid4 = "6;" +
                "3;" +
                "r,r,y;" +
                "b,y,r;" +
                "y,b,g;" +
                "g,g,b;" +
                "e,e,e;" +
                "e,e,e;";

        
        System.out.println(WaterSortSearch.solve(grid4, "UCS", false));


//        double memoryUsed = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1_000_000;
//        double cpuUtilization = osBean.getProcessCpuLoad() * 100;
//        System.out.println("Memeroy used: " + memoryUsed + " MB");
//        System.out.println("CPU Utilization: " + String.format("%.2f", cpuUtilization)  + "%");
    }
    
    
}
