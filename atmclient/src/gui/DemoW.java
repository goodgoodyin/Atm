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
		// 显示带有启动进度条的欢迎窗体
		new DemoWindow();
		
	}
}

// 带有启动进度条的欢迎窗体类
class DemoWindow extends JWindow implements Runnable {
	// 进度条
	private JProgressBar progress = new JProgressBar(1, 100);

	// 图片面板
	ImagePanel ip = new ImagePanel();

	// 构造函数
	public DemoWindow() {
		// 窗体布局
		add(ip, BorderLayout.CENTER);
		add(progress, BorderLayout.SOUTH);

		// 设置进度条
		progress.setStringPainted(true);
		progress.setBorderPainted(false);
		progress.setString("正在启动应用程序...");
		progress.setForeground(Color.blue);
		progress.setBackground(Color.white);

		// 设置窗体光标
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

		// 设置窗体正好显示整个图片
		pack();

		// 设置窗体居中显示
		Toolkit theKit = getToolkit();
		Dimension wndSize = theKit.getScreenSize();
		setLocation((wndSize.width - ip.getWidth()) / 2, (wndSize.height - ip.getHeight()) / 2);
		// 设置窗体为可见
		setVisible(true);
		// 将当前窗体置于屏幕所有窗体的前面
		this.setAlwaysOnTop(true);
		// 启动改变进度条的线程
		Thread splashThread = new Thread(this);
		splashThread.start();
		
	}

	// 改变进度条的线程方法
	public void run() {
		try {
			// 循环100次
			for (int i = 0; i < 100; i++) {
				// 暂停0.02秒
				Thread.sleep(20);

				// 累加进度条的进度
				progress.setValue(progress.getValue() + 1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 释放窗体资源
		this.dispose();
	}
}

// 图片面板
class ImagePanel extends JPanel {
	// 图片内容
	Image image = null;

	// 构造函数
	public ImagePanel() {
		// 创建MediaTracker类变量，以加载图片，它可以保证图片加载完毕后才会进行下一步操作
		MediaTracker tracker = new MediaTracker(this);
		try {
			// 加载图片
			image = Toolkit.getDefaultToolkit().getImage("image\10.jpg");

			// 等待图片加载完毕
			tracker.addImage(image, 0);
			tracker.waitForID(0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(ImagePanel.this, e.getMessage());
			//System.out.println(e.getMessage());
		}
		// 设置图片面板的大小正好容纳整个图片
		setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
	}

	// 重载的绘图函数，绘制指定图片
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this);
		
	}
}