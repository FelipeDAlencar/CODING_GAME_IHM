package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSlider;

import br.com.ihm.coding_in_game.model.Hero;
import br.com.ihm.coding_in_game.model.Util;

public class SettingsDialog extends Panel implements Runnable {

	private static final long serialVersionUID = 1L;
	private JLabel labelBackground, labelTitle, labelSound, labelVelocity;
	private JButton buttonCancel, buttonConfirm, buttonSound;
	private JSlider sliderVelocity;
	private JCheckBox checkBoxSound;
	private WindowDialog windowDialog;
	private ImageIcon imgButtonSoundNormal, imgButtonSoundHover, imgButtonSoundLocked, imgButtonSoundClick,
			imgButtonDoneNormal, imgButtonDoneHover, imgButtonDoneClick, imgButtonDoneLocked, imgButtonCloseNormal,
			imgButtonCloseHover, imgButtonCloseClick, imgButtonCloseLocked;
	private Hero hero;
	private boolean loop;
	private Thread thread;

	public SettingsDialog(WindowDialog windowDialog) {
		this.windowDialog = windowDialog;
		loop = true;

		try {
			setHero(new Hero(1, 64, 126, 4, 4, 300, 250, "/assets/sprite.png"));
		} catch (IOException e) {
			System.out.println("IMAGE HERO NOTFOUND");
			e.printStackTrace();
		}

		setBounds(0, 0, 616, 500);
		setBackground(new Color(0, 0, 0, 0));

		imgButtonSoundNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_sound.png"));
		imgButtonSoundLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_sound.png"));
		imgButtonSoundHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_sound.png"));
		imgButtonSoundClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_sound.png"));

		imgButtonDoneNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_done.png"));
		imgButtonDoneHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_done.png"));
		imgButtonDoneClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_done.png"));
		imgButtonDoneLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_done.png"));

		imgButtonCloseNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_close.png"));
		imgButtonCloseHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_close.png"));
		imgButtonCloseClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_close.png"));
		imgButtonCloseLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_close.png"));

		labelBackground = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/board_dialog.png")));
		labelBackground.setBounds(0, 0, 616, 470);

		labelTitle = new JLabel("AJUSTES");
		labelTitle.setForeground(new Color(61, 57, 57));
		labelTitle.setFont(Util.FONT_TITLE);
		labelTitle.setBounds(217, 15, 250, 50);

		labelSound = new JLabel("Som");
		labelSound.setForeground(new Color(61, 57, 57));
		labelSound.setFont(Util.FONT_CONTENT);
		labelSound.setBounds(70, 130, 100, 30);

		buttonSound = new JButton(imgButtonSoundNormal);
		buttonSound.setContentAreaFilled(false);
		buttonSound.setBorder(null);
		buttonSound.setBounds(70, 160, 52, 54);
		buttonSound.setCursor(Util.CURSOR);
		
		
		labelVelocity = new JLabel("Velocidade");
		labelVelocity.setForeground(new Color(61, 57, 57));
		labelVelocity.setFont(Util.FONT_CONTENT);
		labelVelocity.setBounds(70, 190, 170, 100);

		sliderVelocity = new JSlider(1, 5);
		sliderVelocity.setBounds(70, 230, 200, 100);
		sliderVelocity.setPaintTrack(true);
		sliderVelocity.setPaintTicks(true);
		sliderVelocity.setPaintLabels(true);
		sliderVelocity.setMajorTickSpacing(1);
		sliderVelocity.setMinorTickSpacing(1);
		sliderVelocity.setValue(1);

		buttonCancel = new JButton(imgButtonCloseNormal);
		buttonCancel.setContentAreaFilled(false);
		buttonCancel.setBorder(null);
		buttonCancel.setBounds(400, 435, 50, 52);
		buttonCancel.setCursor(Util.CURSOR);
		buttonCancel.setToolTipText("<html><center><strong>CANCELAR</strong></center></html>");

		buttonConfirm = new JButton(imgButtonDoneNormal);
		buttonConfirm.setContentAreaFilled(false);
		buttonConfirm.setBorder(null);
		buttonConfirm.setBounds(154, 435, 50, 52);
		buttonConfirm.setCursor(Util.CURSOR);
		buttonConfirm.setToolTipText("<html><center><strong>CONFIRMAR</strong></center></html>");

		add(sliderVelocity);
		add(labelVelocity);
		add(labelSound);
		add(buttonSound);
		add(buttonConfirm);
		add(buttonCancel);
		add(labelTitle);
		add(labelBackground);

		setVisible(false);

	}

	public void addNotify() {
		super.addNotify();
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}

	}

	@Override
	public void run() {
		while (true) {
			try {
				if (loop) {
					repaint();
				}
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		hero.animate(Util.POSICTION_RIGHT);
		hero.moveHero(Hero.VELOCITY, 0, Util.POSICTION_RIGHT);
		hero.draw(g);
		returnForStart();

	}

	private void returnForStart() {
		if (hero.getPosX() >= 500) {
			hero.setPosX(300);
		}
	}

	public JLabel getLabelBackground() {
		return labelBackground;
	}

	public void setLabelBackground(JLabel labelBackground) {
		this.labelBackground = labelBackground;
	}

	public JLabel getLabelTitle() {
		return labelTitle;
	}

	public void setLabelTitle(JLabel labelTitle) {
		this.labelTitle = labelTitle;
	}

	public JLabel getLabelSound() {
		return labelSound;
	}

	public void setLabelSound(JLabel labelSound) {
		this.labelSound = labelSound;
	}

	public JLabel getLabelVelocity() {
		return labelVelocity;
	}

	public void setLabelVelocity(JLabel labelVelocity) {
		this.labelVelocity = labelVelocity;
	}

	public JButton getButtonCancel() {
		return buttonCancel;
	}

	public void setButtonCancel(JButton buttonCancel) {
		this.buttonCancel = buttonCancel;
	}

	public JButton getButtonConfirm() {
		return buttonConfirm;
	}

	public void setButtonConfirm(JButton buttonConfirm) {
		this.buttonConfirm = buttonConfirm;
	}

	public WindowDialog getWindowDialog() {
		return windowDialog;
	}

	public void setWindowDialog(WindowDialog windowDialog) {
		this.windowDialog = windowDialog;
	}

	public JSlider getSliderVelocity() {
		return sliderVelocity;
	}

	public void setSliderVelocity(JSlider sliderVelocity) {
		this.sliderVelocity = sliderVelocity;
	}

	public JCheckBox getCheckBoxSound() {
		return checkBoxSound;
	}

	public void setCheckBoxSound(JCheckBox checkBoxSound) {
		this.checkBoxSound = checkBoxSound;
	}

	public JButton getButtonSound() {
		return buttonSound;
	}

	public void setButtonSound(JButton buttonSound) {
		this.buttonSound = buttonSound;
	}

	public ImageIcon getImgButtonSoundNormal() {
		return imgButtonSoundNormal;
	}

	public void setImgButtonSoundNormal(ImageIcon imgButtonSoundNormal) {
		this.imgButtonSoundNormal = imgButtonSoundNormal;
	}

	public ImageIcon getImgButtonSoundHover() {
		return imgButtonSoundHover;
	}

	public void setImgButtonSoundHover(ImageIcon imgButtonSoundHover) {
		this.imgButtonSoundHover = imgButtonSoundHover;
	}

	public ImageIcon getImgButtonSoundLocked() {
		return imgButtonSoundLocked;
	}

	public void setImgButtonSoundLocked(ImageIcon imgButtonSoundLocked) {
		this.imgButtonSoundLocked = imgButtonSoundLocked;
	}

	public ImageIcon getImgButtonSoundClick() {
		return imgButtonSoundClick;
	}

	public void setImgButtonSoundClick(ImageIcon imgButtonSoundClick) {
		this.imgButtonSoundClick = imgButtonSoundClick;
	}

	public ImageIcon getImgButtonDoneNormal() {
		return imgButtonDoneNormal;
	}

	public void setImgButtonDoneNormal(ImageIcon imgButtonDoneNormal) {
		this.imgButtonDoneNormal = imgButtonDoneNormal;
	}

	public ImageIcon getImgButtonDoneHover() {
		return imgButtonDoneHover;
	}

	public void setImgButtonDoneHover(ImageIcon imgButtonDoneHover) {
		this.imgButtonDoneHover = imgButtonDoneHover;
	}

	public ImageIcon getImgButtonDoneClick() {
		return imgButtonDoneClick;
	}

	public void setImgButtonDoneClick(ImageIcon imgButtonDoneClick) {
		this.imgButtonDoneClick = imgButtonDoneClick;
	}

	public ImageIcon getImgButtonDoneLocked() {
		return imgButtonDoneLocked;
	}

	public void setImgButtonDoneLocked(ImageIcon imgButtonDoneLocked) {
		this.imgButtonDoneLocked = imgButtonDoneLocked;
	}

	public ImageIcon getImgButtonCloseNormal() {
		return imgButtonCloseNormal;
	}

	public void setImgButtonCloseNormal(ImageIcon imgButtonCloseNormal) {
		this.imgButtonCloseNormal = imgButtonCloseNormal;
	}

	public ImageIcon getImgButtonCloseHover() {
		return imgButtonCloseHover;
	}

	public void setImgButtonCloseHover(ImageIcon imgButtonCloseHover) {
		this.imgButtonCloseHover = imgButtonCloseHover;
	}

	public ImageIcon getImgButtonCloseClick() {
		return imgButtonCloseClick;
	}

	public void setImgButtonCloseClick(ImageIcon imgButtonCloseClick) {
		this.imgButtonCloseClick = imgButtonCloseClick;
	}

	public ImageIcon getImgButtonCloseLocked() {
		return imgButtonCloseLocked;
	}

	public void setImgButtonCloseLocked(ImageIcon imgButtonCloseLocked) {
		this.imgButtonCloseLocked = imgButtonCloseLocked;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

}
