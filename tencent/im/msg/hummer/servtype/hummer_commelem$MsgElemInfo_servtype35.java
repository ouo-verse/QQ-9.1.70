package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype35 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype35> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_global_padid;
    public final PBBytesField bytes_token;
    public final PBUInt32Field uint32_get_rev;
    public final PBUInt32Field uint32_his_edit_uin_num;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"bytes_token", "bytes_global_padid", "uint32_get_rev", "uint32_his_edit_uin_num"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0}, hummer_commelem$MsgElemInfo_servtype35.class);
    }

    public hummer_commelem$MsgElemInfo_servtype35() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_token = PBField.initBytes(byteStringMicro);
        this.bytes_global_padid = PBField.initBytes(byteStringMicro);
        this.uint32_get_rev = PBField.initUInt32(0);
        this.uint32_his_edit_uin_num = PBField.initUInt32(0);
    }
}
