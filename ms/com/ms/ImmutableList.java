package com.ms;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableList {
    private final List<String> instance;

    public ImmutableList(List<String> _instance) {
           instance = new ArrayList<>();
            _instance.stream().forEach(e ->instance.add(e));
    }

    public List<String> getInstance() {
        return (List<String>) ((ArrayList<String>) instance).clone();
    }
}
