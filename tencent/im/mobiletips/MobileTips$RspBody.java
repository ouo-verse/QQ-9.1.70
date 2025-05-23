package tencent.im.mobiletips;

import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MobileTips$RspBody extends MessageMicro<MobileTips$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"result", NotificationCompat.CATEGORY_ERROR}, new Object[]{0, ""}, MobileTips$RspBody.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField err = PBField.initString("");
}
