package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class PendantOuterClass$PendantMsgSubscript extends MessageMicro<PendantOuterClass$PendantMsgSubscript> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"text_list", "icon"}, new Object[]{"", null}, PendantOuterClass$PendantMsgSubscript.class);
    public final PBRepeatField<String> text_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public CommonOuterClass$ImageItem icon = new CommonOuterClass$ImageItem();
}
