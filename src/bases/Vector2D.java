package bases;

/**
 * Created by duyanh on 10/18/17.
 */
public class Vector2D {
    public float x;
    public float y;

    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }



    public void set(float x,float y){
        this.x = x;
        this.y = y;
    }

    public void set(Vector2D position) {
        this.set(position.x,position.y);
    }


    public Vector2D clone_v(){

        return new Vector2D(this.x,this.y);
    }

    public void addUp(float x, float y){

        this.x += x;
        this.y += y;
    }

    public void addUp(Vector2D vector2D){

       this.addUp(vector2D.x, vector2D.y);

    }
    public Vector2D add(float x, float y){
        return new Vector2D(this.x + x, this.y+y);

    }

    public Vector2D add(Vector2D vector2D){

        return add(vector2D.x, vector2D.y);
    }


    public void subtractBy(float x,float y){

        this.x -= x;
        this.y -= y;
    }

    public void subtractBy(Vector2D vector2D){
        subtractBy(vector2D.x, vector2D.y);
    }





    public Vector2D subtract(float x, float y){
        return new Vector2D(this.x - x, this.y - y);
    }




    public Vector2D subtract(Vector2D vector2D){

        return subtract(vector2D.x, vector2D.y);
    }

    public Vector2D mutiply (float i){
        Vector2D vector2D = new Vector2D();

        vector2D.x = this.x *  i;
        vector2D.y = this.y * i;
        return vector2D;
    }

    public float length(){
       return (float) Math.sqrt(x * x + y * y);
    }

    public Vector2D normalize(){
        float length = length();


        return new Vector2D(this.x / length, this.y / length);
    }


    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


}
