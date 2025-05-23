package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleEnvHub$UserInfo extends MessageMicro<QQCircleEnvHub$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField isFunnyKing = PBField.initBool(false);
    public final PBUInt64Field pushEffectStartTime = PBField.initUInt64(0);
    public final PBUInt64Field pushEffectEndTime = PBField.initUInt64(0);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField nickname = PBField.initString("");
    public final PBStringField headUrl = PBField.initString("");
    public final PBStringField publishConfig = PBField.initString("");
    public final PBBoolField canPublishCommentExpression = PBField.initBool(false);
    public final PBBoolField canPublishGIFExpression = PBField.initBool(false);
    public final PBStringField commentExpressionText = PBField.initString("");
    public final PBBoolField isCloseRecommend = PBField.initBool(false);
    public final PBUInt32Field recommendMaxToastTime = PBField.initUInt32(0);
    public final PBBytesField qq_vip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField sharePanelRecentFirst = PBField.initBool(false);
    public final PBBoolField sharePanelMultiUser = PBField.initBool(false);

    static {
        String[] strArr = {"isFunnyKing", "pushEffectStartTime", "pushEffectEndTime", "uid", "nickname", "headUrl", "publishConfig", "canPublishCommentExpression", "canPublishGIFExpression", "commentExpressionText", "isCloseRecommend", "recommendMaxToastTime", QQPermissionConstants.Business.SCENE.QQ_VIP, "sharePanelRecentFirst", "sharePanelMultiUser"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 64, 72, 82, 88, 96, 106, 112, 120}, strArr, new Object[]{bool, 0L, 0L, "", "", "", "", bool, bool, "", bool, 0, ByteStringMicro.EMPTY, bool, bool}, QQCircleEnvHub$UserInfo.class);
    }
}
