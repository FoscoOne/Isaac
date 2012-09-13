package forms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import moduls.Camera;
import moduls.Container;
import moduls.Data;
import moduls.ImageLoader;
import moduls.LevelObject;

public class Preview extends javax.swing.JPanel {

    private Container container;
    public static Camera camera;
    private int x2 = 0;
    private int y2 = 0;
    private int x1 = 0;
    private int y1 = 0;
    private Graphics2D g2d;
    private int editIndex = -1;
    private boolean drawing = false;
    private boolean init;

    public Preview() {
        initComponents();
        setBackground(Color.black);
        setSize(800, 640);
        setPreferredSize(new Dimension(800, 640));
        container = new Container();
        init = false;
        repaint();
    }

    public void init() {
        setLevelBackground();
        setupCamera();
        init = true;
    }

    public void reinit() {
        container.clear();
        setLevelBackground();
        setupCamera();
        init = true;
    }

    public boolean isInit() {
        return init;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (init) {
            g2d = (Graphics2D) g.create();

            g2d.translate(-(int) camera.getX(), -(int) camera.getY());

            g2d.setColor(Color.CYAN);
            int i = 0;
            if (!container.isEmpty()) {
                Iterator<LevelObject> it = container.getIterator();
                while (it.hasNext()) {
                    if (Tools.isEditMode()) {
                        if (editIndex == i && editIndex >= 0) {
                            g2d.setColor(Color.MAGENTA);
                            it.next().draw(g2d);
                        } else {
                            g2d.setColor(Color.CYAN);
                            it.next().draw(g2d);
                        }
                    } else {
                        it.next().draw(g2d);
                    }
                    i++;
                }
            }

            if (Tools.isDrawMode()) {
                if (drawing && x1 < x2 && y1 < y2) {
                    g2d.setColor(Color.BLUE);
                    g2d.drawRect(x1 + (int) camera.getX(), y1 + (int) camera.getY(), x2 - x1, y2 - y1);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
    if (init) {
        if (Tools.isViewMode()) {
            if (x2 == 0 && y2 == 0) {
                x2 = evt.getX();
                y2 = evt.getY();
            } else {
                camera.setOffset(x2 - evt.getX(), y2 - evt.getY());
                x2 = evt.getX();
                y2 = evt.getY();
            }
        }
        if (Tools.isDrawMode()) {
            if (drawing) {
                x2 = evt.getX();
                y2 = evt.getY();
            }
        }
        if (Tools.isEditMode() && !container.isEmpty() && editIndex != -1) {
            if (x2 == 0 && y2 == 0) {
                x2 = evt.getX();
                y2 = evt.getY();
            } else {
                container.get(editIndex).setOffset(-(x2 - evt.getX()), -(y2 - evt.getY()));
                x2 = evt.getX();
                y2 = evt.getY();
            }
        }
        repaint();
    } else {
        JOptionPane.showMessageDialog(this, "Nejdřívě musíte založit nový projekt.");
    }
}//GEN-LAST:event_formMouseDragged

private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
}//GEN-LAST:event_formMouseMoved

private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
    if (init) {
        if (Tools.isDrawMode() && evt.getButton() == MouseEvent.BUTTON1) {
            x1 = evt.getX();
            y1 = evt.getY();
            drawing = true;
        }
    } else {
        JOptionPane.showMessageDialog(this, "Nejdřívě musíte založit nový projekt.");
    }
}//GEN-LAST:event_formMousePressed

private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
    if (init) {
        if (Tools.isViewMode()) {
            x2 = 0;
            y2 = 0;
        }
        if (Tools.isEditMode()) {
            x2 = 0;
            y2 = 0;
        }
        if (Tools.isDrawMode() && evt.getButton() == MouseEvent.BUTTON1) {
            if (x1 < x2 && y1 < y2) {
                container.add(new LevelObject((int) camera.ScreenXToWorldX(x1),
                        (int) camera.ScreenYToWorldY(y1),
                        x2 - x1, y2 - y1, Tools.getShapeName()));
            }
            x2 = 0;
            y2 = 0;
            drawing = false;
        }
        repaint();
    } else {
        JOptionPane.showMessageDialog(this, "Nejdřívě musíte založit nový projekt.");
    }
}//GEN-LAST:event_formMouseReleased

private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    if (init) {
        if (Tools.isEditMode()) {

            for (int i = 0; i < container.size(); i++) {
                LevelObject lo = container.get(i);
                int xmin = (int) camera.WorldXToScreenX(lo.getX());
                int ymin = (int) camera.WorldYToScreenY(lo.getY());
                int xmax = lo.getWidth() + xmin;
                int ymax = lo.getHeight() + ymin;

                int x = evt.getX();
                int y = evt.getY();

                if (xmin < x && xmax > x && ymin < y && ymax > y && !container.get(i).isLocked()) {
                    if (evt.getButton() == MouseEvent.BUTTON1) {
                        editIndex = i;
                        break;
                    }
                    if (evt.getButton() == MouseEvent.BUTTON3) {
                        container.remove(lo);
                        break;
                    }
                } else {
                    if (evt.getButton() == MouseEvent.BUTTON1) {
                        editIndex = -1;
                    }
                }
            }

        }
        repaint();
    } else {
        JOptionPane.showMessageDialog(this, "Nejdříve musíte založit nový projekt.");
    }
}//GEN-LAST:event_formMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private void setLevelBackground() {

        JOptionPane.showMessageDialog(this, "Vyberte obrázek pozadí levelu...");
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("Images - JPG, JPEG, BMP, PNG", "jpg", "jpeg", "bmp", "png"));
        File file = null;
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
        }
        if (file != null) {

            container.add(new LevelObject(0, 0, file, "background"));
            container.get(0).setLocked();
            repaint();
        }
    }

    public void save(String pathname) {
        Data<Container> data = new Data<Container>();
        System.out.println("saving: objektu k ulozeni " + container.size());
        data.uloz(container, pathname);
        System.out.println("saving: projekt ulozen");
    }

    public void load(String pathname) {
        Data<Container> data = new Data<Container>();
        if (isInit()) {
            if (JOptionPane.showConfirmDialog(this, "Opravdu chcete otevřít "
                    + "projekt? Předchozí projekt bude "
                    + "zavřen.") == JOptionPane.OK_OPTION) {
                ImageLoader.clear();
                data.nacti(container, pathname);
            }
        } else {
            container = data.nacti(container, pathname);
        }
        System.out.println("loading: objektu k nacteni " + container.size());
        System.out.println("loading: nacitani obrazku");
        int count = 0;
        for (int i = 0; i < container.size(); i++) {
            if (container.get(i).getImagePath() != null) {
                try {
                    ImageLoader.load(container.get(i).getName(),
                            ImageIO.read(new File(container.get(i).getImagePath())));
                    count++;
                } catch (IOException ex) {
                }
            }
        }
        System.out.println("loading: nacteno obrazku " + count);
        setupCamera();
        init = true;
        repaint();
    }

    private void setupCamera() {
        camera = new Camera(800, 640, 0, 0,
                container.get(0).getWidth(),
                container.get(0).getHeight());
    }
}
