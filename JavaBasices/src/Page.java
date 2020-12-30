package src;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Page implements Comparable<Page> {
    String name;
    int order;
    Page parent;
    String key;

    Page() {
        name = "root";
        order  = 0;
        parent = null;
        key    = "";
    }

    Page(String name, int order, Page parent) {
        this.name   = name;
        this.order  = order;
        this.parent = parent;
        key = parent.key + (char)order;
    }

    @Override
    public int compareTo(Page o) {
        return key.compareTo(o.key);
    }

    @Override
    public String toString() {
        return name;
    }


public static void main(String[] args) {
    Page root = new Page();

    Page b    = new Page("b"  , 2, root);
    Page b1   = new Page("b.1", 1, b);
    Page b3   = new Page("b.3", 3, b);
    Page b2   = new Page("b.2", 2, b);

    Page a    = new Page("a"  , 1, root);
    Page a2   = new Page("a.2", 2, a);
    Page a1   = new Page("a.1", 1, a);

    List<Page> pages = Arrays.asList(root, a, a1, a2, b, b1, b2, b3);
    System.out.println(pages);

    Collections.shuffle(pages);
    System.out.println(pages);

    Collections.sort(pages);
    System.out.println(pages);
}
}
