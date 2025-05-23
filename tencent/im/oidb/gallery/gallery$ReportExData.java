package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class gallery$ReportExData extends MessageMicro<gallery$ReportExData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"request_timestamp", "mf_seq", "alid", "sort_func"}, new Object[]{0L, "", 0L, ""}, gallery$ReportExData.class);
    public final PBUInt64Field request_timestamp = PBField.initUInt64(0);
    public final PBStringField mf_seq = PBField.initString("");
    public final PBUInt64Field alid = PBField.initUInt64(0);
    public final PBStringField sort_func = PBField.initString("");
}
