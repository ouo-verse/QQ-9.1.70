package tencent.im.oidb.cmd0x439;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x439$RspBody extends MessageMicro<oidb_cmd0x439$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_msg_subscribe_info", "bytes_subscribe_detail_url_pre"}, new Object[]{null, ByteStringMicro.EMPTY}, oidb_cmd0x439$RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0x439$SubscribeInfo> rpt_msg_subscribe_info = PBField.initRepeatMessage(oidb_cmd0x439$SubscribeInfo.class);
    public final PBBytesField bytes_subscribe_detail_url_pre = PBField.initBytes(ByteStringMicro.EMPTY);
}
