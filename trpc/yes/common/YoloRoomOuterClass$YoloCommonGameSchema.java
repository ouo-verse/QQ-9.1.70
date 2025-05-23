package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloCommonGameSchema extends MessageMicro<YoloRoomOuterClass$YoloCommonGameSchema> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"schemas"}, new Object[]{null}, YoloRoomOuterClass$YoloCommonGameSchema.class);
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloCommonGameOneSchema> schemas = PBField.initRepeatMessage(YoloRoomOuterClass$YoloCommonGameOneSchema.class);
}
