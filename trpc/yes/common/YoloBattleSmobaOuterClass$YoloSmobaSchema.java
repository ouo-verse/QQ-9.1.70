package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleSmobaOuterClass$YoloSmobaSchema extends MessageMicro<YoloBattleSmobaOuterClass$YoloSmobaSchema> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"schemas"}, new Object[]{null}, YoloBattleSmobaOuterClass$YoloSmobaSchema.class);
    public final PBRepeatMessageField<YoloBattleSmobaOuterClass$YoloSmobaOneSchema> schemas = PBField.initRepeatMessage(YoloBattleSmobaOuterClass$YoloSmobaOneSchema.class);
}
