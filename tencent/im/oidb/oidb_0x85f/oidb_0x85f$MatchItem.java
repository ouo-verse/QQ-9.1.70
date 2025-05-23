package tencent.im.oidb.oidb_0x85f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x85f$MatchItem extends MessageMicro<oidb_0x85f$MatchItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_match_user_id", "uint32_match"}, new Object[]{0L, 0}, oidb_0x85f$MatchItem.class);
    public final PBUInt64Field uint64_match_user_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_match = PBField.initUInt32(0);
}
