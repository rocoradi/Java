var String = Java.type("java.lang.String");

function greetings(name) {
    var result = "Welcome to Nashorn SON - "  + name;

    return result;
}

print(greetings("Rodrigo Coradi"));