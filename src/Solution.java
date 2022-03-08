import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    String[] tab = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v","w", "x", "y", "z"};

    StringBuilder builder;
    String endWord;
    List<List<String>> ans = new ArrayList<>();
    List<String> current = new ArrayList<>();
    Map<String, Boolean> vis = new HashMap<>();
    int minSize = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        vis.put(beginWord, true);
        for (String s : wordList) {
            vis.put(s, false);
        }
        builder = new StringBuilder(beginWord);
        this.endWord = endWord;
        if (!vis.containsKey(endWord)) return ans;
        current.add(beginWord);
        backtrack();
        return ans;
    }

    private void backtrack() {

        if (current.size() > minSize) return;

        if (endWord.equals(builder.toString())) {
            if (current.size() < minSize) {
                ans.clear();
                minSize = current.size();
            }
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < builder.length(); i++) {
            for (int j = 0; j < tab.length; j++) {
                String oldChar = builder.substring(i, i + 1);
                builder.replace(i, i + 1, tab[j]);
                String newString = builder.toString();
                if (!vis.containsKey(newString) || vis.get(newString)) {
                    builder.replace(i, i + 1, oldChar);
                    continue;
                }
                vis.put(newString, true);
                backtrack();
                vis.put(newString, false);
                builder.replace(i, i + 1, oldChar);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        s.findLadders("hit", "cog", list);
    }

}