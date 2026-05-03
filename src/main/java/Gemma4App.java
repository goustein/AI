import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

public class Gemma4App {

    public static void main(String[] args) {
        System.out.println("Starting application... checking Ollama connection...");
  //  stash 1
        try {
            // 1. Build the connection to your local Ollama instance
            ChatLanguageModel model = OllamaChatModel.builder()
                    .baseUrl("http://localhost:11434")
                    .modelName("gemma4") // Make sure this matches exactly what is in Ollama
                    .build();

            // 2. Ask a simple question
            System.out.println("Sending message to Gemma 4. Please wait...");
            String response = model.generate("Hello! Can you hear me? Please reply with a short sentence.");

            // 3. Print the answer
            System.out.println("\nSUCCESS! Gemma 4 says:");
            System.out.println(response);

        } catch (Exception e) {
            System.err.println("\n--- ERROR ---");
            System.err.println("Could not connect. Please check the following:");
            System.err.println("1. Is the Ollama app open on your Mac?");
            System.err.println("2. Did you download the model? (Run 'ollama run gemma4' in your terminal)");
            e.printStackTrace();
        }
    }
}