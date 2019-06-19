package edu.polytech.myapplication.domain;

public class MainTarae {
    private String Tarae_Id;
    private String user_Id;
    private String Title;
    private String Content;
    private String date;

    private int viewCount;
    private int likeCOunt;

    public String getTarae_Id() {
        return Tarae_Id;
    }

    public void setTarae_Id(String tarae_Id) {
        Tarae_Id = tarae_Id;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getLikeCOunt() {
        return likeCOunt;
    }

    public void setLikeCOunt(int likeCOunt) {
        this.likeCOunt = likeCOunt;
    }
}
