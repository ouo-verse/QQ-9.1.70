package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac5$NowHaiWanStorage extends MessageMicro<cmd0xac5$NowHaiWanStorage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_haiwan_record"}, new Object[]{null}, cmd0xac5$NowHaiWanStorage.class);
    public final PBRepeatMessageField<cmd0xac5$HaiWanRecord> rpt_msg_haiwan_record = PBField.initRepeatMessage(cmd0xac5$HaiWanRecord.class);
}
