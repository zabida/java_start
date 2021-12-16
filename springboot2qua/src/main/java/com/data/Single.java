package com.data;

import lombok.Data;

import java.util.ArrayList;

@Data
class Node {
    private Integer value;
    private Integer last_index;
    private Integer next_index;
}


public class Single {
    private ArrayList<Node> nodes;
    public void add(Node node) {

    }

    public void pop(){

    }
}
