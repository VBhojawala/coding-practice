package hashmap;

public class VerifyAnAlienDictionary953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];

        for (int i=0; i<order.length(); i++){
            orderMap[order.charAt(i) -'a'] = i;
        }
        int iRank, iP1Rank;
        for (int i=0; i<words.length -1; i++){
            for (int j=0; j < words[i].length(); j++){
                if (j >= words[i+1].length()) return false; // CASE : apple app
                if (words[i].charAt(j) != words[i+1].charAt(j)){
                    iRank = orderMap[words[i].charAt(j) - 'a'];
                    iP1Rank = orderMap[words[i+1].charAt(j) - 'a'];

                    if (iRank > iP1Rank)
                        return false;
                    else
                        break;
                }
            }
        }
        return true;
    }
}
