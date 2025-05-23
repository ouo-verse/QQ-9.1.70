package tencent.im.oidb.cmd0x97b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x97b$CountDetailInfo extends MessageMicro<oidb_cmd0x97b$CountDetailInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url;
    public final PBBytesField bytes_name;
    public final PBBytesField bytes_url;
    public final PBEnumField enum_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_id;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 80}, new String[]{"enum_type", "uint32_count", "bytes_name", "bytes_url", "bytes_icon_url", "uint32_id"}, new Object[]{1, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0}, oidb_cmd0x97b$CountDetailInfo.class);
    }

    public oidb_cmd0x97b$CountDetailInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_name = PBField.initBytes(byteStringMicro);
        this.bytes_url = PBField.initBytes(byteStringMicro);
        this.bytes_icon_url = PBField.initBytes(byteStringMicro);
        this.uint32_id = PBField.initUInt32(0);
    }
}
