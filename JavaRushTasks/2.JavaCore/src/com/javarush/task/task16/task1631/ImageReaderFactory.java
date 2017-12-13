package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by userPG on 10.07.2017.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageType) throws IllegalArgumentException{
/*
        switch (imageType){
            case BMP: return new BmpReader();
            case PNG: return new PngReader();
            case JPG: return new JpgReader();
          default: throw new IllegalArgumentException("Неизвестный тип картинки");
        }

       */
        ImageReader reader;
        if (imageType == ImageTypes.BMP){
            reader = new BmpReader();
        } else {
            if (imageType == ImageTypes.JPG){
                reader = new JpgReader();
            } else {
                if (imageType == ImageTypes.PNG){
                    reader = new PngReader();
                } else {
                    throw new IllegalArgumentException("Неизвестный тип картинки");
                }
            }
        }
        return reader;

    }
}
