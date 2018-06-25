package com.aaa.mvpapp.bean;

import com.aaa.mvpapp.bean.Res;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 网络数据结果类
 */
public class MainRes  extends Res {

    /**
     * data : {"scrollpic":["data/upfiles/images/2015-07/31/1_scrollpic_new_1438327122777.png","data/upfiles/images/2015-04/16/1_scrollpic_new_1429163174767.jpg"],"allcount":"10000.00","repay_interest_all":"150.00","recommend":[{"id":"1","user_id":"7082","status":"3","borrow_status":"1","account":"10000.00","borrow_account_yes":"10000.00","borrow_full_status":"1","repay_account_yes":"5000.00","borrow_account_wait":"0.00","borrow_period":"1","name":"56522002","borrow_nid":"20160700001","borrow_apr":"21.6","borrow_type":"day","repay_account_wait":"2000.00","newtype":"1","recommend":"1","borrow_end_time":"1533623820","part_status":"0","mark":"还款中","borrow_period_name":"1天"}],"hot":[{"id":"2","user_id":"7082","status":"1","borrow_status":"1","account":"2000.00","borrow_account_yes":"2000.00","borrow_full_status":"1","repay_account_yes":"0.00","borrow_account_wait":"0.00","borrow_period":"4","name":"租房123456","borrow_nid":"20160700002","borrow_apr":"21.6","borrow_type":"roam","repay_account_wait":"2150.00","newtype":"2","recommend":"2","borrow_end_time":"1533623820","part_status":"0","mark":"去投资","borrow_period_name":"4个月"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * scrollpic : ["data/upfiles/images/2015-07/31/1_scrollpic_new_1438327122777.png","data/upfiles/images/2015-04/16/1_scrollpic_new_1429163174767.jpg"]
         * allcount : 10000.00
         * repay_interest_all : 150.00
         * recommend : [{"id":"1","user_id":"7082","status":"3","borrow_status":"1","account":"10000.00","borrow_account_yes":"10000.00","borrow_full_status":"1","repay_account_yes":"5000.00","borrow_account_wait":"0.00","borrow_period":"1","name":"56522002","borrow_nid":"20160700001","borrow_apr":"21.6","borrow_type":"day","repay_account_wait":"2000.00","newtype":"1","recommend":"1","borrow_end_time":"1533623820","part_status":"0","mark":"还款中","borrow_period_name":"1天"}]
         * hot : [{"id":"2","user_id":"7082","status":"1","borrow_status":"1","account":"2000.00","borrow_account_yes":"2000.00","borrow_full_status":"1","repay_account_yes":"0.00","borrow_account_wait":"0.00","borrow_period":"4","name":"租房123456","borrow_nid":"20160700002","borrow_apr":"21.6","borrow_type":"roam","repay_account_wait":"2150.00","newtype":"2","recommend":"2","borrow_end_time":"1533623820","part_status":"0","mark":"去投资","borrow_period_name":"4个月"}]
         */

        private String allcount;//累计交易总额
        private String repay_interest_all;//累计为投资人赚取收益
        private List<String> scrollpic; //轮播图
        private List<RecommendBean> recommend;  //推荐产品
        private List<HotBean> hot;      //热销产品

        public String getAllcount() {
            return allcount;
        }

        public void setAllcount(String allcount) {
            this.allcount = allcount;
        }

        public String getRepay_interest_all() {
            return repay_interest_all;
        }

        public void setRepay_interest_all(String repay_interest_all) {
            this.repay_interest_all = repay_interest_all;
        }

        public List<String> getScrollpic() {
            return scrollpic;
        }

        public void setScrollpic(List<String> scrollpic) {
            this.scrollpic = scrollpic;
        }

        public List<RecommendBean> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<RecommendBean> recommend) {
            this.recommend = recommend;
        }

        public List<HotBean> getHot() {
            return hot;
        }

        public void setHot(List<HotBean> hot) {
            this.hot = hot;
        }

        public static class RecommendBean {
            /**
             * id : 1
             * user_id : 7082
             * status : 3
             * borrow_status : 1
             * account : 10000.00
             * borrow_account_yes : 10000.00
             * borrow_full_status : 1
             * repay_account_yes : 5000.00
             * borrow_account_wait : 0.00
             * borrow_period : 1
             * name : 56522002
             * borrow_nid : 20160700001
             * borrow_apr : 21.6
             * borrow_type : day
             * repay_account_wait : 2000.00
             * newtype : 1
             * recommend : 1
             * borrow_end_time : 1533623820
             * part_status : 0
             * mark : 还款中
             * borrow_period_name : 1天
             */

            private String id;
            private String user_id;
            @SerializedName("status")
            private String statusX;
            private String borrow_status;
            private String account;
            private String borrow_account_yes;
            private String borrow_full_status;
            private String repay_account_yes;
            private String borrow_account_wait;
            private String borrow_period;
            private String name;
            private String borrow_nid;
            private String borrow_apr;
            private String borrow_type;
            private String repay_account_wait;
            private String newtype;
            private String recommend;
            private String borrow_end_time;
            private String part_status;
            private String mark;
            private String borrow_period_name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getStatusX() {
                return statusX;
            }

            public void setStatusX(String statusX) {
                this.statusX = statusX;
            }

            public String getBorrow_status() {
                return borrow_status;
            }

            public void setBorrow_status(String borrow_status) {
                this.borrow_status = borrow_status;
            }

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getBorrow_account_yes() {
                return borrow_account_yes;
            }

            public void setBorrow_account_yes(String borrow_account_yes) {
                this.borrow_account_yes = borrow_account_yes;
            }

            public String getBorrow_full_status() {
                return borrow_full_status;
            }

            public void setBorrow_full_status(String borrow_full_status) {
                this.borrow_full_status = borrow_full_status;
            }

            public String getRepay_account_yes() {
                return repay_account_yes;
            }

            public void setRepay_account_yes(String repay_account_yes) {
                this.repay_account_yes = repay_account_yes;
            }

            public String getBorrow_account_wait() {
                return borrow_account_wait;
            }

            public void setBorrow_account_wait(String borrow_account_wait) {
                this.borrow_account_wait = borrow_account_wait;
            }

            public String getBorrow_period() {
                return borrow_period;
            }

            public void setBorrow_period(String borrow_period) {
                this.borrow_period = borrow_period;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getBorrow_nid() {
                return borrow_nid;
            }

            public void setBorrow_nid(String borrow_nid) {
                this.borrow_nid = borrow_nid;
            }

            public String getBorrow_apr() {
                return borrow_apr;
            }

            public void setBorrow_apr(String borrow_apr) {
                this.borrow_apr = borrow_apr;
            }

            public String getBorrow_type() {
                return borrow_type;
            }

            public void setBorrow_type(String borrow_type) {
                this.borrow_type = borrow_type;
            }

            public String getRepay_account_wait() {
                return repay_account_wait;
            }

            public void setRepay_account_wait(String repay_account_wait) {
                this.repay_account_wait = repay_account_wait;
            }

            public String getNewtype() {
                return newtype;
            }

            public void setNewtype(String newtype) {
                this.newtype = newtype;
            }

            public String getRecommend() {
                return recommend;
            }

            public void setRecommend(String recommend) {
                this.recommend = recommend;
            }

            public String getBorrow_end_time() {
                return borrow_end_time;
            }

            public void setBorrow_end_time(String borrow_end_time) {
                this.borrow_end_time = borrow_end_time;
            }

            public String getPart_status() {
                return part_status;
            }

            public void setPart_status(String part_status) {
                this.part_status = part_status;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public String getBorrow_period_name() {
                return borrow_period_name;
            }

            public void setBorrow_period_name(String borrow_period_name) {
                this.borrow_period_name = borrow_period_name;
            }
        }

        public static class HotBean {
            /**
             * id : 2
             * user_id : 7082
             * status : 1
             * borrow_status : 1
             * account : 2000.00
             * borrow_account_yes : 2000.00
             * borrow_full_status : 1
             * repay_account_yes : 0.00
             * borrow_account_wait : 0.00
             * borrow_period : 4
             * name : 租房123456
             * borrow_nid : 20160700002
             * borrow_apr : 21.6
             * borrow_type : roam
             * repay_account_wait : 2150.00
             * newtype : 2
             * recommend : 2
             * borrow_end_time : 1533623820
             * part_status : 0
             * mark : 去投资
             * borrow_period_name : 4个月
             */

            private String id;
            private String user_id;
            @SerializedName("status")
            private String statusX;
            private String borrow_status;
            private String account;
            private String borrow_account_yes;
            private String borrow_full_status;
            private String repay_account_yes;
            private String borrow_account_wait;
            private String borrow_period;
            private String name;
            private String borrow_nid;
            private String borrow_apr;
            private String borrow_type;
            private String repay_account_wait;
            private String newtype;
            private String recommend;
            private String borrow_end_time;
            private String part_status;
            private String mark;
            private String borrow_period_name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getStatusX() {
                return statusX;
            }

            public void setStatusX(String statusX) {
                this.statusX = statusX;
            }

            public String getBorrow_status() {
                return borrow_status;
            }

            public void setBorrow_status(String borrow_status) {
                this.borrow_status = borrow_status;
            }

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getBorrow_account_yes() {
                return borrow_account_yes;
            }

            public void setBorrow_account_yes(String borrow_account_yes) {
                this.borrow_account_yes = borrow_account_yes;
            }

            public String getBorrow_full_status() {
                return borrow_full_status;
            }

            public void setBorrow_full_status(String borrow_full_status) {
                this.borrow_full_status = borrow_full_status;
            }

            public String getRepay_account_yes() {
                return repay_account_yes;
            }

            public void setRepay_account_yes(String repay_account_yes) {
                this.repay_account_yes = repay_account_yes;
            }

            public String getBorrow_account_wait() {
                return borrow_account_wait;
            }

            public void setBorrow_account_wait(String borrow_account_wait) {
                this.borrow_account_wait = borrow_account_wait;
            }

            public String getBorrow_period() {
                return borrow_period;
            }

            public void setBorrow_period(String borrow_period) {
                this.borrow_period = borrow_period;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getBorrow_nid() {
                return borrow_nid;
            }

            public void setBorrow_nid(String borrow_nid) {
                this.borrow_nid = borrow_nid;
            }

            public String getBorrow_apr() {
                return borrow_apr;
            }

            public void setBorrow_apr(String borrow_apr) {
                this.borrow_apr = borrow_apr;
            }

            public String getBorrow_type() {
                return borrow_type;
            }

            public void setBorrow_type(String borrow_type) {
                this.borrow_type = borrow_type;
            }

            public String getRepay_account_wait() {
                return repay_account_wait;
            }

            public void setRepay_account_wait(String repay_account_wait) {
                this.repay_account_wait = repay_account_wait;
            }

            public String getNewtype() {
                return newtype;
            }

            public void setNewtype(String newtype) {
                this.newtype = newtype;
            }

            public String getRecommend() {
                return recommend;
            }

            public void setRecommend(String recommend) {
                this.recommend = recommend;
            }

            public String getBorrow_end_time() {
                return borrow_end_time;
            }

            public void setBorrow_end_time(String borrow_end_time) {
                this.borrow_end_time = borrow_end_time;
            }

            public String getPart_status() {
                return part_status;
            }

            public void setPart_status(String part_status) {
                this.part_status = part_status;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public String getBorrow_period_name() {
                return borrow_period_name;
            }

            public void setBorrow_period_name(String borrow_period_name) {
                this.borrow_period_name = borrow_period_name;
            }
        }
    }
}
