package ru.n1ppl3.amazon.items.checker.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public abstract class MyCollectionUtils {

    public static <I, O> List<O> transformToList(Collection<I> col, Function<I, O> transformer) {
        List<O> result = new ArrayList<>(col.size());
        for (I el : col) {
            result.add(transformer.apply(el));
        }
        return result;
    }

    public static <I, O> Set<O> transformToSet(Collection<I> col, Function<I, O> transformer) {
        Set<O> result = new HashSet<>((int) (col.size() * 1.5));
        for (I el : col) {
            result.add(transformer.apply(el));
        }
        return result;
    }
}
