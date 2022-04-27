package google.java;
import java.util.*;

public class ReadNCharactersGivenRead4II {
    public static class FileReader {
        int fileBufferPointer = 0;
        Character[] fileBuffer = new Character[4];

        public int read(Character[] buffer, int numberOfCharsToRead) {
            int totalCharsRead = 0;
            while (numberOfCharsToRead > 0) {
                int charsRead = read4(fileBuffer);

                if (hasReachedEndOfFile(charsRead)) {
                    return totalCharsRead;
                }

                int charsCopied = copyFileBufferToClientBuffer(totalCharsRead, charsRead, numberOfCharsToRead, buffer, fileBuffer);
                totalCharsRead = totalCharsRead + charsCopied;
                numberOfCharsToRead = numberOfCharsToRead - charsCopied;
            }
            return totalCharsRead;
        }

        private boolean hasReachedEndOfFile(int charsRead) {
            return charsRead == 0;
        }

        private int copyFileBufferToClientBuffer(int totalCharsRead, int charsToCopy, int numberOfCharsToRead, Character[] buffer, Character[] fileBuffer) {
            for (int i = 0; i < charsToCopy && i < numberOfCharsToRead; i++) {
                buffer[i + totalCharsRead] = fileBuffer[i];
            }
            return Math.min(charsToCopy, numberOfCharsToRead);
        }
    }
}
