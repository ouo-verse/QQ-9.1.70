package tencent.im.oidb.cmd0x962;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x962$FinishInfo extends MessageMicro<oidb_0x962$FinishInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_first_nick_name;
    public final PBBytesField bytes_text;
    public final PBBytesField bytes_url;
    public final PBUInt32Field uint32_participate_num;
    public final PBUInt64Field uint64_first_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42}, new String[]{"bytes_text", "uint32_participate_num", "uint64_first_uin", "bytes_first_nick_name", "bytes_url"}, new Object[]{byteStringMicro, 0, 0L, byteStringMicro, byteStringMicro}, oidb_0x962$FinishInfo.class);
    }

    public oidb_0x962$FinishInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_text = PBField.initBytes(byteStringMicro);
        this.uint32_participate_num = PBField.initUInt32(0);
        this.uint64_first_uin = PBField.initUInt64(0L);
        this.bytes_first_nick_name = PBField.initBytes(byteStringMicro);
        this.bytes_url = PBField.initBytes(byteStringMicro);
    }
}
