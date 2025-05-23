package tencent.im.oidb.cmd0x10d6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x10d6$FeatureInfo extends MessageMicro<oidb_0x10d6$FeatureInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48, 58, 64}, new String[]{"id", "name", "desc", "status", "url", "type", "available_range_desc", "mark"}, new Object[]{0, "", "", 0, "", 0, "", 0L}, oidb_0x10d6$FeatureInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f435971id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField available_range_desc = PBField.initString("");
    public final PBUInt64Field mark = PBField.initUInt64(0);
}
