package main;

import java.awt.Dimension;

import javax.swing.*;
import graphics.GameFrame;

public class Main {

	public static void main(String[] args) {
		final Dimension DIMENSION = new Dimension(800, 600);
		SwingUtilities.invokeLater(() -> new GameFrame(DIMENSION));
	}

}
