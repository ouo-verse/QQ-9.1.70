package trpc.qq_vgame.activity_center;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.state.mmkv.SKey;
import trpc.qq_vgame.common.AvGameCommon$Result;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ActivityCenter$GetActivitysRsp extends MessageMicro<ActivityCenter$GetActivitysRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"res", "icon_url", SKey.DetailMe.KEY_TITLE_RED_POINT_SP, "jump_url"}, new Object[]{null, "", 0, ""}, ActivityCenter$GetActivitysRsp.class);
    public AvGameCommon$Result res = new AvGameCommon$Result();
    public final PBStringField icon_url = PBField.initString("");
    public final PBUInt32Field red_point = PBField.initUInt32(0);
    public final PBStringField jump_url = PBField.initString("");
}
