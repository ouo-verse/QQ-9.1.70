package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes30.dex */
public final class YoloBattleOuterClass$YoloBattleYesAPPNotifyConfig extends MessageMicro<YoloBattleOuterClass$YoloBattleYesAPPNotifyConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"users"}, new Object[]{null}, YoloBattleOuterClass$YoloBattleYesAPPNotifyConfig.class);
    public final PBRepeatMessageField<YoloBattleOuterClass$YesAPPNotifyUser> users = PBField.initRepeatMessage(YoloBattleOuterClass$YesAPPNotifyUser.class);
}
