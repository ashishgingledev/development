package com.ingleash.misc.tree;

import com.ingleash.misc.utils.CurrentNode;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


/*
X X X X X }{ X
O O X O O O X
X X X X X O X
X O O O X O X
X O X O O O X
{} O X X O X O
X X O X X O X

 */

/*
X }{ O
X  X  O
{} O  O

 */
class Maze {
    String[] traverseMaze(int size, String[][]
            maze) {
        List<CurrentNode> currentNodes = new ArrayList<>();

        for (int i=0; i<size ; i++) {
            for (int j=0; j<size ; j++) {
                CurrentNode currentNode = new CurrentNode(false, CurrentNode.NodeType.getNodeTypeByStr(maze[i][j]), i, j);
                //Set LEFT, RIGHT, UP, DOWN
                AtomicInteger atomicIntegerI = new AtomicInteger(i);
                AtomicInteger atomicIntegerJ = new AtomicInteger(j);

                currentNode.setRight(currentNodes.stream().filter(cn -> cn.getI() == atomicIntegerI.get() && cn.getJ() == atomicIntegerI.get() +1).findAny());
                currentNode.setLeft(currentNodes.stream().filter(cn -> cn.getI() == atomicIntegerI.get() && cn.getJ() == atomicIntegerI.get()-1).findAny());
                currentNode.setUp(currentNodes.stream().filter(cn -> cn.getI() == atomicIntegerI.get()-1 && cn.getJ() == atomicIntegerI.get()).findAny());
                currentNode.setDown(currentNodes.stream().filter(cn -> cn.getI() == atomicIntegerI.get()+1 && cn.getJ() == atomicIntegerI.get()).findAny());
                currentNodes.add(currentNode);
            }
        }

        CurrentNode startNode = currentNodes.stream().filter(cn -> cn.getNodetype().equals(CurrentNode.NodeType.START)).findAny().get();
        System.out.println(startNode);
        CurrentNode endNode = currentNodes.stream().filter(cn -> cn.getNodetype().equals(CurrentNode.NodeType.END)).findAny().get();
        System.out.println(endNode);




        return null;
    }


}

public class TraverseInAMaze {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i, len, size;
        String input_str;

        size = 3; //Integer.parseInt(br.readLine().trim());        //for the size of the Maze


        // String maze[][] = new String[3][3];
        String maze[][] = {
                {"X", "}{", "O"},
                {"X", "X", "O"},
                {"{}", "O", "O"}
        };
       /* for (i = 0; i < size; i++) {
            input_str = br.readLine();
            maze[i] = input_str.split(" ");         //storing elements in maze = }{ , {} , X and O
        }
*/


        Maze m1 = new Maze();
        String[] answer = m1.traverseMaze(size, maze);

        if (answer[0].equals("0")) {
            System.out.println("The end of the maze could not be reached. ");
        } else {
            len = answer[1].length();
            System.out.println(answer[0] + " steps are needed to reach the end of the maze. ");
            for (i = 0; i < len; i++) {
                if (i == 0)
                    System.out.println("The path traversed through the Maze.is: " + answer[1].charAt(i));

                else if ((i == 1) || (i == len - 1))                    //no need space between entry & exit position - the }{ & {}
                    System.out.println(answer[1].charAt(i));
                else
                    System.out.println(" " + answer[1].charAt(i));
            }
        }
    }
}