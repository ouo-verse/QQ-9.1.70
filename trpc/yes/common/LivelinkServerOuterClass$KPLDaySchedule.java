package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class LivelinkServerOuterClass$KPLDaySchedule extends MessageMicro<LivelinkServerOuterClass$KPLDaySchedule> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"date", "is_today", "match_list"}, new Object[]{"", Boolean.FALSE, null}, LivelinkServerOuterClass$KPLDaySchedule.class);
    public final PBStringField date = PBField.initString("");
    public final PBBoolField is_today = PBField.initBool(false);
    public final PBRepeatMessageField<LivelinkServerOuterClass$KPLMatchInfo> match_list = PBField.initRepeatMessage(LivelinkServerOuterClass$KPLMatchInfo.class);
}
