package trpc.zplan;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CsCommon$AvatarInfo extends MessageMicro<CsCommon$AvatarInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"version", "slot_arr"}, new Object[]{0, null}, CsCommon$AvatarInfo.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBRepeatMessageField<CsCommon$SlotInfo> slot_arr = PBField.initRepeatMessage(CsCommon$SlotInfo.class);
}
