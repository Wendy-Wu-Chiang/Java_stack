public class StringManipulator{
    public String trimAndConcat(String string, String anotherstring) {
        string = string.trim();
        anotherstring = anotherstring.trim();
        return string.concat(anotherstring);
    }
    public Integer getIndexOrNull(String input, char c){
        if(input.indexOf(c) == -1) {
            return null;
        }
        return input.indexOf(c);
    }
    public Integer getIndexOrNull(String string, String otherString) {
        if(string.indexOf(otherString) == -1){
            return null;
        }
        return string.indexOf(otherString);

    }
    public String concatSubString(String string, int number, int number2, String otherString) {
        String substr = string.substring(number, number2);
        return substr.concat(otherString);

    }
}