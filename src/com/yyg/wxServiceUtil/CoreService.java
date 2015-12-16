package com.yyg.wxServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;


public class CoreService extends BaseMessage{
	/**
	 * 这个类将处理一切来自微信服务器的消息
	 * 处理微信发来的请求
	 */
	public static String processRequest(HttpServletRequest request) {
		String respMessage = null; //响应数据 
        try {  
            // 默认返回的文本消息内容  
            String respContent = "请求处理异常，请稍候尝试！";  
            // xml请求解析
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
 
            // 回复文本消息  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);
  
            // 文本消息  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
                respContent = "您发送的是文本消息！内容为："+requestMap.get("Content");               
            }  
            // 图片消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
                respContent = "您发送的是图片消息！";  
            }  
            // 地理位置消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respContent = "您发送的是地理位置消息！";  
            }  
            // 链接消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respContent = "您发送的是链接消息！";  
            }  
            // 音频消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                respContent = "您发送的是音频消息！";  
            }  
            // 事件推送  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // 事件类型  
                String eventType = requestMap.get("Event");  
                // 订阅  关注与取消关注没有eventKey值
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                    respContent = "感谢您关注尤勇贵微信的测试平台！";  
                }  
                // 取消订阅  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                }  
                // 自定义菜单点击事件  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                    // 事件KEY值，与创建自定义菜单时指定的KEY值对应  
                    String eventKey = requestMap.get("EventKey");  
  
                    if (eventKey.equals("click_11")) {
                    	//基地介绍
                    	NewsMessage newsMessage = new NewsMessage();
                    	newsMessage.setToUserName(fromUserName);  
                        newsMessage.setFromUserName(toUserName);
                    	String respMsg = menuClickproc.respArticle(newsMessage);
                    	return respMsg;
                    	
                        //respContent = "第一个一级菜单的第一个二级菜单被点击！";  
                    } else if (eventKey.equals("click_12")) {
                    	NewsMessage newsMessage = new NewsMessage();
                    	newsMessage.setToUserName(fromUserName);  
                        newsMessage.setFromUserName(toUserName);
                    	String respMsg = menuClickproc.respArticles(newsMessage);
                    	return respMsg;
                        //respContent = "第一个一级菜单的第二个二级菜单被点击！";  
                    } else if (eventKey.equals("click_13")) {  
                        respContent = "第一个一级菜单的第三个二级菜单被点击！";  
                    } else if (eventKey.equals("click_14")) {  
                        respContent = "第一个一级菜单的第四个二级菜单被点击！";  
                    } else if (eventKey.equals("click_15")) {  
                        respContent = "第一个一级菜单的第五个二级菜单被点击！";  
                    } else if (eventKey.equals("click_21")) {  
                        respContent = "第二个一级菜单的第一个二级菜单被点击！";  
                    } else if (eventKey.equals("click_22")) {  
                        respContent = "第二个一级菜单的第二个二级菜单被点击！";  
                    } else if (eventKey.equals("click_23")) {  
                        respContent = "第二个一级菜单的第三个二级菜单被点击！";  
                    } else if (eventKey.equals("click_24")) {  
                        respContent = "第二个一级菜单的第四个二级菜单被点击！";  
                    } else if (eventKey.equals("click_25")) {  
                        respContent = "第二个一级菜单的第五个二级菜单被点击！";  
                    } else if (eventKey.equals("click_31")) {  
                        respContent = "第三个一级菜单的第一个二级菜单被点击！";  
                    } else if (eventKey.equals("click_32")) {  
                        respContent = "第三个一级菜单的第二个二级菜单被点击！";  
                    } else if (eventKey.equals("click_33")) {  
                        respContent = "第三个一级菜单的第三个二级菜单被点击！";  
                    } else if (eventKey.equals("click_34")) {  
                        respContent = "第三个一级菜单的第四个二级菜单被点击！"; 
                        
                    } else if (eventKey.equals("click_35")) {  
                        respContent = "第三个一级菜单的第五个二级菜单被点击！";
                        
                    }else if(eventKey.equals("click_2")){
                    	// 创建图文消息  
                        NewsMessage newsMessage = new NewsMessage();  
                        newsMessage.setToUserName(fromUserName);  
                        newsMessage.setFromUserName(toUserName);  
                        newsMessage.setCreateTime(new Date().getTime());  
                        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
                        newsMessage.setFuncFlag(0); 
                        
                        List<Article> articleList = new ArrayList<Article>(); 
                    	
                        Article article = new Article();  
                        article.setTitle("微信公众帐号开发Java版");  
                        article.setDescription("尤勇贵，微信公众帐号开发入门。此账号为学习测试号！");  
                        article.setPicUrl("");  
                        article.setUrl("http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E7%AE%80%E7%AC%94%E7%94%BB&step_word=&pn=2&spn=0&di=0&pi=&rn=1&tn=baiduimagedetail&is=&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=-1&cs=3337867571%2C2865511365&os=1181997012%2C1632309485&adpicid=0&ln=1000&fr=&fmq=1442223698913_R&ic=0&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=&bdtype=-1&objurl=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201312%2F22%2F20131222171841_ACnHw.thumb.600_0.jpeg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3B17tpwg2_z%26e3Bv54AzdH3Frj5rsjAzdH3F4ks52AzdH3F88c9ac0ccAzdH3F1jpwtsAzdH3F&gsm=0");  
                        articleList.add(article);  
                        // 设置图文消息个数  
                        newsMessage.setArticleCount(articleList.size());  
                        // 设置图文消息包含的图文集合  
                        newsMessage.setArticles(articleList);  
                        // 将图文消息对象转换成xml字符串  
                        respMessage = MessageUtil.newsMessageToXml(newsMessage);
                        return respMessage;
                    }
                }  
            }  
  
            textMessage.setContent(respContent);  
            respMessage = MessageUtil.textMessageToXml(textMessage); 
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return respMessage;  
	}

	/**
	 * emoji表情转换(hex -> utf-16)
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}
}
