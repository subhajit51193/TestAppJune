package com.assignment;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		
		
		char[][] arr = {{'O','T','O','O'},{'O','T','O','T'},{'T','T','O','T'},{'O','T','O','T'}};
		
		//main function
		int res = numIslands(arr);
		System.out.println(res);
	}
	public static int numIslands(char[][] arr) {
		//edge cases
		if (arr.length == 0) {
			return 0;
		}
		int count = 0;
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				if (arr[i][j] == 'T') {
					count++;
					dfs(arr,i,j);
				}
			}
		}
		return count;
	}
	public static void dfs(char[][] arr,int i, int j) {
		
		//edge cases
		if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length){
            return;
        }
		
        if (arr[i][j] == 'O'){
            return;
        }
        //marking all visited or founded col as 'O'
        arr[i][j] ='O';
        
        //making calls to all 4 directions to find connected cols
        dfs(arr,i+1,j);
        dfs(arr,i-1,j);
        dfs(arr,i,j+1);
        dfs(arr,i,j-1);
    }
	
}
