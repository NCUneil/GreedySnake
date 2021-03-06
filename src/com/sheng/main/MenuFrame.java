package com.sheng.main;

import java.awt.Container;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuFrame extends JFrame {

	private JButton bt_start = new JButton();
	private JButton bt_voice = new JButton();
	private JButton bt_exit = new JButton();
	private JButton bt_help = new JButton();
	private JButton bt_level = new JButton();

	public MenuFrame() {// 初始化框架函数
		this.setLayout(null);
		// this.pack();//自动设置框架大小，以及在框中放入组件。只有在去掉此函数才能隐去JFrame的框
		this.setTitle("GreedySnake");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true); // 隐去边框
		this.setVisible(true);
		this.setResizable(false);

		bt_start.setBounds(new Rectangle(408,100,130,218));// 设置按钮相对于menu_subPanel的位置和大小);
		bt_voice.setBounds(new Rectangle(37,50,159,61));
		bt_exit.setBounds(new Rectangle(37,130,159,61));
		bt_help.setBounds(new Rectangle(37,210,159,61));
		bt_level.setBounds(new Rectangle(37,290,159,61));

		/*
		 * 设置按钮图片
		 */
		ImageIcon icon_start = new ImageIcon("E:/GreedySnake/menu/start.png");// 载入start按钮贴图
		icon_start.getImage();
		Image size_start = icon_start
				.getImage()
				.getScaledInstance// 调整贴图大小与按钮大小匹配
				(136, 218, Image.SCALE_DEFAULT);
		icon_start = new ImageIcon(size_start);
		bt_start.setIcon(icon_start);// 贴图
		
		ImageIcon icon_voice = new ImageIcon("E:/GreedySnake/menu/voice.png");// 载入voice按钮贴图
		icon_voice.getImage();
		Image size_voice = icon_voice
				.getImage()
				.getScaledInstance// 调整贴图大小与按钮大小匹配
				(icon_voice.getIconWidth(),icon_voice.getIconHeight(), Image.SCALE_DEFAULT);
		icon_voice = new ImageIcon(size_voice);
		bt_voice.setIcon(icon_voice);// 贴图

		
		ImageIcon icon_exit = new ImageIcon("E:/GreedySnake/menu/exit.png");// 载入exit按钮贴图
		icon_exit.getImage();
		Image size_exit = icon_exit
				.getImage()
				.getScaledInstance// 调整贴图大小与按钮大小匹配
				(icon_exit.getIconWidth(),icon_exit.getIconHeight(), Image.SCALE_DEFAULT);
		icon_exit = new ImageIcon(size_exit);
		bt_exit.setIcon(icon_exit);// 贴图

		
		ImageIcon icon_help = new ImageIcon("E:/GreedySnake/menu/help.png");// 载入help按钮贴图
		icon_help.getImage();
		Image size_help = icon_help
				.getImage()
				.getScaledInstance// 调整贴图大小与按钮大小匹配
				(icon_help.getIconWidth(),icon_help.getIconHeight(), Image.SCALE_DEFAULT);
		icon_help = new ImageIcon(size_help);
		bt_help.setIcon(icon_help);// 贴图

		
		ImageIcon icon_level = new ImageIcon("E:/GreedySnake/menu/level.png");// 载入level按钮贴图
		icon_level.getImage();
		Image size_level = icon_level
				.getImage()
				.getScaledInstance// 调整贴图大小与按钮大小匹配
				(icon_level.getIconWidth(),icon_level.getIconHeight(), Image.SCALE_DEFAULT);
		icon_level = new ImageIcon(size_level);
		bt_level.setIcon(icon_level);// 贴图


		/*
		 * 背景图片的设置
		 */
		ImageIcon img_backGrand = new ImageIcon("E:/GreedySnake/menu/menu.jpg");// 载入背景图片
		JLabel lab_backGrand = new JLabel(img_backGrand);// 将背景图片加入标签内
		this.getLayeredPane()
				.add(lab_backGrand, new Integer(Integer.MIN_VALUE));// 将标签加到JFrame中
		lab_backGrand.setBounds(0, 0, 600, 400);// 设置标签的大小匹配JFrame的大小
		Container cp = this.getContentPane();
		cp.setLayout(null);// 选择布局方式，为绝对布局方式
		((JPanel) cp).setOpaque(false);// 将容器背景设置成透明，显示背景图片

		add(bt_start);
		add(bt_voice);
		add(bt_exit);
		add(bt_help);
		add(bt_level);

		bt_start.addActionListener(new ButtonActionListener());// 绑定按钮监听类
		bt_voice.addActionListener(new ButtonActionListener());
		bt_exit.addActionListener(new ButtonActionListener());
		bt_help.addActionListener(new ButtonActionListener());
		bt_level.addActionListener(new ButtonActionListener());
	}

	class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bt_start) {
				start();
			}
			if (e.getSource() == bt_voice) {
				VoiceFrame voiceFrame = new VoiceFrame();
			}
			if (e.getSource() == bt_exit) {
				exit();// 退出游戏
			}
			if (e.getSource() == bt_help) {
				help();
			}
			if (e.getSource() == bt_level) {
				LevelFrame levelFrame = new LevelFrame();
			}
		}

		private void help() {
			// TODO Auto-generated method stub
			HelpFrame help = new HelpFrame();

		}

		private boolean exit() {// 退出函数
			// TODO Auto-generated method stub
			dispose();
			return false;

		}

		private void start() {
			// TODO Auto-generated method stub
			dispose();
			new GameFrame();// 开始游戏，调用了盛姐写的函数
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuFrame menuFrame = new MenuFrame();

	}

}
