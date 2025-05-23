package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x6f5$RspBody extends MessageMicro<cmd0x6f5$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"str_config_version", "rpt_task_info"}, new Object[]{"", null}, cmd0x6f5$RspBody.class);
    public final PBStringField str_config_version = PBField.initString("");
    public final PBRepeatMessageField<cmd0x6f5$TaskInfo> rpt_task_info = PBField.initRepeatMessage(cmd0x6f5$TaskInfo.class);
}
