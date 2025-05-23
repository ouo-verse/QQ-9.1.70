package tencent.im.oidb.cmd0x922;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class cmd0x922$PushInfo extends MessageMicro<cmd0x922$PushInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url;
    public final PBBytesField bytes_prompt;
    public final PBBytesField bytes_url;
    public final PBUInt32Field uint32_lst_checkin_time;
    public final PBUInt32Field uint32_open_func;
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_red_point = PBField.initUInt32(0);
    public final PBUInt32Field uint32_day = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 56, 64}, new String[]{"uint32_type", "uint32_red_point", "uint32_day", "bytes_prompt", "bytes_url", "bytes_icon_url", "uint32_lst_checkin_time", "uint32_open_func"}, new Object[]{0, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0}, cmd0x922$PushInfo.class);
    }

    public cmd0x922$PushInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_prompt = PBField.initBytes(byteStringMicro);
        this.bytes_url = PBField.initBytes(byteStringMicro);
        this.bytes_icon_url = PBField.initBytes(byteStringMicro);
        this.uint32_lst_checkin_time = PBField.initUInt32(0);
        this.uint32_open_func = PBField.initUInt32(0);
    }
}
