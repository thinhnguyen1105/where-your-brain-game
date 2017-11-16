package bases.physics;

/**
 * Có những class cần getboxcollider có những class không -> dùng interface
 * DÙng interface giống như + thêm hàm cho class
 */
public interface PhysicsBody {

    BoxCollider getBoxCollider();
    void setIsActive(boolean isActive);
}
