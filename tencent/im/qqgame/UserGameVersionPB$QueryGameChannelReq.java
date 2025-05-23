package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class UserGameVersionPB$QueryGameChannelReq extends MessageMicro<UserGameVersionPB$QueryGameChannelReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"appid", "channel_id", "source"}, new Object[]{"", "", 0}, UserGameVersionPB$QueryGameChannelReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField channel_id = PBField.initString("");
    public final PBEnumField source = PBField.initEnum(0);
}
