package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QzoneAIGC$TextToImageRsp extends MessageMicro<QzoneAIGC$TextToImageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"code", "msg", "pic_url", "remaining_times"}, new Object[]{0, "", "", 0}, QzoneAIGC$TextToImageRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f429487msg = PBField.initString("");
    public final PBRepeatField<String> pic_url = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field remaining_times = PBField.initInt32(0);
}
