package com.company;


/*
*You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.





Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
* */
public class ECheckStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {

        if(coordinates.length == 2) {
            return true;
        }

        int diff1 = coordinates[0][0] - coordinates[1][0];
        int diff2 = coordinates[0][1] - coordinates[1][1];
        float slope = (float)diff2/diff1;

        for(int i=2;i<coordinates.length;i++) {
            int diffX = coordinates[0][0] - coordinates[i][0];
            int diffY = coordinates[0][1] - coordinates[i][1];
            float newSlope = (float)diffY/diffX;
            if(newSlope != slope) {
                return false;
            }
        }
        return true;

    }
}
