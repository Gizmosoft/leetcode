class RandomizedSet {
    Set<Integer> set;

    public RandomizedSet() {
        this.set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(!this.set.contains(val)) {
            this.set.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(this.set.contains(val)) {
            this.set.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        Random random = new Random();
        int random_num = random.nextInt(this.set.size());
        return (int)this.set.toArray()[random_num];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */