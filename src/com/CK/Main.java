package com.CK;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}


class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Set<Integer>> secretMap = new HashMap<>(), guessMap = new HashMap<>();
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char sCh = secret.charAt(i), gCh = guess.charAt(i);
            if (sCh == gCh) {
                bulls++;
                continue;
            }
            if (!secretMap.containsKey(sCh)) {
                secretMap.put(sCh, new HashSet<>());
            }
            secretMap.get(sCh).add(i);

            if (!guessMap.containsKey(gCh)) {
                guessMap.put(gCh, new HashSet<>());
            }
            guessMap.get(gCh).add(i);
        }

        for (Character key : secretMap.keySet()) {
            if (guessMap.containsKey(key)) {
                cows += Math.min(secretMap.get(key).size(), guessMap.get(key).size());
            }
        }

        return bulls + "A" + cows + "B";
    }
}

class Solution {
    public String getHint(String secret, String guess) {
        int arr[] = new int [10];                               // there can only be 10 numbers
        for(char c: secret.toCharArray())                       // put each occurrence of number i in arr[i] and increment
        {
            arr[c-'0']++;
        }
        int bull =0, cow = 0;
        for (int i = 0; i<guess.length(); i++)                  // Loop thru the guess string
        {
            char ch = guess.charAt(i);
            if(secret.charAt(i) == guess.charAt(i))             // this means it's a bull
            {
                bull++;                                         // increment bull
                if (arr[ch-'0']>0)                              // if the count of this number is more than 0 decrement it
                    arr[ch-'0']--;
                else cow--;                                     // for the time we find a bull but count is 0 or less it means we counted it as a cow when we shouldn't have
            }                                                   // so decrement cow
            else
            {
                if (arr[ch-'0']>0)                              // its a cow if the count is non zero
                {
                    cow++;                                      // increment cow
                    arr[ch-'0']--;                              // if the count of this number is more than 0 decrement it
                }

            }
        }
        return bull+"A"+cow+"B";
    }
}