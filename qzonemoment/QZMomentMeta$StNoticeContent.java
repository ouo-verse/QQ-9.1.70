package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentMeta$StNoticeContent extends MessageMicro<QZMomentMeta$StNoticeContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"style", "message", "images"}, new Object[]{0, "", null}, QZMomentMeta$StNoticeContent.class);
    public final PBEnumField style = PBField.initEnum(0);
    public final PBStringField message = PBField.initString("");
    public final PBRepeatMessageField<QZMomentMeta$StImage> images = PBField.initRepeatMessage(QZMomentMeta$StImage.class);
}
