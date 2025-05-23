package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xccb$LocalMsgInfo extends MessageMicro<cmd0xccb$LocalMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"local_res_id", "result"}, new Object[]{ByteStringMicro.EMPTY, 0}, cmd0xccb$LocalMsgInfo.class);
    public final PBBytesField local_res_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field result = PBField.initUInt32(0);
}
