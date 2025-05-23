package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceWriter$WhiteListResult extends MessageMicro<QZIntimateSpaceWriter$WhiteListResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"uid", "status"}, new Object[]{"", Boolean.FALSE}, QZIntimateSpaceWriter$WhiteListResult.class);
    public final PBStringField uid = PBField.initString("");
    public final PBBoolField status = PBField.initBool(false);
}
