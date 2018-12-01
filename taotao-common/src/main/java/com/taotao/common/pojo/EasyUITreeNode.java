package com.taotao.common.pojo;



public class EasyUITreeNode {
    /**
     * state :节点状态   open或者close
     * id：绑定节点的标识符
     * text ：显示的节点文本
     */

    private long id;
    private String state;
    private String text;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
