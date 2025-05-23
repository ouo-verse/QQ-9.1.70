package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes30.dex */
public final class YoloBattleMiniGameOuterClass$YoloMiniGamePlayerInfo extends MessageMicro<YoloBattleMiniGameOuterClass$YoloMiniGamePlayerInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uid", "user_access_info"}, new Object[]{0L, ""}, YoloBattleMiniGameOuterClass$YoloMiniGamePlayerInfo.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField user_access_info = PBField.initString("");
}
