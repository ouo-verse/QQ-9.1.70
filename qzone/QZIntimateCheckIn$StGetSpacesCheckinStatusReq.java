package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateCheckIn$StGetSpacesCheckinStatusReq extends MessageMicro<QZIntimateCheckIn$StGetSpacesCheckinStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"spaces"}, new Object[]{null}, QZIntimateCheckIn$StGetSpacesCheckinStatusReq.class);
    public final PBRepeatMessageField<QZIntimateCheckIn$CheckinSpaceInfo> spaces = PBField.initRepeatMessage(QZIntimateCheckIn$CheckinSpaceInfo.class);
}
