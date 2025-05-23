package qzone;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StFeedCellSummary extends MessageMicro<QZoneBaseMeta$StFeedCellSummary> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"summary", PictureConst.KEY_HAS_MORE}, new Object[]{null, Boolean.FALSE}, QZoneBaseMeta$StFeedCellSummary.class);
    public final PBRepeatMessageField<QZoneBaseMeta$StRichMsg> summary = PBField.initRepeatMessage(QZoneBaseMeta$StRichMsg.class);
    public final PBBoolField has_more = PBField.initBool(false);
}
