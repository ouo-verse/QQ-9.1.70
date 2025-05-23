package trpc.qq_vgame.activity_center;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ActivityCenter$SyncShareGameRsp extends MessageMicro<ActivityCenter$SyncShareGameRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"res", "jump_url"}, new Object[]{null, ""}, ActivityCenter$SyncShareGameRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public final PBStringField jump_url = PBField.initString("");
}
