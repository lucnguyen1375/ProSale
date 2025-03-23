package ProSale.manager;

import java.io.Serializable;

public class IDManager implements Serializable {
    private int CURRENT_USER_ID;
    private int CURRENT_PRODUCT_ID;
    private int CURRENT_ORDER_ID;
    private int CURRENT_IMAGE_ID;

    public int getCURRENT_PRODUCT_ID() throws Exception{
        CURRENT_PRODUCT_ID++;
        IOSystem.saveIDData();
        return CURRENT_PRODUCT_ID;
    }

    public int getCURRENT_USER_ID() throws Exception{
        CURRENT_USER_ID++;
        IOSystem.saveIDData();
        return CURRENT_USER_ID;
    }
    public int getCURRENT_ORDER_ID() throws Exception{
        CURRENT_ORDER_ID++;
        IOSystem.saveIDData();
        return CURRENT_ORDER_ID;
    }

    public int getCURRENT_IMAGE_ID() throws Exception{
        CURRENT_IMAGE_ID++;
        IOSystem.saveIDData();
        return CURRENT_IMAGE_ID;
    }

    public IDManager() {
        CURRENT_USER_ID = 0;
        CURRENT_PRODUCT_ID = 5;
        CURRENT_ORDER_ID = 0;
        CURRENT_IMAGE_ID = 0;
    }

    @Override
    public String toString() {
        return "IDManager{" +
                "CURRENT_USER_ID=" + CURRENT_USER_ID +
                ", CURRENT_PRODUCT_ID=" + CURRENT_PRODUCT_ID +
                ", CURRENT_ORDER_ID=" + CURRENT_ORDER_ID +
                ", CURRENT_IMAGE_ID=" + CURRENT_IMAGE_ID +
                '}';
    }

}
