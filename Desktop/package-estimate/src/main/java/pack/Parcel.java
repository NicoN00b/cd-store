package pack;

/**
 * Created by Guest on 7/31/17.
 */
public class Parcel {
    public float weight;
    public float height;
    public float width;
    public float depth;
    public float volume;
    public float totalCost;
    public float shippingCost;
    public float wrappingCost;

    public Parcel (float weight, float height, float width, float depth) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.wrappingCost = 0;
    }

    public float costToShip() {
        volume = height * width * depth;
        shippingCost = 1 + (volume/20) + (weight/8);
        return shippingCost;
    }

    public float costToWrap() {
        wrappingCost = (height + depth + width)/4;
        return wrappingCost;
    }

    public float totalCost() {
        totalCost = wrappingCost + shippingCost;
        return totalCost;
    }

//    public float Volume(float height, float width, float depth){
//        return this.height * this.width * this.depth;
//    }

}
