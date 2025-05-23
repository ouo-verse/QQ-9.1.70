package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x6f$QimRecomendInfo extends MessageMicro<SubMsgType0x6f$QimRecomendInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_alghbuff;
    public final PBBytesField bytes_longnick;
    public final PBBytesField bytes_name;
    public final PBBytesField bytes_reason;
    public final PBBytesField bytes_source_reason;
    public SubMsgType0x6f$AddFriendSource msg_android_source;
    public SubMsgType0x6f$AddFriendSource msg_ios_source;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_source;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 56, 64, 74, 82, 90}, new String[]{"uint64_uin", "bytes_name", "bytes_reason", "uint32_gender", "bytes_longnick", "bytes_alghbuff", "uint32_age", "uint32_source", "bytes_source_reason", "msg_ios_source", "msg_android_source"}, new Object[]{0L, byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, null, null}, SubMsgType0x6f$QimRecomendInfo.class);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$AddFriendSource] */
    /* JADX WARN: Type inference failed for: r0v5, types: [tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$AddFriendSource] */
    public SubMsgType0x6f$QimRecomendInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_name = PBField.initBytes(byteStringMicro);
        this.bytes_reason = PBField.initBytes(byteStringMicro);
        this.uint32_gender = PBField.initUInt32(0);
        this.bytes_longnick = PBField.initBytes(byteStringMicro);
        this.bytes_alghbuff = PBField.initBytes(byteStringMicro);
        this.uint32_age = PBField.initUInt32(0);
        this.uint32_source = PBField.initUInt32(0);
        this.bytes_source_reason = PBField.initBytes(byteStringMicro);
        this.msg_ios_source = new MessageMicro<SubMsgType0x6f$AddFriendSource>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$AddFriendSource
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_source", "uint32_sub_source"}, new Object[]{0, 0}, SubMsgType0x6f$AddFriendSource.class);
            public final PBUInt32Field uint32_source = PBField.initUInt32(0);
            public final PBUInt32Field uint32_sub_source = PBField.initUInt32(0);
        };
        this.msg_android_source = new MessageMicro<SubMsgType0x6f$AddFriendSource>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f$AddFriendSource
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_source", "uint32_sub_source"}, new Object[]{0, 0}, SubMsgType0x6f$AddFriendSource.class);
            public final PBUInt32Field uint32_source = PBField.initUInt32(0);
            public final PBUInt32Field uint32_sub_source = PBField.initUInt32(0);
        };
    }
}
