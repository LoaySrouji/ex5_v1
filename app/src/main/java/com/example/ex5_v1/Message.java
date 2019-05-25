package com.example.ex5_v1;

public class Message {
    public String Id, Timestamp, Content, Device;

    public Message(String Id, String Timestamp, String Content, String Device)
    {
        this.Content = Content;
        this.Timestamp = Timestamp;
        this.Id = Id;
        this.Device = Device;
    }
    @Override
    public String toString()
    {
        return this.Timestamp + "#" + Content;
    }
}
