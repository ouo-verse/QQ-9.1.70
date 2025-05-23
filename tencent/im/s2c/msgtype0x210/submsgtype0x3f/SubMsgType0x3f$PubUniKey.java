package tencent.im.s2c.msgtype0x210.submsgtype0x3f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class SubMsgType0x3f$PubUniKey extends MessageMicro<SubMsgType0x3f$PubUniKey> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_fromPubUin", "uint64_qwMsgId"}, new Object[]{0L, 0L}, SubMsgType0x3f$PubUniKey.class);
    public final PBUInt64Field uint64_fromPubUin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_qwMsgId = PBField.initUInt64(0);
}
