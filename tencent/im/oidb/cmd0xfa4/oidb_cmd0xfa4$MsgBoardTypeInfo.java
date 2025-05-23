package tencent.im.oidb.cmd0xfa4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xfa4$MsgBoardTypeInfo extends MessageMicro<oidb_cmd0xfa4$MsgBoardTypeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"type", "title", "rpt_msg"}, new Object[]{0, ByteStringMicro.EMPTY, null}, oidb_cmd0xfa4$MsgBoardTypeInfo.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_cmd0xfa4$MsgBoardInfo> rpt_msg = PBField.initRepeatMessage(oidb_cmd0xfa4$MsgBoardInfo.class);
}
