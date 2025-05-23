package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloBattleCfmOuterClass$YoloCFMSchema extends MessageMicro<YoloBattleCfmOuterClass$YoloCFMSchema> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"schemas"}, new Object[]{null}, YoloBattleCfmOuterClass$YoloCFMSchema.class);
    public final PBRepeatMessageField<YoloBattleCfmOuterClass$YoloCFMOneSchema> schemas = PBField.initRepeatMessage(YoloBattleCfmOuterClass$YoloCFMOneSchema.class);
}
