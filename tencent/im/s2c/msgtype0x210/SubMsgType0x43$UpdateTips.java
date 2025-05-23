package tencent.im.s2c.msgtype0x210;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x43$UpdateTips extends MessageMicro<SubMsgType0x43$UpdateTips> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_desc"}, new Object[]{ByteStringMicro.EMPTY}, SubMsgType0x43$UpdateTips.class);
    public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
}
