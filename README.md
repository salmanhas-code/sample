DeepSeek AI Chat API
🚀 A Spring Boot-based AI Chat API that integrates with OpenAI and Ollama models using Spring AI. This API allows users to send chat messages and receive AI-generated responses dynamically.

Features
✅ OpenAI Integration – Communicate with OpenAI models using custom configurations for API authentication, base URL, and model selection.
✅ Ollama Integration – Access AI models running locally via Ollama with minimal setup.
✅ Manual Bean Definition – Auto-configuration for OpenAI chat is disabled, allowing manual control over OpenAI and Ollama chat clients.
✅ Builder API – Uses a builder-like pattern to create prompts, send user input, and extract AI responses efficiently.

Prerequisites
Before using this API, ensure the following requirements are met:

🔹 For OpenAI
You need the following properties in application.properties or application.yml:

properties
Copy
Edit
spring.ai.openai.api-key=YOUR_API_KEY
spring.ai.openai.base-url=https://api.deepseek.com
spring.ai.openai.chat.options.model=deepseek-reasoner
api-key → API key for OpenAI authentication.
base-url → API endpoint for DeepSeek AI.
model → AI model to use (e.g., deepseek-reasoner).
🔹 For Ollama
If using Ollama (running locally), you only need to specify the model:

properties
Copy
Edit
spring.ai.ollama.chat.model=deepseek-r1:1.5b
model → The locally running Ollama AI model.
How It Works
1️⃣ Start a Chat Prompt Session
Initializes a new chat prompt session using .prompt().
2️⃣ Add User's Message
Attach user input with .user(m).
The input can be a simple text message or a structured query.
3️⃣ Send the Chat Request
Call .call() to send the request to the AI model (OpenAI or Ollama).
4️⃣ Extract the AI’s Response
Use .content() to get the final AI-generated response as plain text.
API Endpoint
🔹 GET /deepseek/{m}
This endpoint allows users to interact with the AI models by sending messages dynamically.

📌 Request:
A GET request with the user’s message passed as {m} in the URL.
📌 Response:
A plain string containing the AI-generated response.
Example Usage:
bash
Copy
Edit
curl -X GET "http://localhost:8080/deepseek/Hello"
Example Response:
json
Copy
Edit
"Hello! How can I assist you today?"
Project Structure
bash
Copy
Edit
deepseek-ai
│── src/main/java/com/salman/deepseek_ai
│   ├── controller/DeepSeekController.java   # REST Controller for AI chat
│   ├── config/LLMConfig.java                # Manual Bean Configuration
│── src/main/resources
│   ├── application.properties               # AI model configurations
│── pom.xml                                   # Project dependencies (Spring Boot, Spring AI)
Getting Started
🔹 Clone the Repository
bash
Copy
Edit
git clone https://github.com/yourusername/deepseek-ai.git
cd deepseek-ai
🔹 Build & Run the Project
bash
Copy
Edit
mvn clean install
mvn spring-boot:run
🔹 Access the API
Open your browser or use cURL/Postman:
bash
Copy
Edit
curl -X GET "http://localhost:8080/deepseek/Hello"
Contributing
Contributions are welcome! Feel free to submit issues and pull requests.

License
This project is licensed under the MIT License.
