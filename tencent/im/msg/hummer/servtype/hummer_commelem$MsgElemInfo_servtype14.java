package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype14 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype14> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_id", "reserve_Info"}, new Object[]{0, ByteStringMicro.EMPTY}, hummer_commelem$MsgElemInfo_servtype14.class);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBBytesField reserve_Info = PBField.initBytes(ByteStringMicro.EMPTY);
}
