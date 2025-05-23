package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x6f0$RspBody extends MessageMicro<cmd0x6f0$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_torchbearer_list"}, new Object[]{null}, cmd0x6f0$RspBody.class);
    public final PBRepeatMessageField<torch_transfer$TorchbearerInfo> rpt_torchbearer_list = PBField.initRepeatMessage(torch_transfer$TorchbearerInfo.class);
}
