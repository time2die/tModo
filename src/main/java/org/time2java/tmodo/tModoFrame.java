package org.time2java.tmodo;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JSlider;
import javax.swing.Timer;

/**
 * @author alex
 */
public class tModoFrame extends javax.swing.JFrame {

    public tModoFrame() {
        initComponents();
        setModelStopState();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeLabel = new javax.swing.JLabel();
        timeSlider = new javax.swing.JSlider();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        jMinuteLeftLabel = new javax.swing.JLabel();
        jDotLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        timeLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("30");

        timeSlider.setMaximum(60);
        timeSlider.setMinimum(1);
        timeSlider.setMinorTickSpacing(10);
        timeSlider.setPaintLabels(true);
        timeSlider.setValue(30);
        timeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                timeSliderStateChanged(evt);
            }
        });

        startButton.setText("start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        stopButton.setText("stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        pauseButton.setText("pause");
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        jMinuteLeftLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jMinuteLeftLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMinuteLeftLabel.setText("0");
        jMinuteLeftLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jDotLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jDotLabel.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(stopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pauseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jDotLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMinuteLeftLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDotLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jMinuteLeftLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pauseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        startButton.setEnabled(false);
        pauseButton.setEnabled(true);
        stopButton.setEnabled(true);
        timeSlider.setEnabled(false);

        timeIterator = timeSlider.getValue() * 60;
        startTimer();
    }//GEN-LAST:event_startButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        stopButton.setEnabled(!stopButton.isEnabled());
        if (timer.isRunning()) {
            timer.stop();
        } else {
            timer.start();
        }
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void setModelStopState() {
        startButton.setEnabled(true);
        pauseButton.setEnabled(false);
        stopButton.setEnabled(false);
        timeSlider.setEnabled(true);
        timeSlider.setVisible(true);
        timeSlider.setEnabled(true);
    }

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        setModelStopState();

        try (FileInputStream fis = new FileInputStream("beep.mp3")) {
            Player pl = new Player(fis);
            pl.play();
        } catch (JavaLayerException | IOException e){
            e.printStackTrace();
        }

        if (timer != null) {
            timer.stop();
        }
        timeIterator = 0;
        timeLabel.setText(Integer.valueOf(timeSlider.getValue()).toString());
        jMinuteLeftLabel.setText("0");
    }//GEN-LAST:event_stopButtonActionPerformed

    private void timeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_timeSliderStateChanged
        JSlider slider = (JSlider) evt.getSource();
        timeLabel.setText(Integer.valueOf(slider.getValue()).toString());
    }//GEN-LAST:event_timeSliderStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jDotLabel;
    private javax.swing.JLabel jMinuteLeftLabel;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JSlider timeSlider;
    // End of variables declaration//GEN-END:variables

    private Timer timer;

    private void startTimer() {
        timer = new Timer(1000, timerAL);
        timer.start();
    }

    private static int timeIterator = 0;
    private ActionListener timerAL = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (timeIterator-- > 0) {
                timeLabel.setText(Integer.valueOf(timeIterator).toString());
                jMinuteLeftLabel.setText(Integer.valueOf(timeIterator/60).toString());
            } else {
                stopButtonActionPerformed(null);
                stopTimeDialog d = new stopTimeDialog(tModoFrame.this, true);
                d.setVisible(true);
            }
        }
    };
}
