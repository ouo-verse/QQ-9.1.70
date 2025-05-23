package tencent.im.oidb.cmd0x106a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x106a$RecentRecommendBot extends MessageMicro<oidb_0x106a$RecentRecommendBot> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"robot_uin", "update_ts", "is_expired"}, new Object[]{0L, 0L, Boolean.FALSE}, oidb_0x106a$RecentRecommendBot.class);
    public final PBUInt64Field robot_uin = PBField.initUInt64(0);
    public final PBUInt64Field update_ts = PBField.initUInt64(0);
    public final PBBoolField is_expired = PBField.initBool(false);
}
