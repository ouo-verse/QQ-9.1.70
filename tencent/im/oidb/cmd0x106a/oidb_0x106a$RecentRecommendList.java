package tencent.im.oidb.cmd0x106a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x106a$RecentRecommendList extends MessageMicro<oidb_0x106a$RecentRecommendList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bots", "update_ts"}, new Object[]{null, 0L}, oidb_0x106a$RecentRecommendList.class);
    public final PBRepeatMessageField<oidb_0x106a$RecentRecommendBot> bots = PBField.initRepeatMessage(oidb_0x106a$RecentRecommendBot.class);
    public final PBUInt64Field update_ts = PBField.initUInt64(0);
}
