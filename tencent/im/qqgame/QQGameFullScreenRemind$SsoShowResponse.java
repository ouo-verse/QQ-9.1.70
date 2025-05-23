package tencent.im.qqgame;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameFullScreenRemind$SsoShowResponse extends MessageMicro<QQGameFullScreenRemind$SsoShowResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"show", "message", WadlProxyConsts.KEY_MATERIAL, "package_name", "appid"}, new Object[]{Boolean.FALSE, null, "", "", ""}, QQGameFullScreenRemind$SsoShowResponse.class);
    public final PBBoolField show = PBField.initBool(false);
    public QQGameFullScreenRemind$FullScreenMessage message = new QQGameFullScreenRemind$FullScreenMessage();
    public final PBStringField material = PBField.initString("");
    public final PBStringField package_name = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
}
