package trpc.yes.common;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class MessageOuterClass$LiveRoomEnterGameTeamMsg extends MessageMicro<MessageOuterClass$LiveRoomEnterGameTeamMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"text", "nickname", "uid", QCircleSchemeAttr.Detail.AVATAR_URL}, new Object[]{"", "", 0L, ""}, MessageOuterClass$LiveRoomEnterGameTeamMsg.class);
    public final PBStringField text = PBField.initString("");
    public final PBStringField nickname = PBField.initString("");
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField avatar_url = PBField.initString("");
}
