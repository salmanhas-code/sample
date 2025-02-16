DeepSeek AI Chat API
This is a Spring Boot-based AI Chat API that integrates with OpenAI and Ollama models using Spring AI. The project exposes an API for users to send chat messages and receive AI-generated responses.
 
Features
OpenAI Integration: Communicate with OpenAI models using custom configurations for API authentication, base URL, and model selection.
Ollama Integration: Access AI models running locally via Ollama with minimal setup.
Manual Bean Definition: Auto-configuration for OpenAI chat is disabled to allow manual control and definitions for both OpenAI and Ollama chat clients.
Builder API: The API is designed with a builder-like pattern for creating prompts, sending user input, and extracting AI responses efficiently.
 
Prerequisites
Before using this API, ensure the following requirements are met:
For OpenAI
You will need the following properties:
api-key: For authenticating your requests to the OpenAI service.
base-url: The endpoint for DeepSeek API.
model: The desired model to be used by DeepSeek (e.g., GPT-based models).
For Ollama
You will need the following property in your configuration:
model: The model to be used on the locally running Ollama instance.
 
Key Functionalities
Here’s how the chat process works:
Start a Chat Prompt Session Initializes a new chat prompt session using .prompt().
Add User's Message Attach the user’s input using .user(m). This input can be a simple string or a more structured query.
Send the Chat Request Execute the API request using .call(). This will trigger the AI model (OpenAI or Ollama) to process the prompt and generate a response.
Extract the AI’s Response Use .content() to extract the final AI-generated response as plain text.
 
Endpoint
GET /deepseek/{m}
This endpoint allows users to interact with the AI models by sending messages dynamically via the {m} path variable.
Request:
A GET request with the user’s message passed as {m} in the URL.
Response:
A plain string containing the AI-generated response.
