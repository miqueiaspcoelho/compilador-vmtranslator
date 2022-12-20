package br.ufma.ecp;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    List<String[]> commands;

    Parser (String input) {
        final String eol = System.getProperty("line.separator");
        var output = input.split(eol);
        commands = Arrays.stream(output)
        .map(String::strip)
        .filter(  (s) ->  s.indexOf("//") != 0 && s != "")
        //.map ( (s) -> s.substring(0, s.indexOf("//")) )
        .map ( (s) ->s.split(" ")  )
        .collect(Collectors.toList());

    }

    public boolean hasMoreCommands () {
        return commands.size() != 0;
    }

    public Command nextCommand () {
        return new Command(commands.remove(0));
    }
    
}
