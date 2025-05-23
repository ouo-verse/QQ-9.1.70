package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StPicSpecUrlEntry extends MessageMicro<QZoneBaseMeta$StPicSpecUrlEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"spec", "url"}, new Object[]{0, null}, QZoneBaseMeta$StPicSpecUrlEntry.class);
    public final PBEnumField spec = PBField.initEnum(0);
    public QZoneBaseMeta$StPicUrl url = new QZoneBaseMeta$StPicUrl();
}
