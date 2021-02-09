package com.njq.study;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author wuping
 * @date 2019-04-19
 */

public class PictureProcess {
    private Font font = new Font("宋体", Font.PLAIN, 12); // 添加字体的属性设置

    private Graphics2D g = null;

    private int fontsize = 0;

    private int x = 0;

    private int y = 0;

    private BufferedImage background ;

    public PictureProcess() {
        background = loadImageUrl("https://image.yonghuivip.com/卡片占位图1.png");
    }

    /**
     * 导入本地图片到缓冲区
     */
    public BufferedImage loadImageLocal(String imgName) {
        try {
            return ImageIO.read(new File(imgName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 导入网络图片到缓冲区
     */
    public BufferedImage loadImageUrl(String imgName) {
        try {
            URL url = new URL(imgName);
            return ImageIO.read(url);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 生成新图片到本地
     */
    public void writeImageLocal(String newImage, BufferedImage img) {
        if (newImage != null && img != null) {
            try {
                File outputfile = new File(newImage);
                ImageIO.write(img, "png", outputfile);


//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                ImageIO.write(img, "png", stream);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 设定文字的字体等
     */
    public void setFont(String fontStyle, int fontSize) {
        this.fontsize = fontSize;
        this.font = new Font(fontStyle, Font.PLAIN, fontSize);
    }

    /**
     * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
     */
    public BufferedImage modifyImage(BufferedImage img, Object content, int x, int y) {

        try {
            int w = img.getWidth();
            int h = img.getHeight();
            g = img.createGraphics();
            g.setBackground(Color.WHITE);
            g.setColor(Color.orange);//设置字体颜色
            if (this.font != null)
                g.setFont(this.font);
            // 验证输出位置的纵坐标和横坐标
            if (x >= h || y >= w) {
                this.x = h - this.fontsize + 2;
                this.y = w;
            } else {
                this.x = x;
                this.y = y;
            }
            if (content != null) {
                g.drawString(content.toString(), this.x, this.y);
            }
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return img;
    }

    /**
     * 修改图片,返回修改后的图片缓冲区（输出多个文本段） xory：true表示将内容在一行中输出；false表示将内容多行输出
     */
    public BufferedImage modifyImage(BufferedImage img, Object[] contentArr, int x, int y,
                                     boolean xory) {
        try {
            int w = img.getWidth();
            int h = img.getHeight();
            g = img.createGraphics();
            g.setBackground(Color.WHITE);
            g.setColor(Color.RED);
            if (this.font != null)
                g.setFont(this.font);
            // 验证输出位置的纵坐标和横坐标
            if (x >= h || y >= w) {
                this.x = h - this.fontsize + 2;
                this.y = w;
            } else {
                this.x = x;
                this.y = y;
            }
            if (contentArr != null) {
                int arrlen = contentArr.length;
                if (xory) {
                    for (int i = 0; i < arrlen; i++) {
                        g.drawString(contentArr[i].toString(), this.x, this.y);
                        this.x += contentArr[i].toString().length() * this.fontsize / 2 + 5;// 重新计算文本输出位置
                    }
                } else {
                    for (int i = 0; i < arrlen; i++) {
                        g.drawString(contentArr[i].toString(), this.x, this.y);
                        this.y += this.fontsize + 2;// 重新计算文本输出位置
                    }
                }
            }
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return img;
    }

    /**
     * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
     * <p>
     * 时间:2007-10-8
     *
     * @param img
     * @return
     */
    public BufferedImage modifyImageYe(BufferedImage img) {

        try {
            int w = img.getWidth();
            int h = img.getHeight();
            g = img.createGraphics();
            g.setBackground(Color.WHITE);
            g.setColor(Color.blue);//设置字体颜色
            if (this.font != null)
                g.setFont(this.font);
            g.drawString("www.hi.baidu.com?xia_mingjian", w - 85, h - 5);
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return img;
    }

    public BufferedImage modifyImagetogeter(BufferedImage qrcode, BufferedImage background) {

        try {
            int w = qrcode.getWidth();
            int h = qrcode.getHeight();

            g = background.createGraphics();
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    1));
            g.drawImage(qrcode, 740, 1340, w, h, null);
            g.dispose();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return background;
    }

    public static BufferedImage zoomImage(BufferedImage img, double ratio) throws Exception {
        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
        return ato.filter(img, null);
    }

    public static void main(String[] args) {

        PictureProcess tt = new PictureProcess();
//
//        BufferedImage background = tt.loadImageUrl("https://image.yonghuivip.com/d47b8179a0c7f0f2f9cb6ec3656c1b46.png");
//        BufferedImage qrcode = tt.loadImageUrl("https://image.yonghuivip.com/wechat/miniprogram/productshare/qr-wxc9cf7c95499ee604-28fbc1aca9aad3cd6f1c183bf64d8d6a88af0fc3.jpg");
//        try {
//            qrcode = zoomImage(qrcode, 0.72);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //往图片上写文件
        //tt.writeImageLocal("E:\\ploanshare\\2\\22.jpg", tt.modifyImage(d, "000000", 90, 90));
//        BufferedImage result = tt.modifyImagetogeter(qrcode, background);
        for(int i=0;i<1;i++){
            System.out.println(i+"------------------------开始");
            Long time1  = System.currentTimeMillis();
            BufferedImage result = tt.generateaaa("https://image.yonghuivip.com/d47b8179a0c7f0f2f9cb6ec3656c1b46.png","https://image.yonghuivip.com/wechat/miniprogram/productshare/qr-wxc9cf7c95499ee604-28fbc1aca9aad3cd6f1c183bf64d8d6a88af0fc3.jpg",0.72,203,500);
            String pngName = System.currentTimeMillis() + "";
            System.out.println((System.currentTimeMillis()-time1));
            System.out.println(pngName);
            System.out.println("1!!!!!!!!"+(System.currentTimeMillis()-time1));
            tt.writeImageLocal(pngName + ".png", result);
            System.out.println("2!!!!!!!!"+(System.currentTimeMillis()-time1));
            //将多张图片合在一起
            System.out.println("success");
            System.out.println(i+"------------------------结束");
        }


//        pressImage("D:\\11111\\2222.jpg","D:\\11111\\1111.png","D:\\11111\\3333.png",740, 1340,1);
    }





    public final static void pressImage(String pressImg, String srcImageFile,String destImageFile,
                                        int x, int y, float alpha) {
        try {
            File img = new File(srcImageFile);
            BufferedImage src = ImageIO.read(img);
            int wideth = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(wideth, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, wideth, height, null);
            // 水印文件
            BufferedImage src_biao = null;
            try {
                src_biao = zoomImage(ImageIO.read(new File(pressImg)), 0.72);
            } catch (Exception e) {
                e.printStackTrace();
            }

            int wideth_biao = src_biao.getWidth(null);
            int height_biao = src_biao.getHeight(null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            g.drawImage(src_biao, x,
                    y, wideth_biao, height_biao, null);
            // 水印文件结束
            g.dispose();
            ImageIO.write((BufferedImage) image,  "JPEG", new File(destImageFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public  BufferedImage generateaaa(String backgroundUrl, String pressImg, double ratio, int x, int y) {
        try {
            Long tt = System.currentTimeMillis();
//            BufferedImage background = loadImageUrl(backgroundUrl);
            System.out.println("aaaaa"+(System.currentTimeMillis()-tt));
            int wideth = background.getWidth(null);
            int height = background.getHeight(null);
            BufferedImage image = new BufferedImage(wideth, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(background, 0, 0, wideth, height, null);

            Long tt1 = System.currentTimeMillis();
            BufferedImage qrcode =  zoomImage(loadImageUrl(pressImg), ratio);
            System.out.println("bbbb"+(System.currentTimeMillis()-tt1));
            int wideth_biao = qrcode.getWidth(null);
            int height_biao = qrcode.getHeight(null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1));
            g.drawImage(qrcode, x,
                    y, wideth_biao, height_biao, null);
            System.out.println("cccc"+(System.currentTimeMillis()-tt1));
            // 水印文件结束
            g.dispose();
            return image;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
