package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StTobTabReddotInfo extends MessageMicro<QQCircleFeedBase$StTobTabReddotInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField shouldDisplayNewReddot = PBField.initBool(false);
    public final PBBoolField shouldDisplayActivityReddot = PBField.initBool(false);
    public final PBRepeatMessageField<QQCircleFeedBase$StTabActivityReddotTimeRange> activityReddotTimeRange = PBField.initRepeatMessage(QQCircleFeedBase$StTabActivityReddotTimeRange.class);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"shouldDisplayNewReddot", "shouldDisplayActivityReddot", "activityReddotTimeRange"}, new Object[]{bool, bool, null}, QQCircleFeedBase$StTobTabReddotInfo.class);
    }
}
