package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype18 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype18> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_auth_key;
    public final PBBytesField bytes_listid;
    public final PBUInt32Field uint32_number;
    public final PBUInt64Field uint64_current_amount = PBField.initUInt64(0);
    public final PBUInt64Field uint64_total_amount = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"uint64_current_amount", "uint64_total_amount", "bytes_listid", "bytes_auth_key", "uint32_number"}, new Object[]{0L, 0L, byteStringMicro, byteStringMicro, 0}, hummer_commelem$MsgElemInfo_servtype18.class);
    }

    public hummer_commelem$MsgElemInfo_servtype18() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_listid = PBField.initBytes(byteStringMicro);
        this.bytes_auth_key = PBField.initBytes(byteStringMicro);
        this.uint32_number = PBField.initUInt32(0);
    }
}
