package tencent.im.oidb.cmd0x106a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x106a$CardRecommendReply extends MessageMicro<oidb_0x106a$CardRecommendReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"text", "bots", "more_num", "next_update_timestamp", "max_recommend_icon"}, new Object[]{"", null, 0, 0L, 0}, oidb_0x106a$CardRecommendReply.class);
    public final PBStringField text = PBField.initString("");
    public final PBRepeatMessageField<oidb_0x106a$RobotInfo> bots = PBField.initRepeatMessage(oidb_0x106a$RobotInfo.class);
    public final PBUInt32Field more_num = PBField.initUInt32(0);
    public final PBUInt64Field next_update_timestamp = PBField.initUInt64(0);
    public final PBUInt32Field max_recommend_icon = PBField.initUInt32(0);
}
