package tencent.im.s2c.msgtype0x210.submsgtype0x11a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x11a$UserData extends MessageMicro<submsgtype0x11a$UserData> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_bssid;
    public final PBBytesField bytes_ip;
    public final PBBytesField bytes_ssid;
    public final PBEnumField enum_platform;
    public final PBRepeatField<Integer> rpt_fixed32_port;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21, 26, 34, 40}, new String[]{"bytes_ip", "rpt_fixed32_port", "bytes_ssid", "bytes_bssid", "enum_platform"}, new Object[]{byteStringMicro, 0, byteStringMicro, byteStringMicro, 1}, submsgtype0x11a$UserData.class);
    }

    public submsgtype0x11a$UserData() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_ip = PBField.initBytes(byteStringMicro);
        this.rpt_fixed32_port = PBField.initRepeat(PBFixed32Field.__repeatHelper__);
        this.bytes_ssid = PBField.initBytes(byteStringMicro);
        this.bytes_bssid = PBField.initBytes(byteStringMicro);
        this.enum_platform = PBField.initEnum(1);
    }
}
