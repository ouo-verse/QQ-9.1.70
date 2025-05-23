package tencent.im.oidb.cmd0x6b5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x6b5$ReqBody extends MessageMicro<oidb_0x6b5$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48}, new String[]{"uint64_group_id", "bytes_gift_bagid", "uint32_channel", "msg_login_sig", "uint32_business_id", "uint32_portal"}, new Object[]{0L, ByteStringMicro.EMPTY, 0, null, 0, 0}, oidb_0x6b5$ReqBody.class);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0);
    public final PBBytesField bytes_gift_bagid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_channel = PBField.initUInt32(0);
    public oidb_0x6b5$LoginSig msg_login_sig = new oidb_0x6b5$LoginSig();
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
}
