package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$EventItem extends MessageMicro<QzoneActivityPB$EventItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"tid", "interact_id", "op_uid", "ts"}, new Object[]{"", "", "", 0L}, QzoneActivityPB$EventItem.class);
    public final PBStringField tid = PBField.initString("");
    public final PBStringField interact_id = PBField.initString("");
    public final PBStringField op_uid = PBField.initString("");

    /* renamed from: ts, reason: collision with root package name */
    public final PBInt64Field f430344ts = PBField.initInt64(0);
}
