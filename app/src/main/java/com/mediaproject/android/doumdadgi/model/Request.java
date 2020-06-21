package com.mediaproject.android.doumdadgi.model;

public class Request {
    private boolean isClassRequest;
    private boolean isMatched;
    private ClassInfo requestInfo;
    private String client;

    public Request() {
        this.isClassRequest = true;
        this.isMatched = false;
    }

    public Request(boolean isClassRequest, boolean isMatched, ClassInfo requestInfo, String client) {
        this.isClassRequest = isClassRequest;
        this.isMatched = isMatched;
        this.requestInfo = requestInfo;
        this.client = client;
    }

    public ClassInfo getRequestInfo() { return this.requestInfo; }
    public String getRequestTitle() { return this.requestInfo.getLectureName(); }
    public String getRequestProfessor() { return this.requestInfo.getProfessor(); }
    public String getRequestLocation() { return this.requestInfo.getClassroom(); }
    public String getRequesSchedule() { return this.requestInfo.getSchedule(); }
    public String getClient() { return this.client; }

    public void setMatched(boolean matched) {
        this.isMatched = matched;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setRequestInfo(ClassInfo requestInfo) {
        this.requestInfo = requestInfo;
    }
}