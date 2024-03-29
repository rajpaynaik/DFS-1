//time complexity O(NM) and space complexity O(NM)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    queue.add(new int[]{i,j});
                }
                if(mat[i][j]==1){
                    mat[i][j]=-1;
                }
            }
        }

        int level=1;
        while(!queue.isEmpty()){

            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] cell = queue.poll();

                for(int[] dir:dirs){
                    int nr = dir[0]+cell[0];
                    int nc = dir[1]+ cell[1];

                    if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc]==-1){
                            queue.add(new int[]{nr,nc});
                            mat[nr][nc] = level; 
                    }
                }
            }
            level++;
        }

        return mat;
        
    }
}

//Time complexity O(N) and space complexity O(N)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;    
        Queue<int[]> queue = new LinkedList<>();

        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};


        int orgColor = image[sr][sc];

        if(color==orgColor) return image;
        image[sr][sc]=color;
        queue.add(new int[]{sr,sc});

        

        while(!queue.isEmpty()){
            int[] currColor = queue.poll();

            for(int[] dir:dirs){
                int nr= dir[0] + currColor[0];
                int nc = dir[1] + currColor[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    if(image[nr][nc]==orgColor){
                        image[nr][nc]=color;
                        queue.add(new int[]{nr,nc});
                    }
                }
                
            }
        }

        return image;
        
    }
}
