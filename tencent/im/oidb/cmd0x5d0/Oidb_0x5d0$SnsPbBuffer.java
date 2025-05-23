package tencent.im.oidb.cmd0x5d0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class Oidb_0x5d0$SnsPbBuffer extends MessageMicro<Oidb_0x5d0$SnsPbBuffer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_sns_update_item"}, new Object[]{null}, Oidb_0x5d0$SnsPbBuffer.class);
    public final PBRepeatMessageField<Oidb_0x5d0$SnsUpdateItem> rpt_msg_sns_update_item = PBField.initRepeatMessage(Oidb_0x5d0$SnsUpdateItem.class);
}
