class Solution {

    List<String> res = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, List<String>> adj = new HashMap<>();
        String startingPoint = "JFK";

        for(List<String> ticket: tickets){
            adj.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
        }

        for(Map.Entry<String, List<String>> entry: adj.entrySet()){
            Collections.sort(entry.getValue());
        }

        dfs(adj,startingPoint);

        Collections.reverse(res);
        return res;
    }

    public void dfs(Map<String, List<String>> adj,String currentNode){

        

        if(adj.containsKey(currentNode)){
            while(!adj.get(currentNode).isEmpty()){
                String nextNode = adj.get(currentNode).remove(0);
                dfs(adj,nextNode);
            } 
        }
        res.add(currentNode);
        
    }
    
}