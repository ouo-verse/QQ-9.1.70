package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class QzoneActivityPB$PKActivityRsp extends MessageMicro<QzoneActivityPB$PKActivityRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"target_user_is_winner", "display_data"}, new Object[]{Boolean.FALSE, null}, QzoneActivityPB$PKActivityRsp.class);
    public final PBBoolField target_user_is_winner = PBField.initBool(false);
    public qzoneHolidayshare$DisplayData display_data = new qzoneHolidayshare$DisplayData();
}
