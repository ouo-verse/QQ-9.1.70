package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class structmsg$RspHead extends MessageMicro<structmsg$RspHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"result", "msg_fail"}, new Object[]{0, ""}, structmsg$RspHead.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBStringField msg_fail = PBField.initString("");
}
