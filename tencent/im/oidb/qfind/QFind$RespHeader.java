package tencent.im.oidb.qfind;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QFind$RespHeader extends MessageMicro<QFind$RespHeader> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"result", "desc"}, new Object[]{0, ""}, QFind$RespHeader.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBStringField desc = PBField.initString("");
}
