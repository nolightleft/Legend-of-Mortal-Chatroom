# What is this?
This is a simple chatroom web application that contains 8 characters from the game Legend of Mortal. It's also a side project gone side way just for fun. So please don't take this application seriously.

# How does it look like?
![chatroom](./chatroom.png)

# What does this do?
It's a chatroom application that you can either talk to characters an write answers for yourself (which I do frequently), or you can install [Ollama](https://ollama.com), create a local model, add the model name to chatroom.properties and let the AI answer you.

# How do I open it?
It's a Spring web application. You download the released jar and run it with  
`` java -jar chatroom-v0.1.jar ``  
Then access it with `localhost:8080`.

# How do I set up Ollama and the AI models?
You can check out [Ollama's document](https://github.com/ollama/ollama/tree/main/docs) first.

1. Go to Ollama's website, download and install.
2. Download an appropriate Chinese model
    - I find the [Tifa-RP](https://huggingface.co/Tifa-RP/Tifa-7B-Qwen2-v0.1-GGUF) model pretty good
    for this task and it's Q3_K model runs smoothly on my 4070
3. Create a text file that contains path to model and basic prompts, there're some files I made in `model prompts` for reference, **remember to change model path to either absolute or relative path to your downloaded model**.
4. Run `ollama create model-name -f path/to/text_file` to create an ollama AI model
5. Add model name to chatroom.properties file for an character, this binds the AI model and the character together
6. Run the web application (rerun if opened) and you should be able to talk with AI

# What framework is used here?
- Spring, Spring Boot, Spring JPA, Spring AI. 
- Thymeleaf with native Javascript for AJAX.
- H2 Embeded DB is used for easy storage.
- Chatroom HTML template from [BootDey](https://www.bootdey.com/snippets/tagged/chat)

# TODO 
- [x] add AI as back end
- [x] add external property file for AI models