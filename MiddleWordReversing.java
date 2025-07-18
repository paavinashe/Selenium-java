package basicProgramming;

public class MiddleWordReversing {

	public static void main(String[] args) {
		String str = "The India is optim";
        String[] words = str.split(" ");

        // Loop through words to find "India" and reverse it
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("India")) {
                String reversed = "";
                for (int j = words[i].length() - 1; j >= 0; j--) {
                    reversed += words[i].charAt(j);
                }
                words[i] = reversed;
                break; // stop after reversing the word
            }
        }

        // Join the words back into a sentence
        String result = "";
        for (int i = 0; i < words.length; i++) {
            result += words[i];
            if (i != words.length - 1) {
                result += " ";
            }
        }

        System.out.println(result);

	}

}
