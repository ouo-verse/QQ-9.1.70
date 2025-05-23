package qzone;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StFeedCellComment extends MessageMicro<QZoneBaseMeta$StFeedCellComment> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{WidgetCacheConstellationData.NUM, "comments"}, new Object[]{0, null}, QZoneBaseMeta$StFeedCellComment.class);
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBRepeatMessageField<QZoneBaseMeta$StComment> comments = PBField.initRepeatMessage(QZoneBaseMeta$StComment.class);
}
