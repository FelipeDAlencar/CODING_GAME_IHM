package br.com.ihm.coding_in_game.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.com.ihm.coding_in_game.model.Hero;
import br.com.ihm.coding_in_game.model.Player;
import br.com.ihm.coding_in_game.model.Util;

public class Inventory extends Game {

	public static final long serialVersionUID = 1L;
	private JLabel labelTitleBoardConsole, labelBoardConsole, labelBoardMethods, labelPainelScore, labelScore,
			labelMoveUp, labelMoveDown, labelTurnLeft, labelTurnRight, labelMoveFront, labelTitleBoardMehtods,
			labelContentConsole, labelTitlePhase, labelNamePlayer;
	private JButton buttonInfo, buttonHelp, buttonDelete, buttonHome, buttonExecute, buttonReset;
	private JTextArea textAreaConsole;
	private JScrollPane scrollPaneConsole;
	private boolean isInit = true;
	private Player player;
	private Hero hero;
	private Phase phase;
	private ImageIcon imgButtonExecuteNormal, imgButtonExecuteHover, imgButtonExecuteClick, imgButtonExecuteLocked,
			imgButtonResetNormal, imgButtonResetHover, imgButtonResetClick, imgButtonResetLocked, imgButtonTrashNormal,
			imgButtonTrashHover, imgButtonTrashClick, imgButtonTrashLocked, imgButtonHelpNormal, imgButtonHelpHover,
			imgButtonHelpClick, imgButtonHelpLocked, imgButtonInfoNormal, imgButtonInfoHover, imgButtonInfoClick,
			imgButtonInfoLocked, imgButtonHomeNormal, imgButtonHomeHover, imgButtonHomeClick, imgButtonHomeLocked;
	private Console consolePanel;

	private boolean lockInventary;
	private String finalPhase;

	public Inventory(Phase phase) {
		setBounds(1046, 0, 320, WindowMain.HEIGHT);
		setBackground(new Color(58, 47, 36));

		this.player = phase.getPlayer();
		this.hero = phase.getHero();
		this.phase = phase;
		
		finalPhase = " / 04";

		imgButtonExecuteNormal = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_normal_execute.png"));
		imgButtonExecuteHover = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_hover_execute.png"));
		imgButtonExecuteClick = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_click_execute.png"));
		imgButtonExecuteLocked = new ImageIcon(
				getClass().getClassLoader().getResource("assets/button_locked_execute.png"));

		imgButtonResetNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_reset.png"));
		imgButtonResetHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_reset.png"));
		imgButtonResetClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_reset.png"));
		imgButtonResetLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_reset.png"));

		imgButtonTrashLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_trash.png"));
		imgButtonTrashNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_trash.png"));
		imgButtonTrashHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_trash.png"));
		imgButtonTrashClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_trash.png"));

		imgButtonHomeNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_home.png"));
		imgButtonHomeHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_home.png"));
		imgButtonHomeClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_home.png"));
		imgButtonHomeLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_home.png"));

		imgButtonInfoNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_info.png"));
		imgButtonInfoHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_info.png"));
		imgButtonInfoClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_info.png"));
		imgButtonInfoLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_info.png"));

		imgButtonHelpNormal = new ImageIcon(getClass().getClassLoader().getResource("assets/button_normal_help.png"));
		imgButtonHelpHover = new ImageIcon(getClass().getClassLoader().getResource("assets/button_hover_help.png"));
		imgButtonHelpClick = new ImageIcon(getClass().getClassLoader().getResource("assets/button_click_help.png"));
		imgButtonHelpLocked = new ImageIcon(getClass().getClassLoader().getResource("assets/button_locked_help.png"));

		int x = 10, y = 20;
		int margin = 125;
		int width = 52, height = 53;

		buttonInfo = new JButton(imgButtonInfoNormal);
		buttonInfo.setBounds(x, y, width, height);
		buttonInfo.setContentAreaFilled(false);
		buttonInfo.setBorder(null);
		buttonInfo.setCursor(Util.CURSOR);
		buttonInfo.setToolTipText("<html><center><strong>INFORMAÇÕES</strong></center></html>");

		x += margin;
		buttonHelp = new JButton(imgButtonHelpNormal);
		buttonHelp.setBounds(x, y, width, height);
		buttonHelp.setContentAreaFilled(false);
		buttonHelp.setBorder(null);
		buttonHelp.setCursor(Util.CURSOR);
		buttonHelp.setToolTipText("<html><center><strong>AJUDA</strong></center></html>");

		x += margin;
		buttonHome = new JButton(imgButtonHomeNormal);
		buttonHome.setBounds(x, y, width, height);
		buttonHome.setContentAreaFilled(false);
		buttonHome.setBorder(null);
		buttonHome.setCursor(Util.CURSOR);
		buttonHome.setToolTipText("<html><center><strong>IR PARA O INÍCIO</strong></center></html>");

		x = 10;
		y = 145;
		width = 73;
		height = 34;

		labelPainelScore = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/score.png")));
		labelPainelScore.setBounds(x, y, width, height);

		x = 42;
		labelScore = new JLabel(String.format("%03d", this.player.getScore()));
		labelScore.setFont(Util.FONT_CONTENT);
		labelScore.setForeground(Color.yellow);
		labelScore.setBounds(x, y, width, height);

		x = 20;
		y = 670;
		width = 106;
		height = 56;

		buttonExecute = new JButton(imgButtonExecuteLocked);
		buttonExecute.setBounds(x, y, width, height);
		buttonExecute.setContentAreaFilled(false);
		buttonExecute.setBorder(null);
		buttonExecute.setBorderPainted(false);
		buttonExecute.setCursor(Util.CURSOR);

		x = 193;

		buttonReset = new JButton(imgButtonResetLocked);
		buttonReset.setBounds(x, y, width, height);
		buttonReset.setContentAreaFilled(false);
		buttonReset.setBorder(null);
		buttonReset.setCursor(Util.CURSOR);

		width = 52;
		height = 53;
		x = 133;
		y = 673;
		buttonDelete = new JButton(imgButtonTrashLocked);
		buttonDelete.setBounds(x, y, width, height);
		buttonDelete.setContentAreaFilled(false);
		buttonDelete.setBorder(null);
		buttonDelete.setCursor(Util.CURSOR);
		buttonDelete.setToolTipText("<html><center><strong>DELETAR COMANDO</strong></center></html>");

		x = 10;
		y = 180;
		width = 300;
		height = 228;
		labelBoardMethods = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/board.png")));
		labelBoardMethods.setBounds(x, y, width, height);

		y = 420;

		labelBoardConsole = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("assets/board.png")));
		labelBoardConsole.setBounds(x, y, width, height);
		consolePanel = new Console();
		consolePanel.setBounds(x, y, width, height);

		labelTitleBoardConsole = new JLabel("CONSOLE");
		labelTitleBoardConsole.setForeground(Util.COLOR_LABEL_OTHER);
		labelTitleBoardConsole.setFont(Util.FONT_TITLE_BOARD);
		labelTitleBoardConsole.setBounds(110, 433, 250, 20);

		y = 478;
		x = 42;
		width = 238;
		height = 135;

		textAreaConsole = new JTextArea();
		scrollPaneConsole = new JScrollPane(textAreaConsole);
		textAreaConsole.setFont(Util.FONT_CONTENT_INVENTORY);
		scrollPaneConsole.setBounds(x, y, width, height);
		textAreaConsole.setToolTipText("<html><center><strong>COMANDOS ADICIONADOS</strong></center></html>");
		textAreaConsole.setEditable(false); // EXCLUDE BORDER AND TRANSPARENT
		scrollPaneConsole.getViewport().setOpaque(false);
		textAreaConsole.setBackground(new Color(0, 0, 0, 0));
		textAreaConsole.setOpaque(false);
		scrollPaneConsole.setBorder(null);
		scrollPaneConsole.setEnabled(false);

		width = 300;
		height = 228;
		y = 88;
		x = 110;

		labelTitleBoardMehtods = new JLabel("MÉTODOS");
		labelTitleBoardMehtods.setForeground(Util.COLOR_LABEL_OTHER);
		labelTitleBoardMehtods.setFont(Util.FONT_TITLE_BOARD);
		labelTitleBoardMehtods.setBounds(x, y, width, height);

		y = 240;
		x = 50;
		width = 155;
		height = 30;
		margin = 35;
		labelTurnRight = new JLabel(Util.METHOD_TURN_RIGHT);
		labelTurnRight.setFont(Util.FONT_CONTENT_INVENTORY);
		labelTurnRight.setBounds(x, y, width, height);
		labelTurnRight.setToolTipText("CLICK PARA SER ADICIONADO AO CONSOLE");
		labelTurnRight.setCursor(Util.CURSOR);

		y += margin;
		labelTurnLeft = new JLabel(Util.METHOD_TURN_LEFT);
		labelTurnLeft.setFont(Util.FONT_CONTENT_INVENTORY);
		labelTurnLeft.setBounds(x, y, width, height);
		labelTurnLeft
				.setToolTipText("<html><center><strong>CLICK PARA SER ADICIONADO AO CONSOLE</strong></center></html>");
		labelTurnLeft.setCursor(Util.CURSOR);

		y += margin;
		labelMoveFront = new JLabel(Util.METHOD_MOVE_FRONT);
		labelMoveFront.setFont(Util.FONT_CONTENT_INVENTORY);
		labelMoveFront.setBounds(x, y, width, height);
		labelMoveFront
				.setToolTipText("<html><center><strong>CLICK PARA SER ADICIONADO AO CONSOLE</strong></center></html>");
		labelMoveFront.setCursor(Util.CURSOR);

		x = 175;
		y = 88;

		labelTitlePhase = new JLabel(phase.getTitle() + finalPhase);
		labelTitlePhase.setFont(Util.FONT_CONTENT_INVENTORY);
		labelTitlePhase.setBounds(x, y, width, height);
		labelTitlePhase.setForeground(Color.yellow);
		labelTitlePhase
				.setToolTipText("<html><center><strong>" + phase.getTitle() + " / 04" + "</strong></center></html>");

		x = 175;
		y = 115;
		labelNamePlayer = new JLabel(player.getName().toUpperCase());
		labelNamePlayer.setFont(Util.FONT_CONTENT_INVENTORY);
		labelNamePlayer.setBounds(x, y, width, height);
		labelNamePlayer.setForeground(Color.yellow);

		init();

		add(labelNamePlayer);
		add(labelTitlePhase);
		// add(consolePanel);
		add(scrollPaneConsole);
		add(labelMoveFront);
		add(labelTurnLeft);
		add(labelTurnRight);
		add(labelTitleBoardConsole);
		add(labelTitleBoardMehtods);
		add(labelBoardMethods);
		add(labelBoardConsole);
		add(labelPainelScore);
		add(buttonInfo);
		add(buttonHelp);
		add(buttonDelete);
		add(buttonHome);
		add(buttonExecute);
		add(buttonReset);
		setVisible(false);
	}

	public void init() {
		setLoop(true);
		lockInventary = false;

	}

	public void drawLife(Graphics g) {
		int x = 10, y = 115;
		g.setFont(Util.FONT_CONTENT_INVENTORY);
		g.setColor(Color.yellow);
		g.drawString("VIDA", 15, 113);
		for (BufferedImage image : player.getImgsLife()) {
			g.drawImage(image, x, y, 30, 30, null);
			x += 20;
		}
	}

	public void drawScore(Graphics g) {
		g.setColor(Color.yellow);
		g.drawString(String.format("%03d", player.getScore()), 45, 167);
	}

	public void drawMoves(Graphics g) {

		g.setColor(Color.yellow);
		g.drawString("MOVIMENTO " + String.valueOf(player.getAmountMoves()) + " / " + String.valueOf(phase.getMoves()),
				175, 165);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		drawLife(g);
		drawScore(g);
		drawMoves(g);

	}

	@Override
	public void gameUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameRender() {
		repaint();
	}

	public void turnBottomButtonsLock() {
		getButtonDelete().setIcon(getImgButtonTrashLocked());
		getButtonExecute().setIcon(getImgButtonExecuteLocked());
		getButtonReset().setIcon(getImgButtonResetLocked());

	}

	public JButton getButtonInfo() {
		return buttonInfo;
	}

	public void setButtonInfo(JButton buttonInfo) {
		this.buttonInfo = buttonInfo;
	}

	public JButton getButtonHelp() {
		return buttonHelp;
	}

	public void setButtonHelp(JButton buttonHelp) {
		this.buttonHelp = buttonHelp;
	}

	public JButton getButtonDelete() {
		return buttonDelete;
	}

	public void setButtonDelete(JButton buttonDelete) {
		this.buttonDelete = buttonDelete;
	}

	public JButton getButtonHome() {
		return buttonHome;
	}

	public void setButtonHome(JButton buttonClose) {
		this.buttonHome = buttonClose;
	}

	public boolean isInit() {
		return isInit;
	}

	public void setInit(boolean isInit) {
		this.isInit = isInit;
	}

	public JButton getButtonExecute() {
		return buttonExecute;
	}

	public void setButtonExecute(JButton buttonExecute) {
		this.buttonExecute = buttonExecute;
	}

	public JButton getButtonReset() {
		return buttonReset;
	}

	public void setButtonReset(JButton buttonReset) {
		this.buttonReset = buttonReset;
	}

	public JLabel getLabelBoardMethods() {
		return labelBoardMethods;
	}

	public void setLabelBoardMethods(JLabel labelBoardMethods) {
		this.labelBoardMethods = labelBoardMethods;
	}

	public JLabel getLabelPainelScore() {
		return labelPainelScore;
	}

	public void setLabelPainelScore(JLabel labelPainelScore) {
		this.labelPainelScore = labelPainelScore;
	}

	public JLabel getLabelScore() {
		return labelScore;
	}

	public void setLabelScore(JLabel labelScore) {
		this.labelScore = labelScore;
	}

	public JLabel getLabelMoveUp() {
		return labelMoveUp;
	}

	public void setLabelMoveUp(JLabel labelMoveUp) {
		this.labelMoveUp = labelMoveUp;
	}

	public JLabel getLabelMoveDown() {
		return labelMoveDown;
	}

	public void setLabelMoveDown(JLabel labelMoveDown) {
		this.labelMoveDown = labelMoveDown;
	}

	public JLabel getLabelTurnLeft() {
		return labelTurnLeft;
	}

	public void setLabelTurnLeft(JLabel labelTurnLeft) {
		this.labelTurnLeft = labelTurnLeft;
	}

	public JLabel getLabelTurnRight() {
		return labelTurnRight;
	}

	public void setLabelTurnRight(JLabel labelTurnRight) {
		this.labelTurnRight = labelTurnRight;
	}

	public JLabel getLabelMoveFront() {
		return labelMoveFront;
	}

	public void setLabelMoveFront(JLabel labelMoveFront) {
		this.labelMoveFront = labelMoveFront;
	}

	public JLabel getLabelTitleBoardMehtods() {
		return labelTitleBoardMehtods;
	}

	public void setLabelTitleBoardMehtods(JLabel labelTitleBoardMehtods) {
		this.labelTitleBoardMehtods = labelTitleBoardMehtods;
	}

	public JLabel getLabelContentConsole() {
		return labelContentConsole;
	}

	public void setLabelContentConsole(JLabel labelContentConsole) {
		this.labelContentConsole = labelContentConsole;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public JLabel getLabelTitlePhase() {
		return labelTitlePhase;
	}

	public void setLabelTitlePhase(JLabel labelTitlePhase) {
		this.labelTitlePhase = labelTitlePhase;
	}

	public JTextArea getTextAreaConsole() {
		return textAreaConsole;
	}

	public void setTextAreaConsole(JTextArea textAreaConsole) {
		this.textAreaConsole = textAreaConsole;
	}

	public JScrollPane getScrollPaneConsole() {
		return scrollPaneConsole;
	}

	public void setScrollPaneConsole(JScrollPane scrollPaneConsole) {
		this.scrollPaneConsole = scrollPaneConsole;
	}

	public ImageIcon getImgButtonExecuteNormal() {
		return imgButtonExecuteNormal;
	}

	public void setImgButtonExecuteNormal(ImageIcon imgButtonExecuteNormal) {
		this.imgButtonExecuteNormal = imgButtonExecuteNormal;
	}

	public ImageIcon getImgButtonExecuteHover() {
		return imgButtonExecuteHover;
	}

	public void setImgButtonExecuteHover(ImageIcon imgButtonExecuteHover) {
		this.imgButtonExecuteHover = imgButtonExecuteHover;
	}

	public ImageIcon getImgButtonExecuteClick() {
		return imgButtonExecuteClick;
	}

	public void setImgButtonExecuteClick(ImageIcon imgButtonExecuteClick) {
		this.imgButtonExecuteClick = imgButtonExecuteClick;
	}

	public ImageIcon getImgButtonExecuteLocked() {
		return imgButtonExecuteLocked;
	}

	public void setImgButtonExecuteLocked(ImageIcon imgButtonExecuteLocked) {
		this.imgButtonExecuteLocked = imgButtonExecuteLocked;
	}

	public ImageIcon getImgButtonResetNormal() {
		return imgButtonResetNormal;
	}

	public void setImgButtonResetNormal(ImageIcon imgButtonResetNormal) {
		this.imgButtonResetNormal = imgButtonResetNormal;
	}

	public ImageIcon getImgButtonResetHover() {
		return imgButtonResetHover;
	}

	public void setImgButtonResetHover(ImageIcon imgButtonResetHover) {
		this.imgButtonResetHover = imgButtonResetHover;
	}

	public ImageIcon getImgButtonResetClick() {
		return imgButtonResetClick;
	}

	public void setImgButtonResetClick(ImageIcon imgButtonResetClick) {
		this.imgButtonResetClick = imgButtonResetClick;
	}

	public ImageIcon getImgButtonResetLocked() {
		return imgButtonResetLocked;
	}

	public void setImgButtonResetLocked(ImageIcon imgButtonResetLocked) {
		this.imgButtonResetLocked = imgButtonResetLocked;
	}

	public ImageIcon getImgButtonTrashNormal() {
		return imgButtonTrashNormal;
	}

	public void setImgButtonTrashNormal(ImageIcon imgButtonTrashNormal) {
		this.imgButtonTrashNormal = imgButtonTrashNormal;
	}

	public ImageIcon getImgButtonTrashHover() {
		return imgButtonTrashHover;
	}

	public void setImgButtonTrashHover(ImageIcon imgButtonTrashHover) {
		this.imgButtonTrashHover = imgButtonTrashHover;
	}

	public ImageIcon getImgButtonTrashClick() {
		return imgButtonTrashClick;
	}

	public void setImgButtonTrashClick(ImageIcon imgButtonTrashClick) {
		this.imgButtonTrashClick = imgButtonTrashClick;
	}

	public ImageIcon getImgButtonTrashLocked() {
		return imgButtonTrashLocked;
	}

	public void setImgButtonTrashLocked(ImageIcon imgButtonTrashLocked) {
		this.imgButtonTrashLocked = imgButtonTrashLocked;
	}

	public ImageIcon getImgButtonHelpNormal() {
		return imgButtonHelpNormal;
	}

	public void setImgButtonHelpNormal(ImageIcon imgButtonHelpNormal) {
		this.imgButtonHelpNormal = imgButtonHelpNormal;
	}

	public ImageIcon getImgButtonHelpHover() {
		return imgButtonHelpHover;
	}

	public void setImgButtonHelpHover(ImageIcon imgButtonHelpHover) {
		this.imgButtonHelpHover = imgButtonHelpHover;
	}

	public ImageIcon getImgButtonHelpClick() {
		return imgButtonHelpClick;
	}

	public void setImgButtonHelpClick(ImageIcon imgButtonHelpClick) {
		this.imgButtonHelpClick = imgButtonHelpClick;
	}

	public ImageIcon getImgButtonHelpLocked() {
		return imgButtonHelpLocked;
	}

	public void setImgButtonHelpLocked(ImageIcon imgButtonHelpLocked) {
		this.imgButtonHelpLocked = imgButtonHelpLocked;
	}

	public ImageIcon getImgButtonInfoNormal() {
		return imgButtonInfoNormal;
	}

	public void setImgButtonInfoNormal(ImageIcon imgButtonInfoNormal) {
		this.imgButtonInfoNormal = imgButtonInfoNormal;
	}

	public ImageIcon getImgButtonInfoHover() {
		return imgButtonInfoHover;
	}

	public void setImgButtonInfoHover(ImageIcon imgButtonInfoHover) {
		this.imgButtonInfoHover = imgButtonInfoHover;
	}

	public ImageIcon getImgButtonInfoClick() {
		return imgButtonInfoClick;
	}

	public void setImgButtonInfoClick(ImageIcon imgButtonInfoClick) {
		this.imgButtonInfoClick = imgButtonInfoClick;
	}

	public ImageIcon getImgButtonInfoLocked() {
		return imgButtonInfoLocked;
	}

	public void setImgButtonInfoLocked(ImageIcon imgButtonInfoLocked) {
		this.imgButtonInfoLocked = imgButtonInfoLocked;
	}

	public ImageIcon getImgButtonHomeNormal() {
		return imgButtonHomeNormal;
	}

	public void setImgButtonHomeNormal(ImageIcon imgButtonHomeNormal) {
		this.imgButtonHomeNormal = imgButtonHomeNormal;
	}

	public ImageIcon getImgButtonHomeHover() {
		return imgButtonHomeHover;
	}

	public void setImgButtonHomeHover(ImageIcon imgButtonHomeHover) {
		this.imgButtonHomeHover = imgButtonHomeHover;
	}

	public ImageIcon getImgButtonHomeClick() {
		return imgButtonHomeClick;
	}

	public void setImgButtonHomeClick(ImageIcon imgButtonHomeClick) {
		this.imgButtonHomeClick = imgButtonHomeClick;
	}

	public ImageIcon getImgButtonHomeLocked() {
		return imgButtonHomeLocked;
	}

	public void setImgButtonCloseLocked(ImageIcon imgButtonHomeLocked) {
		this.imgButtonHomeLocked = imgButtonHomeLocked;
	}

	public JLabel getLabelNamePlayer() {
		return labelNamePlayer;
	}

	public void setLabelNamePlayer(JLabel labelNamePlayer) {
		this.labelNamePlayer = labelNamePlayer;
	}

	public boolean isLockInventary() {
		return lockInventary;
	}

	public void setLockInventary(boolean lockInventary) {
		this.lockInventary = lockInventary;
	}

	public Console getConsolePanel() {
		return consolePanel;
	}

	public void setConsolePanel(Console consolePanel) {
		this.consolePanel = consolePanel;
	}

	public void setImgButtonHomeLocked(ImageIcon imgButtonHomeLocked) {
		this.imgButtonHomeLocked = imgButtonHomeLocked;
	}

	public JLabel getLabelTitleBoardConsole() {
		return labelTitleBoardConsole;
	}

	public void setLabelTitleBoardConsole(JLabel labelTitleBoardConsole) {
		this.labelTitleBoardConsole = labelTitleBoardConsole;
	}

	public JLabel getLabelBoardConsole() {
		return labelBoardConsole;
	}

	public void setLabelBoardConsole(JLabel labelBoardConsole) {
		this.labelBoardConsole = labelBoardConsole;
	}

	public String getFinalPhase() {
		return finalPhase;
	}

	public void setFinalPhase(String finalPhase) {
		this.finalPhase = finalPhase;
	}
	
}
