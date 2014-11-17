package feelbetter.uba.eladgel.com.myapplication;

import android.graphics.Point;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by eladgelman on 11/15/14.
 */
public class BoardReper {
    HashSet<Point> liveCells;

    public BoardReper() {
        liveCells = new HashSet<Point>();
    }

    public void add(Point point) {
        liveCells.add(point);
    }

    public BoardReper getNextState() {
        BoardReper newBoard = new BoardReper();
        HashMap<Point, Integer> deadCells = new HashMap<Point, Integer>();
        for (Point point : liveCells) {
            int liveNeigbors = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; i < 2; i++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    Point tempPoint = new Point(point.x + i, point.y + j);
                    if (!liveCells.contains(tempPoint)) {
                        if (!deadCells.containsKey(tempPoint)) {
                            deadCells.put(tempPoint, 0);
                        }
                        deadCells.put(tempPoint, deadCells.get(tempPoint) + 1);
                    } else {
                        liveNeigbors += 1;
                    }

                }
            }
            if (liveNeigbors == 2 || liveNeigbors == 3) {
                newBoard.add(point);
            }
        }

        for (Point point : deadCells.keySet()) {
            if (deadCells.get(point).equals(3)) {
                newBoard.add(point);
            }
        }

        return newBoard;
    }

}
