package com.softwarequality.jabberpoint.drawer;
import com.softwarequality.jabberpoint.ImageLoadingException;
import com.softwarequality.jabberpoint.slide.SlideItem;
import com.softwarequality.jabberpoint.slide.Style;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BitmapItem extends SlideItem {
	private BufferedImage bufferedImage;
	private String imageName;

	protected static final String FILE_NOT_FOUND_MESSAGE = "File ";
	protected static final String FILE_NOT_FOUND_SUFFIX = " not found";

	public BitmapItem(int level, String name) throws ImageLoadingException {
		super(level);
		this.imageName = name;
		loadImage();
	}

	public BitmapItem() {
		super(0);
		try {
			this.loadImage();
		} catch (ImageLoadingException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return imageName;
	}

	public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale, Style style) {
		return new Rectangle((int) (style.getIndent() * scale), 0,
				(int) (bufferedImage.getWidth(observer) * scale),
				(int) (style.getLeading() * scale) +
						(int) (bufferedImage.getHeight(observer) * scale));
	}

	public void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver observer) {
		int width = x + (int) (style.getIndent() * scale);
		int height = y + (int) (style.getLeading() * scale);
		graphics.drawImage(bufferedImage, width, height,(int) (bufferedImage.getWidth(observer) * scale),
				(int) (bufferedImage.getHeight(observer) * scale), observer);
	}

	@Override
	public String getText() {
		return null;
	}

	@Override
	public String toString() {
		return "BitmapItem[" + getLevel() + "," + imageName + "]";
	}
	public BufferedImage getImage() {
		return this.bufferedImage;
	}
	private void loadImage() throws ImageLoadingException{
		try {
			bufferedImage = ImageIO.read(new File(imageName));
		} catch (IOException e) {
			throw new ImageLoadingException(FILE_NOT_FOUND_MESSAGE + imageName + FILE_NOT_FOUND_SUFFIX, e);
		}
	}
}
