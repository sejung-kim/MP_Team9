package com.example.Healing_time;

class FTPServerData {

    private String fServerIp = "humming1106.dothome.co.kr";
    private String fServerId = "humming1106";
    private String fSserverPassword = "KSJ!997549";
    private String fServerPath = "hospitalImage";

    public FTPServerData getFTPServerData(){
        return this;
    }
    public String getfServerIp(){
        return fServerIp;
    }
    public String getfServerId(){
        return fServerId;
    }
    public String getfSserverPassword(){
        return fSserverPassword;
    }
    public String getfServerPath(){
        return fServerPath;
    }
}

class PHPServerData{
    private String dbServerIp = "humming1106.dothome.co.kr";
    private String dbJoinPath = "/inert.php";
    private String PHPLoginPath="/testlogin.php";

    public PHPServerData getPHPServerData(){
        return this;
    }
}

