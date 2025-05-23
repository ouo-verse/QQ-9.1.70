package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZonePhotoDegrade$NotifyMsg extends MessageMicro<QZonePhotoDegrade$NotifyMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"title", "texts", "buttons"}, new Object[]{"", null, null}, QZonePhotoDegrade$NotifyMsg.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<QZonePhotoDegrade$Text> texts = PBField.initRepeatMessage(QZonePhotoDegrade$Text.class);
    public final PBRepeatMessageField<QZonePhotoDegrade$Button> buttons = PBField.initRepeatMessage(QZonePhotoDegrade$Button.class);
}
