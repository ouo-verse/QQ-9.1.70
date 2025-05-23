package tencent.im.DynamicPluginSvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class DynamicPluginSvc$RspDynamicPluginStat extends MessageMicro<DynamicPluginSvc$RspDynamicPluginStat> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"list_data", "ret", "old_user"}, new Object[]{null, 0, Boolean.FALSE}, DynamicPluginSvc$RspDynamicPluginStat.class);
    public final PBRepeatMessageField<DynamicPluginSvc$PluginData> list_data = PBField.initRepeatMessage(DynamicPluginSvc$PluginData.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBBoolField old_user = PBField.initBool(false);
}
