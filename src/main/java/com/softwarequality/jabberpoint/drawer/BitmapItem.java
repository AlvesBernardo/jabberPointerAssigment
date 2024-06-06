package com.softwarequality.jabberpoint.drawer;

import com.softwarequality.jabberpoint.utils.ImageLoadingException;
import com.softwarequality.jabberpoint.slide.SlideItem;
import com.softwarequality.jabberpoint.slide.Style;
import com.softwarequality.jabberpoint.utils.ValidationUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BitmapItem extends SlideItem {
  private static final String FILE_NOT_FOUND_MESSAGE = "File ";
  private static final String FILE_NOT_FOUND_SUFFIX = " not found";
  private BufferedImage bufferedImage;
  private String imageName;

  public BitmapItem(int level, String name) throws ImageLoadingException {
    super(level);
    setImageName(name);
    loadImage();
  }

  public BufferedImage getBufferedImage() {
    return bufferedImage;
  }

  public void setBufferedImage(BufferedImage bufferedImage) {
    ValidationUtils.checkNotNull(bufferedImage, "BufferedImage cannot be null");
    this.bufferedImage = bufferedImage;
  }

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    ValidationUtils.checkNotNull(imageName, "Image name cannot be null");
    this.imageName = imageName;
  }

  @Override
  public Rectangle getBoundingBox(Graphics graphics, ImageObserver observer, float scale, Style style) {
    validateParameters(graphics, observer, style);
    return new Rectangle(
            (int) (style.getIndent() * scale),
            0,
            (int) (bufferedImage.getWidth(observer) * scale),
            (int) (style.getLeading() * scale) + (int) (bufferedImage.getHeight(observer) * scale)
    );
  }

  @Override
  public void draw(int x, int y, float scale, Graphics graphics, Style style, ImageObserver observer) {
    validateParameters(graphics, observer, style);
    int width = x + (int) (style.getIndent() * scale);
    int height = y + (int) (style.getLeading() * scale);

    graphics.drawImage(
            bufferedImage,
            width,
            height,
            (int) (bufferedImage.getWidth(observer) * scale),
            (int) (bufferedImage.getHeight(observer) * scale),
            observer
    );
  }

  @Override
  public String getText() {
    return null;
  }

  @Override
  public String toString() {
    return "BitmapItem[" + getLevel() + "," + imageName + "]";
  }

  private void loadImage() throws ImageLoadingException {
    try {
      bufferedImage = ImageIO.read(new File(imageName));
    } catch (IOException e) {
      throw new ImageLoadingException(FILE_NOT_FOUND_MESSAGE + imageName + FILE_NOT_FOUND_SUFFIX, e);
    }
  }

  private void validateParameters(Graphics graphics, ImageObserver observer, Style style) {
    ValidationUtils.checkNotNull(graphics, "Graphics cannot be null");
    ValidationUtils.checkNotNull(observer, "Observer cannot be null");
    ValidationUtils.checkNotNull(style, "Style cannot be null");
  }
}
