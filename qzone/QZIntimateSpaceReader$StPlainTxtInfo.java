package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$StPlainTxtInfo extends MessageMicro<QZIntimateSpaceReader$StPlainTxtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"txt_info"}, new Object[]{null}, QZIntimateSpaceReader$StPlainTxtInfo.class);
    public final PBRepeatMessageField<QZoneBaseMeta$StRichMsg> txt_info = PBField.initRepeatMessage(QZoneBaseMeta$StRichMsg.class);
}
