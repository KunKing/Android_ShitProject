package com.edu.android_shitproject.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ming on 2015/12/30.
 */
public class ShitCommentsEntity {

    /**
     * count : 30
     * items : [{"liked":false,"floor":1,"created_at":1451395160,"content":"一楼！妹子哪里的？","like_count":4,"user":{"last_visited_at":1411113595,"created_at":1411113595,"last_device":"android_3.3.1","email":"","state":"active","role":"n","login":"爱抽555","id":20878847,"icon":"20141027182307.jpg"},"id":346400166},{"liked":false,"floor":2,"created_at":1451397918,"content":"不是共匪太狡猾 是我军太无能","like_count":7,"user":{"last_visited_at":1357214485,"created_at":1357214485,"last_device":"web","email":"409173790@qq.com","state":"pending","role":"n","login":"不要逼我啊啊","id":5563281,"icon":"20150331191605.jpg"},"id":346404007},{"liked":false,"floor":3,"created_at":1451399297,"content":"回一楼 我媳妇\u2026","like_count":4,"user":{"last_visited_at":1426422101,"created_at":1426422101,"last_device":"android_6.4.0","email":"","state":"active","role":"n","login":"静静是我的！！","id":26628202,"icon":"20151204234805.jpg"},"id":346406125},{"liked":false,"floor":4,"created_at":1451399484,"content":"东莞的？","like_count":1,"user":{"last_visited_at":1409186057,"created_at":1409186057,"last_device":"android_3.2.1","email":"","state":"active","role":"n","login":"搜狗五笔","id":19983079,"icon":"20150317230904.jpg"},"id":346406411},{"liked":false,"floor":5,"created_at":1451399811,"content":"回去后你老爸要遭殃了吧！","like_count":0,"user":{"last_visited_at":1405670183,"created_at":1405670183,"last_device":"android_3.0.2","email":"","state":"active","role":"n","login":"π不疯魔怎成佛","id":18010937,"icon":"20151226231424.jpg"},"id":346406922},{"liked":false,"floor":6,"created_at":1451400029,"content":"没男朋友的话我们在一起吧","like_count":1,"user":{"last_visited_at":1418680293,"created_at":1418680293,"last_device":"android_4.0.0","email":"","state":"active","role":"n","login":"始于行，止于心","id":23829103,"icon":"20151123003643.jpg"},"id":346407248},{"liked":false,"floor":7,"created_at":1451400265,"content":"难道你不知道有一种联系叫电话吗？","like_count":0,"user":{"last_visited_at":1374406635,"created_at":1374406635,"last_device":"android_2.5.2","email":"","state":"active","role":"n","login":"：不良人？","id":10158373,"icon":"20151108163233.jpg"},"id":346407641},{"liked":false,"floor":8,"created_at":1451400597,"content":"回复 7楼：那如果楼主的妈妈把自己手机放进包里，而楼主刚好没带手机呢→_→","like_count":0,"user":{"last_visited_at":1448632869,"created_at":1448632869,"last_device":"android_8.3.3","email":"","state":"active","role":"n","login":"老夫大神","id":30691793,"icon":"20151127140109.jpg"},"id":346408186},{"liked":false,"floor":9,"created_at":1451400933,"content":"出墙，肏不死你","like_count":2,"user":{"last_visited_at":1340278625,"created_at":1340278625,"last_device":"android_1.3.2","email":"975587779@qq.com","state":"bonding","role":"n","login":"蹲坑斗蛆蛆","id":2233965,"icon":""},"id":346408755},{"liked":false,"floor":10,"created_at":1451401570,"content":"这情况你母上大人只是晚一天买而已，少年，你还是太年轻啊～","like_count":5,"user":{"last_visited_at":1433044661,"created_at":1433044661,"last_device":"android_7.0.0","email":"187836@qq.com","state":"bonded","role":"n","login":"这张是假币","id":28723636,"icon":"20151012194513.jpg"},"id":346409720},{"liked":false,"floor":11,"created_at":1451401683,"content":"楼主，好喜欢你！","like_count":0,"user":{"last_visited_at":1435539406,"created_at":1435539406,"last_device":"android_7.1.1","email":"","state":"active","role":"n","login":"阡陌\u2026\u2026","id":29180238,"icon":"20150629005646.jpg"},"id":346409879},{"liked":false,"floor":12,"created_at":1451402202,"content":"没手机么？","like_count":0,"user":{"last_visited_at":1450135412,"created_at":1450135412,"last_device":"android_8.4.0","email":"","state":"active","role":"n","login":"二货糗百帮","id":30785832,"icon":"20151214232333.jpg"},"id":346410670},{"liked":false,"floor":13,"created_at":1451403174,"content":"求落地","like_count":0,"user":{"last_visited_at":1450828542,"created_at":1450828542,"last_device":"android_8.4.0","email":"","state":"active","role":"n","login":"木木岛主","id":30829869,"icon":"20151222235542.jpg"},"id":346412112},{"liked":false,"floor":14,"created_at":1451403513,"content":"出墙我就采你","like_count":0,"user":{"last_visited_at":1397202370,"created_at":1397202370,"last_device":"android_2.8.2","email":"jiuxingzhuyue@foxmail.com","state":"bonding","role":"n","login":"墙外采红杏","id":15504749,"icon":"20150211105619.jpg"},"id":346412578},{"liked":false,"floor":15,"created_at":1451403572,"content":"眼睛好灵光","like_count":0,"user":{"last_visited_at":1409962173,"created_at":1409962173,"last_device":"android_3.2.1","email":"","state":"active","role":"n","login":"繁荣残香焚月影、","id":20310775,"icon":"20151204122930.jpg"},"id":346412668},{"liked":false,"floor":16,"created_at":1451404256,"content":"看到你名字我才进来评论的","like_count":1,"user":{"last_visited_at":1415343496,"created_at":1415343496,"last_device":"android_3.4.2","email":"","state":"active","role":"n","login":"别人老婆似娇妻i","id":22454303,"icon":"nopic.jpg"},"id":346413616},{"liked":false,"floor":17,"created_at":1451405480,"content":"死穷鬼老婆想卖一件衣服都不行吗 要是我妈喜欢我爸倾家荡产给她卖","like_count":0,"user":{"last_visited_at":1415949986,"created_at":1415949986,"last_device":"web","email":"878468377@qq.com","state":"bonded","role":"n","login":"苏菲卫生鲸","id":22675329,"icon":"20141114164832.jpg"},"id":346415081},{"liked":false,"floor":18,"created_at":1451406463,"content":"呵呵","like_count":0,"user":{"last_visited_at":1378612463,"created_at":1378612463,"last_device":"android_2.6","email":"","state":"active","role":"n","login":"非洲难民营里的土肥圆","id":11147625,"icon":"20130908201950.jpg"},"id":346415987},{"liked":false,"floor":19,"created_at":1451406685,"content":"头像很好看","like_count":0,"user":{"last_visited_at":1437227893,"created_at":1437227893,"last_device":"ios_6.9.6","email":"","state":"active","role":"n","login":"1蓝色阿呆","id":29474356,"icon":"20150718135813.jpg"},"id":346416181},{"liked":false,"floor":20,"created_at":1451406968,"content":"哈哈","like_count":0,"user":{"last_visited_at":1391529234,"created_at":1391529234,"last_device":"web","email":"931886844@qq.com","state":"bonded","role":"n","login":"走过荒原","id":13951454,"icon":"20150920195335.jpg"},"id":346416437},{"liked":false,"floor":21,"created_at":1451408090,"content":"手动点赞","like_count":0,"user":{"last_visited_at":1380642878,"created_at":1380642878,"last_device":"ios_2.6.2","email":"","state":"active","role":"n","login":"脾气不好爱较真","id":11530419,"icon":"20151220094418.jpg"},"id":346417315},{"liked":false,"floor":22,"created_at":1451408245,"content":"坐墙头等红杏。","like_count":0,"user":{"last_visited_at":1443798765,"created_at":1443798765,"last_device":"android_8.1.2","email":"","state":"active","role":"n","login":"昨日依山尽，","id":30381297,"icon":"20151002151245.jpg"},"id":346417407},{"liked":false,"floor":23,"created_at":1451409350,"content":"回复 17楼：额，信息量好大","like_count":0,"user":{"last_visited_at":1447479298,"created_at":1447479298,"last_device":"android_8.3.3","email":"","state":"active","role":"n","login":"狂奔哒蜗牛","id":30615840,"icon":"20151114053458.jpg"},"id":346418110},{"liked":false,"floor":24,"created_at":1451409722,"content":"楼主想出墙，请来找我","like_count":0,"user":{"last_visited_at":1436267433,"created_at":1436267433,"last_device":"android_7.1.1","email":"","state":"active","role":"n","login":"葑心鎖情","id":29302346,"icon":"20150722235959.jpg"},"id":346418311},{"liked":false,"floor":25,"created_at":1451410658,"content":"哈哈。 机智的老爸","like_count":0,"user":{"last_visited_at":1423961925,"created_at":1423961925,"last_device":"ios_6.0.1","email":"","state":"active","role":"n","login":"活在當下'","id":25680586,"icon":"20150411200715.jpg"},"id":346418849},{"liked":false,"floor":26,"created_at":1451411088,"content":"老的辣，我同意","like_count":0,"user":{"last_visited_at":1450482519,"created_at":1450482519,"last_device":"android_8.4.0","email":"","state":"active","role":"n","login":"我是供佛的水","id":30807770,"icon":"20151218234839.jpg"},"id":346419097},{"liked":false,"floor":27,"created_at":1451411215,"content":"你老爸让警察逮走啦","like_count":0,"user":{"last_visited_at":1379101238,"created_at":1379101238,"last_device":"ios_2.6","email":"","state":"active","role":"n","login":"万人日不倒","id":11245207,"icon":"20141219223703.jpg"},"id":346419167},{"liked":false,"floor":28,"created_at":1451412411,"content":"我墙角等红杏。。。","like_count":0,"user":{"last_visited_at":1418143780,"created_at":1418143780,"last_device":"android_4.0.0","email":"","state":"active","role":"n","login":"标准十八公分。！","id":23634591,"icon":"20151225231123.jpg"},"id":346419701},{"liked":false,"floor":29,"created_at":1451422892,"content":"同城呦","like_count":0,"user":{"last_visited_at":1379062470,"created_at":1379062470,"last_device":"android_2.3.1","email":"","state":"active","role":"n","login":"精彩加载中","id":11237884,"icon":"20150604180548.jpg"},"id":346422335},{"liked":false,"floor":30,"created_at":1451424631,"content":"红杏准备好了么？","like_count":0,"user":{"last_visited_at":1428335253,"created_at":1428335253,"last_device":"android_6.5.0","email":"","state":"active","role":"n","login":"真心，不好起","id":27369198,"icon":"20150406234733.jpg"},"id":346422714}]
     * total : 107
     * page : 1
     * err : 0
     */
    @SerializedName("count")
    private int count;
    @SerializedName("total")
    private int total;
    @SerializedName("page")
    private int page;
    @SerializedName("err")
    private int err;
    /**
     * liked : false
     * floor : 1
     * created_at : 1451395160
     * content : 一楼！妹子哪里的？
     * like_count : 4
     * user : {"last_visited_at":1411113595,"created_at":1411113595,"last_device":"android_3.3.1","email":"","state":"active","role":"n","login":"爱抽555","id":20878847,"icon":"20141027182307.jpg"}
     * id : 346400166
     */
    @SerializedName("items")
    private List<ItemsEntity> items;

    public void setCount(int count) {
        this.count = count;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public int getErr() {
        return err;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

    public static class ItemsEntity {
        @SerializedName("liked")
        private boolean liked;
        @SerializedName("floor")
        private int floor;
        @SerializedName("created_at")
        private int created_at;
        @SerializedName("content")
        private String content;
        @SerializedName("like_count")
        private int like_count;
        /**
         * last_visited_at : 1411113595
         * created_at : 1411113595
         * last_device : android_3.3.1
         * email :
         * state : active
         * role : n
         * login : 爱抽555
         * id : 20878847
         * icon : 20141027182307.jpg
         */

        private UserEntity user;
        private int id;

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isLiked() {
            return liked;
        }

        public int getFloor() {
            return floor;
        }

        public int getCreated_at() {
            return created_at;
        }

        public String getContent() {
            return content;
        }

        public int getLike_count() {
            return like_count;
        }

        public UserEntity getUser() {
            return user;
        }

        public int getId() {
            return id;
        }

        public static class UserEntity {
            @SerializedName("last_visited_at")
            private int last_visited_at;
            @SerializedName("created_at")
            private int created_at;
            @SerializedName("last_device")
            private String last_device;
            @SerializedName("email")
            private String email;
            @SerializedName("state")
            private String state;
            @SerializedName("role")
            private String role;
            @SerializedName("login")
            private String login;
            @SerializedName("id")
            private int id;
            @SerializedName("icon")
            private String icon;

            public void setLast_visited_at(int last_visited_at) {
                this.last_visited_at = last_visited_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public void setLast_device(String last_device) {
                this.last_device = last_device;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public void setState(String state) {
                this.state = state;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public void setLogin(String login) {
                this.login = login;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public int getLast_visited_at() {
                return last_visited_at;
            }

            public int getCreated_at() {
                return created_at;
            }

            public String getLast_device() {
                return last_device;
            }

            public String getEmail() {
                return email;
            }

            public String getState() {
                return state;
            }

            public String getRole() {
                return role;
            }

            public String getLogin() {
                return login;
            }

            public int getId() {
                return id;
            }

            public String getIcon() {
                return icon;
            }
        }
    }
}
