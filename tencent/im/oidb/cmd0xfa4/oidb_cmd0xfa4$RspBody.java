package tencent.im.oidb.cmd0xfa4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xfa4$RspBody extends MessageMicro<oidb_cmd0xfa4$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"red_info", "rpt_msg_type_list"}, new Object[]{null, null}, oidb_cmd0xfa4$RspBody.class);
    public oidb_cmd0xfa4$RedInfo red_info = new MessageMicro<oidb_cmd0xfa4$RedInfo>() { // from class: tencent.im.oidb.cmd0xfa4.oidb_cmd0xfa4$RedInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"time_stamp", "is_red"}, new Object[]{0L, Boolean.FALSE}, oidb_cmd0xfa4$RedInfo.class);
        public final PBUInt64Field time_stamp = PBField.initUInt64(0);
        public final PBBoolField is_red = PBField.initBool(false);
    };
    public final PBRepeatMessageField<oidb_cmd0xfa4$MsgBoardTypeInfo> rpt_msg_type_list = PBField.initRepeatMessage(oidb_cmd0xfa4$MsgBoardTypeInfo.class);
}
