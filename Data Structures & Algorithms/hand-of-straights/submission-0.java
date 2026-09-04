class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        TreeMap<Integer, Integer> cardCounts = new TreeMap<>();
        for(int card : hand){
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
        }

        while(!cardCounts.isEmpty()){
            int firstCard = cardCounts.firstKey();

            for(int i = 0; i<groupSize; i++){
                int currCard = firstCard + i;

                if(!cardCounts.containsKey(currCard)){
                    return false;
                }

                int count = cardCounts.get(currCard);
                if(count == 1){
                    cardCounts.remove(currCard);
                }else{
                    cardCounts.put(currCard, count - 1);
                }
            }
        }

        return true;
    }
}
