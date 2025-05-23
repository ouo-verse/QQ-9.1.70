package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb7$StDaySignedListRsp extends MessageMicro<oidb_0xeb7$StDaySignedListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ret", "page"}, new Object[]{null, null}, oidb_0xeb7$StDaySignedListRsp.class);
    public oidb_0xeb7$Ret ret = new oidb_0xeb7$Ret();
    public final PBRepeatMessageField<oidb_0xeb7$StDaySignedPage> page = PBField.initRepeatMessage(oidb_0xeb7$StDaySignedPage.class);
}
