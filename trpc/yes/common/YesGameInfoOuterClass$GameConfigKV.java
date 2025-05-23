package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YesGameInfoOuterClass$GameConfigKV extends MessageMicro<YesGameInfoOuterClass$GameConfigKV> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 50}, new String[]{"key", "value", "type", "linkage", "img"}, new Object[]{"", "", 0, null, ""}, YesGameInfoOuterClass$GameConfigKV.class);
    public final PBStringField key = PBField.initString("");
    public final PBRepeatField<String> value = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBRepeatMessageField<YesGameInfoOuterClass$GameConfigLinkageOption> linkage = PBField.initRepeatMessage(YesGameInfoOuterClass$GameConfigLinkageOption.class);
    public final PBStringField img = PBField.initString("");
}
