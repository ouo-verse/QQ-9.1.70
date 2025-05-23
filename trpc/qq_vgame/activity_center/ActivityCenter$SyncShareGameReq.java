package trpc.qq_vgame.activity_center;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ActivityCenter$SyncShareGameReq extends MessageMicro<ActivityCenter$SyncShareGameReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"play_game_id"}, new Object[]{""}, ActivityCenter$SyncShareGameReq.class);
    public final PBStringField play_game_id = PBField.initString("");
}
