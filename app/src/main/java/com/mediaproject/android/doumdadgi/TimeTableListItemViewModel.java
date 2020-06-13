package com.mediaproject.android.doumdadgi;

public class TimeTableListItemViewModel {
    private String lecture_name;
    private String classroom;
    private String professor;
    private String schedule;

    public TimeTableListItemViewModel(String lecture_name, String classroom, String professor, String schedule) {
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
}
