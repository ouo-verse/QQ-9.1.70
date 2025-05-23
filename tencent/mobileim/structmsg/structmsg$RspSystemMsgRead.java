package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class structmsg$RspSystemMsgRead extends MessageMicro<structmsg$RspSystemMsgRead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"head", "type", "checktype"}, new Object[]{null, 0, 1}, structmsg$RspSystemMsgRead.class);
    public structmsg$RspHead head = new structmsg$RspHead();
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBEnumField checktype = PBField.initEnum(1);
}
