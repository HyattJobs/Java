package javanext.util;

import java.io.Serializable;

class Rectangle implements Serializable {
    private static final long serialVersionUID = 1710022455003682613L;
    private Integer width;
    private Integer height;
    private transient Integer area;

    public Rectangle(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        this.area = width * height;
    }

    public Rectangle(Integer width, Integer height, Integer area) {
        this.width = width;
        this.height = height;
        this.area = area;
    }

    public void setArea(){
        this.area = this.width * this.height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", area=" + area +
                '}';
    }
}

