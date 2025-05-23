package tencent.im.oidb.cmd0x978;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x978$FollowStatusInfo extends MessageMicro<oidb_cmd0x978$FollowStatusInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "enum_follow_status"}, new Object[]{0L, 0}, oidb_cmd0x978$FollowStatusInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBEnumField enum_follow_status = PBField.initEnum(0);
}
