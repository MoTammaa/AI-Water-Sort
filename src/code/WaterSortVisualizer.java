package code;
import code.entites.Color;
import code.entites.State;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WaterSortVisualizer extends JFrame {

    ArrayList<State> steps;
    int currentStep = 0;
    DrawingPanel drawingPanel;

    public WaterSortVisualizer(ArrayList<State> steps) {
        this.steps = steps;
        setTitle("Water Sort Visualizer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // previous button
        JButton prevButton = new JButton("Previous");
        prevButton.setBackground(new java.awt.Color(100, 0, 0));
        prevButton.setFont(new Font("Arial", Font.BOLD, 20));
        prevButton.setForeground(java.awt.Color.WHITE);
        prevButton.setFocusPainted(false);
        prevButton.addActionListener(e -> prevStep());
        buttonPanel.add(prevButton);

        // next button
        JButton nextButton = new JButton("Next");
        nextButton.setBackground(new java.awt.Color(0, 100, 0));
        nextButton.setFont(new Font("Arial", Font.BOLD, 20));
        nextButton.setForeground(java.awt.Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.addActionListener(e -> nextStep());
        buttonPanel.add(nextButton);

        add(buttonPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    public void nextStep() {
        if (currentStep < steps.size() - 1) {
            currentStep++;
            drawingPanel.repaint();
        }
    }

    public void prevStep() {
        if (currentStep > 0) {
            currentStep--;
            drawingPanel.repaint();
        }
    }

    private class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (steps != null && !steps.isEmpty()) {
                State state = steps.get(currentStep);
                int n = WaterSortSearch.BOTTLES_COUNT;
                ArrayList<code.entites.Color>[] colors = state.getBottles();

                int width = this.getWidth() / (n + 5 + (n > 10 ? 6 : 0));
                int height = this.getHeight() / (WaterSortSearch.MAX_BOTTLE_CAPACITY + 4);
                int padding = height / 5;
                int x = padding;
                int y = height - padding;

                g.setColor(java.awt.Color.BLACK);
                ((Graphics2D) g).setStroke(new BasicStroke(3));
                for (int i = 0; i < n; i++) {
                    g.drawRect(x, y, width + padding, (height + padding + padding / 2) * WaterSortSearch.MAX_BOTTLE_CAPACITY);
                    x += width + padding * 3;
                }

                x = padding + padding / 2;
                y = (height + padding) * WaterSortSearch.MAX_BOTTLE_CAPACITY;

                for (int i = 0; i < n; i++) {
                    int m = colors[i].size();
                    for (int j = 0; j < m; j++) {
                        code.entites.Color color;
                        if (colors[i].isEmpty()) color = code.entites.Color.EMPTY;
                        else color = colors[i].get(j);
                        if (color != code.entites.Color.EMPTY) {
                            g.setColor(getColor(color));
                            g.fillRect(x, y, width, height);
                        }
                        y -= height + padding;
                    }
                    y = (height + padding) * WaterSortSearch.MAX_BOTTLE_CAPACITY;
                    x += width + padding * 3;
                }

                // if the state is the final state
                if (currentStep == steps.size() - 1) {
                    g.setColor(java.awt.Color.GREEN);
                    g.setFont(new Font("Arial", Font.BOLD, 70));
                    g.drawString("Solved!", this.getWidth() / 2 - 150, this.getHeight() / 2);
                }
            } else if (steps != null) {
                g.setColor(java.awt.Color.RED);
                g.setFont(new Font("Arial", Font.BOLD, 70));
                g.drawString("No Solution!", this.getWidth() / 2 - 200, this.getHeight() / 2);
            }
        }

        public java.awt.Color getColor(code.entites.Color color) {
            return switch (color) {
                case blue -> java.awt.Color.BLUE;
                case red -> java.awt.Color.RED;
                case yellow -> java.awt.Color.YELLOW;
                case green -> java.awt.Color.GREEN;
                case EMPTY -> java.awt.Color.WHITE;
                default -> java.awt.Color.BLACK;
            };
        }
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Water Sort Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
