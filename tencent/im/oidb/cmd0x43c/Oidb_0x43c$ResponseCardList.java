package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x43c$ResponseCardList extends MessageMicro<Oidb_0x43c$ResponseCardList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"seq", "next_flag", "others", "mine"}, new Object[]{0, 0, null, null}, Oidb_0x43c$ResponseCardList.class);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field next_flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<Oidb_0x43c$CardInfo> others = PBField.initRepeatMessage(Oidb_0x43c$CardInfo.class);
    public Oidb_0x43c$CardInfo mine = new Oidb_0x43c$CardInfo();
}
