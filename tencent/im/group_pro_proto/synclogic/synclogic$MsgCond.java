package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class synclogic$MsgCond extends MessageMicro<synclogic$MsgCond> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"msg_seq", "event_version", "token"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY}, synclogic$MsgCond.class);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field event_version = PBField.initUInt64(0);
    public final PBBytesField token = PBField.initBytes(ByteStringMicro.EMPTY);
}
