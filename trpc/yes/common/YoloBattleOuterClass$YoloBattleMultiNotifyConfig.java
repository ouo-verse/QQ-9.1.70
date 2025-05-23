package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleOuterClass$YoloBattleMultiNotifyConfig extends MessageMicro<YoloBattleOuterClass$YoloBattleMultiNotifyConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"notify_config_list"}, new Object[]{null}, YoloBattleOuterClass$YoloBattleMultiNotifyConfig.class);
    public final PBRepeatMessageField<YoloBattleOuterClass$YoloBattleNotifyConfig> notify_config_list = PBField.initRepeatMessage(YoloBattleOuterClass$YoloBattleNotifyConfig.class);
}
