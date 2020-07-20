package ua;

class OAHashTable<T1, T2> {
    private Pair<T1, T2>[] table;
    private int size = 0;

    public OAHashTable(int size) {
        table = new Pair[size];
    }

    public boolean put(T1 key, T2 value)
    {
        int pos = key.hashCode() % table.length;

        if(size != table.length) {
            for (int i = pos; i < table.length; ++i)
                if(putAtPos(i, key, value)) 
                {
                    ++size;
                    return true;
                }

            for (int i = 0; i < pos; ++i)
                if(putAtPos(i, key, value)) 
                {
                    ++size;
                    return true;
                }
        }

        return false;
    }

    public boolean putAtPos(int pos, T1 key, T2 value)
    {
        Pair posValue = table[pos];

        if (posValue == null) {
            table[pos] = new Pair(key, value);
            return true;
        } else if (posValue.getKey().equals(key)) {
            table[pos].setValue(value);
            return true;
        }

        return false;
    }

    public T2 get(T1 key)
    {
        int pos = key.hashCode() % table.length;

        for (int i = pos; i < table.length; ++i)
        {
            Pair<T1, T2> value = table[i];
            if(value != null && value.getKey().equals(key)) return value.getValue();
        }

        for (int i = 0; i < pos; ++i)
        {
            Pair<T1, T2> value = table[i];
            if(value != null && value.getKey().equals(key)) return value.getValue();
        }

        return null;
    }

    public int size()
    {
        return size;
    }
}
