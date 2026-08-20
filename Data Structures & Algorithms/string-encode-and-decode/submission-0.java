class Solution {

    public String encode(List<String> strs) {
        StringBuilder encode_string = new StringBuilder();
        for(String str : strs){
            encode_string.append(str.length()).append("#").append(str);
        }

        return encode_string.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            int stringStart = j+1;
            int stringEnd = stringStart + length;

            result.add(str.substring(stringStart, stringEnd));

            i = stringEnd;
        }
        return result;
    }
}
