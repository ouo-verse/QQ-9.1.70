package tencent.im.qqgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameOrder$SetOrderGameResult extends MessageMicro<QQGameOrder$SetOrderGameResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"app_id", "ret"}, new Object[]{"", 0}, QQGameOrder$SetOrderGameResult.class);
    public final PBStringField app_id = PBField.initString("");
    public final PBEnumField ret = PBField.initEnum(0);
}
