package ua;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {
        new Main().main();
    }

    public void main()
    {
        OAHashTable<Integer, Long> map = new OAHashTable<>(200);

        map.put(300, 150L);
        map.put(301, 175L);
        map.put(500, 200L);
        map.put(301, null);
        map.put(302, 175L);

        assert map.get(300) == 150L;
        assert map.get(301) == null;
        assert map.get(302) == 175L;
        assert map.get(500) == 200L;
        assert map.size() == 4;
    }
}
