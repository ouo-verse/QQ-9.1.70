package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class HbPlayRule$IdiomInfo extends MessageMicro<HbPlayRule$IdiomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"hz", "py", "py_last", "seq"}, new Object[]{"", "", "", 0}, HbPlayRule$IdiomInfo.class);

    /* renamed from: hz, reason: collision with root package name */
    public final PBStringField f436041hz = PBField.initString("");

    /* renamed from: py, reason: collision with root package name */
    public final PBStringField f436042py = PBField.initString("");
    public final PBStringField py_last = PBField.initString("");
    public final PBInt32Field seq = PBField.initInt32(0);
}
