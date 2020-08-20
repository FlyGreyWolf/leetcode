package leetcode;

/**
 * 让我们一起来玩扫雷游戏！

给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。

现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：

如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
如果在此次点击中，若无更多方块可被揭露，则返回面板。
 

示例 1：

输入: 

[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

Click : [3,0]

输出: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]
 
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minesweeper
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * @author FlyGreyWolf
 * @since 2020-08-20
 *
 */
public class _529_扫雷游戏 {
	
	public static void main(String[] args) {
		char[][] board = 
				{{'E', 'E', 'E', 'E', 'E'},
				{'E', 'E', 'M', 'E', 'E'},
				{'E', 'E', 'E', 'E', 'E'},
				{'E', 'E', 'E', 'E', 'E'}}; 
		int[] click = {3, 0};
		
		board = updateBoard(board, click);
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

    public static char[][] updateBoard(char[][] board, int[] click) {
    	
    	int x = click[0];
    	int y = click[1];
    	
    	
    	
    	if(board[x][y] == 'M') {
    		board[x][y] = 'X';
    	}
    	
    	if(board[x][y] == 'E') {
    		dfs(board, x, y);
    	} 
    	return board;
    }
    
    public static void dfs(char[][] board, int x, int y) {
    	
    	int row = board.length;
    	int col = board[0].length;
    	
    	int leiCnt = 0;
    	
    	if(x-1 >= 0) { // 上
    		if(board[x-1][y] == 'M') {
    			leiCnt ++;
    		}
    	}
    	
    	if(x+1 < row) { // 下
    		if(board[x+1][y] == 'M') {
    			leiCnt ++;
    		}
    	}
    	
    	if(y-1 >= 0) { // 左
    		if(board[x][y-1] == 'M') {
    			leiCnt ++;
    		}
    	}
    	
    	if(y+1 < col) { // 右
    		if(board[x][y+1] == 'M') {
    			leiCnt ++;
    		}
    	}
    	
    	if(x-1 >= 0 && y-1 >= 0) { // 左上
    		if(board[x-1][y-1] == 'M') {
    			leiCnt ++;
    		}
    	}
    	
    	if(x-1 >= 0 && y+1 < col) { // 右上
    		if(board[x-1][y+1] == 'M') {
    			leiCnt ++;
    		}
    	}
    	
    	if(x+1 < row && y-1 >= 0) { // 左下
    		if(board[x+1][y-1] == 'M') {
    			leiCnt ++;
    		}
    	}
    	
    	if(x+1 < row && y+1 < col) { // 右下
    		if(board[x+1][y+1] == 'M') {
    			leiCnt ++;
    		}
    	}
    	
    	if(leiCnt > 0) {
    		board[x][y] = (char)('0' + leiCnt);
    		return;
    	}
    	
    	board[x][y] = 'B';
    	if(x-1 >= 0 && board[x-1][y] == 'E') { // 上
    		dfs(board, x-1, y); 
    	}
    	
    	if(x+1 < row && board[x+1][y] == 'E') { // 下
    		dfs(board, x+1, y); 
    	}
    	
    	if(y-1 >= 0 && board[x][y-1] == 'E') { // 左
    		dfs(board, x, y-1); 
    	}
    	
    	if(y+1 < col && board[x][y+1] == 'E') { // 右
    		dfs(board, x, y+1);  
    	} 
    	
    	if(x-1 >= 0 && y-1 >= 0 && board[x-1][y-1] == 'E') { // 左上
    		dfs(board, x-1, y-1); 
    	}
    	
    	if(x-1 >= 0 && y+1 < col && board[x-1][y+1] == 'E') { // 右上
    		dfs(board, x-1, y+1); 
    	}
    	
    	if(x+1 < row && y-1 >= 0 && board[x+1][y-1] == 'E') { // 左下
    		dfs(board, x+1, y-1); 
    	}
    	
    	if(x+1 < row && y+1 < col && board[x+1][y+1] == 'E') { // 右下
    		dfs(board, x+1, y+1); 
    	}
    }
}
















