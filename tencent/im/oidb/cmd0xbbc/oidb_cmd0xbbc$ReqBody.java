package tencent.im.oidb.cmd0xbbc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.channel_button.channel_button$Channel;
import tencent.im.oidb.channel_button.channel_button$Section;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbbc$ReqBody extends MessageMicro<oidb_cmd0xbbc$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"rpt_me_channel", "rpt_recomm_channel", "rpt_msg_section", "uint32_set_type", "msg_phone_type"}, new Object[]{null, null, null, 0, null}, oidb_cmd0xbbc$ReqBody.class);
    public final PBRepeatMessageField<channel_button$Channel> rpt_me_channel = PBField.initRepeatMessage(channel_button$Channel.class);
    public final PBRepeatMessageField<channel_button$Channel> rpt_recomm_channel = PBField.initRepeatMessage(channel_button$Channel.class);
    public final PBRepeatMessageField<channel_button$Section> rpt_msg_section = PBField.initRepeatMessage(channel_button$Section.class);
    public final PBUInt32Field uint32_set_type = PBField.initUInt32(0);
    public oidb_cmd0xbbc$PhoneInfo msg_phone_type = new MessageMicro<oidb_cmd0xbbc$PhoneInfo>() { // from class: tencent.im.oidb.cmd0xbbc.oidb_cmd0xbbc$PhoneInfo
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
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 58, 66, 72}, new String[]{"bytes_muid", "uint32_conn", "uint32_carrier", "uint32_muid_type", "bytes_os_ver", "bytes_qq_ver", "bytes_client_ip", "bytes_appid", "uint32_os_type"}, new Object[]{byteStringMicro, 0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0}, oidb_cmd0xbbc$PhoneInfo.class);
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
}
