package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentMeta$NoticeLeftTextRightImageData extends MessageMicro<QZMomentMeta$NoticeLeftTextRightImageData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"message", "images"}, new Object[]{"", null}, QZMomentMeta$NoticeLeftTextRightImageData.class);
    public final PBStringField message = PBField.initString("");
    public final PBRepeatMessageField<QZMomentMeta$StImage> images = PBField.initRepeatMessage(QZMomentMeta$StImage.class);
}
