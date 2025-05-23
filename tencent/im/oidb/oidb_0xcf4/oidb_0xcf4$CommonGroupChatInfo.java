package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xcf4$CommonGroupChatInfo extends MessageMicro<oidb_0xcf4$CommonGroupChatInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"rpt_msg_one_group_info", "msg_one_group_info", "bytes_wording"}, new Object[]{null, null, ByteStringMicro.EMPTY}, oidb_0xcf4$CommonGroupChatInfo.class);
    public final PBRepeatMessageField<oidb_0xcf4$OneGroupInfo> rpt_msg_one_group_info = PBField.initRepeatMessage(oidb_0xcf4$OneGroupInfo.class);
    public oidb_0xcf4$OneGroupInfo msg_one_group_info = new oidb_0xcf4$OneGroupInfo();
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
}
