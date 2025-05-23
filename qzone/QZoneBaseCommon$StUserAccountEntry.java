package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseCommon$StUserAccountEntry extends MessageMicro<QZoneBaseCommon$StUserAccountEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"uid", "account"}, new Object[]{"", null}, QZoneBaseCommon$StUserAccountEntry.class);
    public final PBStringField uid = PBField.initString("");
    public QZoneBaseCommon$StUserAccountBaseMate account = new QZoneBaseCommon$StUserAccountBaseMate();
}
