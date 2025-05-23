package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x43c$RequestCardDetail extends MessageMicro<Oidb_0x43c$RequestCardDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"card_id"}, new Object[]{ByteStringMicro.EMPTY}, Oidb_0x43c$RequestCardDetail.class);
    public final PBBytesField card_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
