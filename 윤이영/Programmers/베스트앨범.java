import java.util.*;

class Solution {
    // 장르별 총 재생 수를 저장
    static HashMap<String, Integer> genreTotalPlay = new HashMap<>();
    // 장르별 노래 목록을 저장
    static HashMap<String, List<Song>> genreSongs = new HashMap<>();
        
    public int[] solution(String[] genres, int[] plays) {
        int N= plays.length;
        
        for(int i=0; i<N; i++){
            // 장르별 총 재생 수를 누적하여 저장
            if(genreTotalPlay.containsKey(genres[i])){
                genreTotalPlay.put(genres[i], genreTotalPlay.get(genres[i]) + plays[i]);
            }
            else{
                genreTotalPlay.put(genres[i], plays[i]);
                genreSongs.put(genres[i], new ArrayList<>());
            }
            // 장르별 노래를 저장
            genreSongs.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        // 장르를 재생 수 기준으로 정렬
        List<String> genreOrder = new ArrayList<>(genreTotalPlay.keySet());
        genreOrder.sort((a, b) -> genreTotalPlay.get(b) - genreTotalPlay.get(a));
        
        List<Integer> answerList = new ArrayList<>();
        // 장르별 2곡 선택
        for(String genre: genreOrder){
            List<Song> songs = genreSongs.get(genre);
            Collections.sort(songs); // 장르별 정렬
            
            for(int i=0; i<songs.size() && i<2; i++){
                answerList.add(songs.get(i).id);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}



class Song implements Comparable<Song> {
    int id; // 고유번호
    int play; // 재생 횟수
    
    public Song(int id, int play){
        this.id = id;
        this.play = play;
    }
    
    @Override
    public int compareTo(Song o){
        if(this.play == o.play){
            return this.id - o.id;
        }
        return o.play - this.play;   // play 기준 내림차순
    }
    
}
