package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$QQAnchorBindGameReq extends MessageMicro<UserProxyCmdOuterClass$QQAnchorBindGameReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"code", "game_id"}, new Object[]{"", 0}, UserProxyCmdOuterClass$QQAnchorBindGameReq.class);
    public final PBStringField code = PBField.initString("");
    public final PBInt32Field game_id = PBField.initInt32(0);
}
