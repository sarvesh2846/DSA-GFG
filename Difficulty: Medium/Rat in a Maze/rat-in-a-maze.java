class Solution {
	
	public static void findPath(int[][] maze, int r, int c, int n, String path, ArrayList<String> ans) {
		// base cases
		
		//maze boundaries & blocked & already visited
		if(r<0 || c<0 || r>=n || c >=n || maze[r][c] == 0 ||  maze[r][c] == -1){
		    return;
		}
		
		// Path finded and add it
		if(r==n-1 && c==n-1){
		    ans.add(path);
		    return;
		}
		
		// kaam
		
		maze[r][c] = -1; // visited
	    
	    // Left, Right, Up, Down Directions...
        //findPath(maze, r, c-1, n, path + "L", ans);
        //findPath(maze, r, c+1, n, path + "R", ans);
        //findPath(maze, r-1, c, n, path + "U", ans);
        //findPath(maze, r+1, c, n, path + "D", ans);
		
		// Lexicographical order: D < L < R < U
          findPath(maze, r + 1, c, n, path + "D", ans);
          findPath(maze, r, c - 1, n, path + "L", ans);
          findPath(maze, r, c + 1, n, path + "R", ans);
          findPath(maze, r - 1, c, n, path + "U", ans);
		
		//Backtrack
		maze[r][c] = 1; // unvisited
		
	}
	
	public ArrayList<String> ratInMaze(int[][] maze) {
		ArrayList<String> ans = new ArrayList<>();
		findPath(maze, 0, 0, maze.length, "", ans);
		return ans;
		
	}
}
