
package maze3;
import java.util.LinkedList;
import java.util.*;


 
public class Maze3 {
 
    private static class Cell implements Comparable<Cell> {
        int x;
        int y;
        int dist;
        Cell prev;
 
        Cell(int x, int y, int dist, Cell prev) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.prev = prev;
        }
 
        @Override
        public int compareTo(Cell o) {
            return dist - o.dist;
        }
        
        @Override
        public String toString(){
        	return "("+x+ ","+y+")";
        }
    }
    //Time O(n^2), Space O(n^2)
        public static void print(int[][] matrix, int[] start, int[] end) {
//	   if (matrix[start[0]][start[1]] == 0 || matrix[end[0]][end[1]] ==0){}
		   
	   
        Cell[][] cells = new Cell[matrix.length][matrix[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (matrix[i][j] != 0) {
                    cells[i][j] = new Cell(i, j, Integer.MAX_VALUE, null);
                }
            }
        }
 
        LinkedList<Cell> queue = new LinkedList<>();
        Cell src = cells[start[0]][start[1]];
        src.dist = 0;
        queue.add(src);
        Cell dest = null;
        Cell curr;
        while ((curr = queue.poll()) != null) {
            if (curr.x==end[0] && curr.y == end[1]) {
                dest = curr;
            }
            visit(cells, queue, curr.x - 1, curr.y, curr);
            visit(cells, queue, curr.x + 1, curr.y, curr);
            visit(cells, queue, curr.x, curr.y - 1, curr);
            visit(cells, queue, curr.x, curr.y + 1, curr);
        }
 
        if (dest != null) {
            
          
            LinkedList<Cell> path = new LinkedList<>();
            curr = dest;
            do {
                path.addFirst(curr);
            } while ((curr = curr.prev) != null);
            System.out.println(path);
            
        }
    }
 
    static void visit(Cell[][] cells, LinkedList<Cell> queue, int x, int y, Cell parent) {
        int dist = parent.dist + 1;
        if (x < 0 || x >= cells.length || y < 0 || y >= cells[0].length || cells[x][y] == null) {
            return;
        }
        Cell curr = cells[x][y];
        if (dist < curr.dist) {
            curr.dist = dist;
            curr.prev = parent;
            queue.add(curr);
        }
    }
    static int a,b,x,y;

	public static void main(String[] args) { 
	   int[][] matrix = new int[][] {
           {2, 1, 1, 1, 1, 1},
           {1, 1, 1, 1, 0, 1},
           {1, 0, 0, 0, 1, 1},
           {1, 1, 1, 1, 1, 1},
           {0, 0, 0, 0, 1, 0},
           {0, 0, 0, 0, 9, 0}
	   };
           
           
           int[][] maze = new int[][] {
           {1, 1, 1, 1, 1, 1},
           {1, 1, 1, 1, 0, 1},
           {1, 0, 0, 0, 1, 1},
           {1, 1, 1, 1, 1, 1},
           {0, 0, 0, 0, 0, 0}
	   };
           
        for (int i = 0; i < matrix.length; i++) { 
            for (int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j]== 2){
                    a = i;
                    b = j;
                }
                 if(matrix[i][j]== 9){
                    x = i;
                    y = j;
                }

            }
        } 
           
           
           int[] start = {a,b};
	   int[] end = {x,y};
           System.out.println("the path is :");
	   print(matrix, start, end);	
          
           System.out.println();
           
           
           
           int s1,s2,d1,d2;
           Scanner in = new Scanner(System.in);
           System.out.println("enter the source");
           s1=in.nextInt();
           s2=in.nextInt();
           System.out.println("enter the distination");
           d1=in.nextInt();
           d2=in.nextInt();
           
           int[] source = {s1,s2};
	   int[] distination = {d1,d2};
           System.out.println("the path is :");
	   print(maze, source, distination);	
           
	}
}


//                    (0,0)(0,1)(0,2)(0,3)(0,4)(0,5)(1,5)(2,5)(3,5)(3,4)(4,4)(4,5)


        
        
//        [0,1]
//        [2,4]
        
        
        
//        
//        there are two paths 
//                [(0,1)(0,2)(0,3)(0,4)(0,5)(1,5)(2,5)(2,4)]      8 steps
//        
//                [(0,1)(0,0)(1,0)(2,0)(3,0)(3,1)(3,2)(3,3)(3,4)(2,4)]     10 steps
//        
                
        
        
        
