package entity;

/**
 * @author hwang
 * @data 2023/7/21
 * @description
 */
public class TrieNode {
    public int pass;
    public int end;
    public TrieNode[] nexts;

    public TrieNode(){
        pass = 0;
        end = 0;
        nexts = new TrieNode[26];
    }
}
