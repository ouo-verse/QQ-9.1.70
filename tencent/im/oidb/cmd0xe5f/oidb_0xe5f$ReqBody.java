package tencent.im.oidb.cmd0xe5f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe5f$ReqBody extends MessageMicro<oidb_0xe5f$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_praiseuin", "uint32_achievement_id", "uint32_actiontype"}, new Object[]{0L, 0, 0}, oidb_0xe5f$ReqBody.class);
    public final PBUInt64Field uint64_praiseuin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_achievement_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_actiontype = PBField.initUInt32(0);
}
