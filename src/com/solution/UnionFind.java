package com.solution;

import java.util.*;

public class UnionFind {
    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element<?> element = (Element<?>) o;
            return Objects.equals(value, element.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    public static class UnionFindSet<V> {
        public Map<V, Element<V>> elementMap;
        public Map<Element<V>, Element<V>> fartherMap;

        public Map<Element<V>, Integer> sizeMap;

        public UnionFindSet(List<V> list) {
            this.elementMap = new HashMap<>();
            this.fartherMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
            for (V v : list) {
                Element<V> element = new Element<>(v);
                elementMap.put(v, element);
                fartherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        public boolean isSame(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while (element != fartherMap.get(element)) {
                path.push(element);
                element = fartherMap.get(element);
            }
            while (!path.isEmpty()) {
                fartherMap.put(path.pop(), element);
            }
            return element;
        }

        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aHead = findHead(elementMap.get(a));
                Element<V> bHead = findHead(elementMap.get(b));
                if (aHead != bHead) {
                    Element<V> big = sizeMap.get(aHead) > sizeMap.get(bHead) ? aHead : bHead;
                    Element<V> small = big == aHead ? bHead : aHead;
                    fartherMap.put(small, big);
                    sizeMap.put(big, sizeMap.get(aHead) + sizeMap.get(bHead));
                    sizeMap.remove(bHead);
                }
            }
        }
    }

}
