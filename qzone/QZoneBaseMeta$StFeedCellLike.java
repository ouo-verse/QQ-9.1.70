package qzone;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StFeedCellLike extends MessageMicro<QZoneBaseMeta$StFeedCellLike> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{WidgetCacheConstellationData.NUM, "liked", "like_mans", "text"}, new Object[]{0, Boolean.FALSE, null, ""}, QZoneBaseMeta$StFeedCellLike.class);
    public final PBInt32Field num = PBField.initInt32(0);
    public final PBBoolField liked = PBField.initBool(false);
    public final PBRepeatMessageField<QZoneBaseMeta$StLikeMan> like_mans = PBField.initRepeatMessage(QZoneBaseMeta$StLikeMan.class);
    public final PBStringField text = PBField.initString("");
}
