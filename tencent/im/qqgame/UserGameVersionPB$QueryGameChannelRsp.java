package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class UserGameVersionPB$QueryGameChannelRsp extends MessageMicro<UserGameVersionPB$QueryGameChannelRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"is_gamecenter_channel", "reason"}, new Object[]{Boolean.FALSE, ""}, UserGameVersionPB$QueryGameChannelRsp.class);
    public final PBBoolField is_gamecenter_channel = PBField.initBool(false);
    public final PBStringField reason = PBField.initString("");
}
