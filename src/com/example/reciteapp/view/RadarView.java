package com.example.reciteapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * @desciption: �״�
 */
public class RadarView extends View {
    /**
     * ����ε�ĸ���
     */
    private int count = 6;
    /**
     * ����ξ��ȷֽǶ�
     */
    private float angle = (float) (Math.PI * 2 / count);

    /**
     * �������뾶
     */
    private float radius;
    /**
     * ����x
     */
    private int centerX;
    /**
     * ����y
     */
    private int centerY;
    /**
     * �������ֵ
     */
    private float maxValue = 100;
    /**
     * ��ά�ȷ�ֵ
     */
    private double[] data = {10, 10, 10, 10, 10, 10, 10, 10};

	private String[] titles = {"��������", "��ϰ����", "������ȷ��", "���б���", "��ϰ����", "���Ա���"};

    /**
     * �״�������
     */
    private Paint mMainPaint;
    /**
     * �ı�����
     */
    private Paint mTextPaint;
    /**
     * ����������
     */
    private Paint mValuePaint;

    public RadarView(Context context) {
        this(context, null);
    }

    public RadarView(Context context,  AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadarView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mMainPaint = new Paint();
        mMainPaint.setAntiAlias(true);
        mMainPaint.setStrokeWidth(3);
        mMainPaint.setStyle(Paint.Style.STROKE);
        mMainPaint.setColor(Color.WHITE);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(20);

        mValuePaint = new Paint();
        mValuePaint.setAntiAlias(true);
        mValuePaint.setColor(Color.BLACK);
        mValuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //�������뾶
        radius = (float) Math.min(h, w) / 2 * 0.6f;
        centerX = w / 2;
        centerY = h / 2;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //�����������
        drawPolygon(canvas);
        //���ƴ����ĵ�ĩ�˵�ֱ��
        drawLines(canvas);
        //�����ı�
        drawText(canvas);
        //��������
        drawRegion(canvas);
    }

    /**
     * �����������
     */
    private void drawPolygon(Canvas canvas) {
        Path path = new Path();
        //֩��˿֮��ļ��
        float r = radius / count;
        for (int i = 1; i <= count; i++) {
            //��ǰ�뾶
            float curR = r * i;
            path.reset();
            for (int j = 0; j < count; j++) {
                if (j == 0) {
                    path.moveTo(centerX + curR, centerY);
                } else {
                    //���ݰ뾶�������֩��˿��ÿ���������
                    float x = (float) (centerX + curR * Math.cos(angle * j));
                    float y = (float) (centerY + curR * Math.sin(angle * j));
                    path.lineTo(x, y);
                }
            }
            //�պ�·��
            path.close();
            
            canvas.drawPath(path, mMainPaint);
        }
    }

    /**
     * ���ƴ����ĵ�ĩ�˵�ֱ��
     */
    private void drawLines(Canvas canvas) {
        Path path = new Path();
        for (int i = 0; i < count; i++) {
            path.reset();
            path.moveTo(centerX, centerY);
            //���������֩��˿��ÿ���������
            float x = (float) (centerX + radius * Math.cos(angle * i));
            float y = (float) (centerY + radius * Math.sin(angle * i));
            path.lineTo(x, y);
            
            canvas.drawPath(path, mMainPaint);
        }
    }

    /**
     * �����ı�
     * �ȼ�����ı��ĳ��ȣ�Ȼ��ʹ��ʼ������������ƫ��������ȡ�
     */
    private void drawText(Canvas canvas) {
        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
        float fontHeight = fontMetrics.descent - fontMetrics.ascent;
        for (int i = 0; i < count; i++) {
            //���������֩��˿��ÿ���������
            float x = (float) (centerX + (radius + fontHeight / 2) * Math.cos(angle * i));
            float y = (float) (centerY + (radius + fontHeight / 2) * Math.sin(angle * i));
            //��4����
            if (angle * i >= 0 && angle * i <= Math.PI / 2) {
            	float dis = mTextPaint.measureText(titles[i]);
                canvas.drawText(titles[i], x+1, y, mTextPaint);
            }
            //��3����
            else if (angle * i >= Math.PI / 2 && angle * i <= Math.PI) {
                float dis = mTextPaint.measureText(titles[i]);
                canvas.drawText(titles[i], x - dis, y , mTextPaint);
            }
            //��2����
            else if (angle * i >= Math.PI && angle * i <= 3 * Math.PI / 2) {
            	float dis = mTextPaint.measureText(titles[i]);
                canvas.drawText(titles[i], x-dis, y, mTextPaint);
            }
            //��1����
            else if (angle * i >= 3 * Math.PI / 2 && angle * i <= Math.PI * 2) {
            	float dis = mTextPaint.measureText(titles[i]);
                canvas.drawText(titles[i], x, y, mTextPaint);
            }
        }
    }

    /**
     * ��������
     */
    private void drawRegion(Canvas canvas) {
        Path path = new Path();
        
        setValuePaintColor(Color.parseColor("#FF5722"));
        for (int i = 0; i < count; i++) {
            double percent = data[i] / maxValue;
            
            //���������֩��˿��ÿ���������
            float x = (float) (centerX + radius * Math.cos(angle * i) * percent);
            float y = (float) (centerY + radius * Math.sin(angle * i) * percent);
            if (i == 0) {
                path.moveTo(x, centerY);
            } else {
                path.lineTo(x, y);
            }
            //����СԲ��
            canvas.drawCircle(x, y, 4, mValuePaint);
        }
       
        mValuePaint.setAlpha(150);
        //�����������
        canvas.drawPath(path, mValuePaint);
    }

    /**
     * @param titles
     */
    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    /**
     * ��ά�ȷ�ֵ
     *
     * @param data data
     */
    public void setData(double[] data) {
        this.data = data;
    }

    /**
     * �������ֵ
     *
     * @param maxValue maxValue
     */
    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * ����֩������ɫ
     *
     * @param color
     */
    public void setMainPaintColor(int color) {
        mMainPaint.setColor(color);
    }

    /**
     * ���ñ�����ɫ
     *
     * @param color
     */
    public void setTextPaintColor(int color) {
        mTextPaint.setColor(color);
    }

    /**
     * @param color
     */
    public void setValuePaintColor(int color) {
        mValuePaint.setColor(color);
    }
}