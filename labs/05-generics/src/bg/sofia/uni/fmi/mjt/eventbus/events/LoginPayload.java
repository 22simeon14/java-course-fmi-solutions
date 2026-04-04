package bg.sofia.uni.fmi.mjt.eventbus.events;

import bg.sofia.uni.fmi.mjt.eventbus.data.User;

public class LoginPayload implements Payload<User> {
    
    private final int size;
    private final User user;
    private final String ipAddress;
    private final String device;

    public LoginPayload(User user, String ipAddress, String device, int size) {
        if (user == null || ipAddress == null || device == null) {
            throw new IllegalArgumentException("User/Ip address/Device can not be null!");
        }
        if(size < 0) {
            throw new IllegalArgumentException("Login payload size can not be < 0!");
        }

        this.size = size;
        this.user = user;
        this.ipAddress = ipAddress;
        this.device = device;
    }

    public String getIPAddress() {
        return this.ipAddress;
    }

    public String getDevice() {
        return this.device;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public User getPayload() {
        return this.user;
    }

}
