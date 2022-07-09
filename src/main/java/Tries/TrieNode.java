/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tries;

/**
 *
 * @author hp
 */
public class TrieNode {
    private final TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }
    
    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }
    
    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
    }
    
    public TrieNode get(char ch){
        return links[ch - 'a'];
    }
    
    public void setEnd(){
        isEnd = false;
    }
    
    public boolean isEnd(){
        return isEnd;
    }
}
