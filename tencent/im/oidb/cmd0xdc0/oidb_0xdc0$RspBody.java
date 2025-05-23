package tencent.im.oidb.cmd0xdc0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xdc0$RspBody extends MessageMicro<oidb_0xdc0$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90}, new String[]{"msg_location_list"}, new Object[]{null}, oidb_0xdc0$RspBody.class);
    public oidb_0xdc0$LocationList msg_location_list = new MessageMicro<oidb_0xdc0$LocationList>() { // from class: tencent.im.oidb.cmd0xdc0.oidb_0xdc0$LocationList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_group_list"}, new Object[]{null}, oidb_0xdc0$LocationList.class);
        public final PBRepeatMessageField<oidb_0xdc0$GroupInfo> rpt_group_list = PBField.initRepeatMessage(oidb_0xdc0$GroupInfo.class);
    };
}
