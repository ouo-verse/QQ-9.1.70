package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x43c$RequestAdd extends MessageMicro<Oidb_0x43c$RequestAdd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"card_info", "isMine"}, new Object[]{null, Boolean.FALSE}, Oidb_0x43c$RequestAdd.class);
    public Oidb_0x43c$CardInfo card_info = new Oidb_0x43c$CardInfo();
    public final PBBoolField isMine = PBField.initBool(false);
}
