package com.test;

import java.nio.IntBuffer;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacpp.opencv_highgui.CvTrackbarCallback;
import org.bytedeco.javacpp.opencv_videoio;

import static org.bytedeco.javacpp.opencv_highgui.*;

public class MainTest {
    public static void main(String[] args) {
        //进度条最大值
        int switchValue =0;
        //每帧要显示的图像
        IplImage frammeImage = null;
        //回调方法载体
        SwitchCallBack switchCallBack =  new SwitchCallBack();
        //读取视频
        opencv_videoio.CvCapture cvCapture = opencv_videoio.cvCreateFileCapture("/Users/ListenYoung/123.avi");
        if (cvCapture==null) {
            System.out.println("读取文件出错！");
            return;
        }
        switchValue = (int)opencv_videoio.cvGetCaptureProperty(cvCapture,opencv_videoio.CV_CAP_PROP_FRAME_COUNT);
        //创建窗口，大小可调整
        cvNamedWindow("Trackbar", 0);
        cvCreateTrackbar(
                //进度条的名称
                "Progress",
                //窗口的名称
                "Trackbar",
                //当前进度条的值
                switchCallBack.getIntBuffer(),
                //进度条最大值
                switchValue,
                //回调函数载体
                switchCallBack
        );
        while(true) {
            //只要进度条，没有拖到最后，就进行播放
            //if(switchCallBack.getIntBuffer().get(0)!=switchValue&&switchCallBack.getIntBuffer().get(0)!=0){
                frammeImage = opencv_videoio.cvQueryFrame(cvCapture);
                //opencv_videoio.cvGrabFrame(cvCapture);
                //frammeImage = opencv_videoio.cvRetrieveFrame(cvCapture);
                //if(frammeImage==null) break;
            //展示当前帧，以实现视频的播放
            cvShowImage( "Trackbar", frammeImage);
            if(cvWaitKey(10)==27 ){
                break;
            }
        }
        //释放资源
        opencv_videoio.cvReleaseCapture(cvCapture);
        cvDestroyWindow("Trackbar");
    }

}
/**
 * @功能说明：实现拖动进度条的过程中的函数回调
 * @time:2014年7月19日下午6:05:28
 * @version:1.0
 *
 */
class SwitchCallBack extends CvTrackbarCallback{
    private IntBuffer intBuffer = IntBuffer.allocate(30);
    @Override
    public void call(int position){
        //进度条当前位置在0，提示关闭  
        if (position ==0) {
            switchBegin();
            intBuffer.clear();
            intBuffer.put(position);
            //进度条当前位置是30，播放结束
        }else if(position==30){
            switchEnd();
            intBuffer.clear();
            intBuffer.put(position);
            //清空进度条缓存值，放入当前值
        }else{
            intBuffer.clear();
            intBuffer.put(position);
            switchOn();
        }

    }
    public void switchOn(){
        System.out.println("正在播放:");
    }
    public void switchBegin(){
        System.out.println("即将开始播放！");
    }
    public void switchEnd(){
        System.out.println("播放完毕");
    }
    public IntBuffer getIntBuffer() {
        return intBuffer;
    }
    public void setIntBuffer(IntBuffer intBuffer) {
        this.intBuffer = intBuffer;
    }

}