class RandomizedCollection {
    Map<Integer, Set<Integer>> dict;
    List<Integer> list;
    //Random rand = new Random();
    java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        dict = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!dict.containsKey(val)) dict.put(val, new LinkedHashSet<Integer>());
        dict.get(val).add(list.size());
        list.add(val);
        return dict.get(val).size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!dict.containsKey(val)) return false;
        
        int removeIndex = dict.get(val).iterator().next();
        dict.get(val).remove(removeIndex);
        
        int lastElement = list.get(list.size() - 1);
        list.set(removeIndex, lastElement);
        dict.get(lastElement).add(removeIndex);
        dict.get(lastElement).remove(list.size() - 1);
        
        list.remove(list.size() - 1);
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
