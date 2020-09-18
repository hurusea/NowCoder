package month08.day0726;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @hurusea
 * @create2020-08-02 15:25
 */
public class CaptureScreen_2 {
    // test main
    public static void main(String[] args) throws Exception {
        //获取"user.dir"指定的系统属性
        //String userdir = System.getProperty("user.dir");

        File tempFile = new File("temp.png");

        //获取私有单例并调用捕捉屏幕的方法
        CaptureScreen_2 capture = CaptureScreen_2.getInstance();

        //捕捉屏幕的一个矩形区域
        //先获得全屏的截图
        //阻塞？等待事件？
        capture.captureImage();


        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel imagebox = new JLabel();
        panel.add(BorderLayout.CENTER, imagebox);
        //将截图显示到imagebox上
        imagebox.setIcon(capture.getPickedIcon());

        //保存截图 到文件"tempFile"中
        capture.saveToFile(tempFile);

        System.out.println("鼠标释放后，获得一个矩形区域，同时"+
                "将dialog设为不可见，程序才会\n继续往下运行:"+
                "这是第一次获得截图、释放鼠标");
        //Thread.currentThread();
        //运行两次截屏操作之间的代码所需时间太短
        //所以我们感觉dialog是连续出现的，不会看到
        //中间输出文字，如果让程序睡一会，就能看见了
        Thread.sleep(8000);


        //再次截图  一个矩形区域
        //同时将dialog设为可见，此时只有发生释放鼠标
        //事件后，dialog设为不可见后，程序才会继续往下运行
        capture.captureImage();
        System.out.println("鼠标释放后，获得一个矩形区域，同时"+
                "将dialog设为不可见，程序才会\n继续往下运行:"+
                "这是第二次获得截图、释放鼠标");
        //将截图显示在屏幕中 没有保存
        //每次释放鼠标就会更新pickedImage pickedIcon
        imagebox.setIcon(capture.getPickedIcon());
        frame.setContentPane(panel);
        frame.setSize(400, 300);
        frame.setTitle("Second Image");
        frame.show();

        System.out.println("Over");
        //capture.dialog.setVisible(false);
    }

    //私有构造方法
    private CaptureScreen_2() {
        try {
            //获取robot对象 用于获取包含屏幕像素的图像
            robot = new Robot();
        } catch (AWTException e) {
            System.err.println("Internal Error: " + e);
            e.printStackTrace();
        }

        //
        JPanel cp = (JPanel) dialog.getContentPane();
        cp.setLayout(new BorderLayout());


        //添加鼠标监听器  私有内部类方式
        //labFullScreenImage是JLable的子类
        labFullScreenImage.addMouseListener(new MouseAdapter() {
            //响应释放鼠标事件
            public void mouseReleased(MouseEvent evn) {
                isFirstPoint = true;//释放鼠标后将isFirstPoint重置为true

                //设置pickedImage 获得屏幕的一个矩形区域
                pickedImage = fullScreenImage.getSubimage(recX, recY, recW,
                        recH);
                //dialog的作用：两次截屏后程序还在运行
                //但是将dialog设为不可见后可以手动技术程序
                //不然 没办法退出dialog 也没办法结束程序
                //除非注销计算机
                dialog.setVisible(false);
            }
        });
        //添加鼠标移动监听器
        //labFullScreenImage是JLabel的子类
        labFullScreenImage.addMouseMotionListener(new MouseMotionAdapter() {
            //响应点击+移动鼠标事件
            //此处就是按下鼠标左键并移动鼠标
            public void mouseDragged(MouseEvent evn) {
                if (isFirstPoint) {
                    //获得起点  未必是最终起点
                    x1 = evn.getX();
                    y1 = evn.getY();
                    isFirstPoint = false;
                } else {
                    //获得终点  未必是最终终点
                    x2 = evn.getX();
                    y2 = evn.getY();
                    int maxX = Math.max(x1, x2);
                    int maxY = Math.max(y1, y2);
                    int minX = Math.min(x1, x2);
                    int minY = Math.min(y1, y2);
                    //最终起点
                    recX = minX;
                    recY = minY;
                    //矩形区域的宽和高
                    recW = maxX - minX;
                    recH = maxY - minY;
                    //
                    labFullScreenImage.drawRectangle(recX, recY, recW, recH);
                }
            }
            //响应mouseMoved事件 直接移动，没有任何点击 没有其他动作
            //此处就是简单的移动鼠标 不按下左键
            public void mouseMoved(MouseEvent e) {
                labFullScreenImage.drawCross(e.getX(), e.getY());
            }
        });//私有内部类 里面有两个方法


        //得到单例时 最先执行以下代码
        cp.add(BorderLayout.CENTER, labFullScreenImage);

        //dialog为全局变量  程序执行过程中只有一个dialog对象
        dialog.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        dialog.setAlwaysOnTop(true);
        dialog.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        dialog.setUndecorated(true);
        dialog.setSize(dialog.getMaximumSize());
        dialog.setModal(true);
        //dialog.setTitle("Dialog");
    }
    // Singleton Pattern
    public static CaptureScreen_2 getInstance() {
        return defaultCapturer;
    }

    /** 捕捉全屏慕 */
    public Icon captureFullScreen() {
        //获取屏幕截图
        fullScreenImage = robot.createScreenCapture(new Rectangle(Toolkit
                .getDefaultToolkit().getScreenSize()));
        //将截图装载到icon
        ImageIcon icon = new ImageIcon(fullScreenImage);
        return icon;
    }
    /** 捕捉屏幕的一个矫形区域 */
    //通过捕捉全屏幕实现的
    public void captureImage() {
        //获取屏幕截图
        fullScreenImage = robot.createScreenCapture(new Rectangle(Toolkit
                .getDefaultToolkit().getScreenSize()));
        //将截图装载到icon
        ImageIcon icon = new ImageIcon(fullScreenImage);
        labFullScreenImage.setIcon(icon);

        //每次调用此方法 会设置dialog为可见
        dialog.setVisible(true);
    }
    /** 得到捕捉后的BufferedImage */
    public BufferedImage getPickedImage() {
        return pickedImage;
    }
    /** 得到捕捉后的Icon */
    public ImageIcon getPickedIcon() {
        return new ImageIcon(getPickedImage());
    }

    /**
     * 储存为一个文件,为PNG格式
     *
     * @deprecated replaced by saveAsPNG(File file)
     **/
    @Deprecated
    public void saveToFile(File file) throws IOException {
        ImageIO.write(getPickedImage(), defaultImageFormater, file);
    }
    /** 储存为一个文件,为PNG格式 */
    public void saveAsPNG(File file) throws IOException {
        ImageIO.write(getPickedImage(), "png", file);
    }
    /** 储存为一个JPEG格式图像文件 */
    public void saveAsJPEG(File file) throws IOException {
        ImageIO.write(getPickedImage(), "JPEG", file);
    }
    /** 写入一个OutputStream */
    public void write(OutputStream out) throws IOException {
        ImageIO.write(getPickedImage(), defaultImageFormater, out);
    }

    // singleton design pattern (单例模式)
    //使用私有构造函数获得静态私有单例
    private static CaptureScreen_2 defaultCapturer = new CaptureScreen_2();
    private int x1, y1, x2, y2;
    private int recX, recY, recH, recW; // 截取的图像
    private boolean isFirstPoint = true;
    private BackgroundImage labFullScreenImage = new BackgroundImage();
    private Robot robot;
    private BufferedImage fullScreenImage;
    private BufferedImage pickedImage;
    private String defaultImageFormater = "png";
    private JDialog dialog = new JDialog();


}
/** 显示图片的Label */
class BackgroundImage extends JLabel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(x, y, w, h);
        String area = Integer.toString(w) + " * " + Integer.toString(h);
        g.drawString(area, x + (int) w / 2 - 15, y + (int) h / 2);
        g.drawLine(lineX, 0, lineX, getHeight());
        g.drawLine(0, lineY, getWidth(), lineY);
    }
    //画矩形
    public void drawRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        h = height;
        w = width;
        repaint();
    }
    //画十字线（水平线 垂直线 垂直相交）
    public void drawCross(int x, int y) {
        lineX = x;
        lineY = y;
        repaint();
    }
    int lineX, lineY;
    int x, y, h, w;
}
