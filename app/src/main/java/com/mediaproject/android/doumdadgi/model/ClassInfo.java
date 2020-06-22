package com.mediaproject.android.doumdadgi.model;

public class ClassInfo {
    private String lecture_name;
    private String classroom;
    private String professor;
    private String schedule;

    public ClassInfo() { }

    public ClassInfo(String lecture_name, String classroom, String professor, String schedule) {
        this.lecture_name   = lecture_name;
        this.classroom      = classroom;
        this.professor      = professor;
        this.schedule       = schedule;
    }

    public String getLectureName() {
        return lecture_name;
    }
    public String getClassroom() {
        return classroom;
    }
    public String getProfessor() {
        return professor;
    }
    public String getSchedule() {
        return schedule;
    }

    public void setLectureName(String name) { this.lecture_name = name; }
    public void setClassroom(String classroom) { this.classroom = classroom; }
    public void setProfessor(String professor) { this.professor = professor; }
    public void setSchedule(String schedule) { this.schedule = schedule; }
}
