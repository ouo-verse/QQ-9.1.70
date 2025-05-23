package trpc.qq_vgame.activity_center;

import com.tencent.mobileqq.pb.MessageMicro;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* loaded from: classes29.dex */
public final class ActivityCenter$SyncPlayGameRsp extends MessageMicro<ActivityCenter$SyncPlayGameRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"res"}, new Object[]{null}, ActivityCenter$SyncPlayGameRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
}
