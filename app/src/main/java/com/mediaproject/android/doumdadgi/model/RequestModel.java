package com.mediaproject.android.doumdadgi.model;

import java.util.ArrayList;

public class RequestModel {
    private ArrayList<Request> requests;

    public RequestModel() {
        this.requests = new ArrayList<>();
        setRequestDummyData();
    }

    public ArrayList<Request> getRequests() {
        return this.requests;
    }

    private void setRequestDummyData() {
        Request request1 = new Request();
        request1.setRequestInfo(new ClassInfo("프랑코포니 예술", "다106", "손정훈", "월C 수C"));
        request1.setClient("이서연");
        requests.add(request1);

        Request request2 = new Request();
        request2.setRequestInfo(new ClassInfo("실용영어 연습", "다106", "이혜경", "화F 목E"));
        request2.setClient("이서연");
        requests.add(request2);

        Request request3 = new Request();
        request3.setRequestInfo(new ClassInfo("심리학이란 무엇인가?", "율359", "김영진", "월C 수C"));
        request3.setClient("이서연");
        requests.add(request3);

        Request request4 = new Request();
        request4.setRequestInfo(new ClassInfo("현대의 시민 생활과 법", "연105", "이승길", "화F 목E"));
        request4.setClient("이서연");
        requests.add(request4);

        Request request5 = new Request();
        request5.setRequestInfo(new ClassInfo("윤리란 무엇인가", "성105", "정경훈", "화D 목C"));
        request5.setClient("이서연");
        requests.add(request5);

        Request request6 = new Request();
        request6.setRequestInfo(new ClassInfo("일본 사회와 문화", "율259", "박은영", "월A 수A"));
        request6.setClient("이서연");
        requests.add(request6);

        Request request7 = new Request();
        request7.setRequestInfo(new ClassInfo("정치체제론", "율358-1","강신구", "월B 목B"));
        request7.setClient("이서연");
        requests.add(request7);
    }
}
