import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> maps = new HashMap<>();
        maps.put("Mathias", 17);
        maps.put("Yasmin", 18);
        maps.put("Enzo", 19);
        System.out.println(maps.get("Enzo")); //19
        System.out.println(maps.values()); //17, 18, 19
        for (Map.Entry<String, Integer> entry : maps.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println(maps.putIfAbsent("Mathias", 17)); //retorna o value se tem, se não tem retorna null e adiciona
        System.out.println(maps);

        maps.computeIfAbsent("João", s -> 17+1);//pega a chave e faz um calculo com o valor, se houver uma chave não substitui
        System.out.println(maps);
        maps.computeIfPresent("Mathias", (s, integer) -> 17+1); //pega uma chave existente e substitui, se não existir não acontece nada
        System.out.println(maps);
    }
}