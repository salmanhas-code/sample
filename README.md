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
