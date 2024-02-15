class Solution {
    public String simplifyPath(String path) {
        String[] elements = path.split("/");
        List<String> dirs = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        
        for(String elem: elements) {
            if(elem.isEmpty())
                continue;
            if(elem.equals("."))
                continue;
            if(elem.equals("..")) {
                if(dirs.size() > 0) {
                    dirs.remove(dirs.size()-1);
                }
            } else {
                dirs.add(elem);
            }
        }
        
        for(String dir: dirs) {
            res.append("/");
            res.append(dir);
        }
        
        return dirs.size() > 0 ? res.toString() : "/";
    }
}