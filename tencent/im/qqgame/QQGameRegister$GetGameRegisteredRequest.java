package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameRegister$GetGameRegisteredRequest extends MessageMicro<QQGameRegister$GetGameRegisteredRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"plat", "appid"}, new Object[]{0, ""}, QQGameRegister$GetGameRegisteredRequest.class);
    public final PBEnumField plat = PBField.initEnum(0);
    public final PBStringField appid = PBField.initString("");
}
