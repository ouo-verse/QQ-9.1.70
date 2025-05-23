package tencent.im.DynamicPluginSvc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class DynamicPluginSvc$ReqDynamicPluginStat extends MessageMicro<DynamicPluginSvc$ReqDynamicPluginStat> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"old_user"}, new Object[]{Boolean.FALSE}, DynamicPluginSvc$ReqDynamicPluginStat.class);
    public final PBBoolField old_user = PBField.initBool(false);
}
