package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRight$UncareInfo extends MessageMicro<QQCircleRight$UncareInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"uin", "uncare", "reverseuncare", "black", "reverseblack"}, new Object[]{0L, 0, 0, 0, 0}, QQCircleRight$UncareInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBInt32Field uncare = PBField.initInt32(0);
    public final PBInt32Field reverseuncare = PBField.initInt32(0);
    public final PBInt32Field black = PBField.initInt32(0);
    public final PBInt32Field reverseblack = PBField.initInt32(0);
}
