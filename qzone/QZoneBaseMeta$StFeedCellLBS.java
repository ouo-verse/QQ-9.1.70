package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StFeedCellLBS extends MessageMicro<QZoneBaseMeta$StFeedCellLBS> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"lbs", "icon_token"}, new Object[]{null, ""}, QZoneBaseMeta$StFeedCellLBS.class);
    public QZoneBaseMeta$StLBS lbs = new QZoneBaseMeta$StLBS();
    public final PBStringField icon_token = PBField.initString("");
}
