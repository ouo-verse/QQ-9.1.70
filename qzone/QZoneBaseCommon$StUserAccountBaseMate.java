package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseCommon$StUserAccountBaseMate extends MessageMicro<QZoneBaseCommon$StUserAccountBaseMate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"uid", "uin"}, new Object[]{"", 0L}, QZoneBaseCommon$StUserAccountBaseMate.class);
    public final PBStringField uid = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
