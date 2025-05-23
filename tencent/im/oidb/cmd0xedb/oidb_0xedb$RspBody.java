package tencent.im.oidb.cmd0xedb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xedb$RspBody extends MessageMicro<oidb_0xedb$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"dstHeadInfos"}, new Object[]{null}, oidb_0xedb$RspBody.class);
    public final PBRepeatMessageField<oidb_0xedb$RspHeadInfo> dstHeadInfos = PBField.initRepeatMessage(oidb_0xedb$RspHeadInfo.class);
}
