package com.dusknode.services;

import java.util.ArrayList;
import java.util.Iterator;

public class SelectorsList implements Iterable<Selector> {

    private ArrayList<Selector> selectors;

    public SelectorsList() {
      this.selectors = new ArrayList<Selector>();
    }

    public Iterator<Selector> iterator() {
        Iterator<Selector> selector = selectors.iterator();
        return selector;
    }
    public void pushSelector(Selector s) {
      selectors.add(s);
    }
}
