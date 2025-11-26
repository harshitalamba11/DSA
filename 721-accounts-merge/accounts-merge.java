class Solution {
    public int find(int x,int[] parent){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x],parent);
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> map=new HashMap<>();
        int n=accounts.size();
        int[] parent=new int[n];
        for(int i=0;i<n;i++) parent[i]=i;
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail,i);
                }
                else{
                    int p1=find(map.get(mail),parent);
                    int p2=find(i,parent);
                    parent[p2]=p1;
                }
            }
        }

        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<n;i++) res.add(new ArrayList<>());
        for(Map.Entry<String,Integer> m:map.entrySet()){
            int root=find(m.getValue(),parent);
            res.get(root).add(m.getKey());
        }
        // setting name"John<....>" and sorting it in main result
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(res.get(i).size()>0){
            List<String> list=res.get(i);
            Collections.sort(list);
            list.add(0,accounts.get(i).get(0));
            ans.add(res.get(i));
            }
        }
        return ans;
    }
}