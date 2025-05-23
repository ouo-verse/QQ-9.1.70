package tencent.im.oidb.cmd0xbe6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbe6$ReqBody extends MessageMicro<oidb_cmd0xbe6$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"msg_phone_info", "msg_get_channel_info_req", "string_channel_version"}, new Object[]{null, null, ""}, oidb_cmd0xbe6$ReqBody.class);
    public oidb_cmd0xbe6$PhoneInfo msg_phone_info = new MessageMicro<oidb_cmd0xbe6$PhoneInfo>() { // from class: tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6$PhoneInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_appid;
        public final PBBytesField bytes_client_ip;
        public final PBBytesField bytes_muid;
        public final PBBytesField bytes_os_ver;
        public final PBBytesField bytes_qq_ver;
        public final PBUInt32Field uint32_carrier;
        public final PBUInt32Field uint32_conn;
        public final PBUInt32Field uint32_muid_type;
        public final PBUInt32Field uint32_os_type;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 58, 66, 72}, new String[]{"bytes_muid", "uint32_conn", "uint32_carrier", "uint32_muid_type", "bytes_os_ver", "bytes_qq_ver", "bytes_client_ip", "bytes_appid", "uint32_os_type"}, new Object[]{byteStringMicro, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0}, oidb_cmd0xbe6$PhoneInfo.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_muid = PBField.initBytes(byteStringMicro);
            this.uint32_conn = PBField.initUInt32(0);
            this.uint32_carrier = PBField.initUInt32(0);
            this.uint32_muid_type = PBField.initUInt32(0);
            this.bytes_os_ver = PBField.initBytes(byteStringMicro);
            this.bytes_qq_ver = PBField.initBytes(byteStringMicro);
            this.bytes_client_ip = PBField.initBytes(byteStringMicro);
            this.bytes_appid = PBField.initBytes(byteStringMicro);
            this.uint32_os_type = PBField.initUInt32(0);
        }
    };
    public oidb_cmd0xbe6$MsgGetChannelInfoReq msg_get_channel_info_req = new MessageMicro<oidb_cmd0xbe6$MsgGetChannelInfoReq>() { // from class: tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6$MsgGetChannelInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_cmd0xbe6$MsgGetChannelInfoReq.class);
    };
    public final PBStringField string_channel_version = PBField.initString("");
}
