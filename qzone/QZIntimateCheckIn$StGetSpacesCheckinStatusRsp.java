package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateCheckIn$StGetSpacesCheckinStatusRsp extends MessageMicro<QZIntimateCheckIn$StGetSpacesCheckinStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"spaces"}, new Object[]{null}, QZIntimateCheckIn$StGetSpacesCheckinStatusRsp.class);
    public final PBRepeatMessageField<QZIntimateCheckIn$SpaceCheckinEntry> spaces = PBField.initRepeatMessage(QZIntimateCheckIn$SpaceCheckinEntry.class);
}
