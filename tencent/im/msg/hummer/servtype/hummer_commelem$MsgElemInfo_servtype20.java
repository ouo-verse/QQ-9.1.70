package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype20 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype20> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_data"}, new Object[]{ByteStringMicro.EMPTY}, hummer_commelem$MsgElemInfo_servtype20.class);
    public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
