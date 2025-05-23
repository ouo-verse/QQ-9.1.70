package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleOuterClass$YoloBattleTrpcNotifyConfig extends MessageMicro<YoloBattleOuterClass$YoloBattleTrpcNotifyConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"target", "selector", "name_space", "method_name"}, new Object[]{"", "polaris", "", ""}, YoloBattleOuterClass$YoloBattleTrpcNotifyConfig.class);
    public final PBStringField target = PBField.initString("");
    public final PBStringField selector = PBField.initString("polaris");
    public final PBStringField name_space = PBField.initString("");
    public final PBStringField method_name = PBField.initString("");
}
