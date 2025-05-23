package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$DrawGameGiftReq extends MessageMicro<QzoneActivityPB$DrawGameGiftReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"gift_activity_id"}, new Object[]{0L}, QzoneActivityPB$DrawGameGiftReq.class);
    public final PBInt64Field gift_activity_id = PBField.initInt64(0);
}
