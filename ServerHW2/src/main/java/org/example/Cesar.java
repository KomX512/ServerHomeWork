public class Cesar {

    public int keyShift;
    public boolean revers;

    public String encryptString(String baseString) {
        String readyString;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseString.length(); i++) {
            char currentChar = baseString.charAt(i);
            currentChar = (char) ((int) currentChar + keyShift);
            sb.append(currentChar);
        }

        readyString = sb.toString();

        if (revers) {
            readyString = reverseString(readyString);
        }
        return readyString;
    }


    public String reverseString(String baseString) {
        String readyString;
        StringBuilder sb = new StringBuilder();
        for (int i = baseString.length() - 1; i >= 0; i--) {
            sb.append(baseString.charAt(i));
        }
        readyString = sb.toString();
        return readyString;
    }
}
