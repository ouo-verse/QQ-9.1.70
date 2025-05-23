package tencent.im.oidb.cmd0x8fc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x8fc$CommCardNameBuf extends MessageMicro<Oidb_0x8fc$CommCardNameBuf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_rich_card_name", "uint32_cool_id"}, new Object[]{null, 0}, Oidb_0x8fc$CommCardNameBuf.class);
    public final PBRepeatMessageField<Oidb_0x8fc$RichCardNameElem> rpt_rich_card_name = PBField.initRepeatMessage(Oidb_0x8fc$RichCardNameElem.class);
    public final PBUInt32Field uint32_cool_id = PBField.initUInt32(0);
}
