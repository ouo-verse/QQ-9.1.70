package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseCommon$StCommonExt extends MessageMicro<QZoneBaseCommon$StCommonExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"map_info", "attach_info", "map_bytes_info", "map_user_account"}, new Object[]{null, "", null, null}, QZoneBaseCommon$StCommonExt.class);
    public final PBRepeatMessageField<QZoneBaseCommon$Entry> map_info = PBField.initRepeatMessage(QZoneBaseCommon$Entry.class);
    public final PBStringField attach_info = PBField.initString("");
    public final PBRepeatMessageField<QZoneBaseCommon$BytesEntry> map_bytes_info = PBField.initRepeatMessage(QZoneBaseCommon$BytesEntry.class);
    public final PBRepeatMessageField<QZoneBaseCommon$StUserAccountEntry> map_user_account = PBField.initRepeatMessage(QZoneBaseCommon$StUserAccountEntry.class);
}
