package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@ApplicationScoped
public class GreetingService {

    List<String> excuses;
    int size;

    public void loadFile() throws Exception{
         Path path = Paths.get(Objects.requireNonNull(this.getClass().getClassLoader().getResource("excuses.txt")).getPath());
         excuses = Files.readAllLines(path);
         size = excuses.size();
    }

    public String excuse() throws Exception{
        if (excuses == null) {
            loadFile();
        }
        Random random = new Random();
        int randomLineNumber = random.nextInt(size);

        return "Excuse of the day is: " + excuses.get(randomLineNumber);
    }

    public String greeting(String name) {
        return "hello " + name;
    }

}
