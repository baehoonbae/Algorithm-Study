import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

// 9250. 문자열 집합 판별 / 플래 2 / 1시간 17분
class BOJ_9250 extends FI1 {
    static Set<String> set;

    static class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isEnd=false;
    }

    static class Trie{
        TrieNode root=new TrieNode();

        void insert(String s){
            TrieNode node=root;
            for(char c:s.toCharArray()){
                int index=c-'a';
                if(node.children[index]==null){
                    node.children[index]=new TrieNode();
                }
                node=node.children[index];
            }
            node.isEnd=true;
        }

        boolean search(String s){
            for(int i=0;i<s.length();i++){
                TrieNode current=root;
                for(int j=i;j<s.length();j++){
                    int index=s.charAt(j)-'a';
                    if(current.children[index]==null)break;
                    current=current.children[index];
                    if(current.isEnd)return true;
                }
            }
            return false;
        }

    }

    public static void main(String[] args) throws IOException {
        initFI();
        set=new HashSet<>();
        int n=nextInt();
        Trie t=new Trie();
        for(int i=0;i<n;i++){
            t.insert(next());
        }
        int m=nextInt();
        for(int i=0;i<m;i++){
            String s=next();
            boolean found=t.search(s);
            System.out.println(found?"YES":"NO");
        }

    }
}