package com.ooooo.quake.enums;

public enum EnumShopStatus {
    UNKNOW(-1, ""),
    INIT(0, "创建待审核"), //初始状态
    NORMAL(2, "运营中"); //正常状态

    private int status;
    private String statusName;

    public int getStatus() {
        return status;
    }

    public String getStatusName() {
        return statusName;
    }

    EnumShopStatus(int status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public static EnumShopStatus valueOfStatus(Integer status){
        for (EnumShopStatus checkStatus : values()){
            if (checkStatus.status == status){
                return checkStatus;
            }
        }
        return UNKNOW;
    }
}
