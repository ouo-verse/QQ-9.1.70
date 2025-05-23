package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x43c$ResponseCardDetail extends MessageMicro<Oidb_0x43c$ResponseCardDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"card_id", "card_info"}, new Object[]{ByteStringMicro.EMPTY, null}, Oidb_0x43c$ResponseCardDetail.class);
    public final PBBytesField card_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public Oidb_0x43c$CardInfo card_info = new Oidb_0x43c$CardInfo();
}
