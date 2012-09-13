package engine.common;

import org.newdawn.fizzy.Body;
import org.newdawn.fizzy.Circle;
import org.newdawn.fizzy.CompoundShape;
import org.newdawn.fizzy.Polygon;
import org.newdawn.fizzy.Rectangle;
import org.newdawn.fizzy.Shape;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Render {

    public static void drawBody(Graphics g, Body body) {
        Shape shape = body.getShape();
        drawShape(g, body, shape);
    }

    private static void drawShape(Graphics g, Body body, Shape shape) {
        if (shape instanceof Rectangle) {
            drawRectangle(g, body, (Rectangle) shape);
        }
        if (shape instanceof Circle) {
            drawCircle(g, body, (Circle) shape);
        }
        if (shape instanceof Polygon) {
            drawPolygon(g, body, (Polygon) shape);
        }
        if (shape instanceof CompoundShape) {
            drawCompound(g, body, (CompoundShape) shape);
        }
    }

    private static void drawCompound(Graphics g, Body body, CompoundShape shape) {
        int count = shape.getShapeCount();
        for (int i = 0; i < count; i++) {
            drawShape(g, body, shape.getShape(i));
        }
    }

    private static void drawRectangle(Graphics g, Body body, Rectangle shape) {
        g.pushTransform();
        g.translate(body.getX(), body.getY());
        g.rotate(0, 0, (float) Math.toDegrees(body.getRotation()));
        g.translate(shape.getXOffset(), shape.getYOffset());
        g.rotate(0, 0, (float) Math.toDegrees(shape.getAngleOffset()));

        float width = shape.getWidth();
        float height = shape.getHeight();

        g.drawRect(0, 0, width, height);

        g.popTransform();
    }

    private static void drawCircle(Graphics g, Body body, Circle shape) {
        g.pushTransform();
        g.translate(body.getX(), body.getY());
        g.rotate(0, 0, (float) Math.toDegrees(body.getRotation()));

        float radius = shape.getRadius();

        g.drawOval(-(radius), -(radius), radius * 2, radius * 2);

        g.popTransform();
    }

    private static void drawPolygon(Graphics g, Body body, Polygon shape) {
        g.pushTransform();
        g.translate(body.getX(), body.getY());
        g.rotate(0, 0, (float) Math.toDegrees(body.getRotation()));

        for (int i = 0; i < shape.getPointCount(); i++) {
            int n = i + 1;
            if (n >= shape.getPointCount()) {
                n = 0;
            }
            g.drawLine((int) shape.getPointX(i), (int) shape.getPointY(i),
                    (int) shape.getPointX(n), (int) shape.getPointY(n));
        }

        g.popTransform();
    }

    public static void drawBodyImage(Graphics g, Body body, Image image) {
        Shape shape = body.getShape();
        drawShapeImage(g, body, shape, image);
    }

    private static void drawShapeImage(Graphics g, Body body, Shape shape, Image image) {
        if (shape instanceof Rectangle) {
            drawRectangleImage(g, body, (Rectangle) shape, image);
        }
        if (shape instanceof Circle) {
            drawCircleImage(g, body, (Circle) shape, image);
        }
        if (shape instanceof CompoundShape) {
            drawCompoundImage(g, body, (CompoundShape) shape, image);
        }
    }

    private static void drawCompoundImage(Graphics g, Body body, CompoundShape shape, Image image) {
        int count = shape.getShapeCount();
        for (int i = 0; i < count; i++) {
            drawShapeImage(g, body, shape.getShape(i), image);
        }
    }

    private static void drawRectangleImage(Graphics g, Body body, Rectangle shape, Image image) {
        g.pushTransform();
        g.translate(body.getX(), body.getY());
        g.rotate(0, 0, (float) Math.toDegrees(body.getRotation()));
        g.translate(shape.getXOffset(), shape.getYOffset());
        g.rotate(0, 0, (float) Math.toDegrees(shape.getAngleOffset()));

        g.drawImage(image, 0, 0);

        g.popTransform();
    }

    private static void drawCircleImage(Graphics g, Body body, Circle shape, Image image) {
        g.pushTransform();
        g.translate(body.getX(), body.getY());
        g.rotate(0, 0, (float) Math.toDegrees(body.getRotation()));

        float radius = shape.getRadius();

        g.drawImage(image, -radius, -radius);

        g.popTransform();
    }

    public static void drawBodyAnimation(Graphics g, Body body, Animation animation) {
        Shape shape = body.getShape();
        drawShapeAnimation(g, body, shape, animation);
    }

    private static void drawShapeAnimation(Graphics g, Body body, Shape shape, Animation animation) {
        if (shape instanceof Rectangle) {
            drawRectangleAnimation(g, body, (Rectangle) shape, animation);
        }
        if (shape instanceof Circle) {
            drawCircleAnimation(g, body, (Circle) shape, animation);
        }
        if (shape instanceof CompoundShape) {
            drawCompoundAnimation(g, body, (CompoundShape) shape, animation);
        }
    }

    private static void drawCompoundAnimation(Graphics g, Body body, CompoundShape shape, Animation animation) {
        int count = shape.getShapeCount();
        for (int i = 0; i < count; i++) {
            drawShapeAnimation(g, body, shape.getShape(i), animation);
        }
    }

    private static void drawRectangleAnimation(Graphics g, Body body, Rectangle shape, Animation animation) {
        g.pushTransform();
        g.translate(body.getX(), body.getY());
        g.rotate(0, 0, (float) Math.toDegrees(body.getRotation()));
        g.translate(shape.getXOffset(), shape.getYOffset());
        g.rotate(0, 0, (float) Math.toDegrees(shape.getAngleOffset()));

        g.drawAnimation(animation, 0, 0);

        g.popTransform();
    }

    private static void drawCircleAnimation(Graphics g, Body body, Circle shape, Animation animation) {
        g.pushTransform();
        g.translate(body.getX(), body.getY());
        g.rotate(0, 0, (float) Math.toDegrees(body.getRotation()));

        float radius = shape.getRadius();

        g.drawAnimation(animation, -radius, -radius);

        g.popTransform();
    }
}
