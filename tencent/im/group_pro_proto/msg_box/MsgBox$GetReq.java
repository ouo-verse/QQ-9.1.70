package tencent.im.group_pro_proto.msg_box;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgBox$GetReq extends MessageMicro<MsgBox$GetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"cookie"}, new Object[]{ByteStringMicro.EMPTY}, MsgBox$GetReq.class);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
