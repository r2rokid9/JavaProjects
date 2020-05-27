/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatetris;

import java.util.Random;

/**
 *
 * @author Art
 */
public class Shape {

    protected enum Tetrominoe { NoShape, ZShape, SShape, LineShape,
        TShape, SquareShape, LShape, MirroredLShape }

    private Tetrominoe pieceShape;
    private int coords[][];
    private int[][][] coordsTable;
    private int shapeType;

    public Shape() {

        initShape();
    }

    private void initShape() {

        coords = new int[4][2];

        coordsTable = new int[][][] {
                { { 0, 0 },   { 0, 0 },   { 0, 0 },   { 0, 0 } },
                { { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } },
                { { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } },
                { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2 } },
                { { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } },
                { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } },
                { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } },
                { { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } }
        };

        setShape(Tetrominoe.NoShape);
    }

    public int getType()
    {
        return this.shapeType;
    }
    
    protected void setShape(Tetrominoe shape) {

        for (int i = 0; i < 4 ; i++) {

            for (int j = 0; j < 2; ++j) {

                coords[i][j] = coordsTable[shape.ordinal()][i][j];
            }
        }

        pieceShape = shape;
    }

    private void setX(int index, int x) { coords[index][0] = x; }
    private void setY(int index, int y) { coords[index][1] = y; }
    public int x(int index) { return coords[index][0]; }
    public int y(int index) { return coords[index][1]; }
    public int reversey(int index)
    {
        return coords[3-index][1];
    }
    public Tetrominoe getShape()  { return pieceShape; }

    public void setRandomShape() {

        var r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;

        Tetrominoe[] values = Tetrominoe.values();
        shapeType = x;
        setShape(values[x]);
    }

    public int minX() {

        int m = coords[0][0];

        for (int i=0; i < 4; i++) {

            m = Math.min(m, coords[i][0]);
        }

        return m;
    }


    public int minY() {

        int m = coords[0][1];

        for (int i=0; i < 4; i++) {

            m = Math.min(m, coords[i][1]);
        }

        return m;
    }

    public Shape rotateLeft() {

        if (pieceShape == Tetrominoe.SquareShape) {

            return this;
        }

        var result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {

            result.setX(i, y(i));
            result.setY(i, -x(i));
        }

        return result;
    }

    public Shape rotateRight() {

        if (pieceShape == Tetrominoe.SquareShape) {

            return this;
        }

        var result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; ++i) {

            result.setX(i, -y(i));
            result.setY(i, x(i));
        }

        return result;
    }
}
