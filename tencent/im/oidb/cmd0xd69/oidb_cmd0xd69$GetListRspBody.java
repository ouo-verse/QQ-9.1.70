package tencent.im.oidb.cmd0xd69;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd69$GetListRspBody extends MessageMicro<oidb_cmd0xd69$GetListRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_msg_list", "bytes_cookies"}, new Object[]{null, ByteStringMicro.EMPTY}, oidb_cmd0xd69$GetListRspBody.class);
    public final PBRepeatMessageField<oidb_cmd0xd69$DoubtInfo> rpt_msg_list = PBField.initRepeatMessage(oidb_cmd0xd69$DoubtInfo.class);
    public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
}
