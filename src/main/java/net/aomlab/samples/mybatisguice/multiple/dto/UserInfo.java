package net.aomlab.samples.mybatisguice.multiple.dto;

/**
 * Created with IntelliJ IDEA.
 * User: Takuma Mori
 * Date: 13/08/13
 * Time: 16:41
 * To change this template use File | Settings | File Templates.
 */
public class UserInfo {

    private int userId;

    private String address;

    private String phone;

    public UserInfo() {
    }

    public UserInfo(int userId, String address, String phone) {
        this.userId = userId;
        this.address = address;
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
