package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloTeamOuterClass$YoloTeamUserShowInfo extends MessageMicro<YoloTeamOuterClass$YoloTeamUserShowInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"show_nick", "show_avatar_url", "gender"}, new Object[]{"", "", 0}, YoloTeamOuterClass$YoloTeamUserShowInfo.class);
    public final PBStringField show_nick = PBField.initString("");
    public final PBStringField show_avatar_url = PBField.initString("");
    public final PBInt32Field gender = PBField.initInt32(0);
}
