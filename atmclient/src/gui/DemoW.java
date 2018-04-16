package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class DemoW {
public static void main(String[] args) {
		// ��ʾ���������������Ļ�ӭ����
		new DemoWindow();
		
	}
}

// ���������������Ļ�ӭ������
class DemoWindow extends JWindow implements Runnable {
	// ������
	private JProgressBar progress = new JProgressBar(1, 100);

	// ͼƬ���
	ImagePanel ip = new ImagePanel();

	// ���캯��
	public DemoWindow() {
		// ���岼��
		add(ip, BorderLayout.CENTER);
		add(progress, BorderLayout.SOUTH);

		// ���ý�����
		progress.setStringPainted(true);
		progress.setBorderPainted(false);
		progress.setString("��������Ӧ�ó���...");
		progress.setForeground(Color.blue);
		progress.setBackground(Color.white);

		// ���ô�����
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

		// ���ô���������ʾ����ͼƬ
		pack();

		// ���ô��������ʾ
		Toolkit theKit = getToolkit();
		Dimension wndSize = theKit.getScreenSize();
		setLocation((wndSize.width - ip.getWidth()) / 2, (wndSize.height - ip.getHeight()) / 2);
		// ���ô���Ϊ�ɼ�
		setVisible(true);
		// ����ǰ����������Ļ���д����ǰ��
		this.setAlwaysOnTop(true);
		// �����ı���������߳�
		Thread splashThread = new Thread(this);
		splashThread.start();
		
	}

	// �ı���������̷߳���
	public void run() {
		try {
			// ѭ��100��
			for (int i = 0; i < 100; i++) {
				// ��ͣ0.02��
				Thread.sleep(20);

				// �ۼӽ������Ľ���
				progress.setValue(progress.getValue() + 1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// �ͷŴ�����Դ
		this.dispose();
	}
}

// ͼƬ���
class ImagePanel extends JPanel {
	// ͼƬ����
	Image image = null;

	// ���캯��
	public ImagePanel() {
		// ����MediaTracker��������Լ���ͼƬ�������Ա�֤ͼƬ������Ϻ�Ż������һ������
		MediaTracker tracker = new MediaTracker(this);
		try {
			// ����ͼƬ
			image = Toolkit.getDefaultToolkit().getImage("image\10.jpg");

			// �ȴ�ͼƬ�������
			tracker.addImage(image, 0);
			tracker.waitForID(0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(ImagePanel.this, e.getMessage());
			//System.out.println(e.getMessage());
		}
		// ����ͼƬ���Ĵ�С������������ͼƬ
		setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
	}

	// ���صĻ�ͼ����������ָ��ͼƬ
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
		
	}
}