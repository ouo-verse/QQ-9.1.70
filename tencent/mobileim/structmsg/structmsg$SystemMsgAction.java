package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class structmsg$SystemMsgAction extends MessageMicro<structmsg$SystemMsgAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"name", "result", "action", "action_info", "detail_name"}, new Object[]{"", "", 0, null, ""}, structmsg$SystemMsgAction.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField result = PBField.initString("");
    public final PBUInt32Field action = PBField.initUInt32(0);
    public structmsg$SystemMsgActionInfo action_info = new structmsg$SystemMsgActionInfo();
    public final PBStringField detail_name = PBField.initString("");
}
