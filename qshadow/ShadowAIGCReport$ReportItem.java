package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCReport$ReportItem extends MessageMicro<ShadowAIGCReport$ReportItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"local_md5", "priority", "compress_url", "face_crop_url"}, new Object[]{"", 0, "", ""}, ShadowAIGCReport$ReportItem.class);
    public final PBStringField local_md5 = PBField.initString("");
    public final PBInt32Field priority = PBField.initInt32(0);
    public final PBStringField compress_url = PBField.initString("");
    public final PBStringField face_crop_url = PBField.initString("");
}
