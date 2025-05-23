package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class subcmd0x111$OneRenMaiFrd extends MessageMicro<subcmd0x111$OneRenMaiFrd> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_remark;
    public final PBUInt32Field uint32_closeness;
    public final PBUInt32Field uint32_group;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48}, new String[]{"uint64_uin", "uint32_update_time", "bytes_remark", "bytes_nick", "uint32_closeness", "uint32_group"}, new Object[]{0L, 0, byteStringMicro, byteStringMicro, 0, 0}, subcmd0x111$OneRenMaiFrd.class);
    }

    public subcmd0x111$OneRenMaiFrd() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_remark = PBField.initBytes(byteStringMicro);
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.uint32_closeness = PBField.initUInt32(0);
        this.uint32_group = PBField.initUInt32(0);
    }
}
