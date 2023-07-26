package com.example.zhh.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CodeUtil {

    //基本配置
    private static int yy = 20;//字符起始纵标
    private static int fontSize = 20;//字符大小
    private static int interval = -5;//字符间距

    //验证码
    private static int count = 4;//验证码字符数,改这就可以了
    private static int height = fontSize + 2;
    private static int width = (fontSize + interval) * count;
    private static int interferingLine = 15;//干扰线数
    private static int interferingLineLength = 30;//干扰线最大长度

    //数学表达式
    private static int operandCount = 2;//数学表达式操作数个数，改这就可以了
    private static int expressionLength = (operandCount << 1) - 1;//操作符与操作数一共2*operandCount-1长度
    private static int height1 = fontSize + 2;
    private static int width1 = (fontSize + interval) * (expressionLength + 1);
    private static int interferingLine1 = 12;//干扰线数
    private static int interferingLineLengt2 = 20;//干扰线最大长度

    private static char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static char[] operators = {'+', '-', '*', '/'};

    public static Map<String, Object> generateCodeAndPic() {
        //图像buffer
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D gd = bufferedImage.createGraphics();
        Random random = new Random();

        //将图像填充为白色
        gd.setColor(Color.white);
        gd.fillRect(0, 0, width, height);

        //创建字体
        Font font = new Font("Fixedsys", Font.BOLD, fontSize);

        //设置字体
        gd.setFont(font);

        //画边框
        // gd.setColor(Color.black);
        //gd.drawRect(1, 1, width - 2, width - 2);

        //随机产生25条干扰线
        gd.setColor(Color.black);
        for (int i = 0; i < interferingLine; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(interferingLineLength);
            int y1 = random.nextInt(interferingLineLength);
            gd.drawLine(x, y, x + x1, y + y1);
        }
        //保存验证码
        StringBuilder randomCode = new StringBuilder();
        int red, green, blue;

        //随机产生length个验证码
        for (int i = 0; i < count; i++) {
            String code = String.valueOf(codeSequence[random.nextInt(36)]);
            red = random.nextInt(210);
            green = random.nextInt(210);
            blue = random.nextInt(210);

            gd.setColor(new Color(red, green, blue));
            gd.drawString(code, i * (fontSize + interval), yy);
            randomCode.append(code);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", randomCode.toString());
        map.put("bufferedImage", bufferedImage);
        return map;
    }

    public static Map<String, Object> generateMathExpressionAndPic() {
        //图像buffer
        BufferedImage bufferedImage = new BufferedImage(width1, height1, BufferedImage.TYPE_INT_RGB);

        Graphics2D gd = bufferedImage.createGraphics();
        Random random = new Random();

        //将图像填充为白色
        gd.setColor(Color.white);
        gd.fillRect(0, 0, width1, height1);

        //创建字体
        Font font = new Font("Fixedsys", Font.BOLD, fontSize);

        //设置字体
        gd.setFont(font);

        //画边框
        // gd.setColor(Color.black);
        //gd.drawRect(1, 1, width - 2, width - 2);

        //随机产生25条干扰线
        gd.setColor(Color.black);
        for (int i = 0; i < interferingLine1; i++) {
            int x = random.nextInt(width1);
            int y = random.nextInt(height1);
            int x1 = random.nextInt(interferingLineLengt2);
            int y1 = random.nextInt(interferingLineLengt2);
            gd.drawLine(x, y, x + x1, y + y1);
        }
        //保存验证码
        StringBuilder sb = new StringBuilder();
        int red, green, blue;

        //随机产生length个验证码

        for (int i = 0; i < expressionLength; i++) {
            if ((i & 1) == 0) {//偶数则为操作数
                String operand = String.valueOf(numbers[random.nextInt(4)]);
                red = random.nextInt(210);
                green = random.nextInt(210);
                blue = random.nextInt(210);
                gd.setColor(new Color(red, green, blue));
                gd.drawString(operand, i * (fontSize + interval), yy);
                sb.append(operand);
            } else {//操作符
                red = random.nextInt(210);
                green = random.nextInt(210);
                blue = random.nextInt(210);
                String operator = String.valueOf(operators[random.nextInt(2)]);
                gd.setColor(new Color(red, green, blue));
                gd.drawString(operator, i * (fontSize + interval), yy);
                sb.append(operator);
            }

        }

        red = random.nextInt(210);
        green = random.nextInt(210);
        blue = random.nextInt(210);
        gd.setColor(new Color(red, green, blue));
        gd.drawString("=", expressionLength * (fontSize + interval), yy);

        String expr = sb.toString();
        Map<String, Object> map = new HashMap<>();
        map.put("code", expr);
        map.put("bufferedImage", bufferedImage);
        return map;
    }


}