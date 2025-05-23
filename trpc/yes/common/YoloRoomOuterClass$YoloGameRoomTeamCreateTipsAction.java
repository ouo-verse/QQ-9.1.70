package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction extends MessageMicro<YoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"owner_user_id", "tips"}, new Object[]{null, ""}, YoloRoomOuterClass$YoloGameRoomTeamCreateTipsAction.class);
    public CommonOuterClass$QQUserId owner_user_id = new CommonOuterClass$QQUserId();
    public final PBStringField tips = PBField.initString("");
}
