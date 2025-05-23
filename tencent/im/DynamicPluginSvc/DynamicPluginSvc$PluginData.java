package tencent.im.DynamicPluginSvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class DynamicPluginSvc$PluginData extends MessageMicro<DynamicPluginSvc$PluginData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"plugin_id", "plugin_name", "click_cnt"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, DynamicPluginSvc$PluginData.class);
    public final PBUInt32Field plugin_id = PBField.initUInt32(0);
    public final PBBytesField plugin_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field click_cnt = PBField.initUInt32(0);
}
