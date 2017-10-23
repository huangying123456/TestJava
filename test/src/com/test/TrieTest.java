package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ListenYoung on 2017/4/7.
 */

class Node{
    public char content;
    public List<Node> children;
    public boolean isWord;
    public Long id;

    public Node(){
        this.content = '\0';
        this.isWord = false;
    }
}

class TrieTree{
    public Node root;

    public void insert(String name, Long id, Node node){

        if(name.length() < 1){
            return;
        }

        char first = name.charAt(0);
        if(node.children == null || node.children.size() < 1){
            node.children = new ArrayList<>();
            Node n = new Node();
            if(name.length() == 1){
                n.isWord = true;
                n.id = id;
            }
            n.content = first;
            node.children.add(n);
            insert(name.substring(1, name.length()), id, n);
        }else{
            if(name.length() > 1){
                for(Node n : node.children){
                    if(n.content == first){
                        insert(name.substring(1, name.length()), id, n);
                        return;
                    }
                }

                Node newNode = new Node();
                newNode.content = first;
                node.children.add(newNode);
                insert(name.substring(1, name.length()), id, newNode);
                return;
            }else{
                for(Node n : node.children){
                    if(n.content == first){
                        insert(name.substring(1, name.length()), id, n);
                        return;
                    }
                }

                Node newNode = new Node();
                newNode.content = first;
                newNode.isWord = true;
                newNode.id = id;
                node.children.add(newNode);
                insert(name.substring(1, name.length()), id, newNode);
                return;
            }
        }
    }

    public boolean find(String matcher, Node node){
        boolean result = false;

        char first = matcher.charAt(0);
        if(node.children == null || node.children.size() < 1){
            return result;
        }


        for(Node n : node.children){
            if(n.content == first){
                if(matcher.length() == 1){
                    if(n.isWord){
                        result = true;
                    }else{
                        result = false;
                    }
                }else{
                    result = find(matcher.substring(1, matcher.length()), n);
                }
                break;
            }
        }

        return  result;
    }

    public void getSelections(List<Data> list, String prefix, Node node, boolean flag){
        if(node.children == null || node.children.size() < 1){
            return;
        }
        if(flag){
            String temp = prefix;
            while (temp.length() > 0){
                if(node.children == null || node.children.size() < 1){
                    return;
                }else{
                    char first = temp.charAt(0);
                    boolean matcher = false;
                    for(Node n : node.children){
                        if(n.content == first){
                            temp = temp.substring(1, temp.length());
                            node = n;
                            matcher = true;
                            break;
                        }
                    }
                    if(matcher){
                        matcher = false;
                        continue;
                    }else{
                        return;
                    }
                }
            }
        }

        for(Node n : node.children){
            if(n.isWord){
                list.add(new Data(n.id, prefix + n.content));
                if(n.children != null && n.children.size() > 0){
                    getSelections(list, prefix + n.content, n, false);
                }
            }else{
                getSelections(list, prefix + n.content, n, false);
            }
        }
    }
}

public class TrieTest {
    public static void main(String[] args){
        TrieTree trieTree = new TrieTree();
        trieTree.root = new Node();
        trieTree.root.content = '\0';

        List<Data> dataList = new ArrayList<>();
        dataList.add(new Data(1L, "我在"));
        dataList.add(new Data(2L, "我们代价"));
        dataList.add(new Data(3L, "我是人"));
        dataList.add(new Data(4L, "你是我"));
        dataList.add(new Data(5L, "我不会"));
        dataList.add(new Data(6L, "我是谁"));
        dataList.add(new Data(7L, "我和你"));

        for(int i = 0 ; i < 19999 ; i ++){
            dataList.add(new Data(i+20L, "他是" + new String(new Integer(i).toString())));
        }

        for(Data d : dataList){
            trieTree.insert(d.name, d.id, trieTree.root);
        }

        System.out.println(trieTree.find("他是0", trieTree.root));

        List<Data> list = new ArrayList<>();
        trieTree.getSelections(list, "他是155", trieTree.root, true);
        for(Data d : list){
            System.out.println(d.name);
        }
        System.out.print(list.size());
    }
}
