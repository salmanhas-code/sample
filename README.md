# sample
We have disabled auto-configuration for OpenAI chat to manually define both OpenAI and Ollama chat clients as beans. We use @Qualifier("openAiChatClient") to inject the specific bean into the controller.

For OpenAI, we need three properties:

api-key (authentication)
base-url (DeepSeek API endpoint)
model (DeepSeek reasoner model)
For Ollama, since it's running locally, we only need the model property.

1️⃣ chatClient.prompt() – Creating a Chat Prompt
This initializes a new chat prompt session.
The prompt() method provides a builder-like API to configure the request.

2️⃣ .user(m) – Adding the User's Message
.user(m) attaches the user’s input (m) to the prompt.

👉 This step tells the AI model what the user wants.

The message (m) can be a simple string like "Hello AI!" or more complex structured input.

3️⃣ .call() – Executing the API Request
The .call() method sends the request to the AI model for processing.

👉 This step triggers the AI model to process the input and generate a response.

It interacts with OpenAI or Ollama, depending on which chat client was injected.

4️⃣ .content() – Extracting the AI’s Response
The .call() method returns a ChatResponse object.
.content() extracts the AI-generated response as a plain string.

👉 This step extracts the final response and returns it to the user.

1️⃣ Start chat session → 2️⃣ Send user input → 3️⃣ Call the AI model → 4️⃣ Extract AI’s response
