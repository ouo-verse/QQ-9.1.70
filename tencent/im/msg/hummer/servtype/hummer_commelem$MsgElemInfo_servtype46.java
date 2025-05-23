package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype46 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype46> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"inline_keyboard"}, new Object[]{ByteStringMicro.EMPTY}, hummer_commelem$MsgElemInfo_servtype46.class);
    public final PBBytesField inline_keyboard = PBField.initBytes(ByteStringMicro.EMPTY);
}
