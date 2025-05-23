package tencent.im.troop.findtroop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class TabRecommendPB$PersonExtraInfo extends MessageMicro<TabRecommendPB$PersonExtraInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"qzone_media_info", "qzone_jump_url", "uin"}, new Object[]{null, "", 0L}, TabRecommendPB$PersonExtraInfo.class);
    public final PBRepeatMessageField<TabRecommendPB$MediaInfo> qzone_media_info = PBField.initRepeatMessage(TabRecommendPB$MediaInfo.class);
    public final PBStringField qzone_jump_url = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
