package co.laomag.es_spider.models;

/**
 * 统一返回消息类型
 */
public class RequestMessages {
    /**
     * 状态码
     */
    private int code;
    /**
     * 简单消息
     */
    private String message;
    /**
     * 数据
     */
    private Object content;


    public RequestMessages() {
    }

    public RequestMessages(int code, String message, Object content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    /**
     * 返回成功对象
     * @param data 数据
     * @return
     */
    public static RequestMessages success(Object data){
        RequestMessages requestMessages = new RequestMessages(200,"操作成功",data);
        return requestMessages;
    }

    /**
     * 不带数据的成功消息
     * @return
     */
    public static RequestMessages success(){
        RequestMessages requestMessages = new RequestMessages(200,"操作成功",null);
        return requestMessages;
    }

    /**
     * 固定返回4001 操作失败 消息自定义
     * @param message
     * @return
     */
    public static RequestMessages errorMsg(String message){
        RequestMessages requestMessages = new RequestMessages(4001,message,null);
        return requestMessages;

    }

    /**
     * 生成失败对象 自定一状态码意见消息
     * @param code
     * @param message
     * @return
     */
    public static RequestMessages errorMsg(int code,String message){
        RequestMessages requestMessages = new RequestMessages(code,message,null);
        return requestMessages;

    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
