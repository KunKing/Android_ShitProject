package com.edu.android_shitproject.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ming on 2015/12/29.
 */
public class ShitItem {


    @SerializedName("count")
    private int count;
    @SerializedName("err")
    private int err;
    @SerializedName("total")
    private int total;
    @SerializedName("page")
    private int page;
    @SerializedName("refresh")
    private int refresh;

    @SerializedName("items")
    private List<ItemsEntity> items;

    public void setCount(int count) {
        this.count = count;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setRefresh(int refresh) {
        this.refresh = refresh;
    }

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public int getErr() {
        return err;
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public int getRefresh() {
        return refresh;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

    // items
    public static class ItemsEntity {

        @SerializedName("high_url")
        private String high_url;
        @SerializedName("format")
        private String format;
        @SerializedName("image")
        private Object image;
        @SerializedName("published_at")
        private int published_at;
        @SerializedName("tag")
        private String tag;
        /**
         * avatar_updated_at : 1451392978
         * last_visited_at : 1327836426
         * created_at : 1327836426
         * state : active
         * email :
         * last_device : ios_1.0
         * role : n
         * login : 潇湘墨兰
         * id : 441420
         * icon : 20151229124258.jpg
         */
        @SerializedName("user")
        private UserEntity user;
        @SerializedName("image_size")
        private Object image_size;
        @SerializedName("id")
        private int id;
        /**
         * down : -429
         * up : 17320
         */
        @SerializedName("votes")
        private VotesEntity votes;
        @SerializedName("created_at")
        private int created_at;
        @SerializedName("pic_url")
        private String pic_url;
        @SerializedName("content")
        private String content;
        @SerializedName("state")
        private String state;
        @SerializedName("comments_count")
        private int comments_count;
        @SerializedName("low_url")
        private String low_url;
        @SerializedName("allow_comment")
        private boolean allow_comment;
        @SerializedName("share_count")
        private int share_count;
        @SerializedName("type")
        private String type;
        @SerializedName("loop")
        private long loop;

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }
        public String getLow_url() {
            return low_url;
        }

        public void setLow_url(String low_url) {
            this.low_url = low_url;
        }

        public String getHigh_url() {
            return high_url;
        }

        public void setHigh_url(String high_url) {
            this.high_url = high_url;
        }

        public long getLoop() {
            return loop;
        }

        public void setLoop(long loop) {
            this.loop = loop;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public void setPublished_at(int published_at) {
            this.published_at = published_at;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public void setImage_size(Object image_size) {
            this.image_size = image_size;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setVotes(VotesEntity votes) {
            this.votes = votes;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public void setAllow_comment(boolean allow_comment) {
            this.allow_comment = allow_comment;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFormat() {
            return format;
        }

        public Object getImage() {
            return image;
        }

        public int getPublished_at() {
            return published_at;
        }

        public String getTag() {
            return tag;
        }

        public UserEntity getUser() {
            return user;
        }

        public Object getImage_size() {
            return image_size;
        }

        public int getId() {
            return id;
        }

        public VotesEntity getVotes() {
            return votes;
        }

        public int getCreated_at() {
            return created_at;
        }

        public String getContent() {
            return content;
        }

        public String getState() {
            return state;
        }

        public int getComments_count() {
            return comments_count;
        }

        public boolean isAllow_comment() {
            return allow_comment;
        }

        public int getShare_count() {
            return share_count;
        }

        public String getType() {
            return type;
        }

        public static class UserEntity {
            @SerializedName("avatar_updated_at")
            private int avatar_updated_at;
            @SerializedName("last_visited_at")
            private int last_visited_at;
            @SerializedName("created_at")
            private int created_at;
            @SerializedName("state")
            private String state;

            @SerializedName("email")
            private String email;
            @SerializedName("last_device")
            private String last_device;
            @SerializedName("role")
            private String role;
            @SerializedName("login")
            private String login;
            @SerializedName("id")
            private int id;
            @SerializedName("icon")
            private String icon;



            public void setAvatar_updated_at(int avatar_updated_at) {
                this.avatar_updated_at = avatar_updated_at;
            }

            public void setLast_visited_at(int last_visited_at) {
                this.last_visited_at = last_visited_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public void setState(String state) {
                this.state = state;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public void setLast_device(String last_device) {
                this.last_device = last_device;
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

            public int getAvatar_updated_at() {
                return avatar_updated_at;
            }

            public int getLast_visited_at() {
                return last_visited_at;
            }

            public int getCreated_at() {
                return created_at;
            }

            public String getState() {
                return state;
            }

            public String getEmail() {
                return email;
            }

            public String getLast_device() {
                return last_device;
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

        public static class VotesEntity {
            @SerializedName("down")
            private int down;
            @SerializedName("up")
            private int up;

            public void setDown(int down) {
                this.down = down;
            }

            public void setUp(int up) {
                this.up = up;
            }

            public int getDown() {
                return down;
            }

            public int getUp() {
                return up;
            }
        }
    }
}
