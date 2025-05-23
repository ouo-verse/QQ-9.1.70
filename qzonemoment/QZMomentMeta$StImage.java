package qzonemoment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZMomentMeta$StImage extends MessageMicro<QZMomentMeta$StImage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"width", "height", "picUrl", "image_type", "vecImageUrl"}, new Object[]{0, 0, "", 0, null}, QZMomentMeta$StImage.class);
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField picUrl = PBField.initString("");
    public final PBEnumField image_type = PBField.initEnum(0);
    public final PBRepeatMessageField<QZMomentMeta$StImageUrl> vecImageUrl = PBField.initRepeatMessage(QZMomentMeta$StImageUrl.class);
}
