package tencent.im.oidb.cmd0x97b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x97b$MedalInfo extends MessageMicro<oidb_cmd0x97b$MedalInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_jump_url;
    public final PBBytesField bytes_medal_name;
    public final PBBytesField bytes_medal_url;
    public final PBUInt32Field uint32_is_jump;
    public final PBUInt32Field uint32_medal_type;
    public final PBUInt32Field uint32_pic_height;
    public final PBUInt32Field uint32_pic_width;
    public final PBUInt64Field uint64_medal_id = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 56, 64}, new String[]{"uint64_medal_id", "bytes_medal_name", "bytes_medal_url", "uint32_medal_type", "uint32_is_jump", "bytes_jump_url", "uint32_pic_width", "uint32_pic_height"}, new Object[]{0L, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, 0, 0}, oidb_cmd0x97b$MedalInfo.class);
    }

    public oidb_cmd0x97b$MedalInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_medal_name = PBField.initBytes(byteStringMicro);
        this.bytes_medal_url = PBField.initBytes(byteStringMicro);
        this.uint32_medal_type = PBField.initUInt32(0);
        this.uint32_is_jump = PBField.initUInt32(0);
        this.bytes_jump_url = PBField.initBytes(byteStringMicro);
        this.uint32_pic_width = PBField.initUInt32(0);
        this.uint32_pic_height = PBField.initUInt32(0);
    }
}
