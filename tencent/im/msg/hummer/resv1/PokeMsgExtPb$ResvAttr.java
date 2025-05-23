package tencent.im.msg.hummer.resv1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class PokeMsgExtPb$ResvAttr extends MessageMicro<PokeMsgExtPb$ResvAttr> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"wording"}, new Object[]{ByteStringMicro.EMPTY}, PokeMsgExtPb$ResvAttr.class);
    public final PBBytesField wording = PBField.initBytes(ByteStringMicro.EMPTY);
}
