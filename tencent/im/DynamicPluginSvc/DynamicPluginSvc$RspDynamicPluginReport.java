package tencent.im.DynamicPluginSvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class DynamicPluginSvc$RspDynamicPluginReport extends MessageMicro<DynamicPluginSvc$RspDynamicPluginReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ret"}, new Object[]{0}, DynamicPluginSvc$RspDynamicPluginReport.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
}
