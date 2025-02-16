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

- 🔑 **api-key** → OpenAI authentication key.
- 🌍 **base-url** → API endpoint (**DeepSeek AI**).
- 🧠 **model** → AI model to use (**deepseek-reasoner**).

### 🔹 For Ollama  
If using **Ollama (local LLM)**, specify only the model:


deepseek-ai
│── src/main/java/com/salman/deepseek_ai
│   ├── controller/DeepSeekController.java   # REST Controller for AI chat
│   ├── config/LLMConfig.java                # AI Model Configuration
│── src/main/resources
│   ├── application.properties               # AI Model Configurations
│── pom.xml                                   # Dependencies (Spring Boot, Spring AI)

