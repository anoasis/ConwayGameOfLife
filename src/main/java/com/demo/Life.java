package com.demo;

public class Life {
    private static boolean[][] currentGen;
    private static boolean[][] nextGen;
    private static int WIDTH = 0;
    private static int HEIGHT = 0;

    public Life(int width, int height){
        WIDTH = width;
        HEIGHT = height;
        currentGen = new boolean[WIDTH][HEIGHT];
        nextGen = new boolean[WIDTH][HEIGHT];
    }

    public int countAliveNeighbors(int x, int y){
        int count = 0;
        for(int i=x-1;i<=x+1;i++){
            for(int j=y-1;j<=y+1;j++) {
                if(withinBoundary(i,j) && !(i==x&&j==y) && isAlive(i,j)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean withinBoundary(int x, int y) {
        if((x>=0&&y>=0) && (x<WIDTH && y<HEIGHT)) return true;
        else return false;
    }

    public boolean isAlive(int x, int y) {
        return currentGen[x][y];
    }

    public void setAlive(int x, int y) {
        currentGen[x][y]=true;
    }

    public void setDead(int x, int y) {
        currentGen[x][y]=false;
    }

    public void aliveInNextLife(int x, int y) {
        nextGen[x][y]=true;
    }

    public void deadInNextLife(int x, int y) {
        nextGen[x][y]=false;
    }

    public void display(){
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if(isAlive(x,y))
                    System.out.print("0");
                else
                    System.out.print(".");
            }
            System.out.println();
        }
    }

    public void tick(){
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                int aliveNeighbors = countAliveNeighbors(x,y);
                if(isAlive(x,y)){
                    if(aliveNeighbors==2 || aliveNeighbors==3) aliveInNextLife(x,y);
                    else if(aliveNeighbors<2 && aliveNeighbors>3) deadInNextLife(x,y);
                }
                else if(aliveNeighbors==3) aliveInNextLife(x,y);
            }
        }
        currentGen = nextGen;
    }
}
