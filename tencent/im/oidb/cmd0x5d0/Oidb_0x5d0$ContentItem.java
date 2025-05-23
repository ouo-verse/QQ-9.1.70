package tencent.im.oidb.cmd0x5d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x5d0$ContentItem extends MessageMicro<Oidb_0x5d0$ContentItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_field", "msg_general_buffer"}, new Object[]{0, null}, Oidb_0x5d0$ContentItem.class);
    public final PBUInt32Field uint32_field = PBField.initUInt32(0);
    public Oidb_0x5d0$GeneralBuffer msg_general_buffer = new Oidb_0x5d0$GeneralBuffer();
}
