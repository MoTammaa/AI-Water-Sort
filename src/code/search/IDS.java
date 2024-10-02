package code.search;

import code.WaterSortSearch;
import code.entites.Node;

public class IDS extends DFS {
   
   @Override
   public boolean GENERAL_SEARCH() {
      int INF = (int) 1e8;
      for (int i = 1; i < INF; i++) {
         this.MaxDepth = i;
         this.setInitialState(this.initialState);
         if (WaterSortSearch.SHOW_DEBUG) System.out.println("Trying IDS with Depth: " + i);
         if (
                 super.GENERAL_SEARCH()
            )
            return true;
      }
      return false;
   }
}
