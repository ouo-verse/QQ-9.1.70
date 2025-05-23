package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StLBS extends MessageMicro<QZoneBaseMeta$StLBS> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"gps", "location", "id", "address"}, new Object[]{null, "", "", ""}, QZoneBaseMeta$StLBS.class);
    public QZoneBaseMeta$StGPS gps = new QZoneBaseMeta$StGPS();
    public final PBStringField location = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f430335id = PBField.initString("");
    public final PBStringField address = PBField.initString("");
}
