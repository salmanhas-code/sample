# 🚀 DeepSeek AI Chat API
*A Spring Boot AI Chat API integrating OpenAI & Ollama models using Spring AI.*

## ✨ Features
✅ OpenAI Integration – API authentication, base URL & model selection.  
✅ Ollama Integration – Runs locally with minimal setup.  
✅ Manual Bean Definition – Disables auto-config to allow custom AI model control.  
✅ Builder API – Uses a fluent-style method chain to build AI prompts.  

---

## ⚡ Prerequisites

### 🔹 For OpenAI  
Add these properties in `application.properties` or `application.yml`:

```properties
spring.ai.openai.api-key=YOUR_API_KEY
spring.ai.openai.base-url=https://api.deepseek.com
spring.ai.openai.chat.options.model=deepseek-reasoner



---

## API Endpoints

### `GET /deepseek/{m}`

Handles incoming GET requests to generate AI responses based on user input passed as a path variable (`{m}`).

#### Request:
- Method: `GET`
- URL Pattern: `/deepseek/{m}`
- **Path Variable:**
  - `m`: The user input string (message) to send to the chat model.

#### Response:
- Status Code: `200 OK`
- Body: AI-generated response as plain text.

#### Example:

**Request:**
```http
GET http://localhost:8080/deepseek/Hello%20AI!
```

**Response:**
```json
{
  "response": "Hi there! How can I assist you today?"
}
```

---

## Code Walkthrough

The core functionality of the API resides in the `DeepSeekController` class. Below is a breakdown of the methods and key components:

### 1️⃣ ChatClient Initialization

The `ChatClient` object is injected via **manual bean definition**. Two different chat clients are defined for **OpenAI** and **Ollama**, distinguished using the `@Qualifier` annotation. For instance:

```java
private final ChatClient chatClient;

public DeepSeekController(@Qualifier("openAiChatClient") ChatClient chatClient) {
    this.chatClient = chatClient;
}
```

### 2️⃣ Handling Chat Requests

The `@GetMapping` annotation binds the `/deepseek/{m}` endpoint to the `chat()` method. The method processes user input using the following steps:
- Start a chat session (`.prompt()`).
- Add the user’s message (`.user(m)`).
- Execute the chat request (`.call()`).
- Extract and return the response (`.content()`).

```java
@GetMapping("/deepseek/{m}")
public String chat(@PathVariable String m) {
    return chatClient
            .prompt()   // Start a new prompt session
            .user(m)    // Add user input
            .call()     // Execute the request
            .content(); // Extract the response
}
```

---

## Chat Workflow in Detail

### **1️⃣ `.prompt()` – Creating a Chat Prompt**
The `.prompt()` method starts a new chat session.

- Used to initialize a builder-style configuration for the interaction.

---

### **2️⃣ `.user(m)` – Adding the User's Input**
The `.user(m)` method attaches the user’s input to the prompt.

- **Purpose:** Specifies what the AI needs to respond to.
- **Input Example:**
   - `"Hello AI!"`
   - A structured message like `"What is the capital of France?"`.

---

### **3️⃣ `.call()` – Executing the AI Model**
The `.call()` method sends the constructed request to the AI model for processing.

- **Purpose:** Triggers the execution of the chat interaction.
- This step handles communication with either OpenAI or Ollama, depending on which client is injected into the controller.

---

### **4️⃣ `.content()` – Retrieving the AI's Response**
Once the `ChatClient` processes the input, the `.call()` method returns a `ChatResponse` object. The `.content()` method extracts the AI response as a plain string.

- **Purpose:** Returns the final AI-generated message as the output.

---

## Example Usage

1. **Request**:---

## Configuration

Below is the configuration example that enables the API to use both OpenAI and Ollama clients.

### Manual Bean Definitions:

```java
@Configuration
public class ChatClientConfig {
    
    @Bean
    @Qualifier("openAiChatClient")
    public ChatClient openAiChatClient() {
        return new OpenAiChatClient("api-key", "base-url", "model");
    }
    
    @Bean
    @Qualifier("ollamaChatClient")
    public ChatClient ollamaChatClient() {
        return new OllamaChatClient("model");
    }
}
```

**Explanation**:
- **OpenAI Chat Client:** Configures the OpenAI client with `api-key`, `base-url`, and `model`.
- **Ollama Chat Client:** Creates a simple client for interacting with Ollama models.

---

## Getting Started

### Prerequisites

- **Java 21** or later.
- **Spring Boot 3.x**.

### Running the Application

1. Clone the project:---

## Configuration

Below is the configuration example that enables the API to use both OpenAI and Ollama clients.

### Manual Bean Definitions:

```java
@Configuration
public class ChatClientConfig {
    
    @Bean
    @Qualifier("openAiChatClient")
    public ChatClient openAiChatClient() {
        return new OpenAiChatClient("api-key", "base-url", "model");
    }
    
    @Bean
    @Qualifier("ollamaChatClient")
    public ChatClient ollamaChatClient() {
        return new OllamaChatClient("model");
    }
}
```

**Explanation**:
- **OpenAI Chat Client:** Configures the OpenAI client with `api-key`, `base-url`, and `model`.
- **Ollama Chat Client:** Creates a simple client for interacting with Ollama models.

---

## Getting Started

### Prerequisites

- **Java 21** or later.
- **Spring Boot 3.x**.

### Running the Application

1. Clone the project:---

## License

This project is licensed under the [MIT License](LICENSE).

---# DeepSeek AI Chat API

### Description

The **DeepSeek AI Chat API** is a **Spring Boot-based REST API** that integrates with **OpenAI** and **Ollama** models using **Spring AI**. It provides an endpoint for users to input chat messages and receive AI-generated responses. Designed for flexibility and control, the API is configurable for both locally hosted AI models and cloud-based AI services.

---

## Features

- **OpenAI Integration**: Enables interaction with OpenAI models using custom configurations for API authentication, base URL, and model selection.
- **Ollama Integration**: Supports AI models running locally via Ollama with minimal setup required.
- **Manual Bean Definition**: Auto-configuration for OpenAI chat is disabled, allowing manual definition of beans for both OpenAI and Ollama chat clients.
- **Builder-Like API**: Provides an intuitive method-chaining design for creating prompts, sending user input, and extracting responses.

---

## Prerequisites

### For OpenAI

To interact with OpenAI models, you will need:

1. **`api-key`**: Used for authenticating requests to the OpenAI service.
2. **`base-url`**: Custom endpoint for communicating with the DeepSeek API.
3. **`model`**: Specifies the AI model to be used (e.g., a GPT-based model).

### For Ollama

Configuration requires only the **`model`** property, which determines the AI model used by the locally running Ollama instance.

---

## How It Works

### Chat Process Flow

The interaction with the API follows these steps:

1. **Start a Chat Prompt Session:**
   - Use `.prompt()` to start a new chat session.
2. **Add User's Message:**
   - Attach the user’s input (e.g., a question or query) with `.user(m)`.
3. **Send the Chat Request:**
   - Call `.call()` to trigger the AI model to process the input.
4. **Extract the AI’s Response:**
   - Retrieve the output with `.content()`.

Diagrammatically:

