import java.io.IOException;
import java.util.*;

// 7432. 디스크 트리 / 골드 3 / 25분
public class BOJ_7432 extends FI1 {
    static class TrieNode{
        Map<String,TrieNode> children;
        boolean isEnd;

        TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    static class Trie{
        TrieNode root;

        Trie(){
            this.root=new TrieNode();
            root.children=new HashMap<>();
        }

        void insert(String[] s){
            TrieNode node=root;
            for(int i=0;i<s.length;i++){
                node.children.computeIfAbsent(s[i],no->new TrieNode());
                node=node.children.get(s[i]);
            }
            node.isEnd=true;
        }
    }
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        initFI();
        int n=nextInt();
        Trie t=new Trie();
        for(int i=0;i<n;i++){
            String[] s=next().split("\\\\");
            t.insert(s);
        }
        play(t.root,0);
        System.out.println(sb);
    }

    private static void play(TrieNode node,int depth){
        List<String> list=new ArrayList<>(node.children.keySet());
        Collections.sort(list);
        for(String next:list){
            sb.append(" ".repeat(depth)).append(next).append("\n");
            play(node.children.get(next), depth+1);
        }
    }
}