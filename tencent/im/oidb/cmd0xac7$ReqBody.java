package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac7$ReqBody extends MessageMicro<cmd0xac7$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_cmd", "uint64_din", "bytes_extd", "msg_binder_sig"}, new Object[]{0, 0L, ByteStringMicro.EMPTY, null}, cmd0xac7$ReqBody.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_din = PBField.initUInt64(0);
    public final PBBytesField bytes_extd = PBField.initBytes(ByteStringMicro.EMPTY);
    public cmd0xac7$BinderSig msg_binder_sig = new MessageMicro<cmd0xac7$BinderSig>() { // from class: tencent.im.oidb.cmd0xac7$BinderSig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_type", "uint64_uin", "bytes_sig"}, new Object[]{0, 0L, ByteStringMicro.EMPTY}, cmd0xac7$BinderSig.class);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
