package com.bwei.day_07.bean;

import java.util.List;

public class UserBean {
    private String code;
    private Data data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data{
         private List<Mydata> auto;

        public List<Mydata> getAuto() {
            return auto;
        }

        public void setAuto(List<Mydata> auto) {
            this.auto = auto;
        }

        public class Mydata{
             private String title;
             private String unlikeReason;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUnlikeReason() {
                return unlikeReason;
            }

            public void setUnlikeReason(String unlikeReason) {
                this.unlikeReason = unlikeReason;
            }
        }
    }
}
