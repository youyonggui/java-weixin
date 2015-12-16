package com.yyg.wxServiceUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import com.mysql.jdbc.StringUtils;



public class RandomCodeUtil {
	
	 	private static Class<RandomCodeUtil> logger = RandomCodeUtil.class;  
     
	    private static final String RANDOM_CODE_KEY = "random"; //验证码放在session中的key  
	      
	    private static final int CODE_NUM = 4; //验证码字符个数  
	      
	    // 设置图形验证码中字符串的字体和大小    
	    private static Font myFont = new Font("Arial", Font.BOLD, 16);     
	    
	    //随机字符数组  
	    private static char[] charSequence = "abcdefghijklmnopqrstuvmxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();  
	    //private static String charSequence = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; 
	    private static Random random = new Random();  
	      
	      
	    /** 
	     * 生成随机验证码 
	     */  
	    public static void createRandomCode(HttpServletRequest request, HttpServletResponse response){  
	        // 阻止生成的页面内容被缓存，保证每次重新生成随机验证码    
	        response.setHeader("Pragma", "No-cache");    
	        response.setHeader("Cache-Control", "no-cache");    
	        response.setDateHeader("Expires", 0);    
	        response.setContentType("image/jpeg");    
	        // 指定图形验证码图片的大小    
	        int width = 80, height = 25;    
	        // 生成一张新图片    
	        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);    
	        // 在图片中绘制内容    
	        Graphics2D g = (Graphics2D) image.getGraphics();     
	        g.setColor(getRandomColor(200, 250));    
	        g.fillRect(1, 1, width - 1, height - 1);    
	        g.setColor(new Color(102, 102, 102));    
	        g.drawRect(0, 0, width - 1, height - 1);    
	        g.setFont(myFont);    
	        // 随机生成线条，让图片看起来更加杂乱    
	        g.setColor(getRandomColor(160, 200));    
	        for (int i = 0; i < 155; i++) {    
	            int x = random.nextInt(width - 1);// 起点的x坐标    
	            int y = random.nextInt(height - 1);// 起点的y坐标    
	            int x1 = random.nextInt(6) + 1;// x轴偏移量    
	            int y1 = random.nextInt(12) + 1;// y轴偏移量    
	            g.drawLine(x, y, x + x1, y + y1);    
	        }    
	        // 随机生成线条，让图片看起来更加杂乱    
	        for (int i = 0; i < 70; i++) {    
	            int x = random.nextInt(width - 1);    
	            int y = random.nextInt(height - 1);    
	            int x1 = random.nextInt(12) + 1;    
	            int y1 = random.nextInt(6) + 1;    
	            g.drawLine(x, y, x - x1, y - y1);    
	        }    

	        String sb = rotatingRandomChar(g);
	        System.out.println(sb);
	        // 取得用户Session
	        HttpSession session = request.getSession(true);    
	        // 将系统生成的图形验证码添加   到session
	        session.setAttribute(RANDOM_CODE_KEY, sb);    
	        g.dispose();    
	        // 输出图形验证码图片    
	        try {  
	            ImageIO.write(image, "JPEG", response.getOutputStream());  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }    
	    
	    }  
	      
	    /** 
	     * 检查用户输入的验证码是否正确 
	     * @return true: 正确, false:不正确 
	     */  
	    public static boolean checkRandomCode(HttpServletRequest request, String inputCode){  
	        HttpSession session = request.getSession(false);
	        if(session != null){  
	            String code = (String) session.getAttribute(RANDOM_CODE_KEY);  
	            //logger.info("inputCode:"+inputCode.trim()+",code:"+code);
	            System.out.println(code+" ? "+inputCode);
	            return inputCode.equals(code);
	        }  
	        return false;  
	    }  
	      
	    /** 
	     * 移除验证码 
	     */  
	    public static void removeRandomCode(HttpServletRequest request){  
	        HttpSession session = request.getSession(false);  
	        if(session != null){  
	           session.removeAttribute(RANDOM_CODE_KEY);  
	        }  
	    }  
	      
	    // 生成随机颜色    
	    private static Color getRandomColor(int fc, int bc) {    
	        Random random = new Random();    
	        if (fc > 255)    
	            fc = 255;    
	        if (bc > 255)    
	            bc = 255;    
	        int r = fc + random.nextInt(bc - fc);    
	        int g = fc + random.nextInt(bc - fc);    
	        int b = fc + random.nextInt(bc - fc);    
	        return new Color(r, g, b);    
	    }    
	  
	    // 随机生成一个字符    
	    private static String rotatingRandomChar(Graphics2D g) {
	    	StringBuffer sb = new StringBuffer();
	    	String ch = "";
	    	// 控制字数
	    	for (int i = 0; i < CODE_NUM; i++) {
	    	    // 设置字体旋转角度
	    	    int degree = new Random().nextInt() % 30;
	    	    int index = random.nextInt(charSequence.length);
	    	 	ch = String.valueOf(charSequence[index]); 
	    	    sb.append(ch);
	    	     // 正向角度
	    	     g.rotate(degree * Math.PI / 180, 15 * i + 10, 20);
	    	     g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
	    	     //drawString()必须凡在所有设置之后执行，否则其后的设置将无法实现效果
	    	     g.drawString(ch,15 * i + 10, 20);
	    	      // 反向角度
	    	     g.rotate(-degree * Math.PI / 180, 15 * i + 10, 20);
	    	            // x += 30;
	    	}
	    	 return sb.toString();
	   }

}
