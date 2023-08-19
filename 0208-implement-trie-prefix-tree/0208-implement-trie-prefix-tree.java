class Node
{
    Node links[] = new Node[26];
    boolean flag = false;
    
    boolean containsKey(char ch)
    {
        return links[ch - 'a'] != null;
    }
    
    void put(char ch, Node newNode)
    {
        links[ch - 'a'] = newNode;
    }
    
    Node get(char ch)
    {
        return links[ch - 'a'];
    }
    
    void setEnd()
    {
        flag = true;
    }
    
    boolean isEnd()
    {
        return flag;
    }
}

class Trie {

    Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            if(!curr.containsKey(ch))
            {
                curr.put(ch, new Node());
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            if(!curr.containsKey(ch))
                return false;
            curr = curr.get(ch);
        }
        return curr.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++)
        {
            char ch = prefix.charAt(i);
            if(!curr.containsKey(ch))
                return false;
            curr = curr.get(ch);
        }
        return true;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */