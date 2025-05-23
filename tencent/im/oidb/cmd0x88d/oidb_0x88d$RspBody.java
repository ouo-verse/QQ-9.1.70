package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x88d$RspBody extends MessageMicro<oidb_0x88d$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"stzrspgroupinfo", "str_errorinfo"}, new Object[]{null, ByteStringMicro.EMPTY}, oidb_0x88d$RspBody.class);
    public final PBRepeatMessageField<oidb_0x88d$RspGroupInfo> stzrspgroupinfo = PBField.initRepeatMessage(oidb_0x88d$RspGroupInfo.class);
    public final PBBytesField str_errorinfo = PBField.initBytes(ByteStringMicro.EMPTY);
}
