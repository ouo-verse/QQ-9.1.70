package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StFeedCellTitle extends MessageMicro<QZoneBaseMeta$StFeedCellTitle> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"title", "title_url"}, new Object[]{null, ""}, QZoneBaseMeta$StFeedCellTitle.class);
    public final PBRepeatMessageField<QZoneBaseMeta$StRichMsg> title = PBField.initRepeatMessage(QZoneBaseMeta$StRichMsg.class);
    public final PBStringField title_url = PBField.initString("");
}
