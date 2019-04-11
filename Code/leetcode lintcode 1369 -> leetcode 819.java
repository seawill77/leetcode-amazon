leetcode lintcode 1369 -> leetcode 819

leetcode
*/


public class Solution {
    /**
     * @param paragraph: 
     * @param banned: 
     * @return: nothing
     */
    public String mostCommonWord(String paragraph, String[] banned) {
      Set<String> ban = new HashSet<> (Arrays.asList(banned));
      Map<String, Integer> count = new HashMap<>();
      // remove "return" "space" "!"?*+ 去除标点符号
      String[] words = paragraph.replaceAll("\\pP", " ").toLowerCase().split("\\s+");
      for(String w: words) {
          if (!ban.contains(w)){
              count.put(w, count.getOrDefault(w, 0) + 1);
          }
      }
      // collections.max（目标， 方法属性） 
      return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
      
    }
    
}