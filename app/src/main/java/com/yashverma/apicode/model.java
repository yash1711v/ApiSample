package com.yashverma.apicode;

import java.util.ArrayList;

public class model {

     int  product_id;
     String name;
    Boolean in_stock;
    String product_url;
    String form;
    String image;
    ArrayList<manufacturer> mf;
    ArrayList<price> pr;
    static class manufacturer {
        String name;
        String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    static class price{
        int mrp;
        int final_price;
        int discount_perc;

        public int getMrp() {
            return mrp;
        }

        public void setMrp(int mrp) {
            this.mrp = mrp;
        }

        public int getFinal_price() {
            return final_price;
        }

        public void setFinal_price(int final_price) {
            this.final_price = final_price;
        }

        public int getDiscount_perc() {
            return discount_perc;
        }

        public void setDiscount_perc(int discount_perc) {
            this.discount_perc = discount_perc;
        }
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIn_stock() {
        return in_stock;
    }

    public void setIn_stock(Boolean in_stock) {
        this.in_stock = in_stock;
    }

    public String getProduct_url() {
        return product_url;
    }

    public void setProduct_url(String product_url) {
        this.product_url = product_url;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<manufacturer> getMf() {
        return mf;
    }

    public void setMf(ArrayList<manufacturer> mf) {
        this.mf = mf;
    }

    public ArrayList<price> getPr() {
        return pr;
    }

    public void setPr(ArrayList<price> pr) {
        this.pr = pr;
    }
}
