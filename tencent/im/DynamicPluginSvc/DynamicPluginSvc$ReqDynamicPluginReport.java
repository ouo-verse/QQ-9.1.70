package tencent.im.DynamicPluginSvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class DynamicPluginSvc$ReqDynamicPluginReport extends MessageMicro<DynamicPluginSvc$ReqDynamicPluginReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"plugin_id", "plugin_name"}, new Object[]{0, ByteStringMicro.EMPTY}, DynamicPluginSvc$ReqDynamicPluginReport.class);
    public final PBUInt32Field plugin_id = PBField.initUInt32(0);
    public final PBBytesField plugin_name = PBField.initBytes(ByteStringMicro.EMPTY);
}
