package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7cb$CommentConfig extends MessageMicro<cmd0x7cb$CommentConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_appoint_subject", "rpt_msg_configs"}, new Object[]{0, null}, cmd0x7cb$CommentConfig.class);
    public final PBUInt32Field uint32_appoint_subject = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x7cb$ConfigItem> rpt_msg_configs = PBField.initRepeatMessage(cmd0x7cb$ConfigItem.class);
}
