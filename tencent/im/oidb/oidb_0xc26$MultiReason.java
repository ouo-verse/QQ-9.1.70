package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc26$MultiReason extends MessageMicro<oidb_0xc26$MultiReason> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"reason", "strategy_id"}, new Object[]{ByteStringMicro.EMPTY, 0}, oidb_0xc26$MultiReason.class);
    public final PBBytesField reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field strategy_id = PBField.initUInt32(0);
}
