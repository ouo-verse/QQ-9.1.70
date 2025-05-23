package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QZoneTagFeedList$PopularityInfo extends MessageMicro<QZoneTagFeedList$PopularityInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"users", "disciption", "friend_pub_count", "publish_count", "view_count"}, new Object[]{null, "", 0L, 0L, 0L}, QZoneTagFeedList$PopularityInfo.class);
    public final PBRepeatMessageField<QZoneBaseMeta$StUser> users = PBField.initRepeatMessage(QZoneBaseMeta$StUser.class);
    public final PBRepeatField<String> disciption = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt64Field friend_pub_count = PBField.initUInt64(0);
    public final PBUInt64Field publish_count = PBField.initUInt64(0);
    public final PBUInt64Field view_count = PBField.initUInt64(0);
}
